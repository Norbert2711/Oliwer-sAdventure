package rpg;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class GameScenes extends SubScene {

    private boolean isHidden = true;

    public GameScenes() {

        super(new AnchorPane(), 1152, 864);

        String BACKGROUND = "rpg/graph/menu/helpSubSceneBackGr.png";
        BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        AnchorPane root = (AnchorPane) this.getRoot();
        root.setBackground(new Background(backgroundImage));

        setLayoutX(1200);
        setLayoutY(100);

    }

    public void moveSubscene() {

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.3));
        translateTransition.setNode(this);

        //translateTransition.setToY(150);

        if (isHidden) {
            translateTransition.setToX(-1152);
            isHidden = false;

        }

        translateTransition.play();

    }

    public AnchorPane getPane(){
        return (AnchorPane) getRoot();
    }

}
