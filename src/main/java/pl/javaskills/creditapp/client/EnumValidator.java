package pl.javaskills.creditapp.client;

import pl.javaskills.creditapp.core.model.Education;
import pl.javaskills.creditapp.core.model.IncomeType;
import pl.javaskills.creditapp.core.model.Loan;
import pl.javaskills.creditapp.core.model.MaritalStatus;

public class EnumValidator {

    public static boolean validateMaritalStatus (String text)
    {
        for (MaritalStatus status : MaritalStatus.values()) {
            if (text.equals(status.name()))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean validateEducation (String text)
    {
        for (Education education : Education.values()) {
            if (text.equals(education.name()))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean validateLoan (String text)
    {
        for (Loan loan : Loan.values()) {
            if (text.equals(loan.name()))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean validateIncomeType(String text)
    {
        for (IncomeType incomeType : IncomeType.values()) {
            if (text.equals(incomeType.name()))
            {
                return true;
            }
        }
        return false;
    }
}
