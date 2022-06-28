package pl.javaskills.creditapp.core.model;

import java.util.List;

public class NaturalPerson extends Person {

    private final String pesel;

    private NaturalPerson(PersonalData personalData,
                          ContactData contactData,
                          FinanceData financeData,
                          List<FamilyMember> familyMemberList,
                          String pesel) {
        super(personalData, contactData, financeData, familyMemberList);
        this.pesel = pesel;
    }

    public static class Builder {
        private String pesel;
        private PersonalData personalData;
        private ContactData contactData;
        private FinanceData financeData;
        private List<FamilyMember> familyMemberList;

        private Builder() {
        }

        public static Builder create() {
            return new Builder();
        }

        public Builder withPersonalData(PersonalData personalData) {
            this.personalData = personalData;
            return this;
        }


        public Builder withContactData(ContactData contactData) {
            this.contactData = contactData;
            return this;
        }

        public Builder withFinanceData(FinanceData financeData) {
            this.financeData = financeData;
            return this;
        }

        public Builder withFamilyMembers(List<FamilyMember> familyMemberList) {
            this.familyMemberList= familyMemberList;
            return this;
        }

        public Builder withPesel(String pesel) {
            this.pesel = pesel;
            return this;
        }

        public NaturalPerson build() {
            return new NaturalPerson(personalData, contactData, financeData,familyMemberList, pesel);
        }


    }
}
