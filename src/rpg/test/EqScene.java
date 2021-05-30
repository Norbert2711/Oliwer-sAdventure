package rpg.test;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import rpg.Buttons;

import java.io.File;

public class EqScene extends Stage {

    private Stage gameStage;
    private Stage mainStage;
    public Stage menuStage;
    public AnchorPane eqPane;


    public EqScene() {
         eqPane = new AnchorPane();
        Scene gameScene = new Scene(eqPane, 300, 500);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
        gameStage.getScene();
        addExitButton();
        createBackground();
    }

    public void openEq(Stage eqStage) {

        this.menuStage = eqStage;
        this.gameStage.show();

    }

    private void createBackground() {
        Image image = new Image("rpg/graph/items/eqBackground.png", 300, 500, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        eqPane.setBackground(new Background(backgroundImage));
    }


    public void addExitButton(){

        Buttons exit = new Buttons();
        exit.setGraphic(new ImageView("rpg/graph/items/eqExitButton.png"));

        String BACKGROUND = "rpg/graph/buttonBackGr.png";
        Image imageView = new Image(BACKGROUND, 80, 40, false, true);
        BackgroundImage backgroundImageButton = new BackgroundImage(imageView, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, null);
        exit.setBackground(new Background(backgroundImageButton));

        exit.setLayoutY(455);
        exit.setLayoutX(130);
        exit.setOnMouseClicked(event -> clickMusic());
        eqPane.getChildren().add(exit);
        exit.setOnAction(event -> gameStage.close());

    }

    public void clickMusic(){

        MediaPlayer backgroundMusic;

        String musicPath = new File("C:\\Users\\norbe\\Desktop\\RPGtest\\src\\rpg\\music\\click.mp3").toURI().toString();
        backgroundMusic = new MediaPlayer(new Media(musicPath));
        backgroundMusic.play();

    }

}
