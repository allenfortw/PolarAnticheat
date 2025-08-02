/*     */ package net.craftigames.polar.common.messages.redis;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.ScheduledThreadPoolExecutor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import net.craftigames.polar.common.ConnectionType;
/*     */ import net.craftigames.polar.common.Core;
/*     */ import net.craftigames.polar.common.PolarCore;
/*     */ import net.craftigames.polar.common.messages.Message;
/*     */ import net.craftigames.polar.common.messages.MessageReceiver;
/*     */ import net.craftigames.polar.common.messages.Messenger;
/*     */ import net.craftigames.polar.common.messages.SubscriptionHandler;
/*     */ import net.craftigames.polar.common.util.ExpiringSet;
/*     */ import net.craftigames.polar.common.util.exception.MessageNotFoundException;
/*     */ import net.craftigames.polar.common.util.scheduler.PolarThread;
/*     */ import net.craftigames.polar.common.util.scheduler.ScheduledTask;
/*     */ import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import redis.clients.jedis.Jedis;
/*     */ import redis.clients.jedis.JedisPool;
/*     */ import redis.clients.jedis.JedisPoolConfig;
/*     */ 
/*     */ public class RedisMessenger implements Messenger {
/*  27 */   protected static String CHANNEL_SYSTEM = "polar:system";
/*  28 */   protected static String CHANNEL_API = "polar:api";
/*  29 */   protected static String CHANNEL_HEARTBEAT = "polar:heartbeat";
/*  30 */   public static long LAST_POLAR_HEARTBEAT = 0L; private final PolarCore core; private final MessageReceiver receiver; private ConnectionType type;
/*     */   private final ExpiringSet<UUID> alreadyProcessed;
/*  32 */   final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1); private JedisPool jedisPool; @Nullable private Subscription sub; private ScheduledTask subscriberTask; public ScheduledThreadPoolExecutor getExecutor() { return this.executor; }
/*     */   
/*  34 */   public PolarCore getCore() { return this.core; } public MessageReceiver getReceiver() {
/*  35 */     return this.receiver;
/*     */   } public ConnectionType getType() {
/*  37 */     return this.type;
/*     */   } public ExpiringSet<UUID> getAlreadyProcessed() {
/*  39 */     return this.alreadyProcessed;
/*     */   }
/*  41 */   public JedisPool getJedisPool() { return this.jedisPool; } @Nullable
/*  42 */   public Subscription getSub() { return this.sub; }
/*  43 */   public ScheduledTask getSubscriberTask() { return this.subscriberTask; } private boolean closing = false; public boolean isClosing() {
/*  44 */     return this.closing;
/*     */   }
/*     */   public RedisMessenger(PolarCore core, MessageReceiver receiver) {
/*  47 */     this.core = core;
/*  48 */     this.receiver = receiver;
/*  49 */     this.alreadyProcessed = new ExpiringSet(1L, TimeUnit.HOURS);
/*     */   }
/*     */ 
/*     */   
/*     */   public void connect(String address, String password, ConnectionType type, String... extraChannels) {
/*  54 */     String[] addressSplit = address.split(":");
/*  55 */     String host = addressSplit[0];
/*  56 */     int port = (addressSplit.length > 1) ? Integer.parseInt(addressSplit[1]) : 6379;
/*     */     
/*  58 */     if (password.equals("")) {
/*  59 */       this.jedisPool = new JedisPool((GenericObjectPoolConfig)getPoolConfig(), host, port, 2000);
/*     */     } else {
/*  61 */       this.jedisPool = new JedisPool((GenericObjectPoolConfig)getPoolConfig(), host, port, 2000, password);
/*     */     } 
/*  63 */     this.type = type;
/*     */     
/*  65 */     if (type == ConnectionType.SYSTEM) {
/*  66 */       sendHeartBeats();
/*     */     }
/*     */     
/*  69 */     String[] channels = extraChannels;
/*     */     
/*  71 */     if (type.getId() >= 3) {
/*     */       
/*  73 */       channels = Arrays.<String>copyOf(channels, channels.length + 1);
/*  74 */       channels[channels.length - 1] = "polar:" + type.name().toLowerCase();
/*     */     } 
/*     */ 
/*     */     
/*  78 */     if (type != ConnectionType.API_CLIENT) {
/*  79 */       this.sub = new Subscription(channels);
/*  80 */       this.subscriberTask = PolarThread.runAsync(this.sub);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public SubscriptionHandler getSubscriptionHandler() {
/*  87 */     return this.sub;
/*     */   }
/*     */   
/*     */   private void sendHeartBeats() {
/*  91 */     PolarThread.schedule(this::sendHeartBeat, 1L, 1L, TimeUnit.SECONDS);
/*     */   }
/*     */   private void sendHeartBeat() {
/*     */     
/*  95 */     try { Jedis jedis = this.jedisPool.getResource(); 
/*  96 */       try { jedis.publish(CHANNEL_HEARTBEAT, "");
/*  97 */         if (jedis != null) jedis.close();  } catch (Throwable throwable) { if (jedis != null) try { jedis.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception e)
/*  98 */     { e.printStackTrace(); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendMessage(Message message) {
/* 105 */     sendMessage(message, (this.type == ConnectionType.SYSTEM) ? CHANNEL_API : CHANNEL_SYSTEM);
/*     */   }
/*     */ 
/*     */   
/*     */   public void sendMessage(Message message, String channel) {
/* 110 */     if (Core.DEBUG) {
/* 111 */       this.core.getPolarLogger().info("Sent Message: " + message.getClass().getName() + " (To channel: " + channel + ")");
/*     */     }
/* 113 */     this.receiver.onMessageSend(message);
/* 114 */     String encoded = asEncodedString(message);
/*     */     
/* 116 */     try { Jedis jedis = this.jedisPool.getResource(); 
/* 117 */       try { jedis.publish(channel, encoded);
/* 118 */         if (jedis != null) jedis.close();  } catch (Throwable throwable) { if (jedis != null) try { jedis.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception e)
/* 119 */     { e.printStackTrace(); }
/*     */   
/*     */   }
/*     */   
/*     */   public void sendRawJsonMessage(String message, String channel) {
/*     */     
/* 125 */     try { Jedis jedis = this.jedisPool.getResource(); 
/* 126 */       try { jedis.publish(channel, message);
/* 127 */         if (jedis != null) jedis.close();  } catch (Throwable throwable) { if (jedis != null) try { jedis.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception e)
/* 128 */     { e.printStackTrace(); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 134 */     this.closing = true;
/* 135 */     if (this.sub != null) {
/* 136 */       this.sub.unsubscribe();
/*     */     }
/* 138 */     this.jedisPool.destroy();
/*     */   }
/*     */   
/*     */   private class Subscription
/*     */     extends JedisPubSub implements Runnable, SubscriptionHandler {
/*     */     private final String[] channels;
/*     */     private final Set<String> extraChannels;
/*     */     
/*     */     private Subscription(String[] extraChannels) {
/* 147 */       this.channels = extraChannels;
/* 148 */       this.extraChannels = Sets.newConcurrentHashSet(Arrays.asList(extraChannels));
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/*     */       try {
/* 154 */         boolean first = true;
/* 155 */         while (!RedisMessenger.this.closing && !Thread.interrupted() && !RedisMessenger.this.jedisPool.isClosed()) { 
/* 156 */           try { Jedis jedis = RedisMessenger.this.jedisPool.getResource(); 
/* 157 */             try { if (first) {
/* 158 */                 first = false;
/*     */               } else {
/* 160 */                 RedisMessenger.this.core.getPolarLogger().info("Redis pubsub connection re-established");
/*     */               } 
/*     */ 
/*     */               
/* 164 */               String channel = (RedisMessenger.this.type == ConnectionType.SYSTEM) ? RedisMessenger.CHANNEL_SYSTEM : RedisMessenger.CHANNEL_API;
/*     */               
/* 166 */               List<String> channels = new ArrayList<>(this.extraChannels);
/* 167 */               channels.add(channel);
/* 168 */               if (RedisMessenger.this.type != ConnectionType.SYSTEM) {
/* 169 */                 channels.add(RedisMessenger.CHANNEL_HEARTBEAT);
/*     */               }
/*     */               
/* 172 */               String[] array = channels.<String>toArray(new String[0]);
/* 173 */               RedisMessenger.this.core.getPolarLogger().info("Subscribed to Redis channels..: " + Arrays.toString((Object[])array));
/*     */               
/* 175 */               jedis.subscribe(this, array);
/* 176 */               if (jedis != null) jedis.close();  } catch (Throwable throwable) { if (jedis != null) try { jedis.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception e)
/* 177 */           { if (RedisMessenger.this.closing) {
/*     */               return;
/*     */             }
/*     */             
/* 181 */             RedisMessenger.this.core.getPolarLogger().warn("Redis pubsub connection dropped, trying to re-open the connection in 5 seconds", e);
/*     */             try {
/* 183 */               unsubscribe();
/* 184 */             } catch (Exception ex) {
/* 185 */               RedisMessenger.this.core.getPolarLogger().warn("Redis pubsub connection failed to unsubscribe during re-open", ex);
/*     */             } 
/*     */ 
/*     */             
/*     */             try {
/* 190 */               Thread.sleep(5000L);
/* 191 */             } catch (InterruptedException ie) {
/* 192 */               Thread.currentThread().interrupt();
/*     */             }  }
/*     */ 
/*     */ 
/*     */           
/* 197 */           RedisMessenger.this.core.getPolarLogger().warn("Redis pubsub connection thread ended, trying to re-open the connection in 500 ms");
/*     */           
/*     */           try {
/* 200 */             Thread.sleep(500L);
/* 201 */           } catch (InterruptedException ie) {
/* 202 */             Thread.currentThread().interrupt();
/*     */           }  }
/*     */       
/* 205 */       } catch (Exception e) {
/* 206 */         RedisMessenger.this.core.getPolarLogger().warn("Redis pubsub connection crashed, trying to re-open the connection in 5 seconds", e);
/* 207 */       } catch (StackOverflowError e) {
/* 208 */         RedisMessenger.this.core.getPolarLogger().warn("Redis pubsub connection dropped and stackoverflow, trying to re-open the connection in 5 seconds", e);
/*     */       } 
/*     */       
/*     */       try {
/* 212 */         unsubscribe();
/* 213 */       } catch (Exception ex) {
/* 214 */         RedisMessenger.this.core.getPolarLogger().warn("Redis pubsub connection failed to unsubscribe", ex);
/*     */       } 
/*     */       
/* 217 */       if (RedisMessenger.this.subscriberTask != null) {
/* 218 */         RedisMessenger.this.subscriberTask.cancel();
/*     */       }
/*     */       
/* 221 */       RedisMessenger.this.core.getPolarLogger().warn("WEEWOO! Redis pubsub connection thread ended. Making new thread & connection in 5 seconds");
/*     */ 
/*     */       
/*     */       try {
/* 225 */         Thread.sleep(5000L);
/* 226 */       } catch (InterruptedException ie) {
/* 227 */         Thread.currentThread().interrupt();
/*     */       } 
/*     */       
/* 230 */       RedisMessenger.this.sub = new Subscription(this.channels);
/* 231 */       RedisMessenger.this.subscriberTask = PolarThread.runAsync(RedisMessenger.this.sub);
/*     */     }
/*     */ 
/*     */     
/*     */     public void registerRedisChannels(String... channels) {
/* 236 */       this.extraChannels.addAll(Arrays.asList(channels));
/* 237 */       if (isSubscribed()) {
/* 238 */         subscribe(channels);
/* 239 */         RedisMessenger.this.core.getPolarLogger().info("Registered Redis channels: " + Arrays.toString((Object[])channels));
/*     */       } else {
/* 241 */         RedisMessenger.this.core.getPolarLogger().info("Could not register Redis channels: " + Arrays.toString((Object[])channels));
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void unregisterRedisChannels(String... channels) {
/* 247 */       Objects.requireNonNull(this.extraChannels); Arrays.<String>asList(channels).forEach(this.extraChannels::remove);
/* 248 */       if (isSubscribed()) {
/* 249 */         unsubscribe(channels);
/* 250 */         RedisMessenger.this.core.getPolarLogger().info("Unregistered Redis channels: " + Arrays.toString((Object[])channels));
/*     */       } else {
/* 252 */         RedisMessenger.this.core.getPolarLogger().info("Could not unregister Redis channels: " + Arrays.toString((Object[])channels));
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void onMessage(String channelIn, String msg) {
/*     */       try {
/* 260 */         if (channelIn.equals(RedisMessenger.CHANNEL_HEARTBEAT)) {
/* 261 */           RedisMessenger.LAST_POLAR_HEARTBEAT = System.currentTimeMillis();
/*     */           
/*     */           return;
/*     */         } 
/* 265 */         String channel = (RedisMessenger.this.type == ConnectionType.SYSTEM) ? RedisMessenger.CHANNEL_SYSTEM : RedisMessenger.CHANNEL_API;
/*     */         
/* 267 */         if (!channelIn.equalsIgnoreCase(channel) && this.extraChannels.stream().noneMatch(extraChannel -> extraChannel.equalsIgnoreCase(channelIn))) {
/*     */           return;
/*     */         }
/*     */ 
/*     */         
/* 272 */         Message message = MessageConsumer.consumeIncomingMessageAsString(msg, RedisMessenger.this);
/* 273 */         if (message != null) {
/* 274 */           RedisMessenger.this.receiver.receive(message, channelIn);
/*     */         }
/* 276 */       } catch (MessageNotFoundException ex) {
/* 277 */         if (Core.DEBUG) {
/* 278 */           RedisMessenger.this.core.getPolarLogger().warn(ex.getMessage());
/*     */         }
/* 280 */       } catch (Exception ex) {
/* 281 */         RedisMessenger.this.core.getPolarLogger().warn("Error consuming incoming message. (channel: " + channelIn + ")", ex);
/* 282 */         RedisMessenger.this.core.getPolarLogger().warn("Message: " + msg);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private JedisPoolConfig getPoolConfig() {
/* 288 */     JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
/* 289 */     jedisPoolConfig.setMaxTotal(100);
/* 290 */     jedisPoolConfig.setMaxIdle(100);
/* 291 */     jedisPoolConfig.setMinIdle(10);
/*     */     
/* 293 */     return jedisPoolConfig;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\redis\RedisMessenger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */