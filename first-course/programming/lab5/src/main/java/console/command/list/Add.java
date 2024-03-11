package console.command.list;

import console.command.InformationManager;
import collection.CollectionManager;
import collection.data.StudyGroup;

public class Add extends Command {
    private final CollectionManager collectionManager;

    public Add(String name, String description, InformationManager informationManager) {
        super(name, description, informationManager);
        this.collectionManager = informationManager.getCollectionManager();
    }

    @Override
    public String execute() {
        StudyGroup studyGroup = collectionManager.callStudyGroupBuilder(); 
        collectionManager.addStudyGroupToCollection(studyGroup);
        return "Add executed";
    } 
}