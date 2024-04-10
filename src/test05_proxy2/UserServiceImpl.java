package test05_proxy2;

public class UserServiceImpl implements UserService{
    @Override
    public void login(String loginName, String passWord) throws Exception {
        if ("admin".equals(loginName) && "123456".equals(passWord)) {
            System.out.println("您登录成功，欢迎光临本系统");
        }
        else {
            System.out.println("您登陆失败，用户名或密码错误");
        }
        Thread.sleep(1000);
    }
    @Override
    public void deleteUsers() throws Exception {
        System.out.println("成功删除了1万个用户");
        Thread.sleep(1500);
    }
    @Override
    public String[] selectUsers() throws Exception {
        System.out.println("查询出了三个用户");
        String[] names = {"张全蛋", "李二狗", "牛爱华"};
        Thread.sleep(500);
        return names;
    }

    public static void main(String[] args) throws Exception {
        /**
         * 您登录成功，欢迎光临本系统
         * login方法执行耗时：1.015s
         * 查询出了三个用户
         * login方法执行耗时：0.503s
         * 成功删除了1万个用户
         * login方法执行耗时：1.514s
         */
        UserServiceImpl u = new UserServiceImpl();
        u.login("admin", "123456");
        u.selectUsers();
        u.deleteUsers();
    }
}

