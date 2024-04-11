package interview.Singleton;

/**
 * 饿汉式单例模式，静态常量
 * 它好比一个“饿汉”，急切地等待着被实例化，因此在类加载时就立即初始化了自己的静态实例。这种方式简单直接，避免了多线程问题。
 * 构造方法一定要私有化，防止被别人构造
 *
 * 在类内部创建静态的实例，并在类加载时就初始化这个实例。这样做确保了类的实例在应用程序中只有一个。
 *
 * 缺点：在类加载时就完成了实例的初始化，因此不管后续用不用到这个实例，内存中总会占有一份资源，这在某种程度上浪费了资源。
 */
public class Singleton01 {
    private final static Singleton01 INSTANCE = new Singleton01();
    private Singleton01() {}
    public static Singleton01 getInstance() {
        return INSTANCE;
    }
}
