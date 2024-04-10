package test05_proxy2;

public class Test {


    public static void main(String[] args) throws Exception {
        // 为用户业务对象创建了代理对象
        UserService userServiceProxy = ProxyUtil.createProxy(new UserServiceImpl());
        userServiceProxy.login("admin", "123456");
        userServiceProxy.deleteUsers();
        userServiceProxy.selectUsers();
    }

}
