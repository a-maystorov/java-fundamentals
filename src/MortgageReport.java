import java.text.NumberFormat;

public class MortgageReport {
    private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
    private final MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        if (calculator == null)
            throw new IllegalArgumentException("Calculator cannot be null");
        this.calculator = calculator;
    }
    
    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        printSection("MORTGAGE", "Monthly Payments: " + formatCurrency(mortgage));
    }

    public void printPaymentSchedule() {
        printSection("PAYMENT SCHEDULE");
        for (double balance : calculator.getRemainingBalances()) {
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