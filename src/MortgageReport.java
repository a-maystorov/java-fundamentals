import java.text.NumberFormat;

public class MortgageReport {
    private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
    private final MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        printSection("MORTGAGE", "Monthly Payments: " + formatCurrency(mortgage));
    }

    public void printPaymentSchedule() {
        printSection("PAYMENT SCHEDULE");
        for (short month = 1; month <= calculator.getYears() * MortgageCalculator.MONTHS_IN_YEAR; month++) {
            double balance = calculator.calculateBalance(month);
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