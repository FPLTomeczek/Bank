package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.LoanApplication;

public class CreditApplicationValidator implements Validator{

    private final PersonValidator personValidator;
    private final PurposeOfLoanValidator purposeOfLoanValidator;

    public CreditApplicationValidator(PersonValidator personValidator, PurposeOfLoanValidator purposeOfLoanValidator) {
        this.personValidator = personValidator;
        this.purposeOfLoanValidator = purposeOfLoanValidator;
    }

    @Override
    public void validate(LoanApplication creditApplication) throws ValidationException {
        ValidationUtils.validateNotNull("person", creditApplication.getPerson());
        personValidator.validate(creditApplication);
        ValidationUtils.validateNotNull("purposeOfLoan", creditApplication.getLoan());
        purposeOfLoanValidator.validate(creditApplication);


    }
}
