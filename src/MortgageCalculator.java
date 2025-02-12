import java.text.NumberFormat;
import java.util.Scanner;

// TODO: Refactor this into a proper OO class
public class MortgageCalculator {

    public static void main(String[] args) {
        int principal = 0;
        float annualInterestRate = 0;
        byte periodInYears = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();

            if (principal < 1_000 || principal > 1_000_000) {
                System.out.println("Enter a number between 1,000 amd 1,000,000");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();

            if (annualInterestRate <= 0 || annualInterestRate > 30) {
                System.out.println("Enter a number greater than 0 and less than or equal to 30");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("Period (Years): ");
            periodInYears = scanner.nextByte();

            if (periodInYears < 1 || periodInYears > 30) {
                System.out.println("Enter a number between 1 and 30");
                continue;
            }
            break;
        }

        final double mortgage = calculate(principal, annualInterestRate, periodInYears);
        String formattedResult = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + formattedResult);
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
