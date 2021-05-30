package rpg;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class CharacterStatsScene extends Stage {

    private Stage gameStage;
    private Stage mainStage;
    public Stage menuStage;
    public AnchorPane charPane;


    public CharacterStatsScene() {
        charPane = new AnchorPane();
        Scene gameScene = new Scene(charPane, 500, 600);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
        gameStage.getScene();
        addExitButton();
        createBackground();
        addCharGif();
    }

    public void openCharacterStats(Stage eqStage) {

        this.menuStage = eqStage;
        this.gameStage.show();

    }

    public void addExitButton(){

        Buttons exit = new Buttons();
        exit.setGraphic(new ImageView("rpg/graph/items/eqExitButton.png"));

        String BACKGROUND = "rpg/graph/buttonBackGr.png";
        Image imageView = new Image(BACKGROUND, 80, 40, false, true);
        BackgroundImage backgroundImageButton = new BackgroundImage(imageView, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, null);
        exit.setBackground(new Background(backgroundImageButton));

        exit.setLayoutY(555);
        exit.setLayoutX(287);
        exit.setOnMouseClicked(event -> clickMusic());
        charPane.getChildren().add(exit);
        exit.setOnAction(event -> gameStage.close());

    }

    public void clickMusic(){

        MediaPlayer backgroundMusic;

        String musicPath = new File("C:\\Users\\norbe\\Desktop\\RPGtest\\src\\rpg\\music\\click.mp3").toURI().toString();
        backgroundMusic = new MediaPlayer(new Media(musicPath));
        backgroundMusic.play();

    }

    public void createBackground(){

        Image image = new Image("rpg/graph/items/charStats.png", 500, 600, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        charPane.setBackground(new Background(backgroundImage));

    }

    private void addCharGif() {
        ImageView charGif = new ImageView("rpg/graph/items/charGif.gif");
        charGif.setLayoutY(120);
        charGif.setLayoutX(215);
        charPane.getChildren().add(charGif);

    }


}
