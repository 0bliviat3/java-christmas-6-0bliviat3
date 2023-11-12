package christmas.domain.constants;

public enum CalculatorConstants {

    MIN_AMOUNT(10_000),
    MAIN(1),
    DESSERT(2),
    YEAR(2023),
    SPECIAL(1000),
    GIFT_MIN_AMOUNT(120_000),
    NO_DISCOUNT(0);

    private final int number;

    private CalculatorConstants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
