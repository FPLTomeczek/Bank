package pl.javaskills.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.Education;
import pl.javaskills.creditapp.core.model.MaritalStatus;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.scoring.EducationCalculator;
import pl.javaskills.creditapp.core.scoring.IncomeCalculator;
import pl.javaskills.creditapp.core.scoring.MaritalStatusCalculator;

public class PersonScoringCalculator {
    private final EducationCalculator educationCalculator;
    private final MaritalStatusCalculator maritalStatusCalculator;
    private final IncomeCalculator incomeCalculator;
    private static final Logger log = LoggerFactory.getLogger(CreditApplicationService.class);

    public PersonScoringCalculator(EducationCalculator educationCalculator, MaritalStatusCalculator maritalStatusCalculator, IncomeCalculator incomeCalculator) {
        this.educationCalculator = educationCalculator;
        this.maritalStatusCalculator = maritalStatusCalculator;
        this.incomeCalculator = incomeCalculator;
    }

    public int calculate (Person person){

        int scoring = educationCalculator.calculate(person.getPersonalData()) +
                maritalStatusCalculator.calculate(person.getPersonalData()) +
                incomeCalculator.calculate(person.getPersonalData());
        log.info("Calculated scoring = " + scoring + " points");
        return scoring;
    }
}
