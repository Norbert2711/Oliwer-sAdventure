package rpg;

import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

public class StartLocation extends Stage {

    private AnchorPane locationPane;
    private Stage gameStage;
    private Stage mainStage;
    public Stage menuStage;
    MediaPlayer backgroundMusic;

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

    }

    private void addCursorLook() {
        String CURSOR_EFFECT = "rpg/graph/cursor.png";
        Image cursor = new Image(CURSOR_EFFECT);
        locationPane.setCursor(new ImageCursor(cursor));

    }

    private void addGraphStartLocation(){

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

    public void music(){
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
            Label textWell = new Label("wyschnięta"+"\n"+
                    "studnia");
            textWell.setLayoutX(495);
            textWell.setLayoutY(110);
            textWell.prefHeight(80);
            textWell.prefWidth(80);
            textWell.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
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
            oliwersHouseText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
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
            annassHouseText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            annasHouse.setOnMouseExited(event1 -> {
                annassHouseText.setText("");
            });
            locationPane.getChildren().add(annassHouseText);
        });
        locationPane.getChildren().add(annasHouse);



    }





}
