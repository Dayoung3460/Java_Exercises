package dev.lpa;

public class Main {
    public static void main(String[] args) {
        // array는 클래스
        // 배열 생성될 때 사이즈 정해짐
        // 사이즈 변경 불가
        // 요소 빼기 더하기 불가
        // int 타일 배열, 사이즈 10
        int[] myIntArray = new int[10];
        myIntArray[0] = 45;
        myIntArray[1] = 1;
        myIntArray[5] = 50;

        double[] myDoubleArray = new double[10];
        myDoubleArray[2] = 3.5;

        int[] firstTen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("first = " + firstTen[0]);
        int arrayLength = firstTen.length;
        System.out.println("length of array = " + arrayLength);
        System.out.println("last = " + firstTen[arrayLength - 1]);

        int[] newArray;
//        newArray = new int[] {5, 4, 3, 2, 1};
        // 배열 초기화 안했을 때 디폴트 값
        // 숫자 타입: 0
        // 불린: false
        // class: null
        newArray = new int[5];
        for(int i = 0; i < newArray.length; i++) {
            newArray[i] = newArray.length - i;
        }
        for(int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }

        System.out.println();
        for(int element : newArray) {
            System.out.println(element + " ");
        }
    }


}
