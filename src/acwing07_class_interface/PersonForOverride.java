package acwing07_class_interface;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class PersonForOverride {
    private int age;
    private String name;

    public PersonForOverride (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString () {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        // getClass()返回的是Class的元数据，处于同一个class的话返回的就是唯一的Class对象
        if (obj == null || getClass() != obj.getClass()) return false;
        // 由于传进来的是Object类型的，所以还需要强转成Person类型
        // 即使getClass()确认了两个对象属于同一个类，你仍然需要将Object类型的参数转换为你的类类型（例如Person），这样才能访问这个类的具体属性或方法，进行更深入的比较。
        PersonForOverride p = (PersonForOverride) obj;
        // Objects.euqals()即使在双方都是null的情况下，仍然返回true
        // 而name.equals(p.name)如果name是null会爆NullPointerException，因为不能在null上调用方法
        return age == p.age && Objects.equals(name, p.name);
    }

    @Override
    public

}

class Main {
    public static void main(String[] args) {
        List<PersonForOverride> people = new ArrayList<>();
        PersonForOverride p1 = new PersonForOverride("chile", 23);
        PersonForOverride p2 = new PersonForOverride("chile", 23);
        PersonForOverride p3 = new PersonForOverride("Alice", 30);
        PersonForOverride p4 = new PersonForOverride("Bob", 25);
        PersonForOverride p5 = new PersonForOverride("Charlie", 35);

        people.add(p1);
        people.add(p3);
        people.add(p4);
        people.add(p5);

        System.out.println(p1.toString());
        System.out.println(p1.equals(p2));

    }
}
