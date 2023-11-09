package christmas.constants;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.constants.FoodConstants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FoodConstantsTest {

    @DisplayName("존재하지 않는 음식명을 찾는경우 예외발생")
    @Test
    void giveWrongFood() {
        assertThatThrownBy(() -> FoodConstants.from("떡볶이"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("존재하는 음식명을 찾는다면 enum 객체 리턴")
    @ValueSource(strings = {"샴페인", "아이스크림", "티본스테이크", "타파스"})
    @ParameterizedTest
    void giveTrueFood(String food) {
        assertThat(FoodConstants.from(food))
                .isInstanceOf(FoodConstants.class);
    }

}
