public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void watchMovie() {
        // getClass()
        // java.lang.Object 중의 하나
        // 현재 참조하고 있는(runtime) 클래스 정보를 리턴
        // 정보 메소드들
        // getName(): 해당 객체 이름
        // getSuperclass(): 해당 객체 상위 클래스 이름
        // getDeclareFields(): 해당 객채의 선언된 필드 정보를 배열로

        // tip: java.lang.Object 클래스는 자바에서 만드는 모든 클래스들의 root.
        // 모든 클래스는 java.lang.Object를 super class로 가짐

        String instanceType = this.getClass().getSimpleName();
        System.out.println(title + " is a " + instanceType + " film");
    }
}

class Adventure extends Movie {
    public Adventure(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();

        // printf
        // 지시자를 통해 변수의 값을 변환하여 출력 가능
        // %n: 줄바꿈
        // %s: 문자열 형식
        // %b: 불린 형식
        // %d: 정수 형식
        System.out.printf(".. %s%n".repeat(3),
                "Pleasant Scene",
                "Scary Music",
                "Something Bad Happens");
    }
}

class Comedy extends Movie {
    public Comedy(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Something funny happens",
                "Something even funnier happens",
                "Happy ending");
    }
}

class ScienceFiction extends Movie {
    public ScienceFiction(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Bad Aliens do Bad stuff",
                "Space Guys chase Aliens",
                "Planet Blows Up");
    }
}