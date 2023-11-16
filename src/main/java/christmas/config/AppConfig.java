package christmas.config;

import christmas.controller.EventController;
import christmas.domain.AmountDTO;
import christmas.domain.BillBuilder;
import christmas.domain.DiscountCalculator;
import christmas.service.AmountService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig implements Config {

    private static AppConfig defaultAppConfig;
    private InputView inputView;
    private EventController eventController;
    private AmountService amountService;
    private OutputView outputView;
    private AmountDTO amountDTO;
    private DiscountCalculator discountCalculator;
    private BillBuilder billBuilder;

    private AppConfig() {
    }

    public static AppConfig getInstance() {
        if (defaultAppConfig == null) {
            defaultAppConfig = new AppConfig();
        }
        return defaultAppConfig;
    }

    @Override
    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView(eventController());
        }
        return inputView;
    }

    @Override
    public EventController eventController() {
        if (eventController == null) {
            eventController = new EventController(amountService(), outputView());
        }
        return eventController;
    }

    @Override
    public AmountService amountService() {
        if (amountService == null) {
            amountService = new AmountService(amountDTO(), discountCalculator(), billBuilder());
        }
        return amountService;
    }

    @Override
    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    @Override
    public AmountDTO amountDTO() {
        if (amountDTO == null) {
            amountDTO = new AmountDTO();
        }
        return amountDTO;
    }

    @Override
    public DiscountCalculator discountCalculator() {
        if (discountCalculator == null) {
            discountCalculator = new DiscountCalculator();
        }
        return discountCalculator;
    }

    @Override
    public BillBuilder billBuilder() {
        if (billBuilder == null) {
            billBuilder = new BillBuilder(amountDTO());
        }
        return billBuilder;
    }
}
