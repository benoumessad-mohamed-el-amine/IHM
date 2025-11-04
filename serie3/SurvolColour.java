package serie3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

public class SurvolColour extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Essayer de survoler sure le fentre");
        label.setLayoutX(40);
        label.setLayoutY(90);
        
        Pane pane = new Pane();

        // Quand la souris entre dans le panneau → vert
        pane.setOnMouseEntered(e -> {
            pane.setStyle("-fx-background-color: green;");
        });

        // Quand la souris quitte le panneau → rouge
        pane.setOnMouseExited(e -> {
            pane.setStyle("-fx-background-color: red;");
        });

        Scene scene = new Scene(pane ,400,200);
        stage.setScene(scene);
        stage.setTitle("Changer l'arrière-plan");
        stage.show();

        // Important pour que les touches soient reconnues
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch();
    }
}

