package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.When;

@Documented
@TypeQualifier(applicableTo = CharSequence.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Syntax {
  String value();
  
  When when() default When.ALWAYS;
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\javax\annotation\Syntax.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */