package pl.javaskills.creditapp.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.exception.RequirementNotMetException;
import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.Loan;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.validation.CompoundPostValidator;
import pl.javaskills.creditapp.core.validation.CreditApplicationValidator;

import static pl.javaskills.creditapp.core.DecisionType.*;

public class CreditApplicationService {

    private final PersonScoringCalculatorFactory personScoringCalculatorFactory;
    private final CreditApplicationValidator creditApplicationValidator;
    private final CompoundPostValidator compoundPostValidator;

    public CreditApplicationService(PersonScoringCalculatorFactory personScoringCalculatorFactory, CreditApplicationValidator creditApplicationValidator, CompoundPostValidator compoundPostValidator) {
        this.personScoringCalculatorFactory = personScoringCalculatorFactory;
        this.creditApplicationValidator = creditApplicationValidator;
        this.compoundPostValidator = compoundPostValidator;
    }

    private static final Logger log = LoggerFactory.getLogger(CreditApplicationService.class);

    public CreditApplicationDecision getDecision(LoanApplication loanApplication) {

        String id = loanApplication.getId().toString();


        try {
            Person p = loanApplication.getPerson();
            //step1
            creditApplicationValidator.validate(loanApplication);

            //step2
            int points = personScoringCalculatorFactory.getCalculator(p).calculate(loanApplication);

            //step3
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
            double creditRating = LOAN_RATE * p.getIncomePerFamilyMember() * 12 * loanApplication.getLoan().getPeriod();

            //step4
            try
            {
                compoundPostValidator.validate(loanApplication,points,creditRating);
            }catch (RequirementNotMetException reqEx)
            {
                return new CreditApplicationDecision(NEGATIVE_REQUIREMENTS_NOT_MET, p.getPersonalData(), creditRating, points, reqEx.getRequirementNotMetCause());
            }


            CreditApplicationDecision decision = getCreditApplicationDecision(loanApplication, p, points, creditRating);
            log.info("DECISION = " + decision.getDecisionType());
            return decision;
        } catch (ValidationException e) {
            log.error(e.getMessage());
            throw new IllegalStateException();
        }catch(Exception e)
        {

            log.error(e.getMessage());
            throw new IllegalStateException();
        }
        finally {
            log.info("Application processing finished");
        }


    }

    private CreditApplicationDecision getCreditApplicationDecision(LoanApplication loanApplication, Person p, int points, double creditRating) {
        CreditApplicationDecision decision;

        if (points < 300) {
            decision = new CreditApplicationDecision(NEGATIVE_SCORING, p.getPersonalData(), creditRating, points);
        } else if (points <= 400) {
            decision = new CreditApplicationDecision(CONTACT_REQUIRED, p.getPersonalData(), creditRating, points);
        } else if (creditRating >= loanApplication.getLoan().getAmount()) {
            decision = new CreditApplicationDecision(POSITIVE, p.getPersonalData(), creditRating, points);
        } else {
            decision = new CreditApplicationDecision(NEGATIVE_CREDIT_RATING, p.getPersonalData(), creditRating, points);
        }
        return decision;
    }
}
