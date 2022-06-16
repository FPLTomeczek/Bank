package pl.javaskills.creditapp.core.scoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonTestFactory;

import static org.junit.jupiter.api.Assertions.*;

class IncomeCalculatorTest {
    IncomeCalculator cut = new IncomeCalculator();

    @Test
    @DisplayName("should return 100points for every 1000s income for person")
    public void test1()
    {
        Person person = PersonTestFactory.create(5000,2);

        int scoring = cut.calculate(person.getPersonalData());

        assertEquals(200, scoring);
    }
}