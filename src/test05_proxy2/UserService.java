package test05_proxy2;

/**
 * 用户业务接口
 */
public interface UserService {
    void login(String loginName, String passWord) throws Exception;
    void deleteUsers() throws Exception;
    String[] selectUsers() throws Exception;
}
