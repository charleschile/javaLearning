/**
 * 这是一个代理的工具类
 */
package test05_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static Star createProxy(BigStar bigStar) {
        /**
         * newProxyInstance(ClassLoader loader, 用于指定一个类加载器
         * Class<?>[] interfaces, 用于指定生成的代理长什么样子，也就是哪些方法
         * InvocationHandler h) 用来指定生成的大地里对象要干什么事情
         *
         * 主函数中使用:
         * Star starProxy = ProxyUtil.createProxy(s);
         * starProxy.sing("好日子");
         * starProxy.dance();
         * 而这里的sing和dance就会去回调下面的invoke方法
         */
        Star starProxy = (Star)Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class}, new InvocationHandler() {
                    @Override
                    // invoke是代理的重点，是一个回调方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 代理对象要做的事情，会在这里写代码
                        if(method.getName().equals("sing")) {
                            System.out.println("准备话筒，收钱20万 ");
                        }
                        else if (method.getName().equals("dance")) {
                            System.out.println("准备场地，收钱10000万");
                        }
                        // 其他方法不需要代理也还是method.invoke(bigStar, args);
                        return method.invoke(bigStar, args);
                    }
                });
        return starProxy;
    }
}
