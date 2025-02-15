import java.text.NumberFormat;

public class MortgageReport {
    private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();

    public static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = MortgageCalculator.calculateMortgage(principal, annualInterest, years);
        printSection("MORTGAGE", "Monthly Payments: " + formatCurrency(mortgage));
    }

    public static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        printSection("PAYMENT SCHEDULE");
        for (short month = 1; month <= years * MortgageCalculator.MONTHS_IN_YEAR; month++) {
            double balance = MortgageCalculator.calculateBalance(principal, annualInterest, years, month);
            System.out.println(formatCurrency(balance));
        }
    }

    private static void printSection(String title, String... details) {
        System.out.println();
        System.out.println(title);
        System.out.println("-".repeat(title.length()));

        for (String detail : details) {
            System.out.println(detail);
        }
    }

    private static String formatCurrency(double value) {
        return CURRENCY_FORMATTER.format(value);
    }
}