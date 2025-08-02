package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;

@Documented
@Untainted(when = When.ALWAYS)
@Retention(RetentionPolicy.RUNTIME)
@TypeQualifierNickname
public @interface Detainted {}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\javax\annotation\Detainted.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */