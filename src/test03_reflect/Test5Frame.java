package test03_reflect;

import org.junit.Test;

import java.io.FileNotFoundException;

public class Test5Frame {
    @Test
    public void save () throws FileNotFoundException, IllegalAccessException {
        Student s1 = new Student();
        Teacher t1 = new Teacher("乐老师", 9999999.9);
        ObjectFrame.saveObject(s1);
        ObjectFrame.saveObject(t1);

    }
}
