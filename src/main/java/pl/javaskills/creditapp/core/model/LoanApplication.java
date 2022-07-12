package pl.javaskills.creditapp.core.model;

import pl.javaskills.creditapp.core.Constants;
import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.ValidateCollection;
import pl.javaskills.creditapp.core.annotation.ValidateObject;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

public class LoanApplication {
    @NotNull
    private final UUID id;
    @NotNull
    @ValidateObject
    private final Person person;
    @NotNull
    @ValidateObject
    private final PurposeOfLoan loan;
    @NotNull
    @ValidateCollection
    private final Set<Guarantor> guarantors;

    private final ZoneId clientTimeZone;

    private final ZonedDateTime creationDateClientZone;

    public LoanApplication(ZoneId clientTimeZone, Person person, PurposeOfLoan purposeOfLoan)
    {
        this.person = person;
        this.loan = purposeOfLoan;
        this.id = UUID.randomUUID();
        this.clientTimeZone = clientTimeZone;
        this.creationDateClientZone = ZonedDateTime.now(clientTimeZone);
        this.guarantors = new TreeSet<>();
    }

    public LoanApplication(ZoneId clientTimeZone, Person person, PurposeOfLoan purposeOfLoan, Set<Guarantor> guarantors)
    {
        this.person = person;
        this.loan = purposeOfLoan;
        this.id = UUID.randomUUID();
        this.clientTimeZone = clientTimeZone;
        this.creationDateClientZone = ZonedDateTime.now(clientTimeZone);
        this.guarantors = new TreeSet<>(guarantors);
    }

    public ZoneId getClientTimeZone() {
        return clientTimeZone;
    }

    public ZonedDateTime getCreationDateClientZone() {
        return creationDateClientZone;
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
