package pl.javaskills.creditapp.core;

public interface Constants {

    double MORTGAGE_LOAN_RATE = 0.2;
    double PERSONAL_LOAN_LOAN_RATE = 0.1;
    double MIN_LOAN_AMOUNT_MORTGAGE = 100_000.00;
    String DOUBLE_REGEX = "[0-9]+(\\.[0-9]+)?";
    String INT_REGEX = "\\d+";
    String NAME_REGEX = "[A-ZĄ-Ź][a-zą-ź]{2,9}";
    String LASTNAME_REGEX = "[A-ZĄ-Ź][a-zą-ź]+(\\s)?(-)?([A-ZĄ-Ź][a-zą-ź]+)?";
    String EMAIL_REGEX = ".+@.+";
    String PHONE_NUMBER_REGEX = "\\+?([0-9]?){2}[0-9]{9}";
    String PESEL_REGEX = "\\d{11}";

}
