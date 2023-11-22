package interfaceexample;

public class Cat implements Animal {
    @Override
    public void move() {
        System.out.println("냥 슥");
    }

    @Override
    public void eat() {
        System.out.println("냥 냠");
    }

    @Override
    public void bark() {
        System.out.println("야옹");
    }
}
