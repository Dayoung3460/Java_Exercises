package genericextra.dev.lpa.util;

import genericextra.dev.lpa.model.Student;

import java.util.ArrayList;
import java.util.List;

// 타입 다중상속 가능. or이 아니고 and 조건임. 나열할 땐 클래스 먼저

public class QueryList<T extends Student & QueryItem> {
    private List<T> items;

    public QueryList(List<T> items) {
        this.items = items;
    }

    public static <T extends QueryItem> List<T> getMatches(List<T> items, String field, String value) {
        // 클래스 타입의 파라미터는 static 메소드에서 사용될 수 없음
        // 인스턴스화 된(T extends QueryItem) 파라미터는 가능
        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }

    public List<T> getMatches(String field, String value) {
        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }

}
