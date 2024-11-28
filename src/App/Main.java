package App;

import App.controller.AppController;
import App.model.FileModel;
import App.view.AppView;

public class Main {
    public static void main(String[] args) {
        new AppController(new FileModel(), new AppView()).runApp();
    }
}
