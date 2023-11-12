package christmas.exception;

import static christmas.exception.ExceptionConstants.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import christmas.domain.constants.FoodConstants;

public class InputException {

    private static final String NUMBER_REGEX = "[0-9]+";
    private static final String COMAS = ",";
    private static final String BAR = "-";
    private static final int FOOD_INDEX = 0;
    private static final int COUNT = 1;
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
        List<String> orderList = List.of(order.split(COMAS));
        for (String orderPiece : orderList) {
            List<String> orderOne = validateOrderDivision(orderPiece);
            FoodConstants food = FoodConstants.from(orderOne.get(FOOD_INDEX));
            int count = validateOrderCount(orderOne.get(COUNT));
            if (orderMenu.containsKey(food)) {
                throw createException(ORDER);
            }
            orderMenu.put(food, count);
        }
        return orderMenu;
    }

    private static List<String> validateOrderDivision(String orderPiece) {
        List<String> order = List.of(orderPiece.split(BAR));
        if(order.size() != PAIR) {
            throw createException(ORDER);
        }
        return order;
    }

    private static int validateOrderCount(String orderCount) {
        int count = validateNumber(orderCount, ORDER);
        if (count < COUNT) {
            throw createException(ORDER);
        }
        return count;
    }

    public static IllegalArgumentException createException(ExceptionConstants exceptionConstants) {
        return new IllegalArgumentException(exceptionConstants.getMessage());
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
