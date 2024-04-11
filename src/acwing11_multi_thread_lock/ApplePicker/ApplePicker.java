package acwing11_multi_thread_lock.ApplePicker;

public class ApplePicker implements Runnable{
    private static int apples = 9;
    private int numberToTake;
    private String name;
    public ApplePicker(String name, int numberToTake){
        this.name = name;
        this.numberToTake = numberToTake;
    }

    @Override
    public void run() {
        while (true) {
            // 每个时刻只有一个线程能执行这段代码
            synchronized (ApplePicker.class) {
                if (apples >= numberToTake) {
                    apples -= numberToTake;
                    System.out.println(name + " 拿了 " + numberToTake + " 个苹果");
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println(name + " 想要拿 " + numberToTake + " 个苹果，但是只剩下" + apples +"个苹果了");
                    break;
                }

            }
        }
    }

    public static void main(String[] args) {
        // Monkey1是给线程指定的名字
        Thread m1 = new Thread(new ApplePicker("猴子1", 2), "Monkey1");
        Thread m2 = new Thread(new ApplePicker("猴子2", 3), "Monkey2");

        m1.start();
        m2.start();
    }


}
