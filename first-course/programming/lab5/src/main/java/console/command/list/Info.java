package console.command.list;

import console.command.InformationManager;
import collection.CollectionManager;

public class Info extends Command {
    private final CollectionManager collectionManager;

    public Info(String name, String description, InformationManager informationManager) {
        super(name, description, informationManager);
        this.collectionManager = informationManager.getCollectionManager();
    }

    @Override
    public String execute() {
        return collectionManager.getCollectionInfo();
    } 
}
