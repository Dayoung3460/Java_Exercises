package comparing.dev.lpa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for (Integer i : others) {
            int val = five.compareTo(i);
            System.out.println(five);
            System.out.println(val); // 1, 0, -1, 1, -1
            System.out.println(i);
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};

        for (String s : fruit) {
            int val = banana.compareTo(s);
            System.out.println(banana);
            System.out.println(val); // 1, 0, -14, 32
            System.out.println(s);
        }

        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));

        System.out.println("A:" + (int) 'A' + " " + "a:" + (int) 'a');

        Student tim = new Student("Tim");
        Student[] students = {new Student("Zach"), new Student("Tim"),
                new Student("Ann")};
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        // 에러 - 인스턴스랑 스트링 비교 못함
//        System.out.println("result = " + tim.compareTo("Mary"));
    }
}

class Student implements Comparable {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        Student other = (Student) o;
        return name.compareTo(other.name);
    }
}
