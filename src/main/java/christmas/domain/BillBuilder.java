package christmas.domain;

import static christmas.domain.constants.DiscountConstants.*;

import java.text.DecimalFormat;

public class BillBuilder {

    private static final String EMPTY = "";
    private static final String CHAMPAGNE = "샴페인 1개\n";
    private static final String DecimalREGEX = "###,###";
    private final DecimalFormat amountFormat;
    private final AmountDTO amountDTO;

    public BillBuilder(final AmountDTO amountDTO) {
        amountFormat = new DecimalFormat(DecimalREGEX);
        this.amountDTO = amountDTO;
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
