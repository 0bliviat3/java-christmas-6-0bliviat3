package christmas.domain;

import static christmas.exception.ExceptionConstants.BEVERAGE;
import static christmas.exception.ExceptionConstants.MAX;

import java.util.Map;

import christmas.domain.constants.FoodConstants;
import christmas.exception.InputException;

public class OrderMenu {

    private static final String MENU_FORMAT = "%s %d개\n";
    private final Map<FoodConstants, Integer> order;

    public OrderMenu(final Map<FoodConstants, Integer> order) {
        validateOrderCount(order);
        validateBeverage(order);
        this.order = order;
    }

    private void validateOrderCount(final Map<FoodConstants, Integer> order) { // TODO: 상수처리 및 예외 별도관리 고민
        int sum = 0;
        for (int count : order.values()) {
            sum += count;
            if (sum > 20) {
                throw InputException.createException(MAX);
            }
        }
    }

    private void validateBeverage(final Map<FoodConstants, Integer> order) {
        for (FoodConstants foodConstants : order.keySet()) {
            if (foodConstants.getCategory() != 3) {
                return;
            }
        }
        throw InputException.createException(BEVERAGE);
    }

    public int getAmount() {
        int sum = 0;
        for (FoodConstants foodConstants : order.keySet()) {
            sum += foodConstants.getAmount() * order.get(foodConstants);
        }
        return sum;
    }

    public int getCategoryCount(int category) {
        int count = 0;
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
