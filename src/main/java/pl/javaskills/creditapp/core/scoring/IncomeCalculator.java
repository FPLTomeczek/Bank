package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonalData;

public class IncomeCalculator {
    private static final Logger log = LoggerFactory.getLogger(IncomeCalculator.class);
    public int calculate (PersonalData personalData)
    {
        double incomePerFamilyMember = (personalData.incomePerFamilyMember());
        int pointsForIncome = (int) (incomePerFamilyMember/1000) * 100;
        log.info("Income per family member = {} ({} points)",incomePerFamilyMember,pointsForIncome);
        return pointsForIncome;
    }
}
