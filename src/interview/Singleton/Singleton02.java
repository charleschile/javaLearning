package interview.Singleton;

/**
 * 懒汉式单例模式，线程不安全
 * 懒汉式与饿汉式的区别在于懒汉式的实例是在第一次调用获取实例的方法时创建的。注意，这种方式在多线程环境下不能保证单例的唯一性。
 *
 * 类的实例被声明为static，但不在声明时初始化
 * 第一次调用获取实例的方法时，检查实例是否存在，如果不存在，则创建实例。
 *
 * 缺点：在多线程环境下不能保持单例的唯一性。如果多个线程同时访问并且实例还未创建，那么可能会创建多个实例，违背了单例模式的原则。
 */
public class Singleton02 {
    private static Singleton02 INSTANCE;
    private Singleton02() {};
    public static Singleton02 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton02();
        }
        return INSTANCE;
    }
}
