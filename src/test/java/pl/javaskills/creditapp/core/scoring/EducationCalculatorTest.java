package pl.javaskills.creditapp.core.scoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.javaskills.creditapp.core.model.Education;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonTestFactory;
import pl.javaskills.creditapp.core.model.PersonalData;

import java.lang.reflect.ParameterizedType;

import static org.junit.jupiter.api.Assertions.*;

class EducationCalculatorTest {
    EducationCalculator cut = new EducationCalculator();


    @ParameterizedTest
    @DisplayName("should return point attached to enum element")
    @EnumSource(Education.class)
    public void test1(Education education)
    {
        Person person = PersonTestFactory.create(education);
        int scoring = cut.calculate(person);
        assertEquals(education.getValue(), scoring);
    }
}