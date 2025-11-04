package serie2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ex3	 extends Application {

    @Override
    public void start(Stage stage) {
        // Création des boutons
        Button bNord = new Button("Nord");
        Button bOuest = new Button("Ouest");
        Button bSud = new Button("Sud");
        Button bCentre = new Button("Centre");
        Button bEst = new Button("Est");

        // VBox pour disposer les boutons verticalement
        VBox root = new VBox(); // espacement vertical de 10
        root.getChildren().addAll(bNord, bOuest, bSud, bCentre, bEst);

        // Création de la scène
        Scene scene = new Scene(root, 250, 200);

        // Configuration de la fenêtre
        stage.setTitle("Une fenêtre");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

