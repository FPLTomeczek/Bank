package pl.javaskills.creditapp.core;

import org.junit.jupiter.api.Test;
import pl.javaskills.creditapp.core.model.Education;
import pl.javaskills.creditapp.core.model.MaritalStatus;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonTestFactory;

import static org.junit.jupiter.api.Assertions.*;

class PersonScoringCalculatorTest {
    PersonScoringCalculator cut = new PersonScoringCalculator();

    @Test
    public void test1()
    {
        //given
        double totalMonthlyIncomeInPln = 5000.0;
        int numOfDependants = 2;
        Education education = Education.PRIMARY;
        MaritalStatus maritalStatus = MaritalStatus.MARRIED;

        Person person = PersonTestFactory.create(totalMonthlyIncomeInPln, numOfDependants, education, maritalStatus);
        //when
        int scoring = cut.calculate(person);
        //then
        assertEquals(200, scoring);
    }


    @Test
    public void test2()
    {
        //given
        double totalMonthlyIncomeInPln = 5500.0;
        int numOfDependants = 1;
        Education education = Education.MIDDLE;
        MaritalStatus maritalStatus = MaritalStatus.DIVORCED;

        Person person = PersonTestFactory.create(totalMonthlyIncomeInPln, numOfDependants, education, maritalStatus);
        //when
        int scoring = cut.calculate(person);
        //then
        assertEquals(500, scoring);
    }


    @Test
    public void test3()
    {
        //given
        double totalMonthlyIncomeInPln = 9000.0;
        int numOfDependants = 3;
        Education education = Education.NONE;
        MaritalStatus maritalStatus = MaritalStatus.SINGLE;

        Person person = PersonTestFactory.create(totalMonthlyIncomeInPln, numOfDependants, education, maritalStatus);
        //when
        int scoring = cut.calculate(person);
        //then
        assertEquals(100, scoring);
    }
}