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

        int currentYear = LocalDate.now().getYear();

        LocalDate firstDay = LocalDate.ofYearDay(currentYear, 1);
        LocalDate week1 = firstDay.plusDays(7);

        // headMap(): 제공된 키보다 작은 키 값의 Entry를 SortedMap에 담아 반환.
        // 두 번째 인자로 true줄 경우 지정된 키 포함
        Map<LocalDate, List<Purchase>> week1Purchases = datedPurchases.headMap(week1);
        // tailMap(): 제공된 키보다 크거나 같은 값의 Entry를 SortedMap에 담아 반환.
        // 두 번째 인자로 false 줄 경우 지정된 키 포함안함.
        Map<LocalDate, List<Purchase>> week2Purchases = datedPurchases.tailMap(week1);

        displayStats(1, week1Purchases);
        displayStats(2, week1Purchases);

        System.out.println("------------");

        LocalDate lastDate = datedPurchases.lastKey();
        var previousEntry = datedPurchases.lastEntry();

        while (previousEntry != null) {
            List<Purchase> lastDayData = previousEntry.getValue();
            System.out.println(lastDate + " purchases : " + lastDayData.size());

            //lowerKey(): 입력한 key의 순서보다 앞에있는 key를 반환
            LocalDate prevDate = datedPurchases.lowerKey(lastDate);
            // lowerEntry(): 입력한 key의 순서보다 앞에있는 key=value 반환
            previousEntry = datedPurchases.lowerEntry(lastDate);
            lastDate = prevDate;
        }

        System.out.println("--------");
        var reversed = datedPurchases.descendingMap();
        LocalDate firstDate = reversed.firstKey();

//        var nextEntry = reversed.firstEntry();
        // pollFirstEntry(): 맵에서 첫번째 entry 반환하고 맵에서 해당 요소 삭제함. 파라미터 필요없음
        var nextEntry = reversed.pollFirstEntry();

        while (nextEntry != null) {
            List<Purchase> lastDaysData = nextEntry.getValue();
            System.out.println(firstDate + " purchases : " + lastDaysData.size());

            LocalDate nextDate = reversed.higherKey(firstDate);

//            nextEntry = reversed.higherEntry(firstDate);
            nextEntry = reversed.pollFirstEntry();

            firstDate = nextDate;
        }
        System.out.println("-------------");
        // while문 돌면서 pollFirstEntry()로 모든 요소 위에서부터 하나씩 다 삭제해버림.
        // datedPurchases 빈 맵임
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

    private static void displayStats(int period, Map<LocalDate, List<Purchase>> periodData) {
        System.out.println("---------------");
        Map<String, Integer> weeklyCounts = new TreeMap<>();
        periodData.forEach((key, value) -> {
            System.out.println(key + ": " + value);
            for (Purchase p : value) {
                // 루프돌면서 weeklyCounts에 값을 넣는데 키가 중복되면 세번째 파라미터인 함수 로직에 따라 병합됨
                weeklyCounts.merge(p.courseId(), 1, (prev, current) -> {
                    return prev + current;
                });
            }
        });
        System.out.printf("Week %d Purchases = %s%n", period, weeklyCounts);

    }
}

