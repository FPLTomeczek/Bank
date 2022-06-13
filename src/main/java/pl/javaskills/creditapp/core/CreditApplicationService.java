package pl.javaskills.creditapp.core;


import pl.javaskills.creditapp.core.model.Loan;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;

public class CreditApplicationService {
    private final PersonScoringCalculator calculator;
    public CreditApplicationService(PersonScoringCalculator calculator) {
        this.calculator = calculator;
    }

    public CreditApplicationDecision getDecision(LoanApplication loanApplication){

        Person p = loanApplication.getPerson();
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

        double creditRating = LOAN_RATE*p.getPersonalData().incomePerFamilyMember()*12*loanApplication.getLoan().getPeriod();

        if(points < 300){
            return new CreditApplicationDecision(DecisionType.NEGATIVE_SCORING, p.getPersonalData(), creditRating);
        }
        else if (points <= 400)
        {
            return new CreditApplicationDecision(DecisionType.CONTACT_REQUIRED, p.getPersonalData(), creditRating);
        }
        else if(creditRating >= loanApplication.getLoan().getAmount())
        {
            return new CreditApplicationDecision(DecisionType.POSITIVE, p.getPersonalData(), creditRating);
        }
        else{
            return new CreditApplicationDecision(DecisionType.NEGATIVE_CREDIT_RATING, p.getPersonalData(), creditRating);
        }

    }
}
