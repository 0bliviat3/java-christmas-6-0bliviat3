package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DayTest {

    @DisplayName("잘못된 날짜로 날짜 생성시 예외 발생")
    @ValueSource(ints = {0, 32})
    @ParameterizedTest
    void createDayByWrongNumber(int day) {
        assertThatThrownBy(() -> new Day(day))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("크리스마스 할인이 적용된다면 true 반환")
    @Test
    void createDayByChristmas() {
        assertThat(new Day(25).isChristmas())
                .isEqualTo(true);
    }

    @DisplayName("특별 할인이 적용된다면 true 반환")
    @Test
    void createDayByDiscountDay() {
        assertThat(new Day(3).isSpecialDay())
                .isEqualTo(true);
    }

    @DisplayName("주말 할인이 적용된다면 true 반환")
    @Test
    void createDayByWeekend() {
        assertThat(new Day(2).isWeekend())
                .isEqualTo(true);
    }

}
