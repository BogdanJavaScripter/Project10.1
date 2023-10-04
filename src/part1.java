class MyClass {
    int value;

    public MyClass(int value) {

        this.value = value;
    }
}

public class part1 {
    public static void main(String[] args) {

        MyClass obj4 = new MyClass(10);

        MyClass obj = obj4;
        MyClass obj2 = obj4;

        obj2.value = 20;

        System.out.println("obj2.value: " + obj2.value); // Should print 20
        System.out.println("obj3.value: " + obj.value); // Should also print 20
    }
}
