package src;

public class Main {
    public static void main(String[] args) {
        System.out.println(getDurationString(-3945));
        System.out.println(getDurationString(-65, 45));
        System.out.println(getDurationString(65, 145));
        System.out.println(getDurationString(65, 45));
        System.out.println(getDurationString(3945));
    }

    public static String getDurationString(int seconds) {
        if(seconds < 0) {
            return "";
        }
        int minutes = seconds / 60;
        return getDurationString(minutes, seconds % 60);
    }

    public static String getDurationString(int minutes, int seconds) {
        if(minutes < 0) {
            return "";
        }
        if(seconds <=0 || seconds >= 60) {
            return "";
        }
        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;
        return hours + ":" + remainingMinutes + ":" + seconds;

    }
}
