package rpg;

import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class IntroScene extends Stage {

    private AnchorPane introPane;
    private Stage gameStage;
    private Stage mainStage;
    public Stage menuStage;

    public IntroScene() {

        introPane = new AnchorPane();
        //like mainPane
        Scene gameScene = new Scene(introPane, 1400, 900);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
        gameStage.getScene();
        video();
        addCursorLook();
        clickMusic();

    }

    public void createIntroAfterClickRozpocznij(Stage menuStage) {

        this.menuStage = menuStage;
        this.menuStage.hide();
        this.gameStage.show();

    }

    private void addCursorLook() {

        String CURSOR_EFFECT = "rpg/graph/cursor.png";
        Image cursor = new Image(CURSOR_EFFECT);
        introPane.setCursor(new ImageCursor(cursor));

    }

    public void video() {

        String videoPath = "C:\\Users\\norbe\\Desktop\\RPGtest\\src\\rpg\\video\\introV2.mp4";
        Media media = new Media(new File(videoPath).toURI().toString());
        MediaPlayer video = new MediaPlayer(media);
        MediaView videoView = new MediaView(video);
        videoView.setMediaPlayer(video);
        video.setAutoPlay(true);

        introPane.getChildren().add(videoView);

        Buttons skipButton = new Buttons();
        skipButton.setGraphic(new ImageView("rpg/graph/menu/skip.png"));
        skipButton.setLayoutY(830);
        skipButton.setLayoutX(1200);
        introPane.getChildren().add(skipButton);
        skipButton.setOnAction(actionEvent -> {

            video.stop();
            gameStage.hide();
            StartLocation startLocation = new StartLocation();
            startLocation.createAfterSkipIntro(startLocation);

        });

    }

    public void clickMusic(){

        MediaPlayer backgroundMusic;

        String musicPath = new File("C:\\Users\\norbe\\Desktop\\RPGtest\\src\\rpg\\music\\click.mp3").toURI().toString();
        backgroundMusic = new MediaPlayer(new Media(musicPath));
        backgroundMusic.play();

    }

}
