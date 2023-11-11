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

    public static IllegalArgumentException createException(ExceptionConstants exceptionConstants) {
        return new IllegalArgumentException(exceptionConstants.getMessage());
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
