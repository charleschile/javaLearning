package acwing11_multi_thread_lock.WaitNotify;

class Worker extends Thread {
    private final Object object;
    private final boolean needWait;

    public Worker(Object object, boolean needWait) {
        this.object = object;
        this.needWait = needWait;
    }

    @Override
    public void run() {
        synchronized (object) {
            try {
                if (needWait) {
                    object.wait();
                    System.out.println(this.getName() + ": 被唤醒啦！");
                } else {
                    object.notifyAll();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        for (int i = 0; i < 5; i ++ ) {
            Worker worker = new Worker(object, true);
            worker.setName("thread-" + i);
            worker.start();
        }

        Worker worker = new Worker(object, false);
        worker.setName("thread-" + 5);
        Thread.sleep(1000);
        worker.start();
    }
}