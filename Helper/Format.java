package Helper;

import java.util.regex.*;

public class Format {
    public static boolean isValidTimeFormat(String input) {
        Pattern pattern = Pattern.compile("[0-2][0-9][0-6][0-9]");
        if(pattern.matcher(input).matches()){
            int time = Integer.parseInt(input);
            if (time>=0 && time<=2400)
                return true;
        }
        System.out.println("Error! Invalid time format entered");
        return false;
    }

    public static boolean isValidDateFormat(String input) {
        Pattern pattern = Pattern.compile("[0-9]{2}-[a-zA-Z]{3}-[0-9]{4}");
        if (pattern.matcher(input).matches())
            return true;
        System.out.println("Error! Invalid date format entered");
        return false;
    }
}
