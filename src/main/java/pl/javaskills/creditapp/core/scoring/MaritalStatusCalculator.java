package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.MaritalStatus;
import pl.javaskills.creditapp.core.model.Person;

public class MaritalStatusCalculator implements ScoringCalculator {
    private static final Logger log = LoggerFactory.getLogger(MaritalStatusCalculator.class);

    @Override
    public int calculate(Person person){
        MaritalStatus maritalStatus = person.getPersonalData().getMaritalStatus();
        log.info("Marital status: {}, Points: {}",maritalStatus,maritalStatus.getValue());
        return maritalStatus.getValue();
    }
}
