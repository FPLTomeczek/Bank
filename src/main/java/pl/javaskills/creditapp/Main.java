package pl.javaskills.creditapp;

import pl.javaskills.creditapp.client.ConsoleReader;
import pl.javaskills.creditapp.core.CreditApplicationDecision;
import pl.javaskills.creditapp.core.CreditApplicationService;
import pl.javaskills.creditapp.core.PersonScoringCalculator;
import pl.javaskills.creditapp.core.model.LoanApplication;


public class Main {
    public static void main(String[] args) {

        CreditApplicationService service = new CreditApplicationService(new PersonScoringCalculator());
        LoanApplication loanApplication = new ConsoleReader().readInputParameters();
        System.out.println("Hello, " + loanApplication.getPerson().getPersonalData().getName()
                + " "
                + loanApplication.getPerson().getPersonalData().getLastName()
                + "!");
        CreditApplicationDecision CAD = service.getDecision(loanApplication);
        String decision = CAD.getDecisionString();
        System.out.println(decision);
    }
}
