public class Main5 {
    public static void main(String[] args) {
        printInformation("Hello world");
        printInformation("");
        printInformation("\t \n");

        String helloWorld = "Hello World";
        System.out.printf("index of r = %d %n", helloWorld.indexOf('r'));
        System.out.printf("index of r = %d %n", helloWorld.indexOf("World"));
        System.out.printf("index of l = %d %n", helloWorld.indexOf("l"));
        System.out.printf("index of l = %d %n", helloWorld.indexOf("l", 3));
        System.out.printf("index of l = %d %n", helloWorld.lastIndexOf("l"));
        System.out.printf("index of l = %d %n", helloWorld.lastIndexOf("l", 8));
    }

    public static void printInformation(String string) {
        int length = string.length();
        System.out.printf("Length = %d %n", length);
        if(string.isEmpty()) {
            System.out.println("String is Empty");
            return;
        }
        if(string.isBlank()) {
            System.out.println("String is Blank");
            return;
        }
        System.out.printf("First char = %c %n", string.charAt(0));
        System.out.printf("Last char = %c %n", string.charAt(length - 1));
    }
}
