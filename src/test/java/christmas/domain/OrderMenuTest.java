package christmas.domain;

import static christmas.domain.constants.FoodConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;

import christmas.domain.constants.FoodConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderMenuTest {

    @DisplayName("메뉴의 문자열 변환값 확인하기")
    @Test
    void createOrder() {
        Map<FoodConstants, Integer> order = new EnumMap<>(Map.of(TAPAS, 1, COKE, 1));
        assertThat(new OrderMenu(order).toString())
                .isEqualTo("타파스 1개\n제로콜라 1개\n");
    }

}
