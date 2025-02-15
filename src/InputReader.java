import java.util.Scanner;

public class InputReader {
    private static final Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        while (true) {
            double value = readNumber(prompt);
            if (value >= min && value <= max)
                return value;
            System.out.println("Enter a value between " + min + " and " + max);
        }
    }
}