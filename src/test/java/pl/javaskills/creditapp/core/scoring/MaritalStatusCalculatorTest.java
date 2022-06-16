package pl.javaskills.creditapp.core.scoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.javaskills.creditapp.core.model.Education;
import pl.javaskills.creditapp.core.model.MaritalStatus;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonTestFactory;

import static org.junit.jupiter.api.Assertions.*;

class MaritalStatusCalculatorTest {

    MaritalStatusCalculator cut = new MaritalStatusCalculator();

    @ParameterizedTest
    @DisplayName("should return point attached to enum element")
    @EnumSource(MaritalStatus.class)
    public void test1(MaritalStatus maritalStatus)
    {
        Person person = PersonTestFactory.create(maritalStatus);
        int scoring = cut.calculate(person.getPersonalData());
        assertEquals(maritalStatus.getValue(), scoring);
    }
}