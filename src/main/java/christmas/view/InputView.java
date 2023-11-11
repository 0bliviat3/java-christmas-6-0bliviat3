package christmas.view;

import christmas.controller.EventController;

public class InputView {

    private final EventController eventController;

    public InputView(final EventController eventController) {
        this.eventController = eventController;
    }

    private void validateInput(boolean flag, Runnable runnable) {
        while(flag) {

    private void validateRead(InputConstants inputConstant, Consumer<String> consumer) {
        boolean hold = true;
        while (hold) {
            try {
                consumer.accept(inputEvent(inputConstant));
                hold = false;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    private void inputEvent(String inputConstant) {
        System.out.println(inputConstant);

    }

}
