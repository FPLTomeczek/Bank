package pl.javaskills.creditapp.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javaskills.creditapp.core.model.*;
import pl.javaskills.creditapp.core.scoring.EducationCalculator;
import pl.javaskills.creditapp.core.scoring.IncomeCalculator;
import pl.javaskills.creditapp.core.scoring.MaritalStatusCalculator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class PersonScoringCalculatorTest {

    @InjectMocks
    PersonScoringCalculator cut;

    @Mock
    private EducationCalculator educationCalculatorMock;
    @Mock
    private MaritalStatusCalculator maritalStatusCalculatorMock;
    @Mock
    private IncomeCalculator incomeCalculatorMock;

    @Test
    @DisplayName("should return sum of calculations")
    public void test1(){
        Person person = PersonTestFactory.create();
        BDDMockito.given(educationCalculatorMock.calculate(eq(person.getPersonalData()))).willReturn(120);
        BDDMockito.given(maritalStatusCalculatorMock.calculate(eq(person.getPersonalData()))).willReturn(210);
        BDDMockito.given(incomeCalculatorMock.calculate(eq(person.getPersonalData()))).willReturn(230);

        int scoring = cut.calculate(person);

        assertEquals(560, scoring);
    }

//    @Test
//    public void test1()
//    {
//        //given
//        double totalMonthlyIncomeInPln = 5000.0;
//        int numOfDependants = 2;
//        Education education = Education.PRIMARY;
//        MaritalStatus maritalStatus = MaritalStatus.MARRIED;
//
//        Person person = PersonTestFactory.create(totalMonthlyIncomeInPln, numOfDependants, education, maritalStatus);
//        //when
//        int scoring = cut.calculate(person);
//        //then
//        assertEquals(200, scoring);
//    }
//
//
//    @Test
//    public void test2()
//    {
//        //given
//        double totalMonthlyIncomeInPln = 5500.0;
//        int numOfDependants = 1;
//        Education education = Education.MIDDLE;
//        MaritalStatus maritalStatus = MaritalStatus.DIVORCED;
//
//        Person person = PersonTestFactory.create(totalMonthlyIncomeInPln, numOfDependants, education, maritalStatus);
//        //when
//        int scoring = cut.calculate(person);
//        //then
//        assertEquals(500, scoring);
//    }
//
//
//    @Test
//    public void test3()
//    {
//        //given
//        double totalMonthlyIncomeInPln = 9000.0;
//        int numOfDependants = 3;
//        Education education = Education.NONE;
//        MaritalStatus maritalStatus = MaritalStatus.SINGLE;
//
//        Person person = PersonTestFactory.create(totalMonthlyIncomeInPln, numOfDependants, education, maritalStatus);
//        //when
//        int scoring = cut.calculate(person);
//        //then
//        assertEquals(100, scoring);
//    }
}