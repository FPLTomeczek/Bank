package pl.javaskills.creditapp.core.model;

import java.util.Optional;

public class LoanApplication {

    private final Person person;
    private final PurposeOfLoan loan;

    public LoanApplication(Person person, PurposeOfLoan purposeOfLoan)
    {
        this.person = person;
        this.loan = purposeOfLoan;
    }




    public PurposeOfLoan getLoan() {
        return loan;
    }

    public Person getPerson() {
        return person;
    }
}
