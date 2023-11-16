package christmas.domain;

import static christmas.domain.constants.DayConstants.*;
import static christmas.exception.ExceptionConstants.DATE;

import christmas.exception.InputException;

public class Day {

    private final int day;

    public Day(final int day) {
        validateDay(day);
        this.day = day;
    }

    private void validateDay(final int day) {
        if (day > LAST.getNumber() || day < FIRST.getNumber()) {
            throw InputException.createException(DATE);
        }
    }

    public boolean isChristmas() {
        return day <= CHRISTMAS.getNumber();
    }

    public int getChristmasDiscount() {
        return THOUSAND.getNumber() + (day - FIRST.getNumber()) * HUNDRED.getNumber();
    }

    private int modDay() {
        return day % WEEK.getNumber();
    }

    public boolean isWeekend() {
        for (int i = FIRST.getNumber(); i < START_WEEKDAY.getNumber(); i++) {
            if (modDay() == i) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecialDay() {
        return modDay() == START_WEEKDAY.getNumber() || day == CHRISTMAS.getNumber();
    }

}
