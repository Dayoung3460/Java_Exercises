package setsandmaps.dev.lpa;

import java.util.*;

public class TreeSetMain {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

//        NavigableSet<Contact> sorted = new TreeSet<>(phones);
        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);

        sorted.addAll(phones);
        sorted.forEach(System.out::println);

        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach(c -> justNames.add(c.getName()));
        System.out.println(justNames);

        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        // 이름이 알파벳 순으로 정렬됨
        fullList.sort(sorted.comparator());
        System.out.println("-------------------------");
        fullList.forEach(System.out::println);

        Contact min = Collections.min(fullSet, fullSet.comparator());
        Contact max = Collections.max(fullSet, fullSet.comparator());

        Contact first = fullSet.first();
        Contact last = fullSet.last();

        System.out.println("-----------------");
        System.out.printf("min = %s, first=%s %n", min.getName(), first.getName());
        System.out.printf("max = %s, last=%s %n", max.getName(), last.getName());
        System.out.println("---------------");

        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);

        // pollFirst(), pollLast(): 첫번째, 마지막 요소 반환하면서 copiedSet에서 제거됨
        System.out.println("First element = " + copiedSet.pollFirst());
        System.out.println("Last element = " + copiedSet.pollLast());
        copiedSet.forEach(System.out::println);
        System.out.println("---------------");

        Contact daffy = new Contact("Daffy Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");

        for (Contact c : List.of(daffy, daisy, last, snoopy)) {
            //ceiling(): 제공된 값보다 크거나 같은 값 중 가장 작은 값 (인자값 포함)
            System.out.printf("ceiling(%s)=%s%n", c.getName(), fullSet.ceiling(c));
            //higher(): 제공된 값보다 큰 값 중 가장 작은 값 (인자값 미포함)
            System.out.printf("higher(%s)=%s%n", c.getName(), fullSet.higher(c));
        }
        System.out.println("-----------------");
        for (Contact c : List.of(daffy, daisy, first, archie)) {
//            제공된 값과 같거나 작은 값 중 가장 큰 값 (인자값 포함)
            System.out.printf("floor(%s)=%s%n", c.getName(), fullSet.floor(c));
//            제공된 값보다 작은 값 중 가장 큰 값 (인자값 미포함)
            System.out.printf("lower(%s)=%s%n", c.getName(), fullSet.lower(c));
        }
        System.out.println("-----------------");

        NavigableSet<Contact> descendingSet = fullSet.descendingSet();
        descendingSet.forEach(System.out::println);
        System.out.println("-----------------");

        Contact lastContact = descendingSet.pollLast();
        System.out.println("Removed " + lastContact);
        descendingSet.forEach(System.out::println);
        System.out.println("------------");
        // descendingSet의 상위인 fullSet에도 영향이 가서 Charlie Brown이 제거 돼 있음
        fullSet.forEach(System.out::println);
        System.out.println("-----------------");

        Contact marion = new Contact("Maid Marion");
        // headSet: 특정한 자료(기준값)보다 작은 자료 찾아서 SortedSet으로 반환하는 메서드
        // headSet(기준값): '기준값' 미포함
        // headSet(기준값, 논리값): 논리값이 true면 '기준값' 포함
        var headSet = fullSet.headSet(marion, true);
        headSet.forEach(System.out::println);
        System.out.println("--------------");

        // tailSet: 특정한 자료(기준값)보다 큰 자료 찾아서 SortedSet으로 반환하는 메서드
        // tailSet(기준값): '기준값' 포함
        // tailSet(기준값, 논리값): 논리값이 true면 '기준값' 포함
        var tailSet = fullSet.tailSet(marion, false);
        tailSet.forEach(System.out::println);
        System.out.println("--------------------");

        Contact linus = new Contact("Linus Van Pelt");
        // subSet(기준값1, 기준값2)
        // 기준값1 ~ 기준값2 사이의 값을 가져옴
        // 기준값1 포함, 기준값2 미포함

        // subSet(기준값1, 논리값1, 기준값2, 논리값2)
        // 논리값이 각 기준값을 포함할지 여부를 설정
        var subset = fullSet.subSet(linus, false, marion, true);
        subset.forEach(System.out::println);

    }
}
