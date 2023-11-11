package arrayandarraylists.dev.lpa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] originalArray = new String[]{"First", "second", "Third"};
        var originalList = Arrays.asList(originalArray);

        originalList.set(0, "one");
        System.out.println("list: " + originalList);
        // originalArray가 Arrays.asList(originalArray) 이 때 영향을 받으면서 originalList와 같은 값 뱉어냄
        System.out.println("array: " + Arrays.toString(originalArray));

        originalList.sort(Comparator.naturalOrder());
        System.out.println("array: " + Arrays.toString(originalArray));

//        originalList의 요소를 remove 하거나 add 하려고 하면 에러남
        // originalList는 Array이기 때문(요소 변경 set만 가능)
//        originalList.add("fourth");

        List<String> newList = Arrays.asList("Sunday", "Monday", "Tuesday");
        System.out.println(newList);
    }
}
