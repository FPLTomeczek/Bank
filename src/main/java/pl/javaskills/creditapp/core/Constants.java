package pl.javaskills.creditapp.core;

public class Constants {

    public static final double MORTGAGE_LOAN_RATE = 0.2;
    public static final double PERSONAL_LOAN_LOAN_RATE = 0.1;
    public static final double MIN_LOAN_AMOUNT_MORTGAGE = 100_000.00;
    public static final String DOUBLE_REGEX = "[0-9]+(\\.[0-9]+)?";
    public static final String INT_REGEX = "\\d+";
    public static final String NAME_REGEX = "[A-ZĄ-Ź][a-zą-ź]{2,9}";
    public static final String LASTNAME_REGEX = "[A-ZĄ-Ź][a-zą-ź]+(\\s)?(-)?([A-ZĄ-Ź][a-zą-ź]+)?";
    public static final String EMAIL_REGEX = ".+@.+";
    public static final String PHONE_NUMBER_REGEX = "\\+?([0-9]?){2}[0-9]{9}";


}
