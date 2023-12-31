package christmas.service;

import christmas.domain.AmountDTO;
import christmas.domain.Badge;
import christmas.domain.BillBuilder;
import christmas.domain.Day;
import christmas.domain.DiscountCalculator;
import christmas.domain.OrderMenu;

public class AmountService {

    private final AmountDTO amountDTO;
    private final DiscountCalculator discountCalculator;
    private final BillBuilder billBuilder;

    public AmountService(
            final AmountDTO amountDTO,
            final DiscountCalculator discountCalculator,
            final BillBuilder billBuilder) {
        this.amountDTO = amountDTO;
        this.discountCalculator = discountCalculator;
        this.billBuilder = billBuilder;
    }

    public void addDay(Day day) {
        discountCalculator.setDay(day);
    }

    public void addOrderMenu(OrderMenu orderMenu) {
        discountCalculator.setOrderMenu(orderMenu);
    }

    public String findMenu() {
        return discountCalculator.toString();
    }

    public String findBill() {
        addAmount();
        return billBuilder.toString();
    }

    private void addAmount() {
        amountDTO.setAmount(discountCalculator.calculateBeforeDiscount());
        amountDTO.setChristmasDiscount(discountCalculator.calculateChristmas());
        amountDTO.setWeekdayDiscount(discountCalculator.calculateWeekday());
        amountDTO.setWeekendDiscount(discountCalculator.calculateWeekend());
        amountDTO.setSpecialDiscount(discountCalculator.calculateSpecial());
        amountDTO.setGiftDiscount(discountCalculator.calculateGift());
        amountDTO.setWeekend(discountCalculator.isWeekend());
        amountDTO.setMinAmount(discountCalculator.isMinAmount());
    }

    public String findBadge() {
        return new Badge(Math.abs(
                billBuilder.calculateBenefitsAmount()))
                .toString();
    }
}
