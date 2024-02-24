package treesetchallenge.dev.lpa;

import java.util.NavigableSet;
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
