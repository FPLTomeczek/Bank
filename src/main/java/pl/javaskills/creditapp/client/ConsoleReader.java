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

        String validateString = "";
        do {
            System.out.println("What is your marital status? " + GenerateStringForEnums.generateMaritalStatus());
            validateString = in.next();
        }while (!EnumValidator.validateMaritalStatus(validateString));
        MaritalStatus maritalStatus = MaritalStatus.valueOf(validateString);


        do {
            System.out.println("What's your education level? " + GenerateStringForEnums.generateEducation());
            validateString = in.next();

        }while (!EnumValidator.validateEducation(validateString));
        Education education = Education.valueOf(validateString);


        System.out.println("Enter your email address:");
        String email = in.next();

        System.out.println("Enter your phone number:");
        String phoneNumber = in.next();

        System.out.println("How many sources of income do you have?");
        int numOfSources = in.nextInt();

        SourcesOfIncome[] sourcesOfIncomes = new SourcesOfIncome[numOfSources];
        for (int i=1; i<numOfSources+1; i++)
        {
            do {
                System.out.println("Enter type of source of income " + i + " " + GenerateStringForEnums.generateIncomeType());
                validateString = in.next();
            }
            while (!EnumValidator.validateIncomeType(validateString));
            IncomeType incomeType = IncomeType.valueOf(validateString);
            System.out.println("Enter net monthly income of source of income "+ i +": ");
            double monthlyIncome = in.nextDouble();
            sourcesOfIncomes[i-1] = new SourcesOfIncome(incomeType, monthlyIncome);
        }

        System.out.println("Enter number of family dependants(including applicant):");
        int familyDependants = in.nextInt();


        do {
            System.out.println("What is purpose of loan? " + GenerateStringForEnums.generateLoan());
            validateString = in.next();
        }while (!EnumValidator.validateLoan(validateString));
        Loan loan = Loan.valueOf(validateString);

        System.out.println("Enter loan amount:");
        double loanAmount = in.nextDouble();

        System.out.println("Enter loan period (in years)");
        byte loanPeriod = in.nextByte();

        PersonalData pd = new PersonalData(name, lastName, motherMaidenName, maritalStatus,
                education, familyDependants);

        FinanceData fd = new FinanceData(sourcesOfIncomes);

        ContactData cd = new ContactData(email, phoneNumber);

        PurposeOfLoan pof = new PurposeOfLoan(loan, loanAmount, loanPeriod);

        return new LoanApplication(new Person(pd, cd, fd), pof);
    }

}
