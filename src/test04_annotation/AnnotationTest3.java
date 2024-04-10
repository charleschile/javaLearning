package test04_annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationTest3 {
    @Test
    public void parseClass() {
        // 解析要先得到Class 对象
        Class c = Demo.class;
        // 解析类上的注解
        // 判断类上是否包含某个注解
        if (c.isAnnotationPresent(MyTest4.class)) {
            MyTest4 myTest4 = (MyTest4)c.getDeclaredAnnotation(MyTest4.class);
            System.out.println(myTest4.value());
            System.out.println(myTest4.aaa());
            // 数组输出的是地址
            System.out.println(myTest4.bbb());
            // 需要输出数组的值的话，需要用到Arrays.toString
            System.out.println(Arrays.toString(myTest4.bbb()));

        }

    }

    @Test
    public void parseMethod() throws NoSuchMethodException {
        // 解析要先得到Class 对象
        Class c = Demo.class;
        Method m = c.getDeclaredMethod("test1");
        // 解析方法上的注解
        // 判断方法上是否包含某个注解
        if (m.isAnnotationPresent(MyTest4.class)) {
            MyTest4 myTest4 = (MyTest4)m.getDeclaredAnnotation(MyTest4.class);
            System.out.println(myTest4.value());
            System.out.println(myTest4.aaa());
            // 数组输出的是地址
            System.out.println(myTest4.bbb());
            // 需要输出数组的值的话，需要用到Arrays.toString
            System.out.println(Arrays.toString(myTest4.bbb()));

        }

    }
}
