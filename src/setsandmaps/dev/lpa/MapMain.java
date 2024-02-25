package setsandmaps.dev.lpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("------------------------");

        Map<String, Contact> contacts = new HashMap<>();
        for (Contact contact : fullList) {
            // 중복된 키가 있으면 이전 요소가 없어지고 새로운게 추가됨
            contacts.put(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));
        System.out.println("--------------");
        System.out.println(contacts.get("Charlie Brown"));

        System.out.println(contacts.get("Chuck Brown"));
        Contact detaultContact = new Contact("Chuck Brown");
        System.out.println(contacts.getOrDefault("Chuck Brown", detaultContact));

        System.out.println("----------------------");
        contacts.clear();
        for (Contact contact : fullList) {
            // contacts에 contact를 넣으려고 할 때 중복되는 값이 있으면 중복되는 값을 반환
            // 없으면 null
            Contact duplicate = contacts.put(contact.getName(), contact);

            if (duplicate != null) {
//                System.out.println("duplicate = " + duplicate);
//                System.out.println("current = " + contact);
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));
        System.out.println("----------------");
        contacts.clear();

        for (Contact contact : fullList) {
            // 중복된 키가 있으면 리스트에 안 집어넣음
            contacts.putIfAbsent(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("----------------");
        contacts.clear();

        for (Contact contact : fullList) {
            Contact duplicate = contacts.putIfAbsent(contact.getName(), contact);
            if (duplicate != null) {
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-------------");
        contacts.clear();
        // merge: contacts에 루프 돌면서 요소를 넣는데 키가 중복되면 세번째 파라미터인 함수 로직에 따라 병함됨
        fullList.forEach(contact -> contacts.merge(contact.getName(), contact,
                Contact::mergeContactData

        ));
        System.out.println("-----------------");
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------");
        for (String contactName : new String[]{"Daisy Duck", "Daffy Duck",
                "Scrooge McDuck"}) {
            //compute: key 값이 중복되면 이전값을 새로운 값으로 대체함
//            contacts.compute(contactName, (k, v) -> new Contact(k));

//          중보되는 키값이 없을 때만 새로운 요소 넣음
            contacts.computeIfAbsent(contactName, (k) -> new Contact(k));
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------");
        for (String contactName : new String[]{"Daisy Duck", "Daffy Duck",
                "Scrooge McDuck"}) {
            contacts.computeIfPresent(contactName, (k, v) -> {
                v.addEmail("Fun place");
                return v;
            });
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("---------------------------------------------");
        contacts.replaceAll((k, v) -> {
            String newEmail = k.replaceAll(" ", "") + "@funplace.com";
            v.replaceEmailIfExists("DDuck@funplace.com", newEmail);
            return v;
        });
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("---------------------------------------------");
        Contact daisy = new Contact("Daisy Jane Duck", "daisyj@juck.com");

        Contact replacedContact = contacts.replace("Daisy Duck", daisy);
        System.out.println("daisy = " + daisy);
        System.out.println("replacedContact = " + replacedContact);
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

        System.out.println("---------------------------------------------");
        Contact updatedDaisy = replacedContact.mergeContactData(daisy);
        System.out.println("updatedDaisy = " + updatedDaisy);
        boolean success = contacts.replace("Daisy Duck", daisy,
                updatedDaisy);
        if (success) {
            System.out.println("Successfully replaced element");
        } else {
            System.out.println("Did not match on both key: %s and value: %s %n"
                    .formatted("Daisy Duck", replacedContact));
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

        System.out.println("---------------------------------------------");
        success = contacts.remove("Daisy Duck", daisy);
        if (success) {
            System.out.println("Successfully removed element");
        } else {
            System.out.println("Did not match on both key: %s and value: %s %n"
                    .formatted("Daisy Duck", daisy));
        }
        contacts.forEach((k, v) -> System.out.println("key= " + k + ", value=" + v));

        
    }
}
