package setsandmaps.dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactData {
    private static final String phoneData = """
            Charlie Brown, 3334445555
            Maid Marion, 1234567890
            Mickey Mouse, 9998887777
            Mickey Mouse, 1247489758
            Minnie Mouse, 4567805666
            Robin Hood, 5647893000
            Robin Hood, 7899028222
            Lucy Van Pelt, 5642086852
            Mickey Mouse, 9998887777
            """;
    private static final String emailData = """
            Mickey Mouse, mckmouse@gmail.com
            Mickey Mouse, micky1@aws.com
            Minnie Mouse, minnie@verizon.net
            Robin Hood, rhood@gmail.com
            Linus Van Pelt, lvpelt2015@gmail.com
            Daffy Duck, daffy@google.com
            """;

    public static List<Contact> getData(String type) {
        List<Contact> dataList = new ArrayList<>();
        Scanner scanner = new Scanner(type.equals("phone") ? phoneData : emailData);
        while (scanner.hasNext()) {
            String[] data = scanner.nextLine().split(",");
            Arrays.asList(data).replaceAll(String::trim);
//            System.out.println(Arrays.toString(data));
            if (type.equals("phone")) {
                // Contact 객체 만들 때 파라미터 타입이 string, long 이기 때문에
                // Contact(String name, long phone) 이게 실행되고
                dataList.add(new Contact(data[0], Long.parseLong(data[1])));

            } else if (type.equals("email")) {
                // Contact 객체 만들 때 파라미터 타입이 string, string 이기 때문에
                // Contact(String name, String email) 이게 실행됨
                dataList.add(new Contact(data[0], data[1]));
            }
        }
        return dataList;
    }
}

