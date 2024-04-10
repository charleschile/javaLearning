package test05_proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static UserService createProxy(UserServiceImpl userServiceImpl) {
        UserService userService = (UserService) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                new Class[]{UserService.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String name = method.getName();
                        if (name.equals("login") || name.equals("deleteUsers") || name.equals("selectUsers")) {
                            long startTime = System.currentTimeMillis();
                            Object o =  method.invoke(userServiceImpl, args);
                            long endTime = System.currentTimeMillis();
                            System.out.println(method.getName() + "方法执行耗时：" + (endTime - startTime) / 1000.0 + "s");
                            return o;
                        }
                        else {
                            Object o =  method.invoke(userServiceImpl, args);
                            return o;
                        }
                    }
                });
        return userService;
    }
}
