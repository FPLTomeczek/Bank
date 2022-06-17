package pl.javaskills.creditapp.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import pl.javaskills.creditapp.core.model.Loan;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.scoring.EducationCalculator;

import java.util.UUID;

public class CreditApplicationService {
    private final PersonScoringCalculator calculator;
    public CreditApplicationService(PersonScoringCalculator calculator) {
        this.calculator = calculator;
    }

    private static final Logger log = LoggerFactory.getLogger(CreditApplicationService.class);

    public CreditApplicationDecision getDecision(LoanApplication loanApplication){

        String id = UUID.randomUUID().toString();
        MDC.put("id", id);
        log.info("Application ID is {}", id);
        Person p = loanApplication.getPerson();
        CreditApplicationDecision decision;
        int points = calculator.calculate(loanApplication.getPerson());

        double LOAN_RATE;
        Loan loan = loanApplication.getLoan().getLoan();
        switch (loan) {
            case MORTGAGE:
                LOAN_RATE = Constants.MORTGAGE_LOAN_RATE;
                break;
            case PERSONAL_LOAN:
                LOAN_RATE = Constants.PERSONAL_LOAN_LOAN_RATE;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + loan);
        }

        double creditRating = LOAN_RATE*p.getIncomePerFamilyMember()*12*loanApplication.getLoan().getPeriod();

        if(points < 300){
            decision = new CreditApplicationDecision(DecisionType.NEGATIVE_SCORING, p.getPersonalData(), creditRating);
        }
        else if (points <= 400)
        {
            decision = new CreditApplicationDecision(DecisionType.CONTACT_REQUIRED, p.getPersonalData(), creditRating);
        }
        else if(creditRating >= loanApplication.getLoan().getAmount())
        {
            decision = new CreditApplicationDecision(DecisionType.POSITIVE, p.getPersonalData(), creditRating);
        }
        else{
            decision = new CreditApplicationDecision(DecisionType.NEGATIVE_CREDIT_RATING, p.getPersonalData(), creditRating);
        }
        log.info("DECISION = " + decision.getDecisionType());
    return decision;
    }
}
