package minilambdachallenges.dev.lpa;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Consumer<String> printWords = new Consumer<String>() {
            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Consumer<String> printWordsLambda = sentence -> {
            String[] parts = sentence.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        printWords.accept("Lets split this up into an array");
        printWordsLambda.accept("Lets split this up into an array");

        Consumer<String> printWordsForEach = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };

        printWordsForEach.accept("Lets split this up into an array");

        Consumer<String> printWordsConcise = sentence -> {
            Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
        };

        printWordsConcise.accept("Lets split this up into an array");

        UnaryOperator<String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondChar.apply("1234567890"));
        
    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }
}

