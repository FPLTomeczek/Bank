package pl.javaskills.creditapp;

import pl.javaskills.creditapp.client.CreditApplicationReader;
import pl.javaskills.creditapp.client.DummyCreditApplicationReader;
import pl.javaskills.creditapp.core.*;
import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.scoring.*;
import pl.javaskills.creditapp.core.validation.*;
import pl.javaskills.creditapp.core.validation.reflection.*;
import pl.javaskills.creditapp.di.ClassInitializer;

import java.time.ZoneId;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;


public class Main {
    static
    {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of(Constants.DEFAULT_SYSTEM_ZONE_ID)));
    }
    public static void main(String[] args) throws Exception {
        CreditApplicationReader creditApplicationReader = new DummyCreditApplicationReader();
        ;

        List<FieldAnnotationProcessor> fieldAnnotationProcessors = List.of(new NotNullAnnotationProcessor(), new RegexAnnotationProcessor());
        List<ClassAnnotationProcessor> classAnnotationProcessors = List.of(new ExactlyOneNotNullAnnotationProcessor());
        final ObjectValidator objectValidator = new ObjectValidator(fieldAnnotationProcessors, classAnnotationProcessors);

        CompoundPostValidator compoundPostValidator = new CompoundPostValidator(new PurposeOfLoanPostValidator(), new ExpensesPostValidator());
        ClassInitializer classInitializer = new ClassInitializer();
        classInitializer.registerInstance(compoundPostValidator);
        classInitializer.registerInstance(objectValidator);

        CreditApplicationManager creditApplicationManager = (CreditApplicationManager)classInitializer.createInstance(CreditApplicationManager.class);
        creditApplicationManager.add(creditApplicationReader.read());
//        creditApplicationManager.add(creditApplicationReader.read());
//        creditApplicationManager.add(creditApplicationReader.read());
//        creditApplicationManager.add(creditApplicationReader.read());

        creditApplicationManager.startProcessing();
    }
}
