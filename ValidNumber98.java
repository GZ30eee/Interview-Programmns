import java.util.regex.Pattern;

public class ValidNumber98 {
    public static boolean isValidNumber(String s) {
        String regex = "^[+-]?((\\d+\\.\\d*)|(\\.\\d+)|(\\d+))([eE][+-]?\\d+)?$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(s.trim()).matches();
    }

    public static void main(String[] args) {
        String[] validNumbers = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", 
                                 "2e10", "-90E3", "3e+7", "+6e-1", 
                                 "53.5e93", "-123.456e789"};
        
        String[] invalidNumbers = {"abc", "1a", "1e", "e3", 
                                   "99e2.5", "--6", "-+3", "95a54e53"};
        
        System.out.println("Valid Numbers:");
        for (String num : validNumbers) {
            System.out.println(num + ": " + isValidNumber(num));
        }
        
        System.out.println("\nInvalid Numbers:");
        for (String num : invalidNumbers) {
            System.out.println(num + ": " + isValidNumber(num));
        }
    }
}
