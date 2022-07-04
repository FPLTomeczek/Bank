package pl.javaskills.creditapp.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.javaskills.creditapp.core.exception.RequirementNotMetCause;
import pl.javaskills.creditapp.core.model.*;
import pl.javaskills.creditapp.core.scoring.*;
import pl.javaskills.creditapp.core.validation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;

class CreditApplicationServiceBDDTest {

    private final EducationCalculator educationCalculator = new EducationCalculator();
    private final IncomeCalculator incomeCalculator = new IncomeCalculator();
    private final MaritalStatusCalculator maritalStatusCalculator = new MaritalStatusCalculator();
    private final SelfEmployedScoringCalculator selfEmployedScoringCalculator = new SelfEmployedScoringCalculator();
    private final GuarantorsCalculator guarantorsCalculator = new GuarantorsCalculator();
    private final CompoundPostValidator compoundPostValidator = new CompoundPostValidator(new PurposeOfLoanPostValidator(), new ExpensesPostValidator());
    private final CreditApplicationValidator creditApplicationValidator = new CreditApplicationValidator(new PersonValidator(new PersonalDataValidator()),new PurposeOfLoanValidator(), new GuarantorValidator());

    private final PersonScoringCalculatorFactory personScoringCalculatorFactory = new PersonScoringCalculatorFactory(selfEmployedScoringCalculator, educationCalculator,maritalStatusCalculator, incomeCalculator, guarantorsCalculator);

    private CreditApplicationService cut = new CreditApplicationService(personScoringCalculatorFactory, creditApplicationValidator, compoundPostValidator); ;

    @Test
    @DisplayName("should return Decision is NEGATIVE_REQUIREMENTS_NOT_MET, minumum loan amount requirement is not met")
    public void test1(){
        //given
        List<FamilyMember> familyMemberList = Arrays.asList(new FamilyMember("John",18));
        NaturalPerson person = NaturalPerson.Builder
                .create()
                .withFamilyMembers(familyMemberList)
                .withPersonalData(PersonalData.Builder.create()
                        .withName("Test")
                        .withLastName("Test")
                        .withMothersMaidenName("Test")
                        .withEducation(Education.MIDDLE)
                        .withMaritalStatus(MaritalStatus.MARRIED)
                        .build())
                .withFinanceData(new FinanceData(Arrays.asList(new SourcesOfIncome(IncomeType.SELF_EMPLOYMENT, 10000.00))))
                .build();
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(Loan.MORTGAGE, 50000.00, 30);
        LoanApplication loanApplication = LoanApplicationTestFactory.create(person, purposeOfLoan);

        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.NEGATIVE_REQUIREMENTS_NOT_MET, decision.getDecisionType());
        assertEquals(600, decision.getScoring());
        assertEquals(360000.00, decision.getCreditRate());
    }

    @Test
    @DisplayName("should return Decision is NEGATIVE, when years since founded < 2")
    public void test2(){
        //given
        List<FamilyMember> familyMemberList = Arrays.asList(new FamilyMember("John",18));
        SelfEmployed person = SelfEmployed.Builder
                .create()
                .withFamilyMembers(familyMemberList)
                .withPersonalData(PersonalData.Builder.create()
                        .withName("Test")
                        .withLastName("Test")
                        .withMothersMaidenName("Test")
                        .withEducation(Education.MIDDLE)
                        .withMaritalStatus(MaritalStatus.MARRIED)
                        .build())
                .withFinanceData(new FinanceData(Arrays.asList(new SourcesOfIncome(IncomeType.SELF_EMPLOYMENT, 7000.00))))
                .withYearsSinceFounded(1)
                .build();
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(Loan.MORTGAGE, 500000.00, 30);
        LoanApplication loanApplication = LoanApplicationTestFactory.create(person, purposeOfLoan);

        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.NEGATIVE_SCORING, decision.getDecisionType());
        assertEquals(200, decision.getScoring());
    }


    @Test
    @DisplayName("should return Decision is CONTACT_REQUIRED, when years since founded >= 2")
    public void test3(){
        //given
        List<FamilyMember> familyMemberList = Arrays.asList(new FamilyMember("John",18));
        SelfEmployed person = SelfEmployed.Builder
                .create()
                .withFamilyMembers(familyMemberList)
                .withPersonalData(PersonalData.Builder.create()
                        .withName("Test")
                        .withLastName("Test")
                        .withMothersMaidenName("Test")
                        .withEducation(Education.MIDDLE)
                        .withMaritalStatus(MaritalStatus.MARRIED)
                        .build())
                .withFinanceData(new FinanceData(Arrays.asList(new SourcesOfIncome(IncomeType.SELF_EMPLOYMENT, 7000.00))))
                .withYearsSinceFounded(3)
                .build();
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(Loan.MORTGAGE, 500000.00, 30);
        LoanApplication loanApplication = LoanApplicationTestFactory.create(person, purposeOfLoan);

        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.CONTACT_REQUIRED, decision.getDecisionType());
        assertEquals(400, decision.getScoring());
    }

    @Test
    @DisplayName("should return Decision is NEGATIVE REQUIREMENTS NOT MET, cause too high personal expenses")
    public void test4(){
        //given
        Set<Expense> expenseSet = Set.of(new Expense("1",ExpenseType.PERSONAL, 500),
                new Expense("2", ExpenseType.PERSONAL, 750));
        final FinanceData financeData = new FinanceData(Arrays.asList(new SourcesOfIncome(IncomeType.SELF_EMPLOYMENT, 2000.00)),
                expenseSet);
        SelfEmployed person = SelfEmployed.Builder
                .create()
                .withPersonalData(PersonalData.Builder.create()
                        .withName("Test")
                        .withLastName("Test")
                        .withMothersMaidenName("Test")
                        .withEducation(Education.MIDDLE)
                        .withMaritalStatus(MaritalStatus.MARRIED)
                        .build())
                .withFinanceData(financeData)
                .withYearsSinceFounded(3)
                .build();
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(Loan.MORTGAGE, 500000.00, 30);
        LoanApplication loanApplication = LoanApplicationTestFactory.create(person, purposeOfLoan);

        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.NEGATIVE_REQUIREMENTS_NOT_MET, decision.getDecisionType());
        assertTrue(decision.getRequirementNotMetCause().isPresent());
        assertEquals(RequirementNotMetCause.TOO_HIGH_PERSONAL_EXPENSES, decision.getRequirementNotMetCause().get());
    }

}