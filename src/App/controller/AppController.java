package App.controller;

import App.misc.Constants;
import App.model.FileModel;
import App.view.AppView;

public class AppController {
    private final AppView view;
    private final FileModel model;

    public AppController(FileModel model, AppView view) {
        this.view = view;
        this.model = model;
    }

    public void runApp() {
        String fileName = view.getFileName();
        String fileContent = view.getFileContent();
        view.closeScanner();

        String filePath = Constants.BASE_PATH + fileName + ".txt";

        view.writeOutput(model.createDir(Constants.BASE_PATH));
        view.writeOutput(model.createFile(filePath));
        view.writeOutput(model.writeToFile(fileContent, filePath));
        view.writeOutput("CONTENT: " +model.readFromFile(filePath));

    }
}
