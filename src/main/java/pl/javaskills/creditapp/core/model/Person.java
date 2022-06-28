package pl.javaskills.creditapp.core.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Person {
    protected final PersonalData personalData;
    protected final ContactData contactData;
    protected final FinanceData financeData;
    protected final List<FamilyMember> familyMembers;

    protected Person(PersonalData personalData, ContactData contactData, FinanceData financeData, List<FamilyMember> familyMembers) {
        this.personalData = personalData;
        this.contactData = contactData;
        this.financeData = financeData;
        this.familyMembers = familyMembers;
        Collections.sort(this.familyMembers);
    }

    public List<FamilyMember> getFamilyMembers()
    {
        return familyMembers;
    }

    public List<FamilyMember> getFamilyMembersSortedByName()
    {
        List<FamilyMember> copy = new ArrayList<>(this.familyMembers);
        Collections.sort(copy, new FamilyMemberNameComparator());
        return copy;
    }

    public int getNumOfFamilyDependants()
    {
        return 1+this.familyMembers.size();
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
        return totalMonthlyIncome/this.getNumOfFamilyDependants();
    }
}
