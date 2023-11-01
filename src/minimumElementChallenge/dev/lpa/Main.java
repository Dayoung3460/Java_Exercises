package minimumElementChallenge.dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] returnedArray = readIntegers();
        System.out.println(Arrays.toString(returnedArray));

        int returnedMin = findMin(returnedArray);
        System.out.println("min = " + returnedMin);

        // by 나
        int[] myReversedArray = myReverse(returnedArray);
        System.out.println("my reverse = " + Arrays.toString(myReversedArray));

        // by 강사
        teacherReverse(returnedArray);
        System.out.println("teacher reverse = " + Arrays.toString(returnedArray));
    }
    private static int[] readIntegers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of integers, separated by commas: ");
        String input = scanner.nextLine();

        String[] splits = input.split(", ");
        int[] values = new int[splits.length];

        for(int i = 0; i < splits.length; i++) {
            values[i] = Integer.parseInt(splits[i].trim());
        }

        return values;
    }

    private static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for(int el : array) {
            if(el < min) {
                min = el;
            }
        }
        return min;
    }

    private static int[] myReverse(int[] array) {
        int[] reversedArray = new int[array.length];

        for(int i = array.length - 1; i >= 0; i--) {
            reversedArray[i] = array[array.length-1-i];
        }
        return reversedArray;

    }

    private static void teacherReverse(int[] array) {
        int maxIndex = array.length - 1; // 4
        int halfLength = array.length / 2; // 2

        for(int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i ] = temp;
        }
    }
}
