package rpg;

import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import rpg.test.EqScene;

import java.io.File;

public class FieldsLocation extends Stage {

    private AnchorPane fieldsPane;
    private Stage gameStage;
    private Stage mainStage;
    public Stage menuStage;
    MediaPlayer backgroundMusic;
    private EqScene show;

    public FieldsLocation() {

        fieldsPane = new AnchorPane();
        Scene gameScene = new Scene(fieldsPane, 1152, 864);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
        gameStage.getScene();
        addGraphStartLocation();
        addCursorLook();
        music();
        eqButton();
        addCharacterButton();
        // addNextLocationButton();


    }

    private void addCursorLook() {
        String CURSOR_EFFECT = "rpg/graph/cursor.png";
        Image cursor = new Image(CURSOR_EFFECT);
        fieldsPane.setCursor(new ImageCursor(cursor));

    }

    private void addGraphStartLocation() {

        Image image = new Image("rpg/graph/locations/fields.png", 1152, 864, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        fieldsPane.setBackground(new Background(backgroundImage));

    }

    public void createAfterChangeLocation(Stage menuStage) {
        this.menuStage = menuStage;
        this.menuStage.hide();
        this.gameStage.show();
    }

    public void music() {
        String musicPath = new File("C:\\Users\\norbe\\Desktop\\RPGtest\\src\\rpg\\music\\startLocation.mp3").toURI().toString();
        backgroundMusic = new MediaPlayer(new Media(musicPath));
        backgroundMusic.play();
    }


    private void eqButton() {

        Button eq = new Button("");
        String EQ_OPEN = "rpg/graph/items/eqOpened.png";
        String EQ_CLOSE = "rpg/graph/items/eqClose.png";
        eq.setGraphic(new ImageView(EQ_CLOSE));

        String BACKGROUND = "rpg/graph/buttonBackGr.png";
        Image imageView = new Image(BACKGROUND, 200, 40, false, true);
        BackgroundImage backgroundImageButton = new BackgroundImage(imageView, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, null);
        eq.setBackground(new Background(backgroundImageButton));

        eq.setLayoutX(50);
        eq.setLayoutY(800);
        eq.setOnAction(actionEvent -> {
            EqScene eqScene = new EqScene();
            eqScene.openEq(eqScene);
        });

        eq.setOnMousePressed(event -> eq.setGraphic(new ImageView(EQ_OPEN)));
        eq.setOnMouseReleased(event -> eq.setGraphic(new ImageView(EQ_CLOSE)));
        eq.setOnMouseClicked(event -> clickMusic());
        eq.setOnMouseEntered(event -> {
            Label eqText = new Label("Ekwipunek");
            eqText.setLayoutX(60);
            eqText.setLayoutY(770);
            eqText.prefHeight(100);
            eqText.prefWidth(100);
            eqText.setTextFill(Color.YELLOW);
            eqText.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
            eq.setOnMouseExited(event1 -> {
                eqText.setText("");
            });
            fieldsPane.getChildren().add(eqText);
        });

        fieldsPane.getChildren().add(eq);

    }

    public void addCharacterButton() {

        Button characterButton = new Button();
        String charButtonImage = "rpg/graph/items/characterOnBar.png";
        characterButton.setGraphic(new ImageView(charButtonImage));

        String BACKGROUND = "rpg/graph/buttonBackGr.png";
        Image imageView = new Image(BACKGROUND, 200, 40, false, true);
        BackgroundImage backgroundImageButton = new BackgroundImage(imageView, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, null);
        characterButton.setBackground(new Background(backgroundImageButton));

        characterButton.setLayoutX(90);
        characterButton.setLayoutY(790);
        characterButton.setOnAction(event -> {
            CharacterStatsScene characterStatsScene = new CharacterStatsScene();
            characterStatsScene.openCharacterStats(characterStatsScene);
        });

        characterButton.setOnMousePressed(event -> characterButton.setGraphic(new ImageView("rpg/graph/items/pressedCharOnBar.png")));
        characterButton.setOnMouseReleased(event -> characterButton.setGraphic(new ImageView(charButtonImage)));
        characterButton.setOnMouseClicked(event -> clickMusic());
        characterButton.setOnMouseEntered(event -> {
            Label charText = new Label("Postać");
            charText.setLayoutX(110);
            charText.setLayoutY(770);
            charText.prefHeight(100);
            charText.prefWidth(100);
            charText.setTextFill(Color.YELLOW);
            charText.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
            characterButton.setOnMouseExited(event1 -> {
                charText.setText("");
            });

            fieldsPane.getChildren().add(charText);
        });

        fieldsPane.getChildren().add(characterButton);


    }

    public void clickMusic() {

        MediaPlayer backgroundMusic;

        String musicPath = new File("C:\\Users\\norbe\\Desktop\\RPGtest\\src\\rpg\\music\\click.mp3").toURI().toString();
        backgroundMusic = new MediaPlayer(new Media(musicPath));
        backgroundMusic.play();

    }

    private void addBee() {
        ImageView bee = new ImageView("rpg/graph/monsters/bee.gif");
        bee.setLayoutY(120);
        bee.setLayoutX(215);
        fieldsPane.getChildren().add(bee);

    }

    private void addNextLocationButton() {

        Button nextLocationButton = new Button();

        String nextLocationButtonImage = "rpg/graph/locations/buttonNextMap/buttonNextMapDOWN.gif";
        nextLocationButton.setGraphic(new ImageView(nextLocationButtonImage));

        String BACKGROUND = "rpg/graph/buttonBackGr.png";
        Image imageView = new Image(BACKGROUND, 40, 40, false, true);
        BackgroundImage backgroundImageButton = new BackgroundImage(imageView, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, null);
        nextLocationButton.setBackground(new Background(backgroundImageButton));

        nextLocationButton.setLayoutX(450);
        nextLocationButton.setLayoutY(750);
        nextLocationButton.setOnMouseEntered(mouseEvent -> nextLocationButton.setEffect(new SepiaTone()));
        nextLocationButton.setOnMouseExited(mouseEvent -> nextLocationButton.setEffect(null));


        fieldsPane.getChildren().add(nextLocationButton);

    }


}
