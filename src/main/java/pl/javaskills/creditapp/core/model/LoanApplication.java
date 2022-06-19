package pl.javaskills.creditapp.core.model;

public class LoanApplication {
    private final Person person;
    private final PurposeOfLoan loan;

    public LoanApplication(Person person, PurposeOfLoan purposeOfLoan)
    {
        this.person = person;
        this.loan = purposeOfLoan;
    }

    public Person getPerson() {
        return person;
    }

    public PurposeOfLoan getLoan() {
        return loan;
    }
}
