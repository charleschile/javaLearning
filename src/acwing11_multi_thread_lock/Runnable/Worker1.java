package acwing11_multi_thread_lock.Runnable;

import acwing11_multi_thread_lock.Thread.Worker;

public class Worker1 implements Runnable {
    private String name;
    public Worker1(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i ++ ) {
            System.out.println("Hello! " + this.name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main (String[] args) {
        Thread w1 = new Thread(new Worker1("haocheng ni"), "thread-1");
        Thread w2 = new Thread(new Worker1("han tang"), "thread-2");
        w1.start();
        w2.start();;
    }
}
