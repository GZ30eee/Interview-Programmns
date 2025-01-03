import java.util.Scanner;

public class ClockAngleCalculator14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input hours and minutes
        System.out.print("Enter hours (0-12): ");
        int hours = scanner.nextInt();
        
        System.out.print("Enter minutes (0-59): ");
        int minutes = scanner.nextInt();
        
        // Validate input
        if (hours < 0 || hours > 12 || minutes < 0 || minutes > 59) {
            System.out.println("Invalid input. Please enter hours (0-12) and minutes (0-59).");
            return;
        }

        // Calculate the angles
        double minuteAngle = minutes * 6; // Each minute is 6 degrees
        double hourAngle = (hours % 12) * 30 + (minutes * 0.5); // Each hour is 30 degrees and each minute contributes to the hour hand

        // Calculate the difference
        double angle = Math.abs(hourAngle - minuteAngle);

        // Get the smaller angle
        if (angle > 180) {
            angle = 360 - angle;
        }

        // Output the result
        System.out.println("The angle between hour and minute hand is: " + angle + " degrees");
        
        scanner.close();
    }
}
