package christmas.view;

import christmas.controller.EventController;

public class InputView {

    private final EventController eventController;

    public InputView(final EventController eventController) {
        this.eventController = eventController;
    }

    private void validateInput(boolean flag, Runnable runnable) {
        while(flag) {
            try {
                runnable.run();
                flag = false;
            } catch(IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private void inputEvent(String inputConstant) {
        System.out.println(inputConstant);

    }

}
