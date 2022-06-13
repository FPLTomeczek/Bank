package pl.javaskills.creditapp.core.model;

public class LoanApplication {
    Person person;
    PurposeOfLoan loan;

    public LoanApplication(Person person, PurposeOfLoan loan) {
        this.person = person;
        this.loan = loan;
    }

    public Person getPerson() {
        return person;
    }

    public PurposeOfLoan getLoan() {
        return loan;
    }
}
