package test03_reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test2Constructor {
    @Test
    public void testGetConstructors() {
        // 1. 反射第一步，必须先得到类的Class对象
        Class s = Student.class;
        // 2. 获取类的全部构造器
        Constructor[] constructors = s.getConstructors();
        // 3. 遍历数组中的每个构造器对象
        for (Constructor constructor : constructors) {
            // 输出构造器名字
            // test03_reflect.Student---->0
            // test03_reflect.Student---->2
            System.out.println(constructor.getName() + "---->" + constructor.getParameterCount());
        }

        System.out.println("--------------------------------------");

        Constructor[] constructors2 = s.getDeclaredConstructors();
        // 3. 遍历数组中的每个构造器对象
        for (Constructor constructor : constructors2) {
            // 输出构造器名字
            // test03_reflect.Student---->0
            // test03_reflect.Student---->2
            System.out.println(constructor.getName() + "---->" + constructor.getParameterCount());
        }

        System.out.println("--------------------------------------");

    }

    @Test
    public void testGetConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c = Student.class;
        Constructor constructor = c.getDeclaredConstructor();
//        Constructor constructor = c.getConstructor();
        System.out.println(constructor.getName() + "---->" + constructor.getParameterCount());
        Student s = (Student)constructor.newInstance();
        System.out.println(s);


        Constructor constructor1 = c.getDeclaredConstructor(String.class);
        // 暴力反射private构造方法
        constructor1.setAccessible(true);
        Student s1 = (Student)constructor1.newInstance("Rujie Qi");
        System.out.println(s1);
        System.out.println(constructor1.getName() + "---->" + constructor1.getParameterCount());
    }
}
