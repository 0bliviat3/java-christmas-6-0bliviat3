package christmas.domain.constants;

public enum DiscountConstants {

    BEFORE_DISCOUNT("\n<할인 전 총주문 금액>\n%s원\n"),
    GIFT_MENU("\n<증정 메뉴>\n"),
    BENEFITS_DETAILS("\n<혜택 내역>\n"),
    CHRISTMAS("크리스마스 디데이 할인: %s원\n"),
    WEEKDAY("평일 할인: %s원\n"),
    WEEKEND("주말 할인: %s원\n"),
    SPECIAL("특별 할인: %s원\n"),
    GIFT("증정 이벤트: %s원\n"),
    BENEFITS_AMOUNT("\n<총혜택 금액>\n%s원\n"),
    AFTER_DISCOUNT("\n<할인 후 예상 결제 금액>\n%s원\n"),
    NONE("없음\n");

    private final String message;

    private DiscountConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
