package christmas.view.constants;

public enum OutputConstants {

    PREVIEW("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    MENU("\n<주문 메뉴>"),
    BADGE("\n<12월 이벤트 배지>");

    private final String message;

    private OutputConstants(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
