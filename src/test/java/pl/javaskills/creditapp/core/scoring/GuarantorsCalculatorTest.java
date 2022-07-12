package pl.javaskills.creditapp.core.scoring;

import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;
import pl.javaskills.creditapp.core.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static pl.javaskills.creditapp.util.AgeUtils.generateBirthDate;
class GuarantorsCalculatorTest {

    private GuarantorsCalculator cut = new GuarantorsCalculator();
    @Test
    public void test1()
    {
        //given
        NaturalPerson person = getNaturalPerson();
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(Loan.MORTGAGE, 50000.00, 30);
        Set<Guarantor> guarantors = Sets.newSet(new Guarantor("45678934353", generateBirthDate(18)));
        LoanApplication loanApplication = LoanApplicationTestFactory.create(person, purposeOfLoan, guarantors);

        //when
        int scoring = cut.calculate(loanApplication);
        //then
        assertEquals(50, scoring);
    }


    @Test
    public void test2()
    {
        //given
        NaturalPerson person = getNaturalPerson();
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(Loan.MORTGAGE, 50000.00, 30);
        Set<Guarantor> guarantors = Sets.newSet(new Guarantor("45678934353", generateBirthDate(18)),
                new Guarantor("45678934354", generateBirthDate(50)));
        LoanApplication loanApplication = LoanApplicationTestFactory.create(person, purposeOfLoan, guarantors);

        //when
        int scoring = cut.calculate(loanApplication);
        //then
        assertEquals(75, scoring);
    }

    private NaturalPerson getNaturalPerson() {
        NaturalPerson person = NaturalPerson.Builder
                .create()
                .withFamilyMembers(new ArrayList<>())
                .withPersonalData(PersonalData.Builder.create()
                        .withName("Test")
                        .withLastName("Test")
                        .withMothersMaidenName("Test")
                        .withEducation(Education.MIDDLE)
                        .withMaritalStatus(MaritalStatus.MARRIED)
                        .build())
                .withFinanceData(new FinanceData(Arrays.asList(new SourcesOfIncome(IncomeType.SELF_EMPLOYMENT, 10000.00))))
                .build();
        return person;
    }

}