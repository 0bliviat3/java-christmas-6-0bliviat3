package christmas.view;

import static christmas.exception.InputException.printErrorMessage;
import static christmas.view.constants.InputConstants.*;

import java.util.function.Consumer;

import camp.nextstep.edu.missionutils.Console;
import christmas.controller.EventController;
import christmas.view.constants.InputConstants;

public class InputView {

    private final EventController eventController;

    public InputView(final EventController eventController) {
        this.eventController = eventController;
    }

    public void read() {
        validateRead(HELLO, eventController::dayAdd);
        validateRead(TAKE_ORDER, eventController::orderAdd);
    }

    private void validateRead(InputConstants inputConstant, Consumer<String> adder) {
        boolean hold = true;
        while (hold) {
            try {
                adder.accept(inputEvent(inputConstant));
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
