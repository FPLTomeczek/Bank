package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.CreditApplicationService;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;

public class CompoundScoringCalculator implements ScoringCalculator {

    private final ScoringCalculator[] scoringCalculators;

    public CompoundScoringCalculator(ScoringCalculator... scoringCalculators) {
        this.scoringCalculators = scoringCalculators;
    }

    private static final Logger log = LoggerFactory.getLogger(CreditApplicationService.class);

    @Override
    public int calculate(LoanApplication loanApplication) {
        int scoring = 0;
        for(ScoringCalculator scoringCalculator : scoringCalculators)
        {
            scoring+= scoringCalculator.calculate(loanApplication);
        }
        log.info("Calculated scoring = " + scoring + " points");

        return scoring;
    }
}
