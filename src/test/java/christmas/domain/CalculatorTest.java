package christmas.domain;

import static christmas.domain.constants.FoodConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final DiscountCalculator discountCalculator = new DiscountCalculator();

    @BeforeEach
    void init() {
        discountCalculator.setDay(new Day(3));
        discountCalculator.setOrderMenu(
                new OrderMenu(Map.of(STEAK, 1, RIB, 1, CAKE, 2, COKE, 1)));
    }

    @DisplayName("크리스마스 디데이 할인 금액을 반환한다.")
    @Test
    void calculateChristmas() {
        assertThat(discountCalculator.calculateChristmas()).isEqualTo(1200);
    }

    @DisplayName("평일 할인 금액을 반환한다.")
    @Test
    void calculateWeekDay() {
        assertThat(discountCalculator.calculateWeekday()).isEqualTo(4046);
    }

    @DisplayName("주말 할인 금액을 반환한다.")
    @Test
    void calculateWeekend() {
        assertThat(discountCalculator.calculateWeekend()).isEqualTo(4046);
    }
}
