package acwing11_multi_thread_lock.Synchronized;

public class Count extends Thread {
    public static int cnt = 0;
    @Override
    public void run () {
        for (int i = 0; i <= 100000; i++) {
            cnt++;
        }
    }

    public static void main (String[] args) throws InterruptedException {
        Count c1 = new Count();
        Count c2 = new Count();
        c1.start();
        c2.start();
        c1.join();
        c2.join();
        System.out.println(Count.cnt);
    }
}
