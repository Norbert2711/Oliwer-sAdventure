package rpg.test;

import java.util.List;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;

public class DraggableGrid extends GridPane {

    public DraggableGrid(){

        final int CELL_SIZE = 60;

        for (int rank = 0; rank < 5; rank++){
            for (int file = 0; file < 6; file++){
                Group group = new Group();

                Image bgImage = new Image(String.format("/rpg/test/rect.bmp",
                        (file+rank) % 2 == 0 ? "green" : "dark"));
                ImageView bgImageView = new ImageView(bgImage);
                bgImageView.setFitWidth(CELL_SIZE);
                bgImageView.setFitHeight(CELL_SIZE);

                Image fgImage = (file+rank) == 0 ?
                        new Image("rpg/test/sword.png") : null;
                ImageView fgImageView = new ImageView(fgImage);
                fgImageView.setFitWidth(CELL_SIZE);
                fgImageView.setFitHeight(CELL_SIZE);

                group.getChildren().addAll(bgImageView, fgImageView);
                add(group, file, rank);
            }
        }

        addDndFeature();
    }

    private void addDndFeature() {
        List<Node> children = getChildrenUnmodifiable();
        for (int rank = 0; rank < 2; rank++){
            for (int file = 0; file < 2; file++){
                Node currentNode = children.get(file + rank*2);
                ImageView currentNodeImageView = (ImageView) ((Group) currentNode)
                        .getChildren().get(1);

                Image cellImage = currentNodeImageView.getImage();

                currentNodeImageView.setOnDragDetected(event -> {
                    if (cellImage != null) {
                        Dragboard dragboard = currentNodeImageView
                                .startDragAndDrop(TransferMode.MOVE);

                        ClipboardContent clipboardContent = new ClipboardContent();
                        clipboardContent.putImage(cellImage);
                        dragboard.setContent(clipboardContent);

                        /////////////////////////
                        System.err.println("Drag started !");
                        ///////////////////////////

                    }
                    event.consume();
                });

                currentNodeImageView.setOnDragOver(event -> {
                    if (event.getGestureSource() != currentNodeImageView
                            && event.getDragboard().hasImage()){
                        event.acceptTransferModes(TransferMode.MOVE);
                        /////////////////////////
                        System.err.println("Drag accepted !");
                        ///////////////////////////
                    }
                    event.consume();
                });

                currentNodeImageView.setOnDragDropped(event -> {
                    Dragboard dragboard = event.getDragboard();
                    boolean success = false;

                    if (dragboard.hasImage()){
                        currentNodeImageView.setImage(dragboard.getImage());
                        success = true;
                    }

                    event.setDropCompleted(success);

                    /////////////////////////
                    System.err.println("Drag dropped !");
                    ///////////////////////////

                    event.consume();
                });

                currentNodeImageView.setOnDragDone(event -> {
                    if (event.getTransferMode() == TransferMode.MOVE){
                        ((ImageView) event.getSource()).setImage(null);
                    }

                    /////////////////////////
                    System.err.println("Drag done !");
                    ///////////////////////////

                    event.consume();
                });
            }
        }
    }

}