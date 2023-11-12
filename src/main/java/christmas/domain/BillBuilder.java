package christmas.domain;

import static christmas.domain.constants.DiscountConstants.*;

import java.text.DecimalFormat;
import java.util.function.Supplier;

public class BillBuilder {

    private static final String EMPTY = "";
    private static final String CHAMPAGNE = "샴페인 1개\n";
    private static final String DECIMAL_REGEX = "###,###";
    private static final int NO_DISCOUNT = 0;
    private static final int NEGATIVE_CORRECTION = -1;
    private final DecimalFormat amountFormat;
    private final AmountDTO amountDTO;

    public BillBuilder(final AmountDTO amountDTO) {
        amountFormat = new DecimalFormat(DECIMAL_REGEX);
        this.amountDTO = amountDTO;
    }

    @Override
    public String toString() {
        StringBuilder bill = new StringBuilder();
        bill.append(buildAmount(amountDTO.getAmount(), BEFORE_DISCOUNT.getMessage()))
                .append(GIFT_MENU.getMessage())
                .append(buildByIsMin(this::buildGiftMenu, amountDTO.isMinAmount(), NONE.getMessage()))
                .append(BENEFITS_DETAILS.getMessage())
                .append(buildByIsMin(this::buildBenefits, amountDTO.isMinAmount(), NONE.getMessage()))
                .append(buildAmount(calculateBenefitsAmount(), BENEFITS_AMOUNT.getMessage()))
                .append(buildBenefit(this::calculatePay, AFTER_DISCOUNT.getMessage()));
        return bill.toString();
    }

    private String buildAmount(int amount, String constant) {
        return String.format(constant, amountFormat.format(amount));
    }

    private String buildByIsMin(
            Supplier<String> builder, boolean isMinAmount, String noneConstant) {
        if (isMinAmount) {
            return builder.get();
        }
        return noneConstant;
    }

    private String buildGiftMenu() {
        return CHAMPAGNE;
    }

    private String buildBenefits() {
        return String.join(
                EMPTY,
                buildBenefit(amountDTO::getChristmasDiscount, CHRISTMAS.getMessage()),
                buildWeekBenefit(),
                buildBenefit(amountDTO::getSpecialDiscount, SPECIAL.getMessage()),
                buildBenefit(amountDTO::getGiftDiscount, GIFT.getMessage()));
    }

    private String buildBenefit(
            Supplier<Integer> calculator, String discountConstant) {
        int calculateResult = calculator.get();
        if (calculateResult == NO_DISCOUNT) {
            return EMPTY;
        }
        return buildAmount(calculateResult, discountConstant);
    }

    private String buildWeekBenefit() {
        if (amountDTO.isWeekend()) {
            return buildBenefit(amountDTO::getWeekendDiscount, WEEKEND.getMessage());
        }
        return buildBenefit(amountDTO::getWeekdayDiscount, WEEKDAY.getMessage());
    }

    public int calculateBenefitsAmount() {
        int sum = sumProcess();
        if (amountDTO.isWeekend()) {
            return (sum + amountDTO.getWeekendDiscount()) * NEGATIVE_CORRECTION;
        }
        return (sum + amountDTO.getWeekdayDiscount()) * NEGATIVE_CORRECTION;
    }

    private int sumProcess() {
        return amountDTO.getChristmasDiscount()
                + amountDTO.getSpecialDiscount()
                + amountDTO.getGiftDiscount();
    }

    private int calculatePay() {
        int pay = payProcess();
        if (amountDTO.isWeekend()) {
            return pay - amountDTO.getWeekendDiscount();
        }
        return pay - amountDTO.getWeekdayDiscount();
    }

    private int payProcess() {
        return amountDTO.getAmount()
                - amountDTO.getChristmasDiscount()
                - amountDTO.getSpecialDiscount();
    }
}
