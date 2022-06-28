package pl.javaskills.creditapp.core;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.Loan;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.LoanApplicationTestFactory;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.scoring.PersonCalculator;
import pl.javaskills.creditapp.core.validation.CreditApplicationValidator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class CreditApplicationServiceTest {

    @InjectMocks
    private CreditApplicationService cut;

    @Mock
    private PersonCalculator calculatorMock;

    @Mock
    private PersonScoringCalculatorFactory personScoringCalculatorFactoryMock;

    @Mock
    private CreditApplicationValidator creditApplicationValidatorMock;

    @BeforeEach
    public void init() throws ValidationException {
        BDDMockito.given(personScoringCalculatorFactoryMock.getCalculator(any(Person.class))).willReturn(calculatorMock);

        BDDMockito.doNothing()
                .when(creditApplicationValidatorMock)
                .validate(any(LoanApplication.class));
    }

    @Test
    @DisplayName("should return NEGATIVE_SCORING decision, when scoring is < 300")
    public void test1(){
        //given
        LoanApplication loanApplication = LoanApplicationTestFactory.create(Loan.MORTGAGE, 100000.0, (byte) 25);
        BDDMockito.given(calculatorMock.calculate(eq(loanApplication.getPerson()))).willReturn(100);

        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.NEGATIVE_SCORING, decision.getDecisionType());
    }

    @Test
    @DisplayName("should return CONTACT_REQUIRED decision, when scoring is <= 400")
    public void test2(){
        //given
        LoanApplication loanApplication = LoanApplicationTestFactory.create(Loan.MORTGAGE, 100000.0, (byte) 25);
        BDDMockito.given(calculatorMock.calculate(eq(loanApplication.getPerson()))).willReturn(350);

        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.CONTACT_REQUIRED, decision.getDecisionType());
    }


    @Test
    @DisplayName("should return CONTACT_REQUIRED decision, when scoring is > 400 and credit rating > expected loan amount")
    public void test3(){
        //given
        LoanApplication loanApplication = LoanApplicationTestFactory.create(Loan.MORTGAGE, 190000.0, (byte) 25, 5000, 2);
        BDDMockito.given(calculatorMock.calculate(eq(loanApplication.getPerson()))).willReturn(450);

        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.NEGATIVE_CREDIT_RATING, decision.getDecisionType());
    }

    @Test
    @DisplayName("should return POSITIVE decision, when scoring is > 400 and credit rating <= expected loan amount")
    public void test4(){
        //given
        LoanApplication loanApplication = LoanApplicationTestFactory.create(Loan.MORTGAGE, 100000.0, (byte) 25, 5000, 2);
        BDDMockito.given(calculatorMock.calculate(eq(loanApplication.getPerson()))).willReturn(450);

        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.POSITIVE, decision.getDecisionType());
    }

}