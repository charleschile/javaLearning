package test05_proxy;

public class BigStar implements Star{
    private String name;

    public BigStar(String name) {
        this.name = name;
    }

    public String sing(String name) {
        // 准备和收钱让代理来处理
        System.out.println(this.name + " 正在唱歌：" + name);
        return "谢谢！谢谢！";
    }

    public void dance() {
        System.out.println(this.name + " 正在优美的跳舞");
    }
}