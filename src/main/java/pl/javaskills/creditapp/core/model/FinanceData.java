package pl.javaskills.creditapp.core.model;

public class FinanceData {
    private final SourcesOfIncome[] sourcesOfIncomes;

    public FinanceData(SourcesOfIncome... sourcesOfIncomes) {
        this.sourcesOfIncomes = sourcesOfIncomes;
    }

    public SourcesOfIncome[] getSourcesOfIncomes() {
        return sourcesOfIncomes;
    }
}
