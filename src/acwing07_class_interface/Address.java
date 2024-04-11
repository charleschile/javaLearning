package acwing07_class_interface;

public class Address implements Cloneable {
    private String street;
    private String city;

    // 假设有适当的构造器和getter/setter

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    // Address类的clone方法，用于深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
