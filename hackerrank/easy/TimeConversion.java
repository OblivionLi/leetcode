package hackerrank.easy;

public class TimeConversion {
    public static void main(String[] args) {
        String s = "12:05:45AM";

        System.out.println(timeConversion(s));
    }

    public static String timeConversion(String s) {
        String timePeriod = s.substring(s.length() - 2);
        String hoursString = s.substring(0, 2);
        int hours = Integer.parseInt(hoursString);

        if (timePeriod.equals("PM")) {
            if (hours > 0 && hours < 12) {
                hoursString = String.valueOf(hours + 12);
            }
        } else {
            if (hours == 12) {
                hoursString = "00";
            }
        }


        return hoursString + s.substring(2, s.length() - 2);
    }
}
