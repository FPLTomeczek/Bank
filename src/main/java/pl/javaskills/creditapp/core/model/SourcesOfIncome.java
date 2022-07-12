package pl.javaskills.creditapp.core.model;

import pl.javaskills.creditapp.core.annotation.NotNull;

public class SourcesOfIncome {
    @NotNull
    private final IncomeType incomeType;
    private final double netMonthlyIncome;

    public SourcesOfIncome(IncomeType incomeType, double netMonthlyIncome) {
        this.incomeType = incomeType;
        this.netMonthlyIncome = netMonthlyIncome;
    }

    public IncomeType getIncomeType() {
        return incomeType;
    }

    public double getNetMonthlyIncome() {
        return netMonthlyIncome;
    }
}
