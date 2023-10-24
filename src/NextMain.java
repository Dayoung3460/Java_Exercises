public class NextMain {
    public static void main(String[] args) {
        Movie movie = Movie.getMovie("A", "jaws");
        movie.watchMovie();
//
        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
        jaws.watchMovie();

        Object comedy = Movie.getMovie("C", "Airplane");
        Comedy comedyMovie = (Comedy) comedy;
        comedyMovie.watchComedy();
//
//        // var: 변수 선언 시, 타입 생략 가능. 컴파일러가 타입 추론.
//        // 컴파일 타임에 추론 -> 런타임에 추가 연산x. 성능에 영향x
//        // 지역 변수
//        // airplane을 Movie 타입으로 추론
        var airplane = Movie.getMovie("C", "Airplane");
        airplane.watchMovie();

        var plane = new Comedy("Airplane");
        plane.watchComedy();

        Object unknownObject = Movie.getMovie("S", "Star wars");
        if(unknownObject.getClass().getSimpleName() == "Comedy") {
            Comedy c = (Comedy) unknownObject;
            c.watchComedy();
            // instanceof operator(연산자): 객체가 어떤 클래스 타입인지, 어떤 클래스를 상속 받았는지 확인
        } else if(unknownObject instanceof Adventure) {
            ((Adventure) unknownObject).watchAdventure();
            // ScienceFiction syfy = (ScienceFiction) unknownObject
            // 이 과정 생략 가능. 바로 참조변수 생성
        }else if(unknownObject instanceof ScienceFiction syfy) {
            syfy.watchScienceFiction();
        }
    }
}
