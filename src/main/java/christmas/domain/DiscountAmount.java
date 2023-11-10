package christmas.domain;

public class DiscountAmount {

    private final int day;
    private final OrderMenu orderMenu;

    public DiscountAmount(final int day, final OrderMenu orderMenu) {
        this.day = day;
        this.orderMenu = orderMenu;
    }

}
