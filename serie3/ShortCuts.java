package serie3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

public class ShortCuts extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Appuyez sur Ctrl + Alt + O pour rendre le fond orange");
        label.setLayoutX(40);
        label.setLayoutY(90);

        Pane pane = new Pane(label);
        Scene scene = new Scene(pane, 400, 200, Color.WHITE);

        scene.setOnKeyPressed(new javafx.event.EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.isControlDown() && event.isAltDown() && event.getCode().toString().equals("O")) {
                	pane.setStyle("-fx-background-color: Orange;");
                    label.setText("Appuyez sur Ctrl + Alt + R pour rendre le fond orange");
                } else if (event.isControlDown() && event.isAltDown() && event.getCode().toString().equals("R")) {
                	pane.setStyle("-fx-background-color: white;");
                    label.setText("Appuyez sur Ctrl + Alt + O pour rendre le fond Blanche");
                }
            }
        });

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

