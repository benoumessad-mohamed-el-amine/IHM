package serie3;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DragCircle extends Application {
  

    @Override
    public void start(Stage stage) {
        Circle circle = new Circle(80, 80, 40, Color.RED);

        circle.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                circle.startFullDrag();
            }
        });

        circle.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                circle.setCenterX(event.getX());
                circle.setCenterY(event.getY());
            }
        });

        Pane pane = new Pane(circle);
        stage.setScene(new Scene(pane, 400, 300));
        stage.setTitle("Déplacer un cercle");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

