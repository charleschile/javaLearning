package test03_reflect;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectFrame {
    //目的：保存任意对象的字段和数据到文件中去
    public static void saveObject(Object obj) throws IllegalAccessException, FileNotFoundException {
        // obj是任意对象，到底有多少个字段要保存不知道
        PrintStream ps = new PrintStream(new FileOutputStream("C:\\Users\\chile\\Desktop\\code\\javaLearning\\src\\data.txt", true));
        Class c = obj.getClass();
        String cName = c.getSimpleName();
        ps.println("--------------" + cName + "--------------------");
        // 从类中提取他的全部成员变量
        Field[] fields = c.getDeclaredFields();
        // 遍历每个成员变量
        for (Field field : fields) {
            field.setAccessible(true); // 禁止访问控制
            //先拿到成员变量的名字
            String name = field.getName();
            //拿到成员变量再对象中的数据
            String value = field.get(obj) + "";
            ps.println(name + " = " + value);
        }
        ps.close();
    }
}
