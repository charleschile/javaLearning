package interview.Singleton;

/**
 * 双重检查锁定（Double-Checked Locking）是一种用于减少获取单例实例时所需的同步开销的技术
 * 它的核心思想是，只有在实例未被创建时才进行同步。这种方法既能保证线程安全，又能提高性能。
 * 双重检查锁定通常用于延迟初始化场景，特别是单例模式的实现中
 */
public class Singleton04 {
    /**
     * volatile关键字的原因与Java内存模型（JMM）有关: 禁止JVM指令重排，保证在多线程环境中也能正常运行
     * 在没有volatile修饰的情况下，instance = new Singleton();这一行代码其实分为三步执行：
     * 1. 为Singleton实例分配内存空间。
     * 2. 初始化Singleton构造器。
     * 3. 将instance对象指向分配的内存空间（此时instance就不是null了）。
     * 但是在JVM的即时编译器中存在指令重排的优化:也就是说这三步的执行顺序并不保证按照1-2-3的顺序，可能会变成1-3-2
     * 如果是1-3-2，则在3执行完毕、2未执行之前，被另一个线程抢占了，这时instance已经非null了（但实际对象还未完成构造），另一个线程就会直接返回一个未初始化完成的实例，导致程序出错
     */
    private volatile static Singleton04 INSTANCE;
    private Singleton04() {};
    public static Singleton04 getInstance() {
        // 是为了避免不必要的同步,这是大多数情况下的实际情况，从而提高程序性能
        if (INSTANCE == null) {
            synchronized (Singleton04.class) {
                /**
                 * 为了防止多个线程同时通过外部的instance为空的检查（因为在某一时刻，实际上只有一个线程能够获得锁并进入同步块内），这时候如果没有第二次检查就直接创建实例，那么可能会有多个实例被创建。
                 * 1. 线程A进入getInstance()方法，判断instance为null，随后进入同步块。
                 * 2. 线程B也调用getInstance()方法，但由于线程A已经进入同步块，线程B在同步块外等待。
                 * 3. 线程A在同步块内通过new Singleton()创建实例，然后离开同步块，返回实例。
                 * 4. 线程B进入同步块，此时如果没有第二次检查，线程B将会再次创建一个新的Singleton实例，违反了单例模式的原则。
                 */
                if (INSTANCE == null) {
                    INSTANCE = new Singleton04();
                }
            }
        }
        return INSTANCE;
    }
}
