package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import pl.javaskills.creditapp.core.model.Education;
import pl.javaskills.creditapp.core.model.PersonalData;

import java.util.UUID;

public class EducationCalculator {
    private static final Logger log = LoggerFactory.getLogger(EducationCalculator.class);
    public int calculate(PersonalData personalData)
    {
       // MDC.put("id", UUID.randomUUID().toString());
        Education education = personalData.getEducation();
        log.info("Education: {}, Points: {}",education,education.getValue());
        return education.getValue();
    }
}
