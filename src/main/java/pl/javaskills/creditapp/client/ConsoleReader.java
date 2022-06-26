package pl.javaskills.creditapp.client;

import pl.javaskills.creditapp.core.Constants;
import pl.javaskills.creditapp.core.model.*;
import pl.javaskills.creditapp.core.model.Person;

import java.util.Scanner;

public class ConsoleReader {

    public LoanApplication readInputParameters() {

        Scanner in = new Scanner(System.in);

        String name = getName(in);

        String lastName = getLastName(in);

        String motherMaidenName = getMothersMaidenName(in);

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


        String email = getEmail(in);

        String phoneNumber = getPhoneNumber(in);

        int numOfSources = getNumOfSources(in);

        SourcesOfIncome[] sourcesOfIncomes = getSourcesOfIncomes(in, numOfSources);

        int familyDependants = getFamilyDependants(in);
        do {
            System.out.println("What is purpose of loan? " + GenerateStringForEnums.generateLoan());
            validateString = in.next();
        }while (!EnumValidator.validateLoan(validateString));
        Loan loan = Loan.valueOf(validateString);

        double loanAmount = getLoanAmount(in);

        int loanPeriod = getLoanPeriod(in);


        PersonalData pd = PersonalData.Builder.create()
                .withName(name)
                .withLastName(lastName)
                .withMothersMaidenName(motherMaidenName)
                .withMaritalStatus(maritalStatus)
                .withEducation(education)
                .withNumOfFamilyDependants(familyDependants)
                .build();

        FinanceData fd = new FinanceData(sourcesOfIncomes);

        ContactData cd = ContactData.Builder
                .create()
                .withEmail(email)
                .withPhoneNumber(phoneNumber)
                .build();

        PurposeOfLoan pof = new PurposeOfLoan(loan, loanAmount, loanPeriod);

        return new LoanApplication(NaturalPerson.Builder.create()
        .withPersonalData(pd)
        .withFinanceData(fd)
        .withContactData(cd)
                .build(), pof);
    }

    private int getLoanPeriod(Scanner in) {
        String input;
        do {
            System.out.println("Enter loan period (in years)");
            input = in.next();
        }
        while (!NumberValidator.validateInteger(input,5,10,15,20,25,30));
        int loanPeriod = Integer.parseInt(input);
        return loanPeriod;
    }

    private double getLoanAmount(Scanner in) {
        String input;
        do {
            System.out.println("Enter loan amount:");
            input = in.next();
        }while(!NumberValidator.validateDouble(input, 0.,Double.MAX_VALUE));
        return Double.parseDouble(input);
    }

    private int getFamilyDependants(Scanner in) {
        String input;
        do {
            System.out.println("Enter number of family dependants(including applicant):");
            input = in.next();
        }while (!NumberValidator.validateInteger(input, 1,Integer.MAX_VALUE));
        int familyDependants = Integer.parseInt(input);
        return familyDependants;
    }

    private SourcesOfIncome[] getSourcesOfIncomes(Scanner in, int numOfSources) {
        String validateString;
        SourcesOfIncome[] sourcesOfIncomes = new SourcesOfIncome[numOfSources];
        for (int i = 1; i< numOfSources +1; i++)
        {
            do {
                System.out.println("Enter type of source of income " + i + " " + GenerateStringForEnums.generateIncomeType());
                validateString = in.next();
            }
            while (!EnumValidator.validateIncomeType(validateString));
            IncomeType incomeType = IncomeType.valueOf(validateString);
            double monthlyIncome = getMonthlyIncome(in, i);

            sourcesOfIncomes[i-1] = new SourcesOfIncome(incomeType, monthlyIncome);
        }
        return sourcesOfIncomes;
    }
    
    private double getMonthlyIncome(Scanner in, int i) {
        String input;
        do {
            System.out.println("Enter net monthly income of source of income " + i + ": ");
            input = in.next();
        }while(!NumberValidator.validateDouble(input,0.0,Double.MAX_VALUE));
        double monthlyIncome = Double.parseDouble(input);
        return monthlyIncome;
    }

    private int getNumOfSources(Scanner in) {
        String input;
        do {
            System.out.println("How many sources of income do you have?");
            input = in.next();
        }while (!NumberValidator.validateInteger(input,0,Integer.MAX_VALUE));
        return Integer.parseInt(input);
    }

    private String getName(Scanner in) {
        String input = "";
        do {
            System.out.println("Enter your name");
            input = in.next();
        }while (!StringValidator.validateString(input, Constants.NAME_REGEX));
        return input;
    }

    private String getLastName(Scanner in) {
        String input = "";
        do {
            System.out.println("Enter your last name");
            input = in.next();
        }while (!StringValidator.validateString(input, Constants.LASTNAME_REGEX));
        return input;
    }

    private String getMothersMaidenName(Scanner in) {
        String input = "";
        do {
            System.out.println("Enter your mothers maiden name");
            input = in.next();
        }while (!StringValidator.validateString(input, Constants.LASTNAME_REGEX));
        return input;
    }

    private String getEmail(Scanner in) {
        String input = "";
        do {
            System.out.println("Enter your email address:");
            input = in.next();
        }while (!StringValidator.validateString(input, Constants.EMAIL_REGEX));
        return input;
    }

    private String getPhoneNumber(Scanner in) {
        String input = "";
        do {
            System.out.println("Enter your phone number:");
            input = in.next();
        }while (!PhoneValidator.validate(input));
        return input;
    }

    private String getHowManySourcesOfIncome(Scanner in) {
        String input = "";
        do {
            System.out.println("Enter your phone number:");
            input = in.next();
        }while (!NumberValidator.validateInteger(input,1,5));
        return input;
    }


}
