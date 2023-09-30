public class Main {
    public static void main(String[] args) {
        for(int i = 1; i <= 5; i++) {
            LPAStudent s = new LPAStudent("s92300" + i,
                    switch (i) {
                case 1 ->"Mary";
                case 2 -> "Carol";
                case 3 -> "Tim";
                case 4 -> "Harry";
                case 5 -> "Lisa";
                        default -> "Anonymous";
                    },
                    "05/11/1985",
                    "Java Masterclass"
                    );
            System.out.println(s);
        }
        Student pojoStudent = new Student("is9230006", "Ann", "05/11/1995", "Java Masterclass");
        LPAStudent recordStudent = new LPAStudent("s923007", "Bill", "05/11/1985", "Java Masterclass");
        Student pojoStudent2 = new Student("is9230006", "Ann", "05/11/1995", "Java Masterclass");
        System.out.println(pojoStudent);
        System.out.println(recordStudent);

        pojoStudent.setClassList(pojoStudent.getClassList() + '2');
//        recordStudent.setClassList(pojoStudent.getClassList());



        System.out.println(pojoStudent.getName());
        System.out.println(pojoStudent.getClassList());
        System.out.println(pojoStudent2.getClassList());
        System.out.println(recordStudent.name());
        System.out.println(recordStudent.classList());
    }

}