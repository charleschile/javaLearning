package test03_reflect;

import org.junit.Test;
import java.lang.reflect.Field;

public class Test3Field {
    @Test
    public void testGetFields() throws NoSuchFieldException, IllegalAccessException {
        // 1. 反射第一步：必须先得到类的Class对象
        Class c = Student.class;
        // 2. 获取全部成员变量
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + "---->" +field.getType());
        }

        System.out.println("--------------------------------");
        //定位某个成员变量
        Field fName = c.getDeclaredField("name");
        System.out.println(fName.getName() + "---->" + fName.getType());

        Field fAge = c.getDeclaredField("age");
        System.out.println(fAge.getName() + "---->" + fAge.getType());

        Student student = new Student();
        fName.setAccessible(true);
        fName.set(student, "三好学生");
        System.out.println(student);

        String name = (String) fName.get(student);
        System.out.println(name);
    }
}
