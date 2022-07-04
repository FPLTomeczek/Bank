package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.Constants;
import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.Guarantor;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PurposeOfLoan;

import java.util.Set;

public class GuarantorValidator implements Validator{
    @Override
    public void validate(LoanApplication creditApplication) throws ValidationException {
        final Set<Guarantor> guarantors = creditApplication.getGuarantors();
        for (Guarantor g: guarantors)
        {
            ValidationUtils.validateNotNull("pesel",g.getPesel());
            ValidationUtils.validateRegex("pesel", g.getPesel(), Constants.PESEL_REGEX);
            ValidationUtils.validateMinValue("age",18,g.getAge());
        }

    }
}
