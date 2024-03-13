package consumer.specific;

import finalexplored.dev.lpa.generic.BaseClass;

// cmd + n -> override 목록을 봤을 때 부모의 정적(static) 메소드는 없음
// final 이거나 private 메소드도 없음
public class ChildClass extends BaseClass {
    //  부모와 자식의 정적 메소드 이름(public static void recommendedStatic)이 같을 때 자식거 무시하고 부모거 호출됨(hiding)
    // 인스턴스 메소드이면(static 아님) overriding 함
    public static void recommendedStatic() {
        System.out.println("[ChildClass.recommendedStatic] BEST Way to Do it");
        optionalStatic();
//        mandatoryStatic();
    }

//    @Override
//    public void recommendedMethod() {
//        System.out.println("[ChildClass:recommendedMethod]: I'll do things my way");
//        optionalMethod();
//    }

    @Override
    protected void optionalMethod() {
        System.out.println("[Child:optionalMethod] EXTRA Stuff Here");
        super.optionalMethod();
    }

    private void mandatoryMethod() {
        System.out.println("[Child:mandatoryMethod]: My own important stuff");
    }

}
