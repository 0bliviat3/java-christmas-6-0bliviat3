package christmas.domain.constants;

import static christmas.exception.ExceptionConstants.ORDER;

import christmas.exception.InputException;

public enum FoodConstants {

    SOUP("양송이수프", 0, 6000),
    TAPAS("타파스", 0, 5500),
    SALAD("시저샐러드", 0, 8000),
    STEAK("티본스테이크", 1, 55000),
    RIB("바비큐립", 1, 54000),
    SEAFOOD_PASTA("해산물파스타", 1, 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 1, 25000),
    CAKE("초코케이크", 2, 15000),
    ICE_CREAM("아이스크림", 2, 5000),
    COKE("제로콜라", 3, 3000),
    WINE("레드와인", 3, 60000),
    CHAMPAGNE("샴페인", 3, 25000);

    private final String food;
    private final int category;
    private final int amount;

    private FoodConstants(final String food, final int category, final int amount) {
        this.food = food;
        this.category = category;
        this.amount = amount;
    }

    public String getFood() {
        return food;
    }

    public int getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }

    private boolean contains(String food) {
        return this.food.equals(food);
    }

    public static FoodConstants from(String food) {
        for (FoodConstants foodConstants : FoodConstants.values()) {
            if (foodConstants.contains(food)) {
                return foodConstants;
            }
        }
        throw InputException.createException(ORDER);
    }
}
