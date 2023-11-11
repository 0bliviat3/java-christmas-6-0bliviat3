package christmas.controller;

import christmas.service.AmountService;
import christmas.view.OutputView;

public class EventController {

    private final AmountService amountService;
    private final OutputView outputView;

    public EventController(final AmountService amountService, final OutputView outputView) {
        this.amountService = amountService;
        this.outputView = outputView;
    }
}
