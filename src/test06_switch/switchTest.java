package test06_switch;

public class switchTest {
    public static void main(String[] args) {
        // 特殊分支结构
        // switch
        int i = 10;
        switch (i) {
            case 10 :
                System.out.println("分支1");
                break;
            case 20 :
                System.out.println("分支2");
            case 30 :
                System.out.println("分支2");
            default:
                System.out.println("default");
        }
    }
}
