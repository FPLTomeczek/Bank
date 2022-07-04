package pl.javaskills.creditapp;

import pl.javaskills.creditapp.client.CreditApplicationReader;
import pl.javaskills.creditapp.client.DummyCreditApplicationReader;
import pl.javaskills.creditapp.core.*;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.scoring.*;
import pl.javaskills.creditapp.core.validation.*;


public class Main {
    public static void main(String[] args) {
        CreditApplicationReader creditApplicationReader = new DummyCreditApplicationReader();


        EducationCalculator educationCalculator = new EducationCalculator();
        IncomeCalculator incomeCalculator = new IncomeCalculator();
        MaritalStatusCalculator maritalStatusCalculator = new MaritalStatusCalculator();
        SelfEmployedScoringCalculator selfEmployedScoringCalculator = new SelfEmployedScoringCalculator();
        GuarantorsCalculator guarantorsCalculator = new GuarantorsCalculator();

        PersonScoringCalculatorFactory personScoringCalculatorFactory = new PersonScoringCalculatorFactory(selfEmployedScoringCalculator, educationCalculator,
                maritalStatusCalculator, incomeCalculator, guarantorsCalculator);
        CreditApplicationValidator creditApplicationValidator = new CreditApplicationValidator(
                new PersonValidator(new PersonalDataValidator()),
                new PurposeOfLoanValidator(),
                new GuarantorValidator());
        CompoundPostValidator compoundPostValidator = new CompoundPostValidator(new PurposeOfLoanPostValidator(), new ExpensesPostValidator());
        CreditApplicationService service = new CreditApplicationService(personScoringCalculatorFactory, creditApplicationValidator, compoundPostValidator);
        LoanApplication loanApplication = creditApplicationReader.read();
        CreditApplicationManager creditApplicationManager = new CreditApplicationManager(service);

        creditApplicationManager.add(creditApplicationReader.read());
//        creditApplicationManager.add(creditApplicationReader.read());
//        creditApplicationManager.add(creditApplicationReader.read());
//        creditApplicationManager.add(creditApplicationReader.read());

        creditApplicationManager.startProcessing();
    }
}
