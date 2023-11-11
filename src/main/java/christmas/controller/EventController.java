package christmas.controller;

import static christmas.exception.ExceptionConstants.DATE;
import static christmas.exception.InputException.validateNumber;
import static christmas.exception.InputException.validateOrder;

import christmas.domain.Day;
import christmas.domain.OrderMenu;
import christmas.service.AmountService;
import christmas.view.OutputView;

public class EventController {

    private final AmountService amountService;
    private final OutputView outputView;

    public EventController(final AmountService amountService, final OutputView outputView) {
        this.amountService = amountService;
        this.outputView = outputView;
    }

    public void dayAdd(String day) {
        amountService.addDay(new Day(validateNumber(day, DATE)));
    }

    public void orderAdd(String order) {
        amountService.addOrderMenu(new OrderMenu(validateOrder(order)));
    }

    public void preViewList() {
        outputView.printPreview();
        outputView.printMenu();
        outputView.printModel(amountService.findMenu());
        outputView.printModel(amountService.findBill());
        outputView.printBadge();
        outputView.printModel(amountService.findBadge());
    }
}
