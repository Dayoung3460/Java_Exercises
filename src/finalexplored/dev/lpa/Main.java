package finalexplored.dev.lpa;

import consumer.specific.ChildClass;
import external.util.Logger;
import finalexplored.dev.lpa.generic.BaseClass;

public class Main {
    public static void main(String[] args) {
        BaseClass parent = new BaseClass();
        ChildClass child = new ChildClass();
        BaseClass childReferredToAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("--------------");
        childReferredToAsBase.recommendedMethod();
        System.out.println("--------------");
        child.recommendedMethod();

        System.out.println("----------------------");
        parent.recommendedStatic();
        System.out.println("--------------");
        childReferredToAsBase.recommendedStatic();
        System.out.println("--------------");
        child.recommendedStatic();

        System.out.println("--------------");
        BaseClass.recommendedStatic();
        ChildClass.recommendedStatic();

        String xArgument = "This is all I've got to say about Section ";
        StringBuilder zArgument = new StringBuilder("Only saying this: Section ");
        doXYZ(xArgument, 16, zArgument);
        System.out.println("After Method, xArgument: " + xArgument);
        System.out.println("After Method, zArgument: " + zArgument);

        System.out.println("----Logger----");
        StringBuilder tracker = new StringBuilder("Step 1 is abc");
        Logger.logToConsole(tracker.toString());
        tracker.append(", Step 2 is xyz.");
        Logger.logToConsole(tracker.toString());
        System.out.println("After logging, tracker = " + tracker);
    }

    private static void doXYZ(String x, int y, final StringBuilder z) {
        // c는 상수
        final String c = x + y;
        System.out.println("c = " + c);
        x = c;

        // final인 z에 메소드 실행시키는건 괜춘
        z.append(y);
        // 새로운 값을 할당하는건 안됨(Cannot assign a value to final variable 'z')
//        z = new StringBuilder("This is a new reference");
    }

}
