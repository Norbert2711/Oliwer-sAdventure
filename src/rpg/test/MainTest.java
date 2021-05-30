package rpg.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Tested tested = new Tested();
        primaryStage = tested.getMainStage();
        //Scene scene = new Scene(new DraggableGrid());
        //primaryStage.setScene(scene);
        primaryStage.setTitle("R P G");
        primaryStage.show();


    }

}
