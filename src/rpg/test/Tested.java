package rpg.test;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import rpg.Buttons;
import rpg.GameScenes;

public class Tested extends Stage {

    private Stage mainStage;
    private AnchorPane mainPane;
    private GameScenes helpScene;
    private EqScene sceneToHide;
    private Scene dragScene;
    private EqScene eqScene;
    MediaPlayer backgroundMusic;


    public Tested() {

        mainPane = new AnchorPane();
        Scene gameMenuScene = new Scene(mainPane, 1152, 864);
        mainStage = new Stage();
        mainStage.setScene(gameMenuScene);
        eqButton();
        //eqLabel();
        createBackground();
        //addEqLook();
        dragDetection();

    }

    public Stage getMainStage() {
        return mainStage;
    }

    private void eqButton() {

        Button eq = new Button("EKWIPUNEK");
        eq.prefHeight(100);
        eq.prefWidth(100);
        eq.setLayoutX(500);
        eq.setLayoutY(400);
        eq.setOnAction(actionEvent -> {
            EqScene eqScene = new EqScene();
            eqScene.openEq(eqScene);
        });
        mainPane.getChildren().add(eq);

    }


    private void createBackground() {
        Image image = new Image("rpg/test/test.png", 1152, 864, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(backgroundImage));
    }


    public void addEqLook() {

        final int CELL_SIZE = 60;

        for (int rank = 0; rank < 5; rank++) {
            for (int file = 0; file < 6; file++) {
                Group group = new Group();

                Image bgImage = new Image(String.format("/rpg/test/rect.bmp",
                        (file + rank) % 2 == 0 ? "green" : "dark"));
                ImageView bgImageView = new ImageView(bgImage);
                bgImageView.setFitWidth(CELL_SIZE);
                bgImageView.setFitHeight(CELL_SIZE);

                Image fgImage = (file + rank) == 0 ?
                        new Image("rpg/test/sword.png") : null;
                ImageView fgImageView = new ImageView(fgImage);
                fgImageView.setFitWidth(CELL_SIZE);
                fgImageView.setFitHeight(CELL_SIZE);

                mainPane.getChildren().addAll(group, bgImageView, fgImageView);


            }
        }
        dragDetection();
    }


    public void dragDetection() {

        ImageView shield = new ImageView("rpg/test/shield.png");
        shield.setLayoutX(400);
        shield.setLayoutY(400);
        shield.prefHeight(80);
        shield.prefWidth(80);
        Image shield1 = new Image("rpg/test/shield.png");
        ImageView empty = new ImageView("/rpg/test/rect.bmp");
        empty.setLayoutX(700);
        empty.setLayoutY(700);
        empty.prefWidth(80);
        empty.prefHeight(80);

        shield.setOnDragDetected(event -> {
            Dragboard dragShield = shield.startDragAndDrop(TransferMode.ANY);
            ClipboardContent clipboardContent = new ClipboardContent();
            clipboardContent.putImage(shield.getImage());
            dragShield.setContent(clipboardContent);

            System.err.println("Drag started !");

            event.consume();

        });

        shield.setOnDragOver(event -> {
            if(event.getDragboard().hasImage()) {
                event.acceptTransferModes(TransferMode.ANY);
            }

            System.err.println("Drag accepted !");
        });

        shield.setOnDragDropped(event -> {
            Image image = event.getDragboard().getImage();
            empty.setImage(image);
            System.err.println("Drag dropped !");

        });


        shield.setOnDragDone(event -> {
            shield.setImage(null);
            empty.setImage(shield1);
            event.consume();
        });

        mainPane.getChildren().addAll(shield);
        mainPane.getChildren().addAll(empty);
    }

}




