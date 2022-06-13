package pl.javaskills.creditapp.core;

import pl.javaskills.creditapp.core.model.Education;
import pl.javaskills.creditapp.core.model.MaritalStatus;
import pl.javaskills.creditapp.core.model.Person;

public class PersonScoringCalculator {
    public int calculate (Person person){
        int incomePerFamilyMember =(int) (person.getPersonalData().getTotalMonthlyIncomeInPln()/person.getPersonalData().getNumOfFamilyDependants());
        int incomePerFamilyMemberPoints = incomePerFamilyMember/1000;
        int score = 0;

        MaritalStatus maritalStatus = person.getPersonalData().getMaritalStatus();
        int maritalStatusPoints = maritalStatus.getValue();

        Education education = person.getPersonalData().getEducation();
        int educationPoints = education.getValue();


        score = incomePerFamilyMemberPoints*100 + maritalStatusPoints + educationPoints;
        return score;
    }
}
