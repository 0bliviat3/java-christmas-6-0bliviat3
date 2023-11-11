package christmas.domain;

public class DiscountCalculator {

    // TODO: 상수 처리 필요

    private static final String MESSAGE = "\n<주문 메뉴>\n";
    private Day day;
    private OrderMenu orderMenu;

    public void setDay(Day day) {
        this.day = day;
    }

    public void setOrderMenu(OrderMenu orderMenu) {
        this.orderMenu = orderMenu;
    }

    public int calculateBeforeDiscount() {
        return orderMenu.getAmount();
    }

    public boolean isMinAmount() {
        return orderMenu.getAmount() >= 10_000;
    }

    public int calculateChristmas() {
        if(day.isChristmas()) {
            return day.getChristmasDiscount();
        }
        return 0;
    }

    public boolean isWeekend() {
        return day.isWeekend();
    }

    public int calculateWeekend() {
        return orderMenu.getCategoryCount(1) * 2023;
    }

    public int calculateWeekday() {
        return orderMenu.getCategoryCount(2) * 2023;
    }

    public int calculateSpecial() {
        if(day.isSpecialDay()) {
            return 1000;
        }
        return 0;
    }

    public int calculateGift() {
        if(orderMenu.getAmount() >= 120_000) {
            return 25_000;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.join(MESSAGE, orderMenu.toString());
    }
}
