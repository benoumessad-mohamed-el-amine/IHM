package serie3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

public class KeyDisplay extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Appuyez sur une touche...");
        label.setLayoutX(80);
        label.setLayoutY(100);

        Pane pane = new Pane(label);

        Scene scene = new Scene(pane, 400, 200);

        scene.setOnKeyPressed(new javafx.event.EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                label.setText("Touche pressée : " + event.getCode());
            }
        });

        stage.setScene(scene);
        stage.setTitle("Affichage de la touche pressée");
        stage.show();

        // Important: give focus to scene so key events work
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch();
    }
}
