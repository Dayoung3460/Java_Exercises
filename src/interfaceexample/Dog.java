package interfaceexample;

public class Dog implements Animal {
    @Override
    public void move() {
        System.out.println("슥");
    }

    @Override
    public void eat() {
        System.out.println("냠");
    }

    @Override
    public void bark() {
        System.out.println("멍");
    }
}
