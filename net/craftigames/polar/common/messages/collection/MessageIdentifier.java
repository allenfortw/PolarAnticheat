package net.craftigames.polar.common.messages.collection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MessageIdentifier {
  int legacyId() default -1;
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\MessageIdentifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */