public class Main {
    public static void main(String[] args) {
        int principal = (int) InputReader.readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) InputReader.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) InputReader.readNumber("Period (Years): ", 1, 30);

        MortgageReport.printMortgage(principal, annualInterest, years);
        MortgageReport.printPaymentSchedule(principal, annualInterest, years);

    }
}
