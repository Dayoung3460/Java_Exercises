package varargs.dev.lpa;

public class Main {
    public static void main(String... args) {
        String[] splitStrings = "Hello World again".split(" ");
        printText(splitStrings);

        System.out.println("_".repeat(20));
        printText("Hello");

        System.out.println("_".repeat(20));
        printText("Hello", "World", "again");

        System.out.println("_".repeat(20));
        printText();

        String[] sArray = {"first", "second", "third", "fourth", "fifth"};
        System.out.println(String.join(", ", sArray));

        System.out.println("_".repeat(20));
        // 문자에 구분자를 주는 이런 방식으로도 사용 가능
        sum("-", "a", "b", "c");
    }

    private static void printText(String... textList) {
        // 인자 값을 배열로 생성 해서 사용함
        for(String t : textList) {
            System.out.println(t);
        }
    }

    private static void sum(String s, String... str) {
        for(String a : str)
            System.out.print(a+s);
    }

}
