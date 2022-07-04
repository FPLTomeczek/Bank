package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.Education;
import pl.javaskills.creditapp.core.model.Person;

public class EducationCalculator implements ScoringCalculator {
    private static final Logger log = LoggerFactory.getLogger(EducationCalculator.class);

    @Override
    public int calculate(Person person)
    {
       // MDC.put("id", UUID.randomUUID().toString());
        Education education = person.getPersonalData().getEducation();
        log.info("Education: {}, Points: {}",education,education.getValue());
        return education.getValue();
    }
}
