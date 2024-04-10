package test03_reflect;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test4Method {
    @Test
    public void testGetMethods() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c = Student.class;
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() +"------>"
                    + method.getParameterCount() + "------->"
                    + method.getReturnType());
        }

        System.out.println("-------------------------");
        Method run = c.getDeclaredMethod("run");
        System.out.println(run.getName() +"------>"
                + run.getParameterCount() + "------->"
                + run.getReturnType());

        Method eat = c.getDeclaredMethod("eat", String.class);
        System.out.println(eat.getName() +"------>"
                + eat.getParameterCount() + "------->"
                + eat.getReturnType());

        Student s = new Student();
        run.setAccessible(true);
        Object rs = run.invoke(s);
        System.out.println(rs);

        eat.setAccessible(true);
        String rs2 = (String)eat.invoke(s, "hello");
        System.out.println(rs2);

    }
}
