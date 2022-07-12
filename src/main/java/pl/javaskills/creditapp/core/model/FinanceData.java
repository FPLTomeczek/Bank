package pl.javaskills.creditapp.core.model;

import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.ValidateCollection;

import java.util.*;

public class FinanceData {
    @NotNull
    @ValidateCollection
    private final List<SourcesOfIncome> sourcesOfIncomes;
    @NotNull
    @ValidateCollection
    private final Set<Expense> expenses;

    public FinanceData(List<SourcesOfIncome> sourcesOfIncomes) {
        this.sourcesOfIncomes = sourcesOfIncomes;
        this.expenses = new HashSet<>();
    }

    public FinanceData(List<SourcesOfIncome> sourcesOfIncomes, Set<Expense> expenses) {
        this.sourcesOfIncomes = sourcesOfIncomes;
        this.expenses = expenses;
    }



    private Map<ExpenseType, Set<Expense>> getExpensesMap()
    {
        Map <ExpenseType, Set<Expense>> map = new HashMap<>();
        for (Expense expense : expenses)
        {
            if(map.get(expense.getExpenseType())==null)
            {
                Set<Expense> expenseSet = new HashSet<>();
                expenseSet.add(expense);
                map.put(expense.getExpenseType(), expenseSet);
            }
            else
            {
                map.get(expense.getExpenseType()).add(expense);
            }

        }
        return map;
    }

    public double getSumOfExpenses(ExpenseType type)
    {
        Map<ExpenseType, Set<Expense>> expensesMap = getExpensesMap();
        double sum = 0.0;

        if(expensesMap.isEmpty())
        {
            return sum;
        }
        for (Expense expense: expensesMap.get(type))
        {
            sum += expense.getAmount();
        }
        return sum;
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }
    public List<SourcesOfIncome> getSourcesOfIncomes() {
        return sourcesOfIncomes;
    }
}
