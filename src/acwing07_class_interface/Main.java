package acwing07_class_interface;

import java.util.*;

// 一个源文件可以有多个非public类，带上public就不行了
class Point {
    private int x;
    private int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
public class Main {
    public static void main(String[] args) {
        Point point = new Point(2, 3);
        System.out.println(point.toString());
        System.out.println("Hello");
    }
}
