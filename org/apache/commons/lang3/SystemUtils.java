/*      */ package org.apache.commons.lang3;
/*      */ 
/*      */ import java.io.File;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SystemUtils
/*      */ {
/*      */   private static final String OS_NAME_WINDOWS_PREFIX = "Windows";
/*      */   private static final String USER_HOME_KEY = "user.home";
/*      */   private static final String USER_NAME_KEY = "user.name";
/*      */   private static final String USER_DIR_KEY = "user.dir";
/*      */   private static final String JAVA_IO_TMPDIR_KEY = "java.io.tmpdir";
/*      */   private static final String JAVA_HOME_KEY = "java.home";
/*   93 */   public static final String AWT_TOOLKIT = getSystemProperty("awt.toolkit");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  115 */   public static final String FILE_ENCODING = getSystemProperty("file.encoding");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*  142 */   public static final String FILE_SEPARATOR = getSystemProperty("file.separator");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  160 */   public static final String JAVA_AWT_FONTS = getSystemProperty("java.awt.fonts");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  178 */   public static final String JAVA_AWT_GRAPHICSENV = getSystemProperty("java.awt.graphicsenv");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  199 */   public static final String JAVA_AWT_HEADLESS = getSystemProperty("java.awt.headless");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  217 */   public static final String JAVA_AWT_PRINTERJOB = getSystemProperty("java.awt.printerjob");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  235 */   public static final String JAVA_CLASS_PATH = getSystemProperty("java.class.path");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  253 */   public static final String JAVA_CLASS_VERSION = getSystemProperty("java.class.version");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  272 */   public static final String JAVA_COMPILER = getSystemProperty("java.compiler");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  290 */   public static final String JAVA_ENDORSED_DIRS = getSystemProperty("java.endorsed.dirs");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  308 */   public static final String JAVA_EXT_DIRS = getSystemProperty("java.ext.dirs");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  326 */   public static final String JAVA_HOME = getSystemProperty("java.home");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  344 */   public static final String JAVA_IO_TMPDIR = getSystemProperty("java.io.tmpdir");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  362 */   public static final String JAVA_LIBRARY_PATH = getSystemProperty("java.library.path");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  381 */   public static final String JAVA_RUNTIME_NAME = getSystemProperty("java.runtime.name");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  400 */   public static final String JAVA_RUNTIME_VERSION = getSystemProperty("java.runtime.version");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  418 */   public static final String JAVA_SPECIFICATION_NAME = getSystemProperty("java.specification.name");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  436 */   public static final String JAVA_SPECIFICATION_VENDOR = getSystemProperty("java.specification.vendor");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  454 */   public static final String JAVA_SPECIFICATION_VERSION = getSystemProperty("java.specification.version");
/*  455 */   private static final JavaVersion JAVA_SPECIFICATION_VERSION_AS_ENUM = JavaVersion.get(JAVA_SPECIFICATION_VERSION);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  475 */   public static final String JAVA_UTIL_PREFS_PREFERENCES_FACTORY = getSystemProperty("java.util.prefs.PreferencesFactory");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  493 */   public static final String JAVA_VENDOR = getSystemProperty("java.vendor");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  511 */   public static final String JAVA_VENDOR_URL = getSystemProperty("java.vendor.url");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  529 */   public static final String JAVA_VERSION = getSystemProperty("java.version");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  548 */   public static final String JAVA_VM_INFO = getSystemProperty("java.vm.info");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  566 */   public static final String JAVA_VM_NAME = getSystemProperty("java.vm.name");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  584 */   public static final String JAVA_VM_SPECIFICATION_NAME = getSystemProperty("java.vm.specification.name");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  602 */   public static final String JAVA_VM_SPECIFICATION_VENDOR = getSystemProperty("java.vm.specification.vendor");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  620 */   public static final String JAVA_VM_SPECIFICATION_VERSION = getSystemProperty("java.vm.specification.version");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  638 */   public static final String JAVA_VM_VENDOR = getSystemProperty("java.vm.vendor");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  656 */   public static final String JAVA_VM_VERSION = getSystemProperty("java.vm.version");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*  676 */   public static final String LINE_SEPARATOR = getSystemProperty("line.separator");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  694 */   public static final String OS_ARCH = getSystemProperty("os.arch");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  712 */   public static final String OS_NAME = getSystemProperty("os.name");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  730 */   public static final String OS_VERSION = getSystemProperty("os.version");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*  751 */   public static final String PATH_SEPARATOR = getSystemProperty("path.separator");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  771 */   public static final String USER_COUNTRY = (getSystemProperty("user.country") == null) ? 
/*  772 */     getSystemProperty("user.region") : getSystemProperty("user.country");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  790 */   public static final String USER_DIR = getSystemProperty("user.dir");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  808 */   public static final String USER_HOME = getSystemProperty("user.home");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  827 */   public static final String USER_LANGUAGE = getSystemProperty("user.language");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  845 */   public static final String USER_NAME = getSystemProperty("user.name");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  863 */   public static final String USER_TIMEZONE = getSystemProperty("user.timezone");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  878 */   public static final boolean IS_JAVA_1_1 = getJavaVersionMatches("1.1");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  888 */   public static final boolean IS_JAVA_1_2 = getJavaVersionMatches("1.2");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  898 */   public static final boolean IS_JAVA_1_3 = getJavaVersionMatches("1.3");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  908 */   public static final boolean IS_JAVA_1_4 = getJavaVersionMatches("1.4");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  918 */   public static final boolean IS_JAVA_1_5 = getJavaVersionMatches("1.5");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  928 */   public static final boolean IS_JAVA_1_6 = getJavaVersionMatches("1.6");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  940 */   public static final boolean IS_JAVA_1_7 = getJavaVersionMatches("1.7");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  952 */   public static final boolean IS_JAVA_1_8 = getJavaVersionMatches("1.8");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*  967 */   public static final boolean IS_JAVA_1_9 = getJavaVersionMatches("9");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  979 */   public static final boolean IS_JAVA_9 = getJavaVersionMatches("9");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  991 */   public static final boolean IS_JAVA_10 = getJavaVersionMatches("10");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1003 */   public static final boolean IS_JAVA_11 = getJavaVersionMatches("11");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1015 */   public static final boolean IS_JAVA_12 = getJavaVersionMatches("12");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1027 */   public static final boolean IS_JAVA_13 = getJavaVersionMatches("13");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1039 */   public static final boolean IS_JAVA_14 = getJavaVersionMatches("14");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1051 */   public static final boolean IS_JAVA_15 = getJavaVersionMatches("15");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1071 */   public static final boolean IS_OS_AIX = getOsMatchesName("AIX");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1083 */   public static final boolean IS_OS_HP_UX = getOsMatchesName("HP-UX");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1095 */   public static final boolean IS_OS_400 = getOsMatchesName("OS/400");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1107 */   public static final boolean IS_OS_IRIX = getOsMatchesName("Irix");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1119 */   public static final boolean IS_OS_LINUX = (getOsMatchesName("Linux") || getOsMatchesName("LINUX"));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1131 */   public static final boolean IS_OS_MAC = getOsMatchesName("Mac");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1143 */   public static final boolean IS_OS_MAC_OSX = getOsMatchesName("Mac OS X");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1155 */   public static final boolean IS_OS_MAC_OSX_CHEETAH = getOsMatches("Mac OS X", "10.0");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1167 */   public static final boolean IS_OS_MAC_OSX_PUMA = getOsMatches("Mac OS X", "10.1");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1179 */   public static final boolean IS_OS_MAC_OSX_JAGUAR = getOsMatches("Mac OS X", "10.2");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1191 */   public static final boolean IS_OS_MAC_OSX_PANTHER = getOsMatches("Mac OS X", "10.3");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1203 */   public static final boolean IS_OS_MAC_OSX_TIGER = getOsMatches("Mac OS X", "10.4");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1215 */   public static final boolean IS_OS_MAC_OSX_LEOPARD = getOsMatches("Mac OS X", "10.5");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1227 */   public static final boolean IS_OS_MAC_OSX_SNOW_LEOPARD = getOsMatches("Mac OS X", "10.6");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1239 */   public static final boolean IS_OS_MAC_OSX_LION = getOsMatches("Mac OS X", "10.7");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1251 */   public static final boolean IS_OS_MAC_OSX_MOUNTAIN_LION = getOsMatches("Mac OS X", "10.8");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1263 */   public static final boolean IS_OS_MAC_OSX_MAVERICKS = getOsMatches("Mac OS X", "10.9");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1275 */   public static final boolean IS_OS_MAC_OSX_YOSEMITE = getOsMatches("Mac OS X", "10.10");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1287 */   public static final boolean IS_OS_MAC_OSX_EL_CAPITAN = getOsMatches("Mac OS X", "10.11");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1299 */   public static final boolean IS_OS_MAC_OSX_SIERRA = getOsMatches("Mac OS X", "10.12");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1311 */   public static final boolean IS_OS_MAC_OSX_HIGH_SIERRA = getOsMatches("Mac OS X", "10.13");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1323 */   public static final boolean IS_OS_MAC_OSX_MOJAVE = getOsMatches("Mac OS X", "10.14");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1335 */   public static final boolean IS_OS_MAC_OSX_CATALINA = getOsMatches("Mac OS X", "10.15");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1347 */   public static final boolean IS_OS_MAC_OSX_BIG_SUR = getOsMatches("Mac OS X", "10.16");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1359 */   public static final boolean IS_OS_FREE_BSD = getOsMatchesName("FreeBSD");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1371 */   public static final boolean IS_OS_OPEN_BSD = getOsMatchesName("OpenBSD");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1383 */   public static final boolean IS_OS_NET_BSD = getOsMatchesName("NetBSD");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1395 */   public static final boolean IS_OS_OS2 = getOsMatchesName("OS/2");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1407 */   public static final boolean IS_OS_SOLARIS = getOsMatchesName("Solaris");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1419 */   public static final boolean IS_OS_SUN_OS = getOsMatchesName("SunOS");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1431 */   public static final boolean IS_OS_UNIX = (IS_OS_AIX || IS_OS_HP_UX || IS_OS_IRIX || IS_OS_LINUX || IS_OS_MAC_OSX || IS_OS_SOLARIS || IS_OS_SUN_OS || IS_OS_FREE_BSD || IS_OS_OPEN_BSD || IS_OS_NET_BSD);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1444 */   public static final boolean IS_OS_WINDOWS = getOsMatchesName("Windows");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1456 */   public static final boolean IS_OS_WINDOWS_2000 = getOsMatchesName("Windows 2000");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1468 */   public static final boolean IS_OS_WINDOWS_2003 = getOsMatchesName("Windows 2003");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1480 */   public static final boolean IS_OS_WINDOWS_2008 = getOsMatchesName("Windows Server 2008");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1492 */   public static final boolean IS_OS_WINDOWS_2012 = getOsMatchesName("Windows Server 2012");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1504 */   public static final boolean IS_OS_WINDOWS_95 = getOsMatchesName("Windows 95");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1516 */   public static final boolean IS_OS_WINDOWS_98 = getOsMatchesName("Windows 98");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1528 */   public static final boolean IS_OS_WINDOWS_ME = getOsMatchesName("Windows Me");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1540 */   public static final boolean IS_OS_WINDOWS_NT = getOsMatchesName("Windows NT");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1552 */   public static final boolean IS_OS_WINDOWS_XP = getOsMatchesName("Windows XP");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1565 */   public static final boolean IS_OS_WINDOWS_VISTA = getOsMatchesName("Windows Vista");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1577 */   public static final boolean IS_OS_WINDOWS_7 = getOsMatchesName("Windows 7");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1589 */   public static final boolean IS_OS_WINDOWS_8 = getOsMatchesName("Windows 8");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1601 */   public static final boolean IS_OS_WINDOWS_10 = getOsMatchesName("Windows 10");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1618 */   public static final boolean IS_OS_ZOS = getOsMatchesName("z/OS");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getEnvironmentVariable(String name, String defaultValue) {
/*      */     try {
/* 1638 */       String value = System.getenv(name);
/* 1639 */       return (value == null) ? defaultValue : value;
/* 1640 */     } catch (SecurityException ex) {
/*      */ 
/*      */       
/* 1643 */       return defaultValue;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getHostName() {
/* 1659 */     return IS_OS_WINDOWS ? System.getenv("COMPUTERNAME") : System.getenv("HOSTNAME");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File getJavaHome() {
/* 1674 */     return new File(System.getProperty("java.home"));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File getJavaIoTmpDir() {
/* 1689 */     return new File(System.getProperty("java.io.tmpdir"));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean getJavaVersionMatches(String versionPrefix) {
/* 1701 */     return isJavaVersionMatch(JAVA_SPECIFICATION_VERSION, versionPrefix);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean getOsMatches(String osNamePrefix, String osVersionPrefix) {
/* 1712 */     return isOSMatch(OS_NAME, OS_VERSION, osNamePrefix, osVersionPrefix);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean getOsMatchesName(String osNamePrefix) {
/* 1722 */     return isOSNameMatch(OS_NAME, osNamePrefix);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String getSystemProperty(String property) {
/*      */     try {
/* 1740 */       return System.getProperty(property);
/* 1741 */     } catch (SecurityException ex) {
/*      */ 
/*      */ 
/*      */       
/* 1745 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File getUserDir() {
/* 1761 */     return new File(System.getProperty("user.dir"));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File getUserHome() {
/* 1776 */     return new File(System.getProperty("user.home"));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getUserName() {
/* 1791 */     return System.getProperty("user.name");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getUserName(String defaultValue) {
/* 1807 */     return System.getProperty("user.name", defaultValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isJavaAwtHeadless() {
/* 1819 */     return Boolean.TRUE.toString().equals(JAVA_AWT_HEADLESS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isJavaVersionAtLeast(JavaVersion requiredVersion) {
/* 1832 */     return JAVA_SPECIFICATION_VERSION_AS_ENUM.atLeast(requiredVersion);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isJavaVersionAtMost(JavaVersion requiredVersion) {
/* 1848 */     return JAVA_SPECIFICATION_VERSION_AS_ENUM.atMost(requiredVersion);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean isJavaVersionMatch(String version, String versionPrefix) {
/* 1864 */     if (version == null) {
/* 1865 */       return false;
/*      */     }
/* 1867 */     return version.startsWith(versionPrefix);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean isOSMatch(String osName, String osVersion, String osNamePrefix, String osVersionPrefix) {
/* 1883 */     if (osName == null || osVersion == null) {
/* 1884 */       return false;
/*      */     }
/* 1886 */     return (isOSNameMatch(osName, osNamePrefix) && isOSVersionMatch(osVersion, osVersionPrefix));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean isOSNameMatch(String osName, String osNamePrefix) {
/* 1900 */     if (osName == null) {
/* 1901 */       return false;
/*      */     }
/* 1903 */     return osName.startsWith(osNamePrefix);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean isOSVersionMatch(String osVersion, String osVersionPrefix) {
/* 1917 */     if (StringUtils.isEmpty(osVersion)) {
/* 1918 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1922 */     String[] versionPrefixParts = osVersionPrefix.split("\\.");
/* 1923 */     String[] versionParts = osVersion.split("\\.");
/* 1924 */     for (int i = 0; i < Math.min(versionPrefixParts.length, versionParts.length); i++) {
/* 1925 */       if (!versionPrefixParts[i].equals(versionParts[i])) {
/* 1926 */         return false;
/*      */       }
/*      */     } 
/* 1929 */     return true;
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\SystemUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */