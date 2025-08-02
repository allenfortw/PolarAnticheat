package net.craftigames.polar.common.configuration.annotations.types;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ConfigInteger {
  String key() default "cfg-int";
  
  int defaultValue();
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\annotations\types\ConfigInteger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */