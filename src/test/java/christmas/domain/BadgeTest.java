package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BadgeTest {

    @DisplayName("파라미터에 따른 베지를 반환한다.")
    @CsvSource(value = {"20000:산타", "10000:트리", "5000:별", "1000:없음"}, delimiter = ':')
    @ParameterizedTest
    void createBadge(int benefitAmount, String badgeConst) {
        assertThat(new Badge(benefitAmount).getBadge())
                .contains(badgeConst);
    }

}