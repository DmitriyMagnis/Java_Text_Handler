package App.controller;

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
    }
}
