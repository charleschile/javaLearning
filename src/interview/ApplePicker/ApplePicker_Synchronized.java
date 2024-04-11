package interview.ApplePicker;

import acwing11_multi_thread_lock.ApplePicker.ApplePicker;

public class ApplePicker_Synchronized implements Runnable {
    private static int appleCount = 11;
    private int pick;
    private String name;

    @Override
    public void run() {
        while (true) {
            synchronized (ApplePicker_Synchronized.class) {
                if (appleCount >= pick) {
                    appleCount -= pick;
                    System.out.println(name + " 拿了 " + pick + " 个苹果");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else {
                    System.out.println(name + " 想要拿 " + pick + " 个苹果，但是失败了");
                    break;
                }
            }
        }
    }

    public static void main (String[] args) {
        Thread m1 = new Thread(new ApplePicker("猴子1", 2), "Monkey1");
        Thread m2 = new Thread(new ApplePicker("猴子2", 3), "Monkey1");
        m1.start();
        m2.start();
    }
}
