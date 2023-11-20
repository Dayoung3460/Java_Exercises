package abstractclasses.dev.lpa.dev;

abstract class Mammal extends Animal {

    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        System.out.println(getExplicitType() + " ");
        System.out.println(speed.equals("slow") ? "walks" : "runs");
    }

    public abstract void shedHair();
}

public abstract class Animal {
    protected String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    // private 사용불가. 자식클래스에서 무조건 오버라이딩해야하기 때문
    public abstract void move(String speed);

    public abstract void makeNoise();

    // final: 자식클래스에서 오버라이딩 못함
    public final String getExplicitType() {
        return getClass().getSimpleName() + " (" + type + ")";
    }
}
