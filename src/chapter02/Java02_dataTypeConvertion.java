package chapter02;

public class Java02_dataTypeConvertion {
    public static void main(String[] args) {
        // 数据类型的转换
        String name = "zhangsan";
        int age = 30;
        name = "lisi";
        byte b = 10;
        short s = b;
        int i = s;
        long lon = i;
        float f = lon;
        double d = f;
        // 将范围大的数据转换为范围小的数据，那么需要使用强制转换
        int i1 = (int)d;
        System.out.println(i1);
    }
}
