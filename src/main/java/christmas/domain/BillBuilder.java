package christmas.domain;

import static christmas.domain.constants.DiscountConstants.*;

import java.text.DecimalFormat;

public class BillBuilder {

    private static final String EMPTY = "";
    private static final String DecimalREGEX = "-###,###";
    private final DecimalFormat amountFormat;
    private final DiscountCalculator discountCalculator;

    public BillBuilder(DiscountCalculator discountCalculator) {
        amountFormat = new DecimalFormat(DecimalREGEX);
        this.discountCalculator = discountCalculator;
    }

}
