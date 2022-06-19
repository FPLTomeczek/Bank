package pl.javaskills.creditapp.client;

import pl.javaskills.creditapp.core.Constants;

public class NumberValidator {
    public static boolean validateDouble(String input, double min, double max)
    {
        if(input.matches(Constants.DOUBLE_REGEX)) {
            Double double_val = Double.valueOf(input);
            if(double_val >= min && double_val<=max) {
                return true;
            }
        }
        return false;
    }


    public static boolean validateInteger(String input, int min, int max)
    {
        if(input.matches(Constants.INT_REGEX)) {
            Integer int_val = Integer.valueOf(input);
            if(int_val >= min && int_val<=max) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateInteger(String input, int... allowedValues)
    {

        if(input.matches(Constants.INT_REGEX)) {
            Integer int_val = Integer.valueOf(input);
            for(int value: allowedValues)
            {
                if(value==int_val) return true;
            }
        }
        return false;
    }


}
