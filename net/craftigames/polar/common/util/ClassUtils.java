/*    */ package net.craftigames.polar.common.util;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.Reader;
/*    */ import java.net.URL;
/*    */ import java.net.URLDecoder;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Enumeration;
/*    */ import java.util.List;
/*    */ import java.util.jar.JarEntry;
/*    */ import java.util.jar.JarFile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClassUtils
/*    */ {
/*    */   public static List<String> getResourceFiles(String path) throws IOException {
/* 23 */     return getResourceFiles(path, ClassUtils.class.getResource(path));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static List<String> getResourceFiles(String path, URL protocol) throws IOException {
/* 35 */     if (protocol == null) {
/* 36 */       return new ArrayList<>();
/*    */     }
/* 38 */     List<String> filenames = new ArrayList<>();
/*    */ 
/*    */     
/* 41 */     if (protocol.getProtocol().equalsIgnoreCase("jar"))
/* 42 */     { path = path.substring(1);
/* 43 */       String internalPath = protocol.getPath();
/* 44 */       String jarPath = internalPath.substring(5, internalPath.indexOf("!"));
/*    */       
/* 46 */       JarFile jar = new JarFile(URLDecoder.decode(jarPath, StandardCharsets.UTF_8.name())); 
/* 47 */       try { Enumeration<JarEntry> entries = jar.entries();
/* 48 */         while (entries.hasMoreElements()) {
/* 49 */           JarEntry entry = entries.nextElement();
/* 50 */           String name = "/" + entry.getName();
/*    */           
/* 52 */           if (name.startsWith("/" + path)) {
/* 53 */             if (!name.contains(".")) {
/* 54 */               filenames.add("");
/*    */               
/*    */               continue;
/*    */             } 
/* 58 */             filenames.add(name);
/*    */           } 
/*    */         } 
/*    */         
/* 62 */         jar.close(); } catch (Throwable throwable) { try { jar.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }
/*    */          throw throwable; }
/*    */        }
/* 65 */     else { for (String file : readLines(ClassUtils.class.getResourceAsStream(path))) {
/* 66 */         if (!file.contains(".")) {
/* 67 */           filenames.addAll(getResourceFiles(path + "/" + file, protocol));
/*    */           continue;
/*    */         } 
/* 70 */         String name = path + "/" + file;
/* 71 */         filenames.add(name);
/*    */       }  }
/*    */ 
/*    */     
/* 75 */     return filenames;
/*    */   }
/*    */   
/*    */   private static List<String> readLines(InputStream input) throws IOException {
/* 79 */     return readLines(new InputStreamReader(input, StandardCharsets.UTF_8));
/*    */   }
/*    */   
/*    */   private static List<String> readLines(Reader input) throws IOException {
/* 83 */     BufferedReader reader = (input instanceof BufferedReader) ? (BufferedReader)input : new BufferedReader(input);
/* 84 */     List<String> list = new ArrayList<>();
/*    */     
/* 86 */     for (String line = reader.readLine(); line != null; line = reader.readLine()) {
/* 87 */       list.add(line);
/*    */     }
/*    */     
/* 90 */     return list;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\ClassUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */