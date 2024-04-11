package acwing07_class_interface;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class PersonForOverride implements Comparable<PersonForOverride>, Cloneable {
    private int age;
    private String name;
    private Address address;

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

    // 重写hashCode方法是为了确保当两个对象通过equals方法比较为相等时，它们的哈希码也应该相同
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    /**
     * 正数：表示当前对象（this）应该排在比较对象（other）之后。
     * 零：表示两个对象相等，排序时它们之间的顺序不重要。
     * 负数：表示当前对象（this）应该排在比较对象（other）之前。
     * @param other the object to be compared.
     * @return
     */
    @Override
    public int compareTo(PersonForOverride other) {
        int nameCompare = this.name.compareTo(other.name);
        if (nameCompare == 0) {
            // 如果第一个整数小于、等于或大于第二个整数，它分别返回负整数、零或正整数
            return Integer.compare(this.age, other.age);
        }
        return nameCompare;
    }

    /**
     * 当一个类实现了Cloneable接口并且希望提供一个克隆（复制）自身的方法时，它通常会重写Object类中的clone()方法。
     * Object类是Java中所有类的根类，它提供了一个基本的clone()方法实现，但这个方法默认是protected的，并且它的行为是执行浅拷贝。当你在子类中重写clone()方法
     * 使用super.clone()调用实际上是在调用Object类中已经实现的clone()方法，以利用其提供的克隆功能。
     *
     * 当子类和父类有同名的成员（方法或变量），super可以用来引用父类的成员。
     * 在子类的构造器中，可以通过super()调用父类的构造方法。如果不显式调用，编译器会自动插入对父类无参构造器的调用。
     *
     * 使用super.clone()是为了调用在Object类中实现的原始clone()方法，这个方法负责创建对象的一个浅表复制
     *
     * 浅拷贝：对于引用类型字段，浅拷贝仅复制引用而不复制引用指向的对象。因此，原始对象和副本指向同一个引用类型实例。
     * 修改一个列表中的对象会影响另一个列表中的相同对象。
     *
     * @return
     * @throws CloneNotSupportedException
     */
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    /**
     * 深拷贝：为其引用类型字段指向的所有对象创建副本。这意味着原始对象和副本不会共享任何引用类型字段指向的对象。
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        PersonForOverride cloned = (PersonForOverride) super.clone();
        cloned.address = (Address) this.address.clone();
        return cloned;
    }
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
