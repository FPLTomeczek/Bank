package pl.javaskills.creditapp.core;

import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonalData;

public class CreditApplicationDecision {
    private final DecisionType decisionType;
    private final PersonalData personalData;
    private final Double creditRate;

    public CreditApplicationDecision(DecisionType decisionType, PersonalData personalData, Double creditRate) {
        this.decisionType = decisionType;
        this.personalData = personalData;
        this.creditRate = creditRate;
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
                return String.format("Sorry %s %s decision is negative. Bank can borrow only %g", personalData.getName(),
                        personalData.getLastName(),
                        creditRate);
            case CONTACT_REQUIRED:
                return String.format("Sorry, %s %s bank requires additional documents",
                        personalData.getName(), personalData.getLastName());
        }
        return null;
    }

    public DecisionType getDecisionType() {
        return decisionType;
    }
}
