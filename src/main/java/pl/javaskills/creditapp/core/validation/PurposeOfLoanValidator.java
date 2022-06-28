package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.PurposeOfLoan;

public class PurposeOfLoanValidator implements Validator{
    @Override
    public void validate(LoanApplication creditApplication) throws ValidationException {
        final PurposeOfLoan purposeOfLoan = creditApplication.getLoan();

        ValidationUtils.validateNotNull("loan", purposeOfLoan.getLoan());

        ValidationUtils.validateMinValue("amount",0.0,purposeOfLoan.getAmount());
    }
}
