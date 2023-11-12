package christmas.config;

import christmas.controller.EventController;
import christmas.domain.AmountDTO;
import christmas.domain.BillBuilder;
import christmas.domain.DiscountCalculator;
import christmas.service.AmountService;
import christmas.view.InputView;
import christmas.view.OutputView;

public interface Config {

    InputView inputView();
    EventController eventController();
    AmountService amountService();
    OutputView outputView();
    AmountDTO amountDTO();
    DiscountCalculator discountCalculator();
    BillBuilder billBuilder();
}
