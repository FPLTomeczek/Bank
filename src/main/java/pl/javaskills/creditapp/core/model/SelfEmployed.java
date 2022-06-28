package pl.javaskills.creditapp.core.model;

import java.util.List;

public class SelfEmployed extends Person {

    private final String nip;
    private final String regon;
    private final int yearsSinceFounded;

    private SelfEmployed(PersonalData personalData,
                         ContactData contactData,
                         FinanceData financeData,
                         List<FamilyMember> familyMemberList,
                         String nip,
                         String regon, int yearsSinceFounded) {
        super(personalData, contactData, financeData, familyMemberList);
        this.nip = nip;
        this.regon = regon;
        this.yearsSinceFounded = yearsSinceFounded;
    }

    public int getYearsSinceFounded() {
        return yearsSinceFounded;
    }

    public static class Builder {
        private String nip;
        private String regon;
        private PersonalData personalData;
        private ContactData contactData;
        private FinanceData financeData;
        private int yearsSinceFounded;
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

        public Builder withNip(String nip) {
            this.nip = nip;
            return this;
        }

        public Builder withRegon(String regon) {
            this.regon = regon;
            return this;
        }

        public Builder withYearsSinceFounded(int yearsSinceFounded) {
            this.yearsSinceFounded = yearsSinceFounded;
            return this;
        }



        public SelfEmployed build() {
            return new SelfEmployed(personalData, contactData, financeData,familyMemberList, nip, regon, yearsSinceFounded);
        }


    }
}
