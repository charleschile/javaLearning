package acwing08_container;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        System.out.println(list);
        System.out.println(list.size());

        System.out.println("----增强for循环----");
        for (Integer a : list) {
            System.out.println(a);
        }

        System.out.println("----List集合不支持直接通过下标访问元素----");
        // List集合不支持直接通过下标访问元素
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("----Java原生数组支持通过下表访问元素------");
        int arr[] = new int[3];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 3;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        list.clear();

        System.out.println(list);


    }
}
