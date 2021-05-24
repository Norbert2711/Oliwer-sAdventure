package rpg;

import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.File;

public class View {

    private Stage mainStage;
    private AnchorPane mainPane;
    private GameScenes helpScene;
    private GameScenes sceneToHide;
    MediaPlayer backgroundMusic;

    public View() {

        mainPane = new AnchorPane();
        Scene gameMenuScene = new Scene(mainPane, 1152, 864);
        mainStage = new Stage();
        mainStage.setScene(gameMenuScene);
        createBackground();
        createLogo();
        addCursorLook();
        addExitButton();
        addHelpButton();
        addStartButton();
        createSubscens();
        music();

    }

    public void music(){
        String musicPath = new File("C:\\Users\\norbe\\Desktop\\RPGtest\\src\\rpg\\music\\music.mp3").toURI().toString();
        backgroundMusic = new MediaPlayer(new Media(musicPath));
        backgroundMusic.play();
    }

    private void createBackground() {
        Image image = new Image("rpg/graph/menu/menu.png", 1152, 864, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(backgroundImage));
    }

    private void createLogo() {
        ImageView logo = new ImageView("rpg/graph/menu/logo.png");
        Rotate rotate = new Rotate();
        rotate.setAngle(-23);
        logo.setLayoutY(320);
        logo.setLayoutX(425);
        logo.getTransforms().add(rotate);
        logo.setOnMouseEntered(mouseEvent -> logo.setEffect(new DropShadow()));
        logo.setOnMouseExited(mouseEvent -> logo.setEffect(null));
        mainPane.getChildren().add(logo);
    }

    private void addCursorLook() {
        String CURSOR_EFFECT = "rpg/graph/cursor.png";
        Image cursor = new Image(CURSOR_EFFECT);
        mainPane.setCursor(new ImageCursor(cursor));

    }

    private void addExitButton() {

        Buttons exitButton = new Buttons();
        exitButton.setGraphic(new ImageView("rpg/graph/menu/exitButton.png"));
        Rotate rotate1 = new Rotate();
        rotate1.setAngle(-23);
        exitButton.getTransforms().add(rotate1);
        exitButton.setLayoutX(495);
        exitButton.setLayoutY(580);
        mainPane.getChildren().add(exitButton);
        exitButton.setOnAction(actionEvent -> mainStage.close());
    }

    private void addHelpButton() {
        Buttons helpButton = new Buttons();
        helpButton.setGraphic(new ImageView("rpg/graph/menu/helpButton.png"));
        Rotate rotate = new Rotate();
        rotate.setAngle(-23);
        helpButton.getTransforms().add(rotate);
        helpButton.setLayoutX(455);
        helpButton.setLayoutY(500);
        mainPane.getChildren().add(helpButton);
        helpButton.setOnAction(actionEvent -> showSubscene(helpScene));

    }

    private void addStartButton() {
        Buttons startButton = new Buttons();
        startButton.setGraphic(new ImageView("rpg/graph/menu/startButton.png"));
        Rotate rotate = new Rotate();
        rotate.setAngle(-23);
        startButton.getTransforms().add(rotate);
        startButton.setLayoutX(430);
        startButton.setLayoutY(430);
        mainPane.getChildren().add(startButton);

        startButton.setOnAction(actionEvent ->{
                IntroScene intro = new IntroScene();
                intro.createIntroAfterClickRozpocznij(intro);
                mainStage.hide();
                backgroundMusic.stop();
        });
    }

    private void showSubscene(GameScenes scene) {

        if (sceneToHide != null) {
            sceneToHide.moveSubscene();
        }

        scene.moveSubscene();
        sceneToHide = scene;
    }

    private void createSubscens() {

        helpScene = new GameScenes();
        mainPane.getChildren().add(helpScene);
        createHelpScene();

    }

    private void createHelpScene() {

        helpScene = new GameScenes();
        mainPane.getChildren().add(helpScene);
        Text helpText = new Text(
                "Witaj podróżniku!"+"\n"+
                "Przeżyj niesamowitą przygode wraz z Oliwerem." + "\n"+
                "Walcz z potworami, zdobwaj doświadczenie, "+"\n"+
                 "odkrywaj nowe lokacje." + "\n"+
                "Do gry używaj LEWEGO przycisku myszy."+"\n"+
                "Powodzenia!");

        helpScene.getPane().getChildren().add(helpText);
        helpText.setFont(Font.font("Comic Sans MS", 45));
        helpText.setFill(Color.BURLYWOOD);
        helpText.setLayoutX(50);
        helpText.setLayoutY(150);

        Buttons back = new Buttons();
        back.setGraphic(new ImageView("rpg/graph/menu/back.png"));
        back.setLayoutX(430);
        back.setLayoutY(530);
        helpScene.getPane().getChildren().add(back);
        back.setOnAction(event -> helpScene.getPane().relocate(2000,2000));

    }

    public Stage getMainStage() {
        return mainStage;
    }

    public AnchorPane getMainPane() {
        return mainPane;
    }

}


