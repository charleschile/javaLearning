package interview.Singleton;

/**
 * 懒汉式的基础上增加了同步锁，使其在多线程环境下能够保持单例的唯一性，但相应地降低了性能
 * 为了线程安全，可以在获取实例的方法上添加synchronized关键字，确保每次只有一个线程可以执行实例化代码。
 *
 * 缺点：虽然解决了线程安全问题，但每次访问getInstance()方法时都需要进行同步，这会导致不必要的同步开销，降低了性能。
 */
public class Singleton03 {
    private static Singleton03 INSTANCE;
    private Singleton03 () {};
    public static synchronized Singleton03 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }
}
