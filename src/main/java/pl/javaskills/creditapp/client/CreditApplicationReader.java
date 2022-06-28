package pl.javaskills.creditapp.client;

import pl.javaskills.creditapp.core.model.LoanApplication;

public interface CreditApplicationReader {
    LoanApplication read();
}
