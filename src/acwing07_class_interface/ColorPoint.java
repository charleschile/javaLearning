package acwing07_class_interface;

public class ColorPoint extends Point {
    private String color;
    public ColorPoint(int x, int y, String color) {
        // super调用父类的构造函数
        // 因为直接使用this.x = x，当前类中并没有x，所以无法调用
        super(x, y);
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 子类和父类中都有toString会优先使用子类中的toString函数
     * @return
     */
    public String toString() {
        return String.format("(%d, %d, %s)", super.getX(), super.getY(), this.color);
    }
}

class main {
    public static void main(String[] args) {
        Point point = new Point(2, 3);
        Point colorPoint = new ColorPoint(2, 3, "blue");
        System.out.println(point.toString());
        System.out.println(colorPoint.toString());
    }
}