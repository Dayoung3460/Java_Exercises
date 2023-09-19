package src;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        System.out.println(car.isConvertible());
        car.setConvertible(false);
        System.out.println(car.isConvertible());
        car.setMake("Holden");
        System.out.println(car.getMake());
        car.describeCar();
    }
}
