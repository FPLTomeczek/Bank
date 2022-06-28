package pl.javaskills.creditapp.core;

import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonalData;

public class CreditApplicationDecision {
    private final DecisionType decisionType;
    private final PersonalData personalData;
    private final Double creditRate;
    private final int scoring;

    public CreditApplicationDecision(DecisionType decisionType, PersonalData personalData, Double creditRate, int scoring) {
        this.decisionType = decisionType;
        this.personalData = personalData;
        this.creditRate = creditRate;
        this.scoring = scoring;
    }

    public String getDecisionString()
    {
        switch (decisionType){
            case POSITIVE:
                return String.format("Congratulations, %s %s decision is positive",
                        personalData.getName(), personalData.getLastName());
            case NEGATIVE_SCORING:
                return String.format("Sorry %s %s decision is negative", personalData.getName(),
                        personalData.getLastName());
            case NEGATIVE_CREDIT_RATING:
                return String.format("Sorry %s %s decision is negative. Bank can borrow only %f", personalData.getName(),
                        personalData.getLastName(),
                        creditRate);
            case CONTACT_REQUIRED:
                return String.format("Sorry, %s %s bank requires additional documents",
                        personalData.getName(), personalData.getLastName());
            case NEGATIVE_REQUIREMENTS_NOT_MET:
                return String.format("Sorry, %s %s, decision is negative. Minimum loan amount for mortgage is" +
                                "%f",
                        personalData.getName(), personalData.getLastName(),Constants.MIN_LOAN_AMOUNT_MORTGAGE);

        }
        return null;
    }

    public DecisionType getDecisionType() {
        return decisionType;
    }

    public int getScoring() {
        return scoring;
    }

    public Double getCreditRate() {
        return creditRate;
    }
}
