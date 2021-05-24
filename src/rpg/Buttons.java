package rpg;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

import java.io.File;

public class Buttons extends Button {

    public Buttons() {
        setPrefHeight(40);
        setPrefWidth(200);
        someMouseEventsOnButtons();
        backgroundButtonsImage();
    }

    private void addFont() {
        String FONT_PATH = "rpg/font/NorthwoodHigh.ttf";
        setFont(Font.loadFont(String.valueOf(getClass().getResource(FONT_PATH)), 20));
    }

    private void someMouseEventsOnButtons() {
        setOnMouseEntered(mouseEvent -> setEffect(new DropShadow()));
        setOnMouseExited(mouseEvent -> setEffect(null));
        setOnMouseClicked(mouseEvent -> setEffect(new SepiaTone()));
        setOnMouseClicked(mouseEvent -> clickMusic());

    }

    public void clickMusic(){

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

