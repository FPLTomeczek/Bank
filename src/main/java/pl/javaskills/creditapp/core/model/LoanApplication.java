package pl.javaskills.creditapp.core.model;

import java.util.Optional;

public class LoanApplication {
    private final Optional<NaturalPerson> naturalPerson;
    private final Optional<SelfEmployed> selfEmployed;
    private final PurposeOfLoan loan;

    public LoanApplication(NaturalPerson person, PurposeOfLoan purposeOfLoan)
    {
        this.naturalPerson = Optional.of(person);
        this.selfEmployed = Optional.empty();
        this.loan = purposeOfLoan;
    }

    public LoanApplication(SelfEmployed person, PurposeOfLoan purposeOfLoan)
    {
        this.naturalPerson = Optional.empty();
        this.selfEmployed = Optional.of(person);
        this.loan = purposeOfLoan;
    }

    public Optional<NaturalPerson> getNaturalPerson() {
        return naturalPerson;
    }

    public Optional<SelfEmployed> getSelfEmployed() {
        return selfEmployed;
    }

    public PurposeOfLoan getLoan() {
        return loan;
    }

    public Person getPerson(){
        if(naturalPerson.isPresent())
        {
            return naturalPerson.get();
        }
        return selfEmployed.get();
    }
}
