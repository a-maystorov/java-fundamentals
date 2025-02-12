import java.text.NumberFormat;
import java.util.Scanner;

// TODO: Refactor this into a proper OO class
public class MortgageCalculator {

    public static void calculate() {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextFloat();

        System.out.print("Period (Years): ");
        byte periodInYears = scanner.nextByte();

        float monthlyInterestRate = (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;
        int numberOfPayments = periodInYears * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        String formattedResult = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + formattedResult);
    }
}
