package christmas.view;

import static christmas.exception.InputException.printErrorMessage;
import static christmas.view.InputConstants.*;

import java.util.function.Consumer;

import camp.nextstep.edu.missionutils.Console;
import christmas.controller.EventController;

public class InputView {

    private final EventController eventController;

    public InputView(final EventController eventController) {
        this.eventController = eventController;
    }

    public void read() {
        validateRead(HELLO, eventController::dayAdd);
        validateRead(TAKE_ORDER, eventController::orderAdd);
    }

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

    private String inputEvent(InputConstants inputConstant) {
        System.out.println(inputConstant.getMessage());
        return Console.readLine();
    }

}
