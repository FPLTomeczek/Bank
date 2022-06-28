package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.*;

public class ValidationUtils {
    public static void validateNotNull(String field, Object object) throws ValidationException {
        if(object==null)
        {
            throw new NotNullException(field);
        }
    }
    public static void validateRegex(String field, String value, String regex) throws ValidationException
    {
        if(!value.matches(regex))
        {
            throw new RegexException(field);
        }
    }

    public static void validateMinValue(String field, int expValue, int actValue) throws ValidationException
    {
        if(expValue>actValue)
        {
            throw new MinValueException(field, expValue);
        }
    }

    public static void validateMinValue(String field, double expValue, double actValue) throws ValidationException
    {
        if(expValue>actValue)
        {
            throw new MinValueException(field, expValue);
        }
    }

    public static void validateMaxValue(String field, int expValue, int actValue) throws ValidationException
    {
        if(expValue<actValue)
        {
            throw new MaxValueException(field, expValue);
        }
    }

    public static void validateMaxValue(String field, double expValue, double actValue) throws ValidationException
    {
        if(expValue<actValue)
        {
            throw new MaxValueException(field, expValue);
        }
    }

}
