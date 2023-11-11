package christmas.exception;

import static christmas.exception.ExceptionConstants.*;

import java.util.EnumMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import christmas.domain.constants.FoodConstants;

public class InputException {

    private static final String NUMBER_REGEX = "[0-9]+";
    private static final Pattern regex = Pattern.compile(NUMBER_REGEX);

    private InputException() {
    }

    public static int validateNumber(String number, ExceptionConstants exceptionConstants) {
        if (regex.matcher(number).matches()) {
            return Integer.parseInt(number);
        }
        throw createException(exceptionConstants);
    }

    public static Map<FoodConstants, Integer> validateOrder(String order) {
        Map<FoodConstants, Integer> orderMenu = new EnumMap<>(FoodConstants.class);
        StringTokenizer orderToken = new StringTokenizer(order, "-,");
        validateOrder(orderToken.countTokens());
        while (orderToken.hasMoreTokens()) {
            FoodConstants food = FoodConstants.from(orderToken.nextToken());
            int count = validateOrderCount(orderToken.nextToken());
            if (orderMenu.containsKey(food)) {
                throw createException(ORDER);
            }
            orderMenu.put(food, count);
        }
        return orderMenu;
    }

    private static int validateOrderCount(String orderCount) {
        int count = validateNumber(orderCount, ORDER);
        if (count < 1) {
            throw createException(ORDER);
        }
        return count;
    }

    private static void validateOrder(int count) {
        if (count % 2 == 1) {
            throw createException(ORDER);
        }
    }

    public static IllegalArgumentException createException(ExceptionConstants exceptionConstants) {
        return new IllegalArgumentException(exceptionConstants.getMessage());
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
