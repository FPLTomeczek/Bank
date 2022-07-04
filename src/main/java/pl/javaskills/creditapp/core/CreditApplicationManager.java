package pl.javaskills.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import pl.javaskills.creditapp.core.model.LoanApplication;

import java.util.ArrayDeque;
import java.util.Deque;

public class CreditApplicationManager {
    private static final Logger log = LoggerFactory.getLogger(CreditApplicationService.class);
    private final Deque<LoanApplication> deque = new ArrayDeque<>();
    private final CreditApplicationService creditApplicationService;

    public CreditApplicationManager(CreditApplicationService creditApplicationService) {
        this.creditApplicationService = creditApplicationService;
    }

    public void add(LoanApplication loanApplication)
    {
        log.info(String.format("Application %s is added to queue", loanApplication.getId()));
        deque.addFirst(loanApplication);
    }

    public void startProcessing()
    {
        while (!deque.isEmpty())
        {
            LoanApplication loanApplication = deque.pollLast();
            log.info(String.format("Starting processing app with id %s", loanApplication.getId()));
            CreditApplicationDecision decision = creditApplicationService.getDecision(loanApplication);
            log.info(decision.getDecisionString());
            MDC.remove("id");
        }
    }
}
