package command.list;

import collection.CollectionService;
import collection.data.StudyGroup;
import command.Command;
import command.InformationStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Adds element to collection
 */
public class Add extends Command implements RequestingInput {
    private static final Logger addCommandLogger = LogManager.getLogger();
    public Add() {
        super("add {element}", "Add new element to collection");
    }

    @Override
    public String execute(CollectionService collectionService, String username) {
        StudyGroup studyGroup = InformationStorage.getReceivedStudyGroup();
        addCommandLogger.trace("StudyGroup received...");
        if (studyGroup != null) return collectionService.addStudyGroup(studyGroup);
        throw new NullPointerException("studyGroup is null!");
    }
}