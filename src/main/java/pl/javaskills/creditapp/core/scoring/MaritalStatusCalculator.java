package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.MaritalStatus;
import pl.javaskills.creditapp.core.model.PersonalData;

public class MaritalStatusCalculator {
    private static final Logger log = LoggerFactory.getLogger(MaritalStatusCalculator.class);
    public int calculate(PersonalData personalData){
        MaritalStatus maritalStatus = personalData.getMaritalStatus();
        log.info("Marital status: {}, Points: {}",maritalStatus,maritalStatus.getValue());
        return maritalStatus.getValue();
    }
}
