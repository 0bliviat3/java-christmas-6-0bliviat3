package christmas.view;

import static christmas.view.constants.OutputConstants.*;

public class OutputView {

    public void printPreview() {
        System.out.println(PREVIEW.getMessage());
    }

    public void printMenu() {
        System.out.println(MENU.getMessage());
    }

    public void printBadge() {
        System.out.println(BADGE.getMessage());
    }

    public void printModel(String model) {
        System.out.println(model);
    }
}
