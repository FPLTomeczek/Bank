package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.SelfEmployed;

public class SelfEmployedScoringCalculator implements PersonCalculator {

    private static final Logger log = LoggerFactory.getLogger(SelfEmployedScoringCalculator.class);


    @Override
    public int calculate(SelfEmployed selfEmployed) {

    log.info("Years since founded = " + selfEmployed.getYearsSinceFounded());
    if (selfEmployed.getYearsSinceFounded() < 2) {
        return -200;
    }
    return 0;
    }
}
