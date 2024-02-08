package collectionMethods.dev.lpa;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);

        // 용량을 52로 만든다는거지 어떤 요소로 채워져 있지 않음. null로도 채워져 있지 않음
        List<Card> cards = new ArrayList<>(52);
        // fill 메서드는 요소를 추가하지 않음. cards가 0이기 때문에 채워지지 않음. 기본값을 넣어줘야함.
        Collections.fill(cards, aceOfHearts);
        System.out.println(aceOfHearts);
        System.out.println(cards); // []
        System.out.println("cards.size() = " + cards.size());  // 0


        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "kingOfClubs", 1);

        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card Collection with Aces added", 2);


        // cards의 크기가 kingsOfClubs의 크기보다 작으면 카피안됨
        // cards에 원래 들어있던 값은 없어짐
        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards, "Card Collection with Kings copied", 2);

        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List Copy of Kings", 1);

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Deck of Cards", 4);

        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgorithm);
        Card.printDeck(deck, "Standard Deck sorted by rank, suit", 13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted by rank, suit reversed: ", 13);
        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Kings in deck", 1);
        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens, "tens in deck", 1);

//        Collections.shuffle(deck);

        // 전체 목록에서 하위목록이 사작하는 인덱스 반환
        // 하위목록은 연속적이어야함
        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for tens = " + subListIndex);
        System.out.println("Contains = " + deck.containsAll(tens));

        // disjoint: 두 목록중에 겹치는게 없으면 true
        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("disjoint = " + disjoint);

        // kings, tens는 공통 요소가 없어서 true
        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("disjoint2 = " + disjoint2);

        // sorting을 안하면 binarySearch를 할 수 없음. 목록이 정렬되어 잇어야함
        // 위에서 deck를 reverse()한적이 있음 다시 소팅해줘얌
        deck.sort(sortingAlgorithm);
        Card tenOfHearts = Card.getNumbericCard(Card.Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
        System.out.println("foundIndex = " + foundIndex);
        System.out.println(deck.get(foundIndex));

        System.out.println("foundIndex = " + foundIndex);
        System.out.println("foundIndex = " + deck.indexOf(tenOfHearts));
        System.out.println(deck.get(foundIndex));

        System.out.println(deck);
        Card tenOfClubs = Card.getNumbericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
        Card.printDeck(deck.subList(32, 36), "Tens row", 1);
        Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
        Card.printDeck(deck.subList(32, 36), "Tens row", 1);

        // tenOfHearts가 모두 tenOfClubs로 바뀐상태라
        // tenOfHearts가 리스트에 없음
        if (Collections.replaceAll(deck, tenOfHearts, tenOfClubs)) {
            System.out.println("tens of hearts replaced with tens of clubs");
        } else {
            System.out.println("No tens of hearts found in the list");
        }

        System.out.println("Ten of Clubs Cards = " +
                Collections.frequency(deck, tenOfClubs));

        System.out.println("Best Card = " + Collections.max(deck, sortingAlgorithm));
        System.out.println("Worst Card = " + Collections.min(deck, sortingAlgorithm));

        var sortBySuit = Comparator.comparing(Card::suit)
                .thenComparing(Card::rank);
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Sorted by Suit, Rank", 4);

        List<Card> copied = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copied, 2);
        System.out.println("UnRotated: " + deck.subList(0, 13));
        System.out.println("Rotated " + 2 + ": " + copied);

        copied = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copied, -2);
        System.out.println("UnRotated: " + deck.subList(0, 13));
        System.out.println("Rotated " + -2 + ": " + copied);

        copied = new ArrayList<>(deck.subList(0, 13));
        for (int i = 0; i < copied.size() / 2; i++) {
            Collections.swap(copied, i, copied.size() - 1 - i);
        }
        System.out.println("Manual reverse : " + copied);

        copied = new ArrayList<>(deck.subList(0, 13));
        Collections.reverse(copied);
        System.out.println("using reverse: " + copied);
    }
}
