package sortedmaps.dev.lpa;

import java.time.LocalDate;
import java.util.*;

public class Main {
    // LinkedHashMap 요소 삽입 순서에 따라 정렬됨
    private static Map<String, Purchase> purchases = new LinkedHashMap<>();
    // TreeMap 요소 삽입 순서 상관없이 순서대로 정렬됨
    private static NavigableMap<String, Student> students = new TreeMap<>();

    public static void main(String[] args) {
        Course jmc = new Course("jmc101", "Java Master Class",
                "Java");
        Course python = new Course("pyt101", "Python Master Class",
                "Python");
        addPurchase("Mary Martin", jmc, 129.99);
        addPurchase("Andy Martin", jmc, 139.99);
        addPurchase("Mary Martin", python, 149.99);
        addPurchase("Joe Jones", jmc, 149.99);
        addPurchase("Bill Brown", python, 119.99);
        addPurchase("Chuck Cheese", python, 119.99);
        addPurchase("Davey Jones", python, 139.99);
        addPurchase("Eva East", python, 139.99);
        addPurchase("Fred Forker", python, 139.99);
        addPurchase("Grag Brady", python, 129.99);

        purchases.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("------------------");
        students.forEach((key, value) -> System.out.println(key + ": " + value));

        NavigableMap<LocalDate, List<Purchase>> datedPurchases = new TreeMap<>();
        for (Purchase p : purchases.values()) {
            //compute: key 값이 중복되면 이전값을 새로운 값으로 대체함
            datedPurchases.compute(p.purchaseData(),
                    (pdate, plist) -> {
                        List<Purchase> list =
                                (plist == null) ? new ArrayList<>() : plist;
                        list.add(p);
                        return list;
                    });
        }
        // key값(ex) 2024-01-01, 2024-01-02...) 기준으로 정렬됨
        datedPurchases.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static void addPurchase(String name, Course course, double price) {
        Student existingStudent = students.get(name);
        if (existingStudent == null) {
            existingStudent = new Student(name, course); // Mary Martin, jmc
            students.put(name, existingStudent);
        } else {
            existingStudent.addCourse(course);
        }
        // 1~14 숫자
        int day = new Random().nextInt(1, 15);
//        int day = purchases.size() + 1;
        String key = course.courseId() + "_" + existingStudent.getId(); // jmc101_1
        int year = LocalDate.now().getYear();
        Purchase purchase = new Purchase(course.courseId(),
                existingStudent.getId(), price, year, day);
        purchases.put(key, purchase);
    }
}

