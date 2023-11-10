package christmas.domain;

import static christmas.domain.constants.FoodConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.EnumMap;
import java.util.Map;

import christmas.domain.constants.FoodConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class OrderMenuTest {

    @DisplayName("메뉴의 문자열 변환값 확인하기")
    @Test
    void createOrder() {
        Map<FoodConstants, Integer> order = new EnumMap<>(
                Map.of(TAPAS, 1, COKE, 1));

        assertThat(new OrderMenu(order).toString())
                .isEqualTo("타파스 1개\n제로콜라 1개\n");
    }

    @DisplayName("총 주문수가 20을 초과하면 예외가 발생한다.")
    @Test
    void createOrderByOverCount() {
        assertThatThrownBy(() -> new OrderMenu(Map.of(TAPAS, 21)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문에 따른 주문총액을 반환한다.")
    @Test
    void createOrderAmount() {
        assertThat(new OrderMenu(
                Map.of(STEAK, 1, RIB, 1, CAKE, 2, COKE, 1)).getAmount())
                .isEqualTo(142000);
    }

    @DisplayName("카테고리에 해당하는 주문의 개수를 반환한다.")
    @Test
    void createOrderCategoryCount() {
        assertThat(new OrderMenu(
                Map.of(STEAK, 1, RIB, 1, CAKE, 2, COKE, 1)).getCategoryCount(2))
                .isEqualTo(2);
    }
}
