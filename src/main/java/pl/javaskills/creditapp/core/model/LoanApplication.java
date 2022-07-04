package pl.javaskills.creditapp.core.model;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

public class LoanApplication {

    private final UUID id;
    private final Person person;
    private final PurposeOfLoan loan;
    private final Set<Guarantor> guarantors;

    public LoanApplication(Person person, PurposeOfLoan purposeOfLoan)
    {
        this.person = person;
        this.loan = purposeOfLoan;
        this.id = UUID.randomUUID();
        this.guarantors = new TreeSet<>();
    }

    public LoanApplication(Person person, PurposeOfLoan purposeOfLoan, Set<Guarantor> guarantors)
    {
        this.person = person;
        this.loan = purposeOfLoan;
        this.id = UUID.randomUUID();
        this.guarantors = new TreeSet<>(guarantors);
    }

    public Set<Guarantor> getGuarantors() {
        return guarantors;
    }

    public UUID getId() {
        return id;
    }

    public PurposeOfLoan getLoan() {
        return loan;
    }

    public Person getPerson() {
        return person;
    }
}
