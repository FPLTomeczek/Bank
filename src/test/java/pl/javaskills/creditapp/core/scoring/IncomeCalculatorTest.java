package pl.javaskills.creditapp.core.scoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.javaskills.creditapp.core.model.IncomeType;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonTestFactory;
import pl.javaskills.creditapp.core.model.SourcesOfIncome;

import static org.junit.jupiter.api.Assertions.*;

class IncomeCalculatorTest {
    IncomeCalculator cut = new IncomeCalculator();

    @Test
    @DisplayName("should return 100points for every 1000s income for person")
    public void test1()
    {
        SourcesOfIncome s1 = new SourcesOfIncome(IncomeType.SELF_EMPLOYMENT, 5000.00);
        Person person = PersonTestFactory.create(2, s1);

        int scoring = cut.calculate(person);

        assertEquals(200, scoring);
    }

    @Test
    @DisplayName("should return extra 100 points where there is more than 1 source of income")
    public void test2()
    {
        SourcesOfIncome s1 = new SourcesOfIncome(IncomeType.SELF_EMPLOYMENT, 4000.00);
        SourcesOfIncome s2 = new SourcesOfIncome(IncomeType.RETIREMENT, 1000.00);
        Person person = PersonTestFactory.create(2, s1,s2);

        int scoring = cut.calculate(person);

        assertEquals(300, scoring);
    }
}