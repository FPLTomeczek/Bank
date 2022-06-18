package pl.javaskills.creditapp.client;

import pl.javaskills.creditapp.core.model.Education;
import pl.javaskills.creditapp.core.model.IncomeType;
import pl.javaskills.creditapp.core.model.Loan;
import pl.javaskills.creditapp.core.model.MaritalStatus;

public class GenerateStringForEnums {

    public static String generateMaritalStatus()
    {

        StringBuilder middle= new StringBuilder();
        int i=0;
        for(MaritalStatus maritalStatus: MaritalStatus.values())
        {
            i++;
            middle.append(maritalStatus.name());
            if(i!=MaritalStatus.values().length) {
                middle.append(", ");
            }
        }
        return "("+middle+")";
    }

    public static String generateEducation()
    {

        StringBuilder middle= new StringBuilder();
        int i=0;
        for(Education education: Education.values())
        {
            i++;
            middle.append(education.name());
            if(i!=Education.values().length) {
                middle.append(", ");
            }
        }
        return "("+middle+")";
    }

    public static String generateLoan()
    {

        StringBuilder middle= new StringBuilder();
        int i=0;
        for(Loan loan: Loan.values())
        {
            i++;
            middle.append(loan.name());
            if(i!=Loan.values().length) {
                middle.append(", ");
            }
        }
        return "("+middle+")";
    }

    public static String generateIncomeType()
    {

        StringBuilder middle= new StringBuilder();
        int i=0;
        for(IncomeType incomeType: IncomeType.values())
        {
            i++;
            middle.append(incomeType.name());
            if(i!=IncomeType.values().length) {
                middle.append(", ");
            }
        }
        return "("+middle+")";
    }
}
