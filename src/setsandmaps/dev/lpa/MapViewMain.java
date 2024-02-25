package setsandmaps.dev.lpa;

import java.util.*;

public class MapViewMain {
    public static void main(String[] args) {
        Map<String, Contact> contacts = new HashMap<>();
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));

        // keysView, contacts 같은 참조값 가짐
        Set<String> keysView = contacts.keySet();
        System.out.println(keysView);

        // 새로운 객체 생성 -> copyOfKeys, contacts 참조값이 서로 다름
        Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKeys);

        if (contacts.containsKey("Linus Van Pelt")) {
            System.out.println("Linus and i go way back, so of course i have info");
        }
        keysView.remove("Daffy Duck");
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));

        System.out.println("----------------");
        // contacts에 영향을 주지 않음
        copyOfKeys.remove("Linus Van Pelt");
        System.out.println(copyOfKeys);
        contacts.forEach((k, v) -> System.out.println(v));

        System.out.println("----------------");
        keysView.retainAll(List.of("Linus Van Pelt", "Charlie Brown", "Robin Hood", "Mickey Mouse"));
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));

        keysView.clear();
        System.out.println(contacts);

        // error: keySet()에 연산(add()) 할 수 없음
//        keysView.add("Daffy Duck");

        System.out.println("----------------");
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        // keysView에 새로 값 안넣어줘도 contacts의 변경 사항을 실시간 반영
        System.out.println(keysView);
        System.out.println("----------------");
        var values = contacts.values();
        values.forEach(System.out::println);

        System.out.println("----------------");
        // retainAll 두 리스트의 교집합만 남기고 나머지는 values에서 제거
        values.retainAll(ContactData.getData("email"));
        System.out.println(values);
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));

        System.out.println("-------------");
        List<Contact> list = new ArrayList<>(values);
        list.sort(Comparator.comparing(Contact::getNameLastFirst));
        list.forEach(c -> System.out.println(c.getNameLastFirst() + ": " + c));

        System.out.println("-------------");
        Contact first = list.get(0);
        contacts.put(first.getNameLastFirst(), first);
        values.forEach(System.out::println);
        keysView.forEach(System.out::println);

        System.out.println("-------------");
        HashSet<Contact> set = new HashSet<>(values);
        set.forEach(System.out::println);
        if (set.size() < contacts.keySet().size()) { // 5 < 6
            System.out.println("Duplicate Values are in my Map");
        }

        System.out.println("-------------");
        var nodeSet = contacts.entrySet();
        nodeSet.forEach(System.out::println);
        for (var node : nodeSet) {
            System.out.println(nodeSet.getClass().getName()); // java.util.HashMap$EntrySet
            if (!node.getKey().equals(node.getValue().getName())) {
                System.out.println(node.getClass().getName()); // java.util.HashMap$Node
                System.out.println("Key doesn't match name: " + node.getKey() + ": " +
                        node.getValue());
            }
        }
    }
}
