package pl.javaskills.creditapp.core.model;

public class Person {
    private PersonalData personalData;
    private ContactData contactData;
    private FinanceData financeData;

    public Person(PersonalData personalData, ContactData contactData, FinanceData financeData) {
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
