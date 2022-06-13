package pl.javaskills.creditapp.core.model;

public class PurposeOfLoan {
    private final Loan loan;
    private final double amount;
    private final byte period;

    public PurposeOfLoan(Loan loan, double amount, byte period) {
        this.loan = loan;
        this.amount = amount;
        this.period = period;
    }

    public Loan getLoan() {
        return loan;
    }

    public double getAmount() {
        return amount;
    }

    public byte getPeriod() {
        return period;
    }
}
