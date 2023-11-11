package christmas.view;

public class OutputView {

    private static final String PREVIEW = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String MENU = "\n<주문 메뉴>";
    private static final String BADGE = "\n<12월 이벤트 배지>";

    public void printPreview() {
        System.out.println(PREVIEW);
    }

    public void printMenu() {
        System.out.println(MENU);
    }

    public void printBadge() {
        System.out.println(BADGE);
    }

    public void printModel(String model) {
        System.out.println(model);
    }
}
