package test04_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 代表注解只能注解方法
@Retention(RetentionPolicy.RUNTIME) // 代表存活到运行阶段，让当前注解可以一直存活者
public @interface MyTest {
}
