package pl.javaskills.creditapp.core.validation;

import org.junit.jupiter.api.Test;
import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.*;
import pl.javaskills.creditapp.core.validation.reflection.*;
import pl.javaskills.creditapp.util.AgeUtils;

import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CreditApplicationValidatorTest {
    List<FieldAnnotationProcessor> fieldAnnotationProcessors = List.of(new NotNullAnnotationProcessor(), new RegexAnnotationProcessor());
    List<ClassAnnotationProcessor> classAnnotationProcessors = List.of(new ExactlyOneNotNullAnnotationProcessor());
    final ObjectValidator objectValidator = new ObjectValidator(fieldAnnotationProcessors, classAnnotationProcessors);
    CreditApplicationValidator cut = new CreditApplicationValidator(objectValidator);
    @Test
    public void test() throws ValidationException {
        //given
        final FamilyMember familyMember1 = new FamilyMember("John", AgeUtils.generateBirthDate(18));
        final FamilyMember familyMember2 = new FamilyMember("Jane", AgeUtils.generateBirthDate(5));
        final FamilyMember familyMember3 = new FamilyMember("Jarret", AgeUtils.generateBirthDate(40));
        List<FamilyMember> familyMemberList = Arrays.asList(familyMember1,familyMember2,familyMember3);
        NaturalPerson person = NaturalPerson.Builder
                .create()
                .withPesel("12312312312")
                .withFamilyMembers(familyMemberList)
                .withPersonalData(PersonalData.Builder.create()
                        .withName("Test")
                        .withLastName("Test")
                        .withMothersMaidenName("Test")
                        .withEducation(Education.MIDDLE)
                        .withMaritalStatus(MaritalStatus.MARRIED)
                        .build())
                .withFinanceData(new FinanceData(Arrays.asList(new SourcesOfIncome(IncomeType.SELF_EMPLOYMENT, 10000.00))))
                .withContactData(ContactData.Builder.create()
                    .withEmail("test@test")
                    .withPhoneNumber("123123132")
                    .withHomeAddress(new Address("test","test","test","test","test"))
                    .withCorrespondenceAddress(new Address("test","test","test","test","test"))
                    .build())
                .build();
        Set<Guarantor> guarantors = Set.of(new Guarantor("12341234123", AgeUtils.generateBirthDate(18)),
                new Guarantor("12341234125", AgeUtils.generateBirthDate(40)));
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(Loan.MORTGAGE, 50000.00, 30);
        LoanApplication loanApplication = new LoanApplication(ZoneId.of("Europe/Warsaw"), person, purposeOfLoan, guarantors);
        //when
        cut.validate(loanApplication);

    }

}