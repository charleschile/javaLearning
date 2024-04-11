package acwing11_multi_thread_lock.Synchronized;

import java.util.concurrent.locks.ReentrantLock;
class Worker extends Thread {
    public static int cnt = 0;
    private static final ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        for (int i = 0; i < 100000; i ++ ) {
            lock.lock();
            try {
                cnt ++ ;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker1 = new Worker();
        Worker worker2 = new Worker();

        worker1.start();
        worker2.start();
        worker1.join();
        worker2.join();

        System.out.println(Worker.cnt);
    }
}

