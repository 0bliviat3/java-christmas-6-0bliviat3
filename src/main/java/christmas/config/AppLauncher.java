package christmas.config;

import camp.nextstep.edu.missionutils.Console;

public class AppLauncher {

    private final AppConfig appConfig;

    public AppLauncher(final AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public void run() {
        appConfig.inputView().read();
        appConfig.eventController().preViewList();
        Console.close();
    }

}
