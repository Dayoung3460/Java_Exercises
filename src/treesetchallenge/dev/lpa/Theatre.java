package treesetchallenge.dev.lpa;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Theatre {
    private String theatreName;
    private int seatsPerRow;
    private NavigableSet<Seat> seats;

    public Theatre(String theatreName, int rows, int totalSeats) {
        this.theatreName = theatreName;
        this.seatsPerRow = totalSeats / rows; // 10

        seats = new TreeSet<>();
        for (int i = 0; i < totalSeats; i++) {
            char rowChar = (char) (i / seatsPerRow + (int) 'A'); // 0 / 10 + 65 // 65 // A
            // 9 / 10 + 65 // A
            // 10 / 10 + 65 // B
            int seatInRow = i % seatsPerRow + 1; // 0 % 10 + 1 // 1
            // 9 % 10 + 1 // 10
            // 10 % 10 + 1 // 1
            seats.add(new Seat(rowChar, seatInRow));
        }
    }

    public void printSeatMap() {
        String separatorLine = "-".repeat(90);
        System.out.printf("%1$s%n%2$s Seat Map%n%1$s%n", separatorLine,
                theatreName);
        int index = 0;

        for (Seat s : seats) {
            System.out.printf("%-8s%s",
                    s.seatNum + ((s.reserved) ? "(\u25CF)" : ""),
                    ((index++ + 1) % seatsPerRow == 0) ? "\n" : "");
        }
        System.out.println(separatorLine);
    }

    public String reserveSeat(char row, int seat) {
        Seat requesetedSeat = new Seat(row, seat);
//        제공된 값과 같거나 작은 값 중 가장 큰 값 (인자값 포함)
        Seat requested = seats.floor(requesetedSeat);

        if (requested == null || !requested.seatNum.equals(requesetedSeat.seatNum)) {
            System.out.println("--> No such seat: " + requesetedSeat);
            System.out.printf(": Seat must be between %s and %s%n",
                    seats.first().seatNum, seats.last().seatNum);
        } else {
            if (!requested.reserved) {
                requested.reserved = true;
                return requested.seatNum;
            } else {
                System.out.println("Seat's already reserved.");
            }
        }
        return null;
    }

    // 4 B C 1 10
    private boolean validate(int count, char first, char last, int min, int max) {
        boolean result = (min > 0 || seatsPerRow >= count || (max - min + 1) >= count);
        result = result && seats.contains(new Seat(first, min));
        if (!result) {
            System.out.printf("Invalid! %1$d seats between " +
                            "%2$c[%3$d-%4$d]-%5$c[%3$d-%4$d] Try again",
                    count, first, min, max, last);
            System.out.printf(": Seat must be between %s and %s%n",
                    seats.first().seatNum, seats.last().seatNum);
        }
        return result;
    }

    //    bookSeats(rodgersNYC, 4, 'B', 'C', 1, 10);
    public Set<Seat> reserveSeats(int count, char minRow, char maxRow,
                                  int minSeat, int maxSeat) {
        char lastValid = seats.last().seatNum.charAt(0); // J
        maxRow = (maxRow < lastValid) ? maxRow : lastValid; // C
        if (!validate(count, minRow, maxRow, minSeat, maxSeat)) {
            return null;
        }
        NavigableSet<Seat> selected = null;
        for (char letter = minRow; letter <= maxRow; letter++) {
            //기준값1 ~ 기준값2 사이의 값을 가져옴
            NavigableSet<Seat> contiguous = seats.subSet(
                    new Seat(letter, minSeat), true,
                    new Seat(letter, maxSeat), true);
            int index = 0;
            Seat first = null;
            for (Seat current : contiguous) {
                if (current.reserved) {
                    index = 0;
                    // 반복문 현재 단계 중단
                    continue;
                }
                first = (index == 0) ? current : first;
                if (++index == count) {
                    selected = contiguous.subSet(first, true,
                            current, true);
                    // 반복문 전체를 중단
                    break;
                }
            }
            if (selected != null) {
                break;
            }
        }
        Set<Seat> reservedSeats = null;
        if (selected != null) {
            selected.forEach(s -> s.reserved = true);
            reservedSeats = new TreeSet<>(selected);
        }
        return reservedSeats;
    }

    class Seat implements Comparable<Seat> {
        private String seatNum;
        private boolean reserved;

        public Seat(char rowChar, int seatNo) {
            this.seatNum = "%c%03d".formatted(rowChar, seatNo).toUpperCase();
        }

        @Override
        public String toString() {
            return seatNum;
        }

        @Override
        public int compareTo(Seat o) {
            return seatNum.compareTo(o.seatNum);
        }
    }
}
