package christmas.domain;

import static christmas.domain.constants.CalculatorConstants.*;
import static christmas.domain.constants.FoodConstants.CHAMPAGNE;

public class DiscountCalculator {

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
        return orderMenu.getAmount() >= MIN_AMOUNT.getNumber();
    }

    public int calculateChristmas() {
        if (day.isChristmas()) {
            return day.getChristmasDiscount();
        }
        return NO_DISCOUNT.getNumber();
    }

    public boolean isWeekend() {
        return day.isWeekend();
    }

    public int calculateWeekend() {
        return orderMenu.getCategoryCount(MAIN.getNumber()) * YEAR.getNumber();
    }

    public int calculateWeekday() {
        return orderMenu.getCategoryCount(DESSERT.getNumber()) * YEAR.getNumber();
    }

    public int calculateSpecial() {
        if (day.isSpecialDay()) {
            return SPECIAL.getNumber();
        }
        return NO_DISCOUNT.getNumber();
    }

    public int calculateGift() {
        if (orderMenu.getAmount() >= GIFT_MIN_AMOUNT.getNumber()) {
            return  CHAMPAGNE.getAmount();
        }
        return NO_DISCOUNT.getNumber();
    }

    @Override
    public String toString() {
        return orderMenu.toString();
    }
}
