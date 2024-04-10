package chapter02;

public class Java02_variable {
    public static void main(String[] args) {
        String name = "zhangsan";
        byte b = 10;
        short s = 10;
        int i = 10;
        long l = 10;
        // 默认情况下，小数点的数据会被识别为精度较高的双精度double类型，使用F结尾来标识单精度
        float f = 1.0F;
        double d = 2.0;

        char c = '@';


        boolean bln = true;


        System.out.println(name);

        System.out.println(1 / 2);
    }
}
