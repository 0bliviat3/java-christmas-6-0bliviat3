package christmas.service;

import christmas.domain.AmountDTO;
import christmas.domain.BillBuilder;
import christmas.domain.DiscountCalculator;

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





}
