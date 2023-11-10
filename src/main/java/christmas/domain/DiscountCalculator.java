package christmas.domain;

public class DiscountCalculator {

    private final Day day;
    private final OrderMenu orderMenu;

    public DiscountCalculator(final Day day, final OrderMenu orderMenu) {
        this.day = day;
        this.orderMenu = orderMenu;
    }

}
