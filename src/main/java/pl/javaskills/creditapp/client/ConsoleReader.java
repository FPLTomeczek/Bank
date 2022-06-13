package pl.javaskills.creditapp.client;

import pl.javaskills.creditapp.core.model.*;
import pl.javaskills.creditapp.core.model.Person;

import java.util.Scanner;

public class ConsoleReader {

    public LoanApplication readInputParameters() {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = in.next();

        System.out.println("Enter your last name");
        String lastName = in.next();

        System.out.println("Enter your mothers maiden name");
        String motherMaidenName = in.next();

        System.out.println("What is your marital status? (SINGLE, MARRIED, DIVORCED, WIDOWED, SEPARATED)");
        MaritalStatus maritalStatus = MaritalStatus.valueOf(in.next());

        System.out.println("What's your education level? (NONE, PRIMARY, MIDDLE, SECONDARY, POST_SECONDARY, TERTIARY)");
        Education education = Education.valueOf(in.next());

        System.out.println("Enter your email address:");
        String email = in.next();

        System.out.println("Enter your phone number:");
        String phoneNumber = in.next();

        System.out.println("Enter total monthly income in PLN:");
        double monthlyIncome = in.nextDouble();

        System.out.println("Enter number of family dependants(including applicant):");
        int familyDependants = in.nextInt();

        System.out.println("What is purpose of loan? (MORTGAGE | PERSONAL_LOAN):");
        Loan loan = Loan.valueOf(in.next());

        System.out.println("Enter loan amount:");
        double loanAmount = in.nextDouble();

        System.out.println("Enter loan period (in years)");
        byte loanPeriod = in.nextByte();

        PersonalData pd = new PersonalData(name, lastName, motherMaidenName, maritalStatus,
                education, monthlyIncome, familyDependants);

        ContactData cd = new ContactData(email, phoneNumber);

        PurposeOfLoan pof = new PurposeOfLoan(loan, loanAmount, loanPeriod);

        return new LoanApplication(new Person(pd, cd), pof);
    }

}
