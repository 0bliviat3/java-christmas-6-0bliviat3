package christmas.domain;

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

}
