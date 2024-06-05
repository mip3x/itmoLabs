import io.console.ConsoleHandler;
import io.console.ConsoleService;
import io.console.InformationStorage;
import io.database.DataBaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tcp.Server;
import validation.CommandValidator;

import java.io.FileReader;
import java.util.Properties;

public class Main {
    private static final String CONFIG_FILE_NAME = "server/src/main/resources/config.properties";
    public static void main(String[] args) {
        Logger applicationLogger = LogManager.getLogger();
        applicationLogger.trace("Initializing server");

        Properties dbConnectionArguments = new Properties();

        try (FileReader fileReader = new FileReader(CONFIG_FILE_NAME)) {
            dbConnectionArguments.load(fileReader);

            String dbUrl = dbConnectionArguments.getProperty("DB.URL");
            String dbUser = dbConnectionArguments.getProperty("DB.USER");
            String dbPassword = dbConnectionArguments.getProperty("DB.PASSWORD");

            if (!DataBaseService.establishConnection(dbUrl, dbUser, dbPassword))
                return;

            DataBaseService.loadCollection();
            applicationLogger.info("Collection was loaded");

            InformationStorage.getInstance();
            CommandValidator.getInstance();
        }
        catch (Exception exception) {
            applicationLogger.error(exception.getMessage());
            return;
        }

        applicationLogger.trace("ConsoleManager object created!");

        Server server = new Server(1337);
        Thread serverThread = new Thread(server, "SERVER");
        server.init();
        serverThread.start();

        ConsoleService serverConsole = new ConsoleService(new ConsoleHandler());
        Thread serverConsoleThread = new Thread(serverConsole, "CONSOLE");
        serverConsoleThread.start();
    }
}