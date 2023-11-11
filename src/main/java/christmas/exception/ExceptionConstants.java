package christmas.exception;

public enum ExceptionConstants {

    DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MAX("[ERROR] 메뉴는 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요."),
    BEVERAGE("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력해주세요.");
    private final String message;

    private ExceptionConstants(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
