package christmas.domain;

import static christmas.exception.ExceptionConstants.BEVERAGE;
import static christmas.exception.ExceptionConstants.MAX;

import java.util.Map;

import christmas.domain.constants.FoodConstants;
import christmas.exception.InputException;

public class OrderMenu {

    private static final String MENU_FORMAT = "%s %d개\n";
    private static final int DEFAULT = 0;
    private static final int MAX_ORDER = 20;
    private static final int BEVERAGE_NUMBER = 3;
    private final Map<FoodConstants, Integer> order;

    public OrderMenu(final Map<FoodConstants, Integer> order) {
        validateOrderCount(order);
        validateBeverage(order);
        this.order = order;
    }

    private void validateOrderCount(final Map<FoodConstants, Integer> order) {
        int sum = DEFAULT;
        for (int count : order.values()) {
            sum += count;
            if (sum > MAX_ORDER) {
                throw InputException.createException(MAX);
            }
        }
    }

    private void validateBeverage(final Map<FoodConstants, Integer> order) {
        for (FoodConstants foodConstants : order.keySet()) {
            if (foodConstants.getCategory() != BEVERAGE_NUMBER) {
                return;
            }
        }
        throw InputException.createException(BEVERAGE);
    }

    public int getAmount() {
        int sum = DEFAULT;
        for (FoodConstants foodConstants : order.keySet()) {
            sum += foodConstants.getAmount() * order.get(foodConstants);
        }
        return sum;
    }

    public int getCategoryCount(int category) {
        int count = DEFAULT;
        for (FoodConstants foodConstants : order.keySet()) {
            if (foodConstants.getCategory() == category) {
                count += order.get(foodConstants);
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder orderBuilder = new StringBuilder();
        order.forEach((foodConstants, count) -> {
            orderBuilder.append(String.format(MENU_FORMAT, foodConstants.getFood(), count));
        });
        return orderBuilder.toString();
    }
}
