package christmas;

import christmas.config.AppConfig;
import christmas.config.AppLauncher;

public class Application {
    public static void main(String[] args) {
        AppLauncher appLauncher = new AppLauncher(AppConfig.getInstance());
        appLauncher.run();
    }
}
