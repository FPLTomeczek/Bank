package pl.javaskills.creditapp.core.model;

import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.ValidateCollection;
import pl.javaskills.creditapp.core.annotation.ValidateObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Person {
    @NotNull
    @ValidateObject
    protected final PersonalData personalData;
    @NotNull
    @ValidateObject
    protected final ContactData contactData;
    @NotNull
    @ValidateObject
    protected final FinanceData financeData;
    @NotNull
    @ValidateCollection
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

    public double getBalance()
    {
        double totalMonthlyIncome = 0.0;
        for (SourcesOfIncome sourceOfIncome: financeData.getSourcesOfIncomes()) {
            totalMonthlyIncome+=sourceOfIncome.getNetMonthlyIncome();
        }

        double totalExpenses = 0.0;
        for (Expense expense: financeData.getExpenses()) {
            totalExpenses+=expense.getAmount();
        }

        return totalMonthlyIncome - totalExpenses;
    }

    public double getIncomePerFamilyMember()
    {
        return getBalance()/this.getNumOfFamilyDependants();
    }
}
