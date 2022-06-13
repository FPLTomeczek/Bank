package pl.javaskills.creditapp.core;


import pl.javaskills.creditapp.core.model.Loan;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;

public class CreditApplicationService {
    public String getDecision(LoanApplication loanApplication){
        PersonScoringCalculator pcalc = new PersonScoringCalculator();
        String decision;
        Person p = loanApplication.getPerson();
        int points = pcalc.calculate(loanApplication.getPerson());

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
            decision = String.format("Sorry %s %s decision is negative", loanApplication.getPerson().getPersonalData().getName(),
                    loanApplication.getPerson().getPersonalData().getLastName());
        }
        else if (points <= 400)
        {
            decision = String.format("Sorry, %s %s bank requires additional documents",
                    loanApplication.getPerson().getPersonalData().getName(), loanApplication.getPerson().getPersonalData().getLastName());
        }
        else if(creditRating >= loanApplication.getLoan().getAmount())
        {
            decision = String.format("Congratulations, %s %s decision is positive",
                    loanApplication.getPerson().getPersonalData().getName(), loanApplication.getPerson().getPersonalData().getLastName());
        }
        else{
            decision =String.format("Sorry %s %s decision is negative. Bank can borrow only %g", loanApplication.getPerson().getPersonalData().getName(),
                    loanApplication.getPerson().getPersonalData().getLastName(),
                    creditRating);
        }

        return decision;
    }
}
