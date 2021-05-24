package rpg.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import rpg.Buttons;
import rpg.GameScenes;
import rpg.View;

public class Tested extends Application {
    private GameScenes helpScene;
    private GameScenes sceneToHide;

    public Tested() {

eqLabel();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane mainPane = new AnchorPane();
        Scene gameMenuScene = new Scene(mainPane, 1152, 864);
        Stage mainStage = new Stage();
        mainStage.setScene(gameMenuScene);
        primaryStage.setTitle("R P G");
        primaryStage.show();

    }

    private void eqLabel(){

        Button eq = new Button("EQ");
        eq.prefHeight(200);
        eq.prefWidth(200);

    }


}
