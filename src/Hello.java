package src;

public class Hello {
    public static void main(String[] args) {
        boolean isAlien = false;
        if(isAlien == false) {
            System.out.println("It is not an alien");
        }

        int topScore = 100;
        if(topScore >= 100) {
            System.out.println("You got the high score");
        }

        int secondTopScore = 60;
        if(topScore > secondTopScore && topScore == 100) {
            System.out.println("Greater than second top score and less than 100");
        }

        int newValue = 50;
        if(newValue == 50) {
            System.out.println("this is an error");
        }

        boolean isCar = false;
        if(!isCar) {
            System.out.println("isCar");
        }

        String makeOfCar = "volkswagen";
        boolean isDomestic = makeOfCar == "volkswagen" ? false : true;
        System.out.println("-------");

        Double doubleVal = 20.00;
        Double doubleValTwo = 80.00;
        Double plus = (doubleVal + doubleValTwo) * 100.00;
        Double remainder = plus % 60.00;
    }
}
