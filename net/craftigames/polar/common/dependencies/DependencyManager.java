/*     */ package net.craftigames.polar.common.dependencies;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import java.io.File;
/*     */ import java.io.InputStream;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.nio.file.Files;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Base64;
/*     */ import java.util.EnumMap;
/*     */ import java.util.EnumSet;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.craftigames.polar.common.PolarCore;
/*     */ import net.craftigames.polar.common.dependencies.classloader.IsolatedClassLoader;
/*     */ import net.craftigames.polar.common.dependencies.relocation.Relocation;
/*     */ import net.craftigames.polar.common.dependencies.relocation.RelocationHandler;
/*     */ 
/*     */ public class DependencyManager {
/*     */   private final PolarCore core;
/*     */   private final MessageDigest digest;
/*  26 */   private final EnumMap<Dependency, File> loaded = new EnumMap<>(Dependency.class);
/*  27 */   private final Map<ImmutableSet<Dependency>, IsolatedClassLoader> loaders = new HashMap<>();
/*  28 */   private RelocationHandler relocationHandler = null;
/*     */   
/*     */   public DependencyManager(PolarCore core) {
/*  31 */     this.core = core;
/*     */     try {
/*  33 */       this.digest = MessageDigest.getInstance("SHA-256");
/*  34 */     } catch (NoSuchAlgorithmException e) {
/*  35 */       throw new RuntimeException(e);
/*     */     } 
/*     */     
/*  38 */     loadDependencies(EnumSet.of(Dependency.ASM, Dependency.ASM_COMMONS, Dependency.JAR_RELOCATOR));
/*  39 */     loadDependencies(EnumSet.of(Dependency.ADVENTURE, Dependency.ADVENTURE_PLATFORM));
/*     */   }
/*     */   
/*     */   private static boolean shouldAutoLoad(Dependency dependency) {
/*  43 */     switch (dependency) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case JAR_RELOCATOR:
/*  51 */         return false;
/*     */     } 
/*  53 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private synchronized RelocationHandler getRelocationHandler() {
/*  58 */     if (this.relocationHandler == null) {
/*  59 */       this.relocationHandler = new RelocationHandler(this);
/*     */     }
/*  61 */     return this.relocationHandler;
/*     */   }
/*     */   
/*     */   private File getSaveDirectory() {
/*  65 */     File saveDirectory = new File(this.core.getDataFolder(), "lib");
/*  66 */     if (!saveDirectory.exists() && !saveDirectory.mkdirs()) {
/*  67 */       throw new RuntimeException("Unable to create lib dir - " + saveDirectory.getPath());
/*     */     }
/*     */     
/*  70 */     return saveDirectory;
/*     */   }
/*     */   
/*     */   public IsolatedClassLoader obtainClassLoaderWith(Set<Dependency> dependencies) {
/*  74 */     ImmutableSet<Dependency> set = ImmutableSet.copyOf(dependencies);
/*     */     
/*  76 */     for (Dependency dependency : dependencies) {
/*  77 */       if (!this.loaded.containsKey(dependency)) {
/*  78 */         throw new IllegalStateException("Dependency " + dependency + " is not loaded.");
/*     */       }
/*     */     } 
/*     */     
/*  82 */     synchronized (this.loaders) {
/*  83 */       IsolatedClassLoader classLoader = this.loaders.get(set);
/*  84 */       if (classLoader != null) {
/*  85 */         return classLoader;
/*     */       }
/*     */ 
/*     */       
/*  89 */       Objects.requireNonNull(this.loaded);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  97 */       URL[] urls = (URL[])set.stream().map(this.loaded::get).map(file -> { try { return file.toURI().toURL(); } catch (MalformedURLException e) { throw new RuntimeException(e); }  }).toArray(x$0 -> new URL[x$0]);
/*     */       
/*  99 */       classLoader = new IsolatedClassLoader(urls);
/* 100 */       this.loaders.put(set, classLoader);
/* 101 */       return classLoader;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void loadDependencies(Set<Dependency> dependencies, boolean remap) {
/* 106 */     File saveDirectory = getSaveDirectory();
/*     */ 
/*     */     
/* 109 */     List<Source> sources = new ArrayList<>();
/*     */ 
/*     */     
/* 112 */     for (Dependency dependency : dependencies) {
/* 113 */       if (this.loaded.containsKey(dependency)) {
/*     */         continue;
/*     */       }
/*     */       
/*     */       try {
/* 118 */         File file = downloadDependency(saveDirectory, dependency);
/* 119 */         sources.add(new Source(dependency, file));
/* 120 */       } catch (Throwable e) {
/* 121 */         this.core.getPolarLogger().warn("Exception whilst downloading dependency " + dependency.name());
/* 122 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 127 */     List<Source> remappedJars = new ArrayList<>(sources.size());
/* 128 */     for (Source source : sources) {
/*     */       
/*     */       try {
/* 131 */         List<Relocation> relocations = source.dependency.getRelocations();
/*     */         
/* 133 */         if (relocations.isEmpty()) {
/* 134 */           remappedJars.add(source);
/*     */           
/*     */           continue;
/*     */         } 
/* 138 */         File input = source.file;
/* 139 */         File output = new File(input.getParentFile(), "remapped-" + input.getName());
/*     */ 
/*     */         
/* 142 */         if (output.exists()) {
/* 143 */           remappedJars.add(new Source(source.dependency, output));
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 148 */         RelocationHandler relocationHandler = getRelocationHandler();
/*     */ 
/*     */         
/* 151 */         this.core.getPolarLogger().info("Attempting to apply relocations to " + input.getName() + "...");
/* 152 */         relocationHandler.remap(input, output, relocations);
/*     */         
/* 154 */         remappedJars.add(new Source(source.dependency, output));
/* 155 */       } catch (Throwable e) {
/* 156 */         this.core.getPolarLogger().warn("Unable to remap the source file '" + source.dependency.name() + "'.");
/* 157 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 162 */     for (Source source : remappedJars) {
/* 163 */       if (!shouldAutoLoad(source.dependency)) {
/* 164 */         this.loaded.put(source.dependency, source.file);
/*     */         
/*     */         continue;
/*     */       } 
/*     */       try {
/* 169 */         this.core.getPluginClassLoader().loadJar(source.file);
/* 170 */         this.loaded.put(source.dependency, source.file);
/* 171 */         this.core.getPolarLogger().info("Successfully loaded dependency jar '" + source.file.getName() + "'.");
/* 172 */       } catch (Throwable e) {
/* 173 */         this.core.getPolarLogger().warn("Failed to load dependency jar '" + source.file.getName() + "'.");
/* 174 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void loadDependencies(Set<Dependency> dependencies) {
/* 180 */     loadDependencies(dependencies, true);
/*     */   }
/*     */   
/*     */   private File downloadDependency(File saveDirectory, Dependency dependency) throws Exception {
/* 184 */     String fileName = dependency.name().toLowerCase() + "-" + dependency.getVersion() + ".jar";
/* 185 */     File file = new File(saveDirectory, fileName);
/*     */ 
/*     */     
/* 188 */     if (file.exists()) {
/* 189 */       return file;
/*     */     }
/*     */     
/* 192 */     URL url = new URL(dependency.getUrl());
/* 193 */     InputStream in = url.openStream();
/*     */ 
/*     */     
/* 196 */     try { byte[] bytes = ByteStreams.toByteArray(in);
/* 197 */       if (bytes.length == 0) {
/* 198 */         throw new RuntimeException("Empty stream");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 203 */       byte[] hash = this.digest.digest(bytes);
/*     */       
/* 205 */       this.core.getPolarLogger().info("Successfully downloaded '" + fileName + "' with checksum: " + Base64.getEncoder().encodeToString(hash));
/*     */ 
/*     */       
/* 208 */       if (!Arrays.equals(hash, dependency.getChecksum())) {
/* 209 */         throw new RuntimeException("Downloaded file had an invalid hash. Expected: " + Base64.getEncoder().encodeToString(dependency.getChecksum()));
/*     */       }
/*     */ 
/*     */       
/* 213 */       Files.write(file.toPath(), bytes, new java.nio.file.OpenOption[0]);
/* 214 */       if (in != null) in.close();  } catch (Throwable throwable) { if (in != null)
/*     */         try { in.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }
/*     */           throw throwable; }
/* 217 */      if (!file.exists()) {
/* 218 */       throw new IllegalStateException("File not present. - " + file.toString());
/*     */     }
/* 220 */     return file;
/*     */   }
/*     */   
/*     */   private static final class Source
/*     */   {
/*     */     private final Dependency dependency;
/*     */     private final File file;
/*     */     
/*     */     private Source(Dependency dependency, File file) {
/* 229 */       this.dependency = dependency;
/* 230 */       this.file = file;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\dependencies\DependencyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */