package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonalData;

public class IncomeCalculator {
    private static final Logger log = LoggerFactory.getLogger(IncomeCalculator.class);
    public int calculate (Person person)
    {
        double incomePerFamilyMember = (person.getIncomePerFamilyMember());
        int pointsForIncome = (int) (incomePerFamilyMember/1000) * 100;
        if(person.getFinanceData().getSourcesOfIncomes().length > 1)
        {
            pointsForIncome+=100;
            log.info("Extra 100 points for " + person.getFinanceData().getSourcesOfIncomes().length + " sources of income");
        }
        log.info("Income per family member = {} ({} points)",incomePerFamilyMember,(int) (incomePerFamilyMember)/1000*100);
        return pointsForIncome;
    }
}
