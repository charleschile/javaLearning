package interview.ApplePicker;

import acwing11_multi_thread_lock.ApplePicker.ApplePicker;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ApplePicker_ReentrantLock implements Runnable {
    private static final Lock lock = new ReentrantLock();
    private static int apples = 11;
    private int numberToTake;
    private String name;
    public ApplePicker_ReentrantLock(String name, int numberToTake) {
        this.name = name;
        this.numberToTake = numberToTake;
    }
    @Override
    public void run () {
        while(true) {
            lock.lock();
            try {
                if (apples >= numberToTake) {
                    apples -= numberToTake;
                    System.out.println(name + " 拿了 " + numberToTake + " 个苹果");
                    Thread.sleep(1000);
                }
                else {
                    System.out.println(name + " 想要拿 " + numberToTake + " 个苹果，但是只剩下" + apples +"个苹果了");
                    break;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Thread monkey1 = new Thread(new ApplePicker("猴子1", 2), "Monkey1");
        Thread monkey2 = new Thread(new ApplePicker("猴子2", 3), "Monkey2");

        monkey1.start();
        monkey2.start();
    }

}