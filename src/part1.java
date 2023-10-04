class MyClass {
    int value;

    public MyClass(int value) {

        this.value = value;
    }
}

public class part1 {
    public static void main(String[] args) {

        MyClass obj1 = new MyClass(10);

        MyClass obj2 = obj1;
        MyClass obj3 = obj1;

        obj2.value = 20;

        System.out.println("obj1.value: " + obj1.value); // Should print 20
        System.out.println("obj3.value: " + obj3.value); // Should also print 20
    }
}
