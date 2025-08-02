/*     */ package net.craftigames.polar.common.dependencies;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.security.MessageDigest;
/*     */ import java.util.Arrays;
/*     */ import java.util.Base64;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import net.craftigames.polar.common.dependencies.relocation.Relocation;
/*     */ import net.craftigames.polar.common.dependencies.relocation.RelocationHelper;
/*     */ 
/*     */ 
/*     */ public enum Dependency
/*     */ {
/*  17 */   ASM("org.ow2.asm", "asm", "7.1", "SrL6K20sycyx6qBeoynEB7R7E+0pFfYvjEuMyWJY1N4="),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  23 */   ASM_COMMONS("org.ow2.asm", "asm-commons", "7.1", "5VkEidjxmE2Fv+q9Oxc3TFnCiuCdSOxKDrvQGVns01g="),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  29 */   JAR_RELOCATOR("me.lucko", "jar-relocator", "1.3", "mmz3ltQbS8xXGA2scM0ZH6raISlt4nukjCiU2l9Jxfs="),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   MYSQL_DRIVER("mysql", "mysql-connector-java", "8.0.22", "UBne+9EjFilel6bojyqbB/EYNFpOmCcQu6Iy5JmyL08=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  40 */     Relocation.of("mysql", "com{}mysql")),
/*     */ 
/*     */   
/*  43 */   MARIADB_DRIVER("org{}mariadb{}jdbc", "mariadb-java-client", "2.7.0", "ABURDun85Q01kf119r4yjDtl5ju9Fg9uV2nXyU3SEdw=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  48 */     Relocation.of("mariadb", "org{}mariadb{}jdbc")),
/*     */   
/*  50 */   HIKARI("com{}zaxxer", "HikariCP", "4.0.2", "DP9czSdMnMysTbuoBK5cy9w5r2zR6rdaB09L/HfHncU=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  55 */     Relocation.of("hikari", "com{}zaxxer{}hikari")),
/*     */   
/*  57 */   SLF4J_SIMPLE("org.slf4j", "slf4j-simple", "1.7.25", "CWbob/+lvlLT2ee4ndZ02YoD7tCkVPuvfBvZSTvZ2HQ="),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   SLF4J_API("org.slf4j", "slf4j-api", "1.7.25", "GMSgCV1cHaa4F1kudnuyPSndL1YK1033X/OWHb3iW3k="),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   JEDIS("redis.clients", "jedis", "3.8.0", "eufA/dNLpzLwoF4ahMZ8PhvN7Ot6kV29Hf3qUjL05ZI=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  74 */     Arrays.asList(new Relocation[] {
/*  75 */         Relocation.of("jedis", "redis{}clients{}jedis"), 
/*  76 */         Relocation.of("commonspool2", "org{}apache{}commons{}pool2")
/*     */       
/*     */       })),
/*  79 */   COMMONS_POOL_2("org.apache.commons", "commons-pool2", "2.8.0", "Xvqfu1SlixoSIFpfrFZfaYKr/rD/Rb28MYdI71/To/8=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     Relocation.of("commonspool2", "org{}apache{}commons{}pool2")),
/*     */   
/*  86 */   CONFIGURATE_CORE("org{}spongepowered", "configurate-core", "3.7.2", "XF2LzWLkSV0wyQRDt33I+gDlf3t2WzxH1h8JCZZgPp4=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     Relocation.of("configurate", "ninja{}leaping{}configurate")),
/*     */   
/*  93 */   CONFIGURATE_GSON("org{}spongepowered", "configurate-gson", "3.7.2", "9S/mp3Ig9De7NNd6+2kX+L4R90bHnAosSNVbFjrl7sM=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     Relocation.of("configurate", "ninja{}leaping{}configurate")),
/*     */   
/* 100 */   CONFIGURATE_YAML("org{}spongepowered", "configurate-yaml", "3.7.2", "OBfYn4nSMGZfVf2DoZhZq+G9TF1mODX/C5OOz/mkPmc=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     Arrays.asList(new Relocation[] {
/* 106 */         Relocation.of("configurate", "ninja{}leaping{}configurate"), 
/* 107 */         Relocation.of("yaml", "org{}yaml{}snakeyaml")
/*     */       })),
/* 109 */   OKIO("com{}squareup{}" + RelocationHelper.OKIO_STRING, RelocationHelper.OKIO_STRING, "1.17.3", "yxja86IIrjirnYJUP/uT4fGF6GPIoOUsw3L/46WPVUk=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     Relocation.of(RelocationHelper.OKIO_STRING, RelocationHelper.OKIO_STRING)),
/*     */   
/* 116 */   OKHTTP("com{}squareup{}" + RelocationHelper.OKHTTP3_STRING, "okhttp", "3.14.1", "WmvmkWUwdqpk3NNh0uRF5AYLS13IgrH2uknnnd/D5WM=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     Arrays.asList(new Relocation[] {
/* 122 */         Relocation.of(RelocationHelper.OKHTTP3_STRING, RelocationHelper.OKHTTP3_STRING), 
/* 123 */         Relocation.of(RelocationHelper.OKIO_STRING, RelocationHelper.OKIO_STRING)
/*     */       })),
/* 125 */   RETROFIT2("com{}squareup{}" + RelocationHelper.RETROFIT2_STRING, "retrofit", "2.8.1", "n4KyEt3ZGwSjbZvXRkmhDmicyGkx5CKEi0VLdNiQRos=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     Arrays.asList(new Relocation[] {
/* 131 */         Relocation.of(RelocationHelper.RETROFIT2_STRING, RelocationHelper.RETROFIT2_STRING), 
/* 132 */         Relocation.of(RelocationHelper.OKHTTP3_STRING, RelocationHelper.OKHTTP3_STRING), 
/* 133 */         Relocation.of(RelocationHelper.OKIO_STRING, RelocationHelper.OKIO_STRING)
/*     */       })),
/* 135 */   RETROFIT2_MOSHI("com{}squareup{}" + RelocationHelper.MOSHI_STRING, "moshi", "1.8.0", "Qv50bSaU6hH+agK+zZ2iyj2v6Xye/VCg+a9cRZbnSmo=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 140 */     Arrays.asList(new Relocation[] {
/* 141 */         Relocation.of(RelocationHelper.MOSHI_STRING, RelocationHelper.MOSHI_STRING), 
/* 142 */         Relocation.of(RelocationHelper.RETROFIT2_STRING, RelocationHelper.RETROFIT2_STRING), 
/* 143 */         Relocation.of(RelocationHelper.OKHTTP3_STRING, RelocationHelper.OKHTTP3_STRING), 
/* 144 */         Relocation.of(RelocationHelper.OKIO_STRING, RelocationHelper.OKIO_STRING)
/*     */       })),
/* 146 */   RETROFIT2_MOSHI_CONVERTER("com{}squareup{}" + RelocationHelper.RETROFIT2_STRING, "converter-moshi", "2.8.1", "8EqWCUKDsoqBY34iRcwAbO5xX/eXHzw4umJmStdHQFo=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 151 */     Arrays.asList(new Relocation[] {
/* 152 */         Relocation.of(RelocationHelper.MOSHI_STRING, RelocationHelper.MOSHI_STRING), 
/* 153 */         Relocation.of(RelocationHelper.RETROFIT2_STRING, RelocationHelper.RETROFIT2_STRING), 
/* 154 */         Relocation.of(RelocationHelper.OKHTTP3_STRING, RelocationHelper.OKHTTP3_STRING), 
/* 155 */         Relocation.of(RelocationHelper.OKIO_STRING, RelocationHelper.OKIO_STRING)
/*     */       
/*     */       })),
/* 158 */   RETROFIT2_GSON_CONVERTER("com{}squareup{}" + RelocationHelper.RETROFIT2_STRING, "converter-gson", "2.9.0", "Mqoga5opyd9e2pOgks+zsLkTPiMsBiuqiC8DGfDnnw4=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     Arrays.asList(new Relocation[] {
/* 164 */         Relocation.of(RelocationHelper.RETROFIT2_STRING, RelocationHelper.RETROFIT2_STRING), 
/* 165 */         Relocation.of(RelocationHelper.OKHTTP3_STRING, RelocationHelper.OKHTTP3_STRING), 
/* 166 */         Relocation.of(RelocationHelper.OKIO_STRING, RelocationHelper.OKIO_STRING)
/*     */       
/*     */       })),
/* 169 */   OKHTTP_LOGGING("com{}squareup{}" + RelocationHelper.OKHTTP3_STRING, "logging-interceptor", "3.14.1", "kvJaPpRdKpjYgrXsYUJpVne4Xyyb4LVcB0XgP4EIW7k=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     Arrays.asList(new Relocation[] {
/* 175 */         Relocation.of(RelocationHelper.RETROFIT2_STRING, RelocationHelper.RETROFIT2_STRING), 
/* 176 */         Relocation.of(RelocationHelper.OKHTTP3_STRING, RelocationHelper.OKHTTP3_STRING), 
/* 177 */         Relocation.of(RelocationHelper.OKIO_STRING, RelocationHelper.OKIO_STRING)
/*     */       })),
/* 179 */   INFLUXDB("org{}influxdb", "influxdb-java", "2.21", "rLqbKmEh+qh3qGkXpWqdYwRPCGnpjNeZagyPxbdSX2k=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 184 */     Arrays.asList(new Relocation[] {
/* 185 */         Relocation.of("influxdb", "org{}influxdb"), 
/* 186 */         Relocation.of(RelocationHelper.RETROFIT2_STRING, RelocationHelper.RETROFIT2_STRING), 
/* 187 */         Relocation.of(RelocationHelper.OKHTTP3_STRING, RelocationHelper.OKHTTP3_STRING), 
/* 188 */         Relocation.of(RelocationHelper.OKIO_STRING, RelocationHelper.OKIO_STRING)
/*     */       })),
/* 190 */   JACKSON_CORE("com{}fasterxml{}jackson{}core", "jackson-core", "2.10.4", "Vk9uVwYJYXlTcRQpnm10ktLDjaGC3414NKTJFBsHjvM=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 195 */     Relocation.of("jackson-core", "com{}fasterxml{}jackson{}core")),
/*     */   
/* 197 */   SENTRY("io{}sentry", "sentry", "5.5.0", "eN+rHvbKHSN/AoiVUwDS6+kUB8Weyoo6pZUhFIaEw00=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 202 */     Arrays.asList(new Relocation[] {
/* 203 */         Relocation.of("sentry", "io{}sentry"), 
/* 204 */         Relocation.of("jackson-core", "com{}fasterxml{}jackson{}core")
/*     */       
/*     */       })),
/* 207 */   ADVENTURE("me{}lucko", "adventure-api", "4.9.4", "bh1cB0ZdzxstqRfVowKbgAZM16T/CtJ7oIJCaknbGeM="),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 214 */   ADVENTURE_PLATFORM("me{}lucko", "adventure-platform-api", "4.9.4", "CZVyxNOi7ln7dgldfDs1m1M6d9w/bKG8Rp27qfAuTJw="),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 221 */   ADVENTURE_PLATFORM_BUKKIT("me{}lucko", "adventure-platform-bukkit", "4.9.4", "JkA3GGkf3pADA3PACYfdVlAglstgzz+ajAxElMXXn6I="),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 228 */   ADVENTURE_PLATFORM_BUNGEECORD("me{}lucko", "adventure-platform-bungeecord", "4.9.4", "a/p8/eIjbQnNlN5cJ/yIUjttZyJ/GRXgcsg8rhY7SwI="),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 235 */   EVENT("net{}kyori", "event-api", "3.0.0", "yjvdTdAyktl3iFEQFLHC3qYwwt7/DbCd7Zc8Q4SlIag="),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 242 */   CAFFEINE("com{}github{}ben-manes{}caffeine", "caffeine", "2.8.4", "KV9YN5gQj6b507VJApJpPF5PkCon0DZqAi0T7Ln0lag=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 247 */     Relocation.of("caffeine", "com{}github{}benmanes{}caffeine")),
/*     */   
/* 249 */   BYTEBUDDY("net{}bytebuddy", "byte-buddy", "1.10.19", "XwjJt1Hwzn6f5eAvfCpogy5OlzO0BoujJzeprWIsavI=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 254 */     Relocation.of("bytebuddy", "net{}bytebuddy")),
/*     */   
/* 256 */   SNAKEYAML("org.yaml", "snakeyaml", "1.29", "icXwKYEbCMh48LgduwXpYmYkwf2kCHomhxEB5JmiF6s=", 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 261 */     Relocation.of("yaml", "org{}yaml{}snakeyaml"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String MAVEN_CENTRAL_FORMAT = "https://repo1.maven.org/maven2/%s/%s/%s/%s-%s.jar";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String url;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String version;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final byte[] checksum;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final List<Relocation> relocations;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Dependency(String url, String version, String checksum, List<Relocation> relocations) {
/* 303 */     this.url = url;
/* 304 */     this.version = version;
/* 305 */     this.checksum = Base64.getDecoder().decode(checksum);
/* 306 */     this.relocations = relocations;
/*     */   }
/*     */   
/*     */   private static String rewriteEscaping(String s) {
/* 310 */     return s.replace("{}", ".");
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 314 */     Dependency$1.init(); MessageDigest digest = MessageDigest.getInstance("SHA-256");
/*     */     
/* 316 */     for (Dependency dependency : values()) {
/* 317 */       URL url = new URL(dependency.getUrl());
/* 318 */       InputStream in = url.openStream(); 
/* 319 */       try { ByteArrayOutputStream buffer = new ByteArrayOutputStream();
/*     */ 
/*     */         
/* 322 */         byte[] data = new byte[16384];
/*     */         int nRead;
/* 324 */         while ((nRead = in.read(data, 0, data.length)) != -1) {
/* 325 */           buffer.write(data, 0, nRead);
/*     */         }
/*     */         
/* 328 */         byte[] bytes = buffer.toByteArray();
/*     */ 
/*     */         
/* 331 */         if (bytes.length == 0) {
/* 332 */           throw new RuntimeException("Empty stream");
/*     */         }
/*     */         
/* 335 */         byte[] hash = digest.digest(bytes);
/*     */         
/* 337 */         if (Arrays.equals(hash, dependency.getChecksum())) {
/* 338 */           System.out.println("MATCH " + dependency.name() + ": " + Base64.getEncoder().encodeToString(hash));
/*     */         } else {
/* 340 */           System.out.println("NO MATCH " + dependency.name() + ": " + Base64.getEncoder().encodeToString(hash));
/*     */         } 
/* 342 */         if (in != null) in.close();  } catch (Throwable throwable) { if (in != null)
/*     */           try { in.close(); }
/*     */           catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }
/*     */             throw throwable; }
/*     */     
/* 347 */     }  } public String getUrl() { return this.url; }
/*     */ 
/*     */   
/*     */   public String getVersion() {
/* 351 */     return this.version;
/*     */   }
/*     */   
/*     */   public byte[] getChecksum() {
/* 355 */     return this.checksum;
/*     */   }
/*     */   
/*     */   public List<Relocation> getRelocations() {
/* 359 */     return this.relocations;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\dependencies\Dependency.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */