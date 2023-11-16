package christmas.domain.constants;

public enum DiscountConstants {

    BEFORE_DISCOUNT("<할인 전 총주문 금액>\n%s원" + System.lineSeparator()),
    GIFT_MENU("\n<증정 메뉴>" + System.lineSeparator()),
    BENEFITS_DETAILS("\n<혜택 내역>" + System.lineSeparator()),
    CHRISTMAS("크리스마스 디데이 할인: -%s원" + System.lineSeparator()),
    WEEKDAY("평일 할인: -%s원" + System.lineSeparator()),
    WEEKEND("주말 할인: -%s원" + System.lineSeparator()),
    SPECIAL("특별 할인: -%s원" + System.lineSeparator()),
    GIFT("증정 이벤트: -%s원" + System.lineSeparator()),
    BENEFITS_AMOUNT("\n<총혜택 금액>\n%s원" + System.lineSeparator()),
    AFTER_DISCOUNT("\n<할인 후 예상 결제 금액>\n%s원" + System.lineSeparator()),
    NONE("없음" + System.lineSeparator());

    private final String message;

    private DiscountConstants(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
