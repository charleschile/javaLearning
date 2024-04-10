/**
 * 模拟@Test的执行
 */
package test04_annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest4 {
//    @MyTest
    public void test1() {
        System.out.println("===test1===");
    }

    @MyTest()
    public void test2() {
        System.out.println("===test2===");
    }

//    @MyTest()
    public void test3() {
        System.out.println("===test3===");
    }

    @MyTest()
    public void test4() {
        System.out.println("===test4===");
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // 启动程序
        // 把当前class中的所有方法都拿到，然后挨个问是否有@MyTest注解
        // 有@MyTest注解的才跑起来

        // 1. 得到Class对象
        Class c = AnnotationTest4.class;

        // 2. 提取这个类中的全部成员方法
        Method[] methods = c.getDeclaredMethods();

        // 3. 遍历数组中的每个方法，看方法上是否存在MyTest注解
        // 触发该方法执行
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)) {
                // 当前方法上存在MyTest注解，触发当前方法执行
                AnnotationTest4 a = new AnnotationTest4();
                method.invoke(a);
            }
        }

    }
}
