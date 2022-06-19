package pl.javaskills.creditapp.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javaskills.creditapp.client.ConsoleReader;
import pl.javaskills.creditapp.core.model.Loan;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.LoanApplicationTestFactory;
import pl.javaskills.creditapp.core.scoring.EducationCalculator;
import pl.javaskills.creditapp.core.scoring.IncomeCalculator;
import pl.javaskills.creditapp.core.scoring.MaritalStatusCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;

class CreditApplicationServiceBDDTest {


    private CreditApplicationService cut = new CreditApplicationService(new PersonScoringCalculator(new EducationCalculator(),
            new MaritalStatusCalculator(), new IncomeCalculator())); ;

    @Test
    @DisplayName("should return Decision is NEGATIVE_REQUIREMENTS_NOT_MET, minumum loan amount requirement is not met")
    public void test1(){
        //given
        LoanApplication loanApplication = LoanApplicationTestFactory.create();

        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.NEGATIVE_REQUIREMENTS_NOT_MET, decision.getDecisionType());
        assertEquals(600, decision.getScoring());
        assertEquals(360000.00, decision.getCreditRate());
    }

}