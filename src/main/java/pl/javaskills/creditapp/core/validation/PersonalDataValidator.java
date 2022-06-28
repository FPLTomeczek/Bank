package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.Constants;
import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.Loan;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonalData;

public class PersonalDataValidator implements Validator{

    @Override
    public void validate(LoanApplication creditApplication) throws ValidationException {
           PersonalData personalData = creditApplication.getPerson().getPersonalData();

           ValidationUtils.validateNotNull("name", personalData.getName());
           ValidationUtils.validateRegex("name",personalData.getName(), Constants.NAME_REGEX);

           ValidationUtils.validateNotNull("lastName", personalData.getLastName());
           ValidationUtils.validateRegex("lastName",personalData.getLastName(), Constants.LASTNAME_REGEX);

           ValidationUtils.validateNotNull("mothersMaidenName", personalData.getMothersMaidenName());
           ValidationUtils.validateRegex("mothersMaidenName", personalData.getMothersMaidenName(), Constants.LASTNAME_REGEX);

           ValidationUtils.validateNotNull("maritalStatus", personalData.getMaritalStatus());
           ValidationUtils.validateNotNull("education", personalData.getEducation());

           ValidationUtils.validateMinValue("familyDependants", 0, creditApplication.getPerson().getNumOfFamilyDependants());


    }
}
