package io.console.command.list;

import collection.CollectionManager;
import io.console.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Returns info about collection
 */
public class Info extends Command {
    private static final Logger infoCommandLogger = LogManager.getLogger();
    private final CollectionManager collectionManager = CollectionManager.getInstance();
    public Info() {
        super("info", "Print out info about collection");
    }

    @Override
    public String execute() {
        infoCommandLogger.trace("Info command executed");
        return collectionManager.getCollectionInfo();
    }
}
