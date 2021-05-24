package rpg;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class StartLocationButtons extends Buttons {

    public StartLocationButtons() {

        setPrefHeight(100);
        setPrefWidth(80);
        someMouseEventsOnButtons();
       // backgroundButtonsImage();

    }

    private void someMouseEventsOnButtons() {
        setOnMouseEntered(mouseEvent -> setEffect(new DropShadow()));
        setOnMouseExited(mouseEvent -> setEffect(null));
        setOnMouseClicked(mouseEvent -> setEffect(new SepiaTone()));
        setOnMouseClicked(mouseEvent -> clickMusic());

    }

    public void clickMusic() {

        MediaPlayer backgroundMusic;

        String musicPath = new File("C:\\Users\\norbe\\Desktop\\RPGtest\\src\\rpg\\music\\click.mp3").toURI().toString();
        backgroundMusic = new MediaPlayer(new Media(musicPath));
        backgroundMusic.play();

    }

    private void backgroundButtonsImage() {
        String BACKGROUND = "rpg/graph/buttonBackGr.png";
        Image imageView = new Image(BACKGROUND, 200, 40, false, true);
        BackgroundImage backgroundImageButton = new BackgroundImage(imageView, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, null);
        setBackground(new Background(backgroundImageButton));
    }


}
