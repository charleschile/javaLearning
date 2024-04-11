package interview.Singleton;

/**
 * 枚举单例模式
 * 枚举类型（enum）的特性来实现单例模式的一种方式
 * 这种实现方式不仅简洁易懂，而且自动提供了序列化机制，并由JVM保证了绝对的线程安全和单一实例的保证，这些特性使得枚举实现方式成为实现单例模式的最佳方法之一。
 * 枚举类型（enum）本质上是一种类，它有自己的字段、方法和构造函数。但与普通类不同的是，枚举的实例被限制为在枚举定义中显式声明的几个实例，而且这些实例在JVM中是唯一的。
 */
public enum Singleton06 {
    INSTANCE; // 显式声明的单例实例

    public void doSomething() {
        System.out.println("do something");
    }
}
