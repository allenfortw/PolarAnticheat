package net.craftigames.polar.common.dependencies.classloader;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public interface PluginClassLoader {
  URLClassLoader getClassLoader();
  
  void loadJar(URL paramURL);
  
  void loadJar(File paramFile);
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\dependencies\classloader\PluginClassLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */