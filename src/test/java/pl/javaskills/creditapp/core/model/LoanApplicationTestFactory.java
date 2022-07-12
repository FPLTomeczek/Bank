package pl.javaskills.creditapp.core.model;

import java.time.ZoneId;
import java.util.Set;

public class LoanApplicationTestFactory {
    static final ZoneId zone = ZoneId.of("Europe/Warsaw");
    public static LoanApplication create(NaturalPerson person , PurposeOfLoan purposeOfLoan, Set<Guarantor> guarantors){

        return new LoanApplication(zone, person, purposeOfLoan, guarantors);
    }


    public static LoanApplication create(){
        NaturalPerson person = PersonTestFactory.create(MaritalStatus.MARRIED, Education.MIDDLE, 2, new SourcesOfIncome(IncomeType.SELF_EMPLOYMENT, 10000.00));
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(Loan.MORTGAGE, 50000.00, 30);
        LoanApplication loanApplication = new LoanApplication(zone, person, purposeOfLoan);
        return loanApplication;
    }

    public static LoanApplication create(Loan loanType , double expectedLoanAmount,
                                         byte expectedLoanPeriod){
        NaturalPerson person = PersonTestFactory.create(5000, 2, Education.MIDDLE, MaritalStatus.SEPARATED);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(loanType, expectedLoanAmount, expectedLoanPeriod);
        LoanApplication loanApplication = new LoanApplication(zone, person, purposeOfLoan);
        return loanApplication;
    }

    public static LoanApplication create(Loan loanType , double expectedLoanAmount,
                                         byte expectedLoanPeriod, double totalMonthlyIncomeInPln, int numOfDependants){
        NaturalPerson person = PersonTestFactory.create(totalMonthlyIncomeInPln, numOfDependants, Education.MIDDLE, MaritalStatus.SEPARATED);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(loanType, expectedLoanAmount, expectedLoanPeriod);
        LoanApplication loanApplication = new LoanApplication(zone, person, purposeOfLoan);
        return loanApplication;
    }

    public static LoanApplication create(NaturalPerson person , PurposeOfLoan purposeOfLoan){
        return new LoanApplication(zone, person, purposeOfLoan);
    }

    public static LoanApplication create(SelfEmployed person , PurposeOfLoan purposeOfLoan){
        return new LoanApplication(zone, person, purposeOfLoan);
    }
}
