package pl.javaskills.creditapp.core.model;

public class LoanApplicationTestFactory {

    public static LoanApplication create(){
        NaturalPerson person = PersonTestFactory.create(MaritalStatus.MARRIED, Education.MIDDLE, 2, new SourcesOfIncome(IncomeType.SELF_EMPLOYMENT, 10000.00));
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(Loan.MORTGAGE, 50000.00, 30);
        LoanApplication loanApplication = new LoanApplication(person, purposeOfLoan);
        return loanApplication;
    }

    public static LoanApplication create(Loan loanType , double expectedLoanAmount,
                                         byte expectedLoanPeriod){
        NaturalPerson person = PersonTestFactory.create(5000, 2, Education.MIDDLE, MaritalStatus.SEPARATED);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(loanType, expectedLoanAmount, expectedLoanPeriod);
        LoanApplication loanApplication = new LoanApplication(person, purposeOfLoan);
        return loanApplication;
    }

    public static LoanApplication create(Loan loanType , double expectedLoanAmount,
                                         byte expectedLoanPeriod, double totalMonthlyIncomeInPln, int numOfDependants){
        NaturalPerson person = PersonTestFactory.create(totalMonthlyIncomeInPln, numOfDependants, Education.MIDDLE, MaritalStatus.SEPARATED);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(loanType, expectedLoanAmount, expectedLoanPeriod);
        LoanApplication loanApplication = new LoanApplication(person, purposeOfLoan);
        return loanApplication;
    }

    public static LoanApplication create(NaturalPerson person , PurposeOfLoan purposeOfLoan){
        return new LoanApplication(person, purposeOfLoan);
    }

    public static LoanApplication create(SelfEmployed person , PurposeOfLoan purposeOfLoan){
        return new LoanApplication(person, purposeOfLoan);
    }
}
