package test02_hashCodeOverride;

import java.util.HashMap;
import java.util.Objects;

public class PersonWithoutOverride {
    private String name;
    private int age;
    public PersonWithoutOverride(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        HashMap<PersonWithoutOverride, String> map = new HashMap<>();
        PersonWithoutOverride p1 = new PersonWithoutOverride("Chi Le", 23);
        map.put(p1, "Software Engineer Intern");

        // 尝试检索相同属性的新对象
        PersonWithoutOverride p2 = new PersonWithoutOverride("Chi Le", 23);
        // 输出null
        System.out.println("Occupation: " + map.get(p2));
    }
}
