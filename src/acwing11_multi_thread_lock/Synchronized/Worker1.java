package acwing11_multi_thread_lock.Synchronized;

class Worker1 implements Runnable {
    public static int cnt = 0;

    private void work() {
        synchronized (Worker1.class) {
            for (int i = 0; i < 100000; i ++ ) {
                cnt ++ ;
            }
        }

    }

    @Override
    public void run() {
        work();
    }

    public static void main(String[] args) throws InterruptedException {
        Worker1 worker = new Worker1();
        Worker1 worker_1 = new Worker1();
        Thread worker1 = new Thread(worker);
        Thread worker2 = new Thread(worker_1);

        worker1.start();
        worker2.start();
        worker1.join();
        worker2.join();

        System.out.println(Worker1.cnt);
    }
}
