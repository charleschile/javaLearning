package test03_reflect;
/*
反射获取CLass对象
 */
public class Student {
    private String name;
    private int age;

    public static int a;
    public static final String COUNTRY = "中国";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge () {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Student() {
        System.out.println("无参数public构造器执行了");
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("两个参数public构造器执行了");
    }

    private Student(String name) {
        this.name = name;
        this.age = 0;
        System.out.println("单个参数private构造器执行了");
    }

    @Override
    public String toString() {
        return "Student{" + "name=" +name + '\'' +
                ", age=" + age + '}';
    }

    private void run () {
        System.out.println("跑的真快");
    }

    public void eat() {
        System.out.println("最爱吃香肠");
    }
    private String eat(String name) {
        return "最爱吃: " + name;
    }

}
