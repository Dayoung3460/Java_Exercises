package usingarray.dev.lpa;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = new int[10];
        System.out.println(Arrays.toString(secondArray)); //[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        // 배열의 모든 값을 같은 값으로 초기화
        Arrays.fill(secondArray, 5);
        System.out.println(Arrays.toString(secondArray));//[5, 5, 5, 5, 5, 5, 5, 5, 5, 5]

        int[] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));

        // 깊은 복사
        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        System.out.println(Arrays.toString(fourthArray));

        // thirdArray를 복사했던 fourthArray 소팅해도 thirdArray값은 변하지 x
        Arrays.sort(fourthArray);
        System.out.println(Arrays.toString(thirdArray));
        System.out.println(Arrays.toString(fourthArray));

        // thirdArray 앞에서 5개 값까지 복사됨
        int[] smallerArray = Arrays.copyOf(thirdArray, 5);
        System.out.println(Arrays.toString(smallerArray));

        // thirdArray 다 복사 하고 남은 공간엔 0으로 채워짐
        int[] largerArray = Arrays.copyOf(thirdArray, 15);
        System.out.println(Arrays.toString(largerArray)); // [98, 23, 10, 5, 33, 69, 2, 2, 14, 17, 0, 0, 0, 0, 0]
    }

    private static int[] getRandomArray(int len) {
        Random random = new Random();
        int[] newInt = new int[len];
        for(int i = 0; i < len; i++) {
            // 0 ~ 99 사이의 정수형 난수
            newInt[i] = random.nextInt(100);
        }

        return newInt;
    }
}
