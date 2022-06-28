package pl.javaskills.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.scoring.PersonCalculator;

public class CompoundScoringCalculator implements PersonCalculator {

    private final PersonCalculator[] personCalculators;

    public CompoundScoringCalculator(PersonCalculator... personCalculators) {
        this.personCalculators = personCalculators;
    }

    private static final Logger log = LoggerFactory.getLogger(CreditApplicationService.class);

    @Override
    public int calculate(Person person) {
        int scoring = 0;
        for(PersonCalculator personCalculator : personCalculators)
        {
            scoring+=personCalculator.calculate(person);
        }
        log.info("Calculated scoring = " + scoring + " points");

        return scoring;
    }
}
