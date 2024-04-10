package test01_junit;

import org.junit.*;

public class test01_junitTest {
    @Before
    public void test1() {
        System.out.println("---> test1 Before 执行了----");
    }

    @After
    public void test2() {
        System.out.println("---> test2 After 执行了----");
    }

    @BeforeClass
    public static void test3() {
        System.out.println("---> test3 BeforeClass 执行了----");
    }


    @AfterClass
    public static void test4() {
        System.out.println("---> test4 AfterClass 执行了----");
    }

    @Test
    public void testPrintNumber() {
        test01_junit.printNumber("Chi Le");
        test01_junit.printNumber(null);
    }

    @Test
    public void testGetMaxIndex() {
        int index1 = test01_junit.getMaxIndex(null);
        System.out.println(index1);

        int index2 = test01_junit.getMaxIndex("admin");
        System.out.println(index2);

        // 断言机制：通过预测业务方法的结果来判断是否正确
        Assert.assertEquals("方法内部有bug!", 4, index2);
    }


}
