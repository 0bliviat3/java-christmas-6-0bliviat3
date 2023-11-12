package christmas.domain.constants;

public enum DayConstants {

    FIRST(1),
    LAST(31),
    CHRISTMAS(25),
    THOUSAND(1000),
    HUNDRED(100),
    WEEK(7),
    START_WEEKDAY(3);

    private final int number;

    private DayConstants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
