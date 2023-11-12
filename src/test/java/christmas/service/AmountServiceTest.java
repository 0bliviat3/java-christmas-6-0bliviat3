package christmas.service;

import static christmas.domain.constants.FoodConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import christmas.domain.AmountDTO;
import christmas.domain.BillBuilder;
import christmas.domain.Day;
import christmas.domain.DiscountCalculator;
import christmas.domain.OrderMenu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AmountServiceTest {

    private final AmountDTO amountDTO = new AmountDTO();
    private DiscountCalculator discountCalculator;
    private AmountService amountService;

    void init() {

    }

    @DisplayName("예제 데이터2로 입력받았을때 동일한 결과를 반환")
    @Test
    void findBillWhenThird() {
        discountCalculator = new DiscountCalculator();
        amountService = new AmountService(
                amountDTO, discountCalculator, new BillBuilder(amountDTO));
        discountCalculator.setDay(new Day(3));
        discountCalculator.setOrderMenu(
                new OrderMenu(Map.of(STEAK, 1, RIB, 1, CAKE, 2, COKE, 1)));

        assertThat(amountService.findBill()).contains(
                "<할인 전 총주문 금액>",
                "142,000원",
                "<증정 메뉴>",
                "샴페인 1개",
                "<혜택 내역>",
                "크리스마스 디데이 할인: -1,200원",
                "평일 할인: -4,046원",
                "특별 할인: -1,000원",
                "증정 이벤트: -25,000원",
                "<총혜택 금액>",
                "-31,246원",
                "<할인 후 예상 결제 금액>",
                "135,754원"
        );
    }

    @DisplayName("예제 데이터1로 입력받았을때 동일한 결과를 반환")
    @Test
    void findBillWhen26Days() {
        discountCalculator = new DiscountCalculator();
        amountService = new AmountService(
                amountDTO, discountCalculator, new BillBuilder(amountDTO));
        discountCalculator.setDay(new Day(26));
        discountCalculator.setOrderMenu(new OrderMenu(Map.of(TAPAS, 1, COKE, 1)));

        assertThat(amountService.findBill()).contains(
                "<할인 전 총주문 금액>",
                "8,500원",
                "<증정 메뉴>",
                "없음",
                "<혜택 내역>",
                "없음",
                "<총혜택 금액>",
                "0원",
                "<할인 후 예상 결제 금액>",
                "8,500원"
        );
    }

    @DisplayName("크리스마스에 디저트만 입력받았을때 결과를 반환")
    @Test
    void findBillWhen25Days() {
        discountCalculator = new DiscountCalculator();
        amountService = new AmountService(
                amountDTO, discountCalculator, new BillBuilder(amountDTO));
        discountCalculator.setDay(new Day(25));
        discountCalculator.setOrderMenu(new OrderMenu(Map.of(CAKE, 10, ICE_CREAM, 10)));

        assertThat(amountService.findBill()).contains(
                "<할인 전 총주문 금액>",
                "200,000원",
                "<증정 메뉴>",
                "샴페인 1개",
                "<혜택 내역>",
                "크리스마스 디데이 할인: -3,400원",
                "평일 할인: -40,460원",
                "특별 할인: -1,000원",
                "증정 이벤트: -25,000원",
                "<총혜택 금액>",
                "-69,860원",
                "<할인 후 예상 결제 금액>",
                "155,140원"
        );
    }

    @DisplayName("30일에 메인메뉴만 입력받았을때 결과를 반환")
    @Test
    void findBillWhen30Days() {
        discountCalculator = new DiscountCalculator();
        amountService = new AmountService(
                amountDTO, discountCalculator, new BillBuilder(amountDTO));
        discountCalculator.setDay(new Day(30));
        discountCalculator.setOrderMenu(new OrderMenu(Map.of(STEAK, 20)));

        assertThat(amountService.findBill()).contains(
                "<할인 전 총주문 금액>",
                "1,100,000원",
                "<증정 메뉴>",
                "샴페인 1개",
                "<혜택 내역>",
                "주말 할인: -40,460원",
                "증정 이벤트: -25,000원",
                "<총혜택 금액>",
                "-65,460원",
                "<할인 후 예상 결제 금액>",
                "1,059,540원"
        );
    }

}
