package christmas.exception;

import static christmas.exception.ExceptionConstants.*;

import java.util.EnumMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import christmas.domain.constants.FoodConstants;

public class InputException {

    // TODO: 상수 처리 할것

    private static final String NUMBER_REGEX = "[0-9]+";
    private static final String SPLIT_DELIMITER = "-,";
    private static final int SINGLE = 1;
    private static final int PAIR = 2;
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
        StringTokenizer orderToken = new StringTokenizer(order, SPLIT_DELIMITER);
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
        if (count < SINGLE) {
            throw createException(ORDER);
        }
        return count;
    }

    private static void validateOrder(int count) {
        if (count % PAIR == SINGLE) {
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
