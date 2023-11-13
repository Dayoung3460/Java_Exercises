package linkedlist.dev.lpa.dev;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
//        var placesToVisit = new LinkedList<String>();

        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
//        System.out.println(placesToVisit);
        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);

//        gettingElements(placesToVisit);
//        printItinerary3(placesToVisit);
        testIterator(placesToVisit);

    }

    private static void addMoreElements(LinkedList<String> list) {
        list.addFirst("Darwin");
        list.addLast("hobart");
        // queue methods
        list.offer("Melbourne"); // 리스트 끝에 붙음
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");

        //stack methods
        list.push("Alice Springs"); // 리스트 젤 앞에 붙음
    }

    private static void removeElements(LinkedList<String> list) {
        list.remove(4);
        list.remove("Brisbane");

        System.out.println(list);
        String s1 = list.remove(); // remove first element
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst();
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast();
        System.out.println(s3 + " was removed");

        String p1 = list.poll(); // remove first element
        System.out.println(p1 + " was removed");
        String p2 = list.pollFirst();
        System.out.println(p2 + " was removed");
        String p3 = list.pollLast();
        System.out.println(p3 + " was removed");

        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        System.out.println(list);
        String p4 = list.pop(); // remove first element
        System.out.println(p4 + " was removed");
    }

    private static void gettingElements(LinkedList<String> list) {
        System.out.println("Retrieved Element = " + list.get(4));
        System.out.println("First Element = " + list.getFirst());
        System.out.println("Last Element = " + list.getLast());

        System.out.println("Darwin is at position: " + list.indexOf("Darwin"));
        System.out.println("Melbourne is at position: " + list.lastIndexOf("Melbourne"));

        // queue retrieval methods
        System.out.println("Element from element() = " + list.element()); // return first element

        // stack retrieval methods
        System.out.println("Element from peek() = " + list.peek());// return first element
        System.out.println("Element from peekFirst() = " + list.peekFirst());
        System.out.println("Element from peekLast() = " + list.peekLast());

    }

    public static void printItinerary(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        for (int i = 1; i < list.size(); i++) {
            System.out.println("--> From: " + list.get(i - 1) + " to " + list.get(i));
        }


        System.out.println("Trip ends at " + list.getLast());

    }

    public static void printItinerary2(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        for (String town : list) {
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }

        System.out.println("Trip ends at " + list.getLast());

    }

    public static void printItinerary3(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
//      list.listIterator(): Returns a list-iterator of the elements in this list, starting at the specified position in the list
        ListIterator<String> iterator = list.listIterator(1);
        while (iterator.hasNext()) {
            var town = iterator.next();
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }

        System.out.println("Trip ends at " + list.getLast());

    }

    private static void testIterator(LinkedList<String> list) {
        var iterator = list.listIterator();

        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
            if (iterator.next().equals("Brisbane")) {
                iterator.add("Lake Wivenhoe");
//                iterator.remove();
                // list를 이미 이터레이터로 바꿨기 때문에 에러남.
//                list.remove();
            }
        }
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
        System.out.println(list);
        var iterator2 = list.listIterator(3);
        System.out.println(iterator2.previous());
    }
}
