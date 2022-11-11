package Helper;

import java.util.regex.*;

 /**
  Contains static helper methods to deal with date and time format checking
  @author Julian Wong
  @version 1.0
  @since 2022-11-12
 */
public class Format {
    
    /**
     * Method to check if input time string is in Military Time format.
     * @param input This is the input String to be checked.
     * @return true if input time string is in Military Time format; return false if otherwise.
     */
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
    
    /**
     * Method to check if input date string is in DD-MMM-YYYY format.
     * @param input This is the input string to be checked.
     * @return true if input date string is in in DD-MMM-YYYY format; return false if otherwise.
     */
    public static boolean isValidDateFormat(String input) {
        Pattern pattern = Pattern.compile("[0-9]{2}-[a-zA-Z]{3}-[0-9]{4}");
        if (pattern.matcher(input).matches())
            return true;
        System.out.println("Error! Invalid date format entered");
        return false;
    }
}
