package interview.Singleton;

/**
 * 内部静态类
 * 这种方式通过使用一个内部静态类来持有外部类的单例实例，这样既实现了延迟加载，又由JVM保证了线程安全。内部类不会在外部类加载时立即加载，而是在需要实例化时加载和初始化。
 * 利用类加载机制保证初始化实例时的线程安全性。这种方法是懒加载和线程安全的一种优雅实现。
 *
 * 对于静态内部类，其加载时机也遵循这个规则，即只有在第一次使用时才会被加载
 * SingletonHolder是一个静态内部类，它持有Singleton的静态实例。当外部类Singleton的getInstance()方法被调用时，才会首次引用SingletonHolder.INSTANCE，这个引用触发了SingletonHolder类的加载和初始化，从而实例化Singleton。在这之前，Singleton实例并未创建，实现了延迟加载。
 */
public class Singleton05 {
    private Singleton05() {};
    private static class SingletonHolder {
        private static final Singleton05 INSTANCE = new Singleton05();
    }

    public static Singleton05 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
