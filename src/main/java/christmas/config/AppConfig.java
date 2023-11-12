package christmas.config;

import christmas.controller.EventController;
import christmas.domain.AmountDTO;
import christmas.domain.BillBuilder;
import christmas.domain.DiscountCalculator;
import christmas.service.AmountService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig {

    private InputView inputView;
    private EventController eventController;
    private AmountService amountService;
    private OutputView outputView;
    private AmountDTO amountDTO;
    private DiscountCalculator discountCalculator;
    private BillBuilder billBuilder;

    private AppConfig() {

    }

}
