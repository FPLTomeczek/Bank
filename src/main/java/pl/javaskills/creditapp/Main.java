package pl.javaskills.creditapp;

import pl.javaskills.creditapp.client.CreditApplicationReader;
import pl.javaskills.creditapp.client.DummyCreditApplicationReader;
import pl.javaskills.creditapp.core.*;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.scoring.EducationCalculator;
import pl.javaskills.creditapp.core.scoring.IncomeCalculator;
import pl.javaskills.creditapp.core.scoring.MaritalStatusCalculator;
import pl.javaskills.creditapp.core.scoring.SelfEmployedScoringCalculator;
import pl.javaskills.creditapp.core.validation.CreditApplicationValidator;
import pl.javaskills.creditapp.core.validation.PersonValidator;
import pl.javaskills.creditapp.core.validation.PersonalDataValidator;
import pl.javaskills.creditapp.core.validation.PurposeOfLoanValidator;


public class Main {
    public static void main(String[] args) {
        CreditApplicationReader creditApplicationReader = new DummyCreditApplicationReader();


        EducationCalculator educationCalculator = new EducationCalculator();
        IncomeCalculator incomeCalculator = new IncomeCalculator();
        MaritalStatusCalculator maritalStatusCalculator = new MaritalStatusCalculator();
        SelfEmployedScoringCalculator selfEmployedScoringCalculator = new SelfEmployedScoringCalculator();

        PersonScoringCalculatorFactory personScoringCalculatorFactory = new PersonScoringCalculatorFactory(selfEmployedScoringCalculator, educationCalculator,
                maritalStatusCalculator, incomeCalculator);
        CreditApplicationValidator creditApplicationValidator = new CreditApplicationValidator(new PersonValidator(new PersonalDataValidator()),new PurposeOfLoanValidator());
        CreditApplicationService service = new CreditApplicationService(personScoringCalculatorFactory, creditApplicationValidator);
        LoanApplication loanApplication = creditApplicationReader.read();
        
        CreditApplicationDecision CAD = service.getDecision(loanApplication);
        String decision = CAD.getDecisionString();
        System.out.println(decision);
    }
}
