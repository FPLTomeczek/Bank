package pl.javaskills.creditapp.core.model;

import java.util.Arrays;
import java.util.List;

public class FinanceData {
    private final List<SourcesOfIncome> sourcesOfIncomes;

    public FinanceData(SourcesOfIncome... sourcesOfIncomes) {
        this.sourcesOfIncomes = Arrays.asList(sourcesOfIncomes);
    }

    public List<SourcesOfIncome> getSourcesOfIncomes() {
        return sourcesOfIncomes;
    }
}
