package christmas.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputExceptionTest {

    @DisplayName("숫자가 아닌 다른 문자를 입력시 예외 발생")
    @Test
    void inputNotaNumber() {
        assertThatThrownBy(() -> InputException.validateNumber("a", ExceptionConstants.ORDER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문제있는 메뉴를 입력하면 예외가 발생한다.")
    @ValueSource(
            strings = {"타파스-1,타파스-2",
            "딤섬-20",
            "제로콜라-0",
            "초코케이크--1",
            "제로콜라,3",
            "타파스,,1",
            "초코케이크,-1"})
    @ParameterizedTest
    void inputOrderByProblematic(String order) {
        assertThatThrownBy(() -> InputException.validateOrder(order))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
