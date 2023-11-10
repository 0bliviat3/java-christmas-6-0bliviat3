package christmas.domain;

public class Day {

    private final int day;

    // TODO: 상수처리 할것

    public Day(final int day) {
        validateDay(day);
        this.day = day;
    }

    private void validateDay(final int day) {
        if(day > 31 || day < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public boolean isChristmas() {
        return day <= 25;
    }

    private int modDay() {
        return day % 7;
    }

    public boolean isWeekend() {
        for(int i = 1; i < 3; i++) {
            if(modDay() == i) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialDay() {
        return modDay() == 3 || day == 25;
    }

}
