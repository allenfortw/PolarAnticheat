/*    */ package net.craftigames.polar.common.util;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.URL;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import javax.net.ssl.HttpsURLConnection;
/*    */ 
/*    */ public class Hastebin
/*    */ {
/*    */   private static final String DEFAULT_URL = "https://haste.cgsys.net/";
/*    */   
/*    */   public static String post(String text, boolean raw) throws IOException {
/* 16 */     byte[] postData = text.getBytes(StandardCharsets.UTF_8);
/* 17 */     int postDataLength = postData.length;
/*    */     
/* 19 */     String requestURL = "https://haste.cgsys.net//documents";
/* 20 */     URL url = new URL(requestURL);
/* 21 */     HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
/* 22 */     conn.setDoOutput(true);
/* 23 */     conn.setInstanceFollowRedirects(false);
/* 24 */     conn.setRequestMethod("POST");
/* 25 */     conn.setRequestProperty("User-Agent", "Hastebin-Java-Api");
/* 26 */     conn.setRequestProperty("Content-Type", "text/plain");
/*    */     
/* 28 */     conn.setUseCaches(false);
/*    */     
/* 30 */     String response = null;
/*    */     
/*    */     try {
/* 33 */       DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
/* 34 */       wr.write(postData);
/* 35 */       BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
/* 36 */       response = reader.readLine();
/* 37 */     } catch (IOException e) {
/* 38 */       e.printStackTrace();
/*    */     } 
/*    */     
/* 41 */     if (response != null && 
/* 42 */       response.contains("\"key\"")) {
/* 43 */       response = response.substring(response.indexOf(":") + 2, response.length() - 2);
/*    */       
/* 45 */       String postURL = raw ? "https://haste.cgsys.net//raw" : "https://haste.cgsys.net/";
/* 46 */       response = postURL + response;
/*    */     } 
/*    */ 
/*    */     
/* 50 */     return response;
/*    */   }
/*    */   
/*    */   public static String post(String text) throws IOException {
/* 54 */     return post(text, false);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\Hastebin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */