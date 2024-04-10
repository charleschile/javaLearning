package test04_annotation;
@MyTest1(aaa="乐驰", ccc={"HTML", "JAVA"})
@MyTest2("孙悟空")
public class AnnotationTest1 {
    @MyTest1(aaa="戚汝洁", bbb=false, ccc={"C++", "C"})
    public void test1() {

    }

    public static void main(String[] args) {

    }
}
