package christmas.domain;

import static christmas.domain.constants.DiscountConstants.*;

import java.text.DecimalFormat;
import java.util.function.Supplier;

public class BillBuilder {

    // TODO: 상수처리 필요

    private static final String EMPTY = "";
    private static final String CHAMPAGNE = "샴페인 1개\n";
    private static final String DecimalREGEX = "###,###";
    private final DecimalFormat amountFormat;
    private final AmountDTO amountDTO;

    public BillBuilder(final AmountDTO amountDTO) {
        amountFormat = new DecimalFormat(DecimalREGEX);
        this.amountDTO = amountDTO;
    }

    public String makeBill() {
        StringBuilder bill = new StringBuilder();
        boolean flag = amountDTO.isMinAmount();
        bill.append(buildAmount(amountDTO.getAmount(), BEFORE_DISCOUNT.getMessage()))
                .append(GIFT_MENU.getMessage())
                .append(buildByFlag(this::buildGiftMenu, flag, NONE.getMessage()))
                .append(BENEFITS_DETAILS.getMessage())
                .append(buildByFlag(this::buildBenefits, flag, NONE.getMessage()))
                .append(buildAmount(calculateBenefitsAmount(), BENEFITS_AMOUNT.getMessage()))
                .append(buildBenefit(this::calculatePay, AFTER_DISCOUNT.getMessage()));
        return bill.toString();
    }

    private String buildAmount(int amount, String constant) {
        return String.format(constant, amountFormat.format(amount));
    }

    private String buildByFlag(
            Supplier<String> builder, boolean flag, String noneConstant) {
        if (flag) {
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
        if (calculateResult == 0) {
            return EMPTY;
        }
        return String.format(discountConstant, amountFormat.format(calculateResult));
    }

    private String buildWeekBenefit() {
        if (amountDTO.isWeekend()) {
            return buildBenefit(amountDTO::getWeekendDiscount, WEEKEND.getMessage());
        }
        return buildBenefit(amountDTO::getWeekdayDiscount, WEEKDAY.getMessage());
    }

    private int calculateBenefitsAmount() {
        int sum = amountDTO.getChristmasDiscount() +
                amountDTO.getSpecialDiscount() +
                amountDTO.getGiftDiscount();
        if(amountDTO.isWeekend()) {
            return (sum + amountDTO.getWeekendDiscount()) * -1;
        }
        return (sum + amountDTO.getWeekdayDiscount()) * -1;
    }

    private int calculatePay() {
        int pay = amountDTO.getAmount() -
                amountDTO.getChristmasDiscount() -
                amountDTO.getSpecialDiscount();
        if(amountDTO.isWeekend()) {
            return pay - amountDTO.getWeekendDiscount();
        }
        return pay - amountDTO.getWeekdayDiscount();
    }
}
