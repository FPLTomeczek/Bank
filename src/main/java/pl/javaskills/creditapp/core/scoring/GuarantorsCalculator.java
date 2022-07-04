package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.Guarantor;
import pl.javaskills.creditapp.core.model.LoanApplication;

public class GuarantorsCalculator implements ScoringCalculator {

    private static final Logger log = LoggerFactory.getLogger(GuarantorsCalculator.class);

    @Override
    public int calculate(LoanApplication loanApplication) {
        int scoringUnder40 = 0;
        int scoringOthers = 0;
        for (Guarantor g : loanApplication.getGuarantors()) {
            if (g.getAge() < 40) {
                scoringUnder40 += 50;
            }
            else
            {
                scoringOthers += 25;
            }
        }

        if (scoringUnder40 > 0)
        {
            log.info("Points for guarantor under 40: " + scoringUnder40);
        }
        if (scoringUnder40 > 0)
        {
            log.info("Points for guarantor more or equal 40: " + scoringOthers);
        }
        return scoringOthers + scoringUnder40;
    }
}
