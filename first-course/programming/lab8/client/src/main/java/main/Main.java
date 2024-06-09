package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ui.AuthApp;

public class Main {
    public static void main(String[] args) {
        Logger applicationLogger = LogManager.getLogger();
        applicationLogger.trace("Initializing client...");

        AuthApp.main(args);
    }
}
