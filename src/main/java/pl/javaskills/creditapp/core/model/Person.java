package pl.javaskills.creditapp.core.model;

public abstract class Person {
    protected final PersonalData personalData;
    protected final ContactData contactData;
    protected final FinanceData financeData;

    protected Person(PersonalData personalData, ContactData contactData, FinanceData financeData) {
        this.personalData = personalData;
        this.contactData = contactData;
        this.financeData = financeData;
    }



    public PersonalData getPersonalData() {
        return personalData;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public FinanceData getFinanceData() {
        return financeData;
    }

    public double getIncomePerFamilyMember()
    {
        double totalMonthlyIncome = 0;
        for (SourcesOfIncome sourceofIncome: financeData.getSourcesOfIncomes()) {
            totalMonthlyIncome+=sourceofIncome.getNetMonthlyIncome();
        }
        return totalMonthlyIncome/this.getPersonalData().getNumOfFamilyDependants();
    }
}
