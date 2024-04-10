package test02_hashCodeOverride;

import java.util.HashMap;
import java.util.Objects;

public class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        // 使用Objects.equals是为了防止数据出现null
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode () {
        // Objects类是Java 7中引入的一个实用工具类，位于java.util包中。这个类提供了一些静态方法来操作对象，这些方法是空安全的，可以减少代码中的空指针异常
        return Objects.hash(name, age);
    }

    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("Chi Le", 23);
        map.put(p1, "Software Engineer Intern");

        // 尝试检索相同属性的新对象
        Person p2 = new Person("Chi Le", 23);
        // 输出Software Engineer Intern
        System.out.println("Occupation: " + map.get(p2));
    }
}
