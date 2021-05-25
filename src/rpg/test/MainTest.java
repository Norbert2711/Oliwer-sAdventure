package rpg.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import rpg.GameScenes;

public class Tested extends Application {

    private GameScenes helpScene;
    private GameScenes sceneToHide;
    private AnchorPane mainPane;
    MediaPlayer backgroundMusic;
    private AnchorPane testedPane;

    public Tested() {

        testedPane = new AnchorPane();
        Scene gameScene = new Scene(testedPane, 1152, 864);
        Stage gameStage = new Stage();
        gameStage.setScene(gameScene);
        gameStage.getScene();
        eqLabel();
        createBackground();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane mainPane = new AnchorPane();
        Scene gameMenuScene = new Scene(mainPane, 1152, 864);
        Stage mainStage = new Stage();
        mainStage.setScene(gameMenuScene);
        primaryStage.setTitle("R P G");
        eqLabel();
        createBackground();
        primaryStage.show();


    }

    private void eqLabel() {

        Button eq = new Button("EQ");
        eq.prefHeight(200);
        eq.prefWidth(200);
        testedPane.getChildren().add(eq);

    }

    private void createBackground() {
        Image image = new Image("rpg/graph/menu/menu.png", 1152, 864, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        testedPane.setBackground(new Background(backgroundImage));
    }

}
