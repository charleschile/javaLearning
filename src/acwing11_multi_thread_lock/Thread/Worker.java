package acwing11_multi_thread_lock.Thread;

public class Worker extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // getName返回的是Thread线程名
            System.out.println("Hello! "+ i + " " + this.getName());
            try {
                Thread.sleep(1000);
            }
            // 注意这里sleep抛的是InterruptedException
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    public static void main (String[] args) {
        Worker worker1 = new Worker();
        Worker worker2 = new Worker();
        worker1.setName("thread-1");
        worker2.setName("thread-2");
        worker1.start();
        worker2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }

        try {
            // 最多等五秒钟
            worker1.join(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // interrupt可以打断sleep
        worker1.interrupt();

        System.out.println("不等了");
        try {
            worker2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main thread finished!");
    }
}
