package javax.annotation.meta;

import javax.annotation.Nonnull;

public interface TypeQualifierValidator<A extends java.lang.annotation.Annotation> {
  @Nonnull
  When forConstantValue(@Nonnull A paramA, Object paramObject);
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\javax\annotation\meta\TypeQualifierValidator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */