package pl.javaskills.creditapp.core;

import pl.javaskills.creditapp.core.exception.RequirementNotMetCause;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonalData;

import java.util.Optional;

public class CreditApplicationDecision {
    private final DecisionType decisionType;
    private final PersonalData personalData;
    private final Double creditRate;
    private final Integer scoring;
    private final Optional<RequirementNotMetCause> requirementNotMetCause;

    public CreditApplicationDecision(DecisionType decisionType, PersonalData personalData, Double creditRate, Integer scoring) {
        this.decisionType = decisionType;
        this.personalData = personalData;
        this.creditRate = creditRate;
        this.scoring = scoring;
        this.requirementNotMetCause = Optional.empty();
    }
    public CreditApplicationDecision(DecisionType decisionType, PersonalData personalData, Double creditRate, Integer scoring, RequirementNotMetCause requirementNotMetCause) {
        this.decisionType = decisionType;
        this.personalData = personalData;
        this.creditRate = creditRate;
        this.scoring = scoring;
        this.requirementNotMetCause = Optional.of(requirementNotMetCause);
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
                switch (requirementNotMetCause.get()){
                    case TOO_HIGH_PERSONAL_EXPENSES:
                        return "Decision is negative requirements not met, cause too high personal expenses.";
                    case TOO_LOW_LOAN_AMOUNT:
                        return "Decision is negative requirements not met, cause too low loan amount.";
                }
        }
        return null;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public Optional<RequirementNotMetCause> getRequirementNotMetCause() {
        return requirementNotMetCause;
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
