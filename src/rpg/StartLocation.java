package rpg;

import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
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

public class StartLocation extends Stage {

    private AnchorPane locationPane;
    private Stage gameStage;
    private Stage mainStage;
    public Stage menuStage;
    MediaPlayer backgroundMusic;
    private EqScene show;

    public StartLocation() {

        locationPane = new AnchorPane();
        Scene gameScene = new Scene(locationPane, 1152, 864);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
        gameStage.getScene();
        addGraphStartLocation();
        addCursorLook();
        music();
        addDescriptiveButtonsOnPane();
        eqButton();
        addCharacterButton();


    }

    private void addCursorLook() {
        String CURSOR_EFFECT = "rpg/graph/cursor.png";
        Image cursor = new Image(CURSOR_EFFECT);
        locationPane.setCursor(new ImageCursor(cursor));

    }

    private void addGraphStartLocation() {

        Image image = new Image("rpg/graph/locations/startmap.png", 1152, 864, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        locationPane.setBackground(new Background(backgroundImage));

    }

    public void createAfterSkipIntro(Stage menuStage) {
        this.menuStage = menuStage;
        this.menuStage.hide();
        this.gameStage.show();
    }

    public void music() {
        String musicPath = new File("C:\\Users\\norbe\\Desktop\\RPGtest\\src\\rpg\\music\\startLocation.mp3").toURI().toString();
        backgroundMusic = new MediaPlayer(new Media(musicPath));
        backgroundMusic.play();
    }

    private void addDescriptiveButtonsOnPane() {
//im mniejszy y tym wyzej na planszy
// im wiekszy x tym bardziej w prawo

        //well button
        StartLocationButtons well = new StartLocationButtons();
        well.setLayoutX(560);
        well.setLayoutY(150);

        well.setOnMouseEntered(event -> {
            Label textWell = new Label("wyschnięta" + "\n" +
                    "studnia");
            textWell.setLayoutX(495);
            textWell.setLayoutY(110);
            textWell.prefHeight(80);
            textWell.prefWidth(80);
            textWell.setTextFill(Color.YELLOW);
            textWell.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
            well.setOnMouseExited(event1 -> {
                textWell.setText("");
            });
            locationPane.getChildren().add(textWell);
        });
        locationPane.getChildren().add(well);

        //Oliwer's house
        StartLocationButtons oliwersHouse = new StartLocationButtons();
        oliwersHouse.setLayoutX(250);
        oliwersHouse.setLayoutY(440);

        oliwersHouse.setOnMouseEntered(event -> {
            Label oliwersHouseText = new Label("Dom Oliwera");
            oliwersHouseText.setLayoutX(250);
            oliwersHouseText.setLayoutY(330);
            oliwersHouseText.prefHeight(80);
            oliwersHouseText.prefWidth(80);
            oliwersHouseText.setTextFill(Color.YELLOW);
            oliwersHouseText.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
            oliwersHouse.setOnMouseExited(event1 -> {
                oliwersHouseText.setText("");
            });
            locationPane.getChildren().add(oliwersHouseText);
        });
        locationPane.getChildren().add(oliwersHouse);

        //Anna's house
        StartLocationButtons annasHouse = new StartLocationButtons();
        annasHouse.setLayoutX(800);
        annasHouse.setLayoutY(440);

        annasHouse.setOnMouseEntered(event -> {
            Label annassHouseText = new Label("Dom Anny");
            annassHouseText.setLayoutX(800);
            annassHouseText.setLayoutY(330);
            annassHouseText.prefHeight(80);
            annassHouseText.prefWidth(80);
            annassHouseText.setTextFill(Color.YELLOW);
            annassHouseText.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
            annasHouse.setOnMouseExited(event1 -> {
                annassHouseText.setText("");
            });
            locationPane.getChildren().add(annassHouseText);
        });
        locationPane.getChildren().add(annasHouse);


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
            locationPane.getChildren().add(eqText);
        });

        locationPane.getChildren().add(eq);

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
        characterButton.setOnMouseReleased(event ->  characterButton.setGraphic(new ImageView(charButtonImage)));
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

            locationPane.getChildren().add(charText);
        });

        locationPane.getChildren().add(characterButton);


    }
    public void clickMusic(){

        MediaPlayer backgroundMusic;

        String musicPath = new File("C:\\Users\\norbe\\Desktop\\RPGtest\\src\\rpg\\music\\click.mp3").toURI().toString();
        backgroundMusic = new MediaPlayer(new Media(musicPath));
        backgroundMusic.play();

    }


}
