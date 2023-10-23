import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        // 부모 클래스의 타입에 자식 클래스 타입의 인스턴스 생성 가능
//        Movie theMovie = new Adventure("Star Wars");

//        Movie theMovie = Movie.getMovie("Science Fiction", "Star wars");
//        theMovie.watchMovie();

        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Enter Type (A for Adventure , C for Comedy, S for Science Fiction, or Q to quit): ");
            String type = s.nextLine();
            if("Qq".contains(type)) {
                break;
            }
            System.out.println("Enter Movie Title: ");
            String title = s.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();
        }
    }
}
