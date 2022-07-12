package pl.javaskills.creditapp.core.model;

import pl.javaskills.creditapp.core.annotation.NotNull;

public class PurposeOfLoan {
    @NotNull
    private final Loan loan;
    private final double amount;
    private final int period;

    public PurposeOfLoan(Loan loan, double amount, int period) {
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

    public int getPeriod() {
        return period;
    }
}
