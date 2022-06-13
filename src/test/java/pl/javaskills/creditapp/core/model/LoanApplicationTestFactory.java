package pl.javaskills.creditapp.core.model;

public class LoanApplicationTestFactory {
    public static LoanApplication create(Loan loanType , double expectedLoanAmount,
                                         byte expectedLoanPeriod){
        Person person = PersonTestFactory.create(5000, 2, Education.MIDDLE, MaritalStatus.SEPARATED);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(loanType, expectedLoanAmount, expectedLoanPeriod);
        LoanApplication loanApplication = new LoanApplication(person, purposeOfLoan);
        return loanApplication;
    }
    public static LoanApplication create(Loan loanType , double expectedLoanAmount,
                                         byte expectedLoanPeriod, double totalMonthlyIncomeInPln, int numOfDependants){
        Person person = PersonTestFactory.create(totalMonthlyIncomeInPln, numOfDependants, Education.MIDDLE, MaritalStatus.SEPARATED);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(loanType, expectedLoanAmount, expectedLoanPeriod);
        LoanApplication loanApplication = new LoanApplication(person, purposeOfLoan);
        return loanApplication;
    }
}
