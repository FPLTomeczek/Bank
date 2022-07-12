package pl.javaskills.creditapp.client;

import pl.javaskills.creditapp.core.model.*;

import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static pl.javaskills.creditapp.util.AgeUtils.generateBirthDate;

public class DummyCreditApplicationReader implements CreditApplicationReader{
    @Override
    public LoanApplication read() {
        final FamilyMember familyMember1 = new FamilyMember("John", generateBirthDate(18));
        final FamilyMember familyMember2 = new FamilyMember("Jane", generateBirthDate(5));
        final FamilyMember familyMember3 = new FamilyMember("Jarret", generateBirthDate(40));
        List<FamilyMember> familyMemberList = Arrays.asList(familyMember1,familyMember2,familyMember3);
        NaturalPerson person = NaturalPerson.Builder
                .create()
                .withPesel("12341234123")
                .withFamilyMembers(familyMemberList)
                .withPersonalData(PersonalData.Builder.create()
                        .withName("Test")
                        .withLastName("Test")
                        .withMothersMaidenName("Test")
                        .withEducation(Education.MIDDLE)
                        .withMaritalStatus(MaritalStatus.MARRIED)
                        .build())
                .withContactData(ContactData.Builder.create()
                        .withEmail("test@test")
                        .withPhoneNumber("123123132")
                        .withHomeAddress(new Address("test","test","test","test","test"))
                        .withCorrespondenceAddress(new Address("test","test","test","test","test"))
                        .build())
                .withFinanceData(new FinanceData(Arrays.asList(new SourcesOfIncome(IncomeType.SELF_EMPLOYMENT, 10000.00))))
                .build();
        Set<Guarantor> guarantors = Set.of(new Guarantor("12341234123", generateBirthDate(18)),
                new Guarantor("12341234125", generateBirthDate(40)));
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(Loan.MORTGAGE, 50000.00, 30);
        LoanApplication loanApplication = new LoanApplication(ZoneId.of("Europe/Warsaw"), person, purposeOfLoan, guarantors);


        return loanApplication;
    }
}
