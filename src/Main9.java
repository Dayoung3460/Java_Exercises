public class Main9 {
    public static void main(String[] args) {
        // 부모 클래스의 타입에 자식 클래스 타입의 인스턴스 생성 가능
        Movie theMovie = new Adventure("Star Wars");
        theMovie.watchMovie();
    }
}
