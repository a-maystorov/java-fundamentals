import java.text.NumberFormat;
import java.util.Scanner;

// TODO: Refactor this into a proper OO class
public class MortgageCalculator {
    public static void main(String[] args) {
        int principal = (int) readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate: ", 0, 30);
        byte periodInYears = (byte) readNumber("Period (Years): ", 1, 30);

        final double mortgage = calculate(principal, annualInterestRate, periodInYears);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + formattedMortgage);
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();

            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Enter a number between " + (int) min + " and " + (int) max);
        }
        return value;
    }

    public static double calculate(int principal, float annualInterestRate, byte periodInYears) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterestRate = (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (periodInYears * MONTHS_IN_YEAR);

        return principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }
}
