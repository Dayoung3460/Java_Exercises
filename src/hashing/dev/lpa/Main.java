package hashing.dev.lpa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l", "He", "lo");
        String dText = "He".concat("llo");
        String eText = "hello";

        List<String> hellos = Arrays.asList(aText, bText, cText, dText, eText);
        hellos.forEach((s) -> System.out.println(s + ": " + s.hashCode()));

        // HashSet은 hashCode로 중복값을 찾아냄
        Set<String> mySet = new HashSet<>(hellos);

        System.out.println("mySet: " + mySet);
        System.out.println("# of elements = " + mySet.size());

        for (String setValue : mySet) {
            System.out.println(setValue + ": ");
            for (int i = 0; i < hellos.size(); i++) {
                // 참조값이 같은지
                if (setValue == hellos.get(i)) {
                    System.out.println(i + ", ");
                }
            }
        }
        // *** aText, bText, cText, dText는 같은 값 'Hello'로 해쉬코드가 같음
        // 하지만 객체 메모리상으로는 aText, bText가 같은 참조값을 가지고 있고
        // cText, dText, eText는 서로 다른 객체를 참조하고 있음

        System.out.println(" ");

        PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard kingClubs = new PlayingCard("Clubs", "King");
        PlayingCard queenSpades = new PlayingCard("Spades", "Queen");

        List<PlayingCard> cards = Arrays.asList(aceHearts, kingClubs, queenSpades);
        cards.forEach((s) -> System.out.println(s + ": " + s.hashCode()));

        System.out.println("----------------------");
        Set<PlayingCard> deck = new HashSet<>();

        // set은 루프돌 때 리스트의 순서대로 안돌 수도 있음

        for (PlayingCard c : cards) {
            System.out.println(c);
            // add()는 성공적으로 요소 추가하면 트루 반환
            // set에는 중복값이 add 될 수 없음
            // add()가 실행될 때 PlayingCard의 오버라이딩된 equals() 실행함
            // cards요소(c)끼리 hashCode 비교해서 같은 hashCode값이 중복되면 안됨
            if (!deck.add(c)) {
                System.out.println("Found a duplicated for " + c);
            }
        }
        System.out.println(deck);

    }

}
