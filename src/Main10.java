public class Main10 {
    public static void main(String[] args) {
        Car car = new Car("2023 Blue Ferrari 296 GTS");
        runRace(car);

        Car ferrari = new GasPoweredCar("2022 Blue Ferrari 296 GTS", 15.4, 6);
        runRace(ferrari);

        Car tesla = new ElectricCar("2023 Red Tesla Model 3", 568, 75);
        runRace(tesla);

        Car ferrariHybrid = new HybridCar("2023 Black Ferrari SF90 Stradale", 16, 8, 8);
        runRace(ferrariHybrid);
        //Hybrid -> 8 cylinders are fired up.
        //Hybrid -> switch 8 kWh battery on, Ready!
        //Car -> driving, type is HybridCar
        //Hybrid -> usage below average: 16.00
    }

    public static void runRace(Car car) {
        car.startEngine();
        car.drive();
    }
}
