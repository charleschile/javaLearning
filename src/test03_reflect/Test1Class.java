package test03_reflect;

public class Test1Class {
    public static void main(String[] args) throws ClassNotFoundException {
        // c1指向Student类的字节码，代表了整个学生类
        Class c1 = Student.class;
        // 全类名test03_reflect.Student
        System.out.println(c1.getName());
        // 简名就是普通类名Student
        System.out.println(c1.getSimpleName());
//        c1.getMethod()
//        c1.getConstructor();

        // c1和c2拿到的是同一个地址
        Class c2 = Class.forName("test03_reflect.Student");
        System.out.println(c1 == c2);

        //实例化Student
        // getClass得到的也是原始的那个Class
        Student s = new Student();
        Class c3 = s.getClass();

        System.out.println(c3 == c2);

    }
}
