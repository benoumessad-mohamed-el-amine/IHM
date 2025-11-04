package serie2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ex4 extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10); // espacement horizontal
        grid.setVgap(10); // espacement vertical
        grid.setPadding(new Insets(15	)); // marge intérieure

        // Création des boutons
        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button b4 = new Button("4");
        Button b5 = new Button("5");
        Button b6 = new Button("6");
        Button b7 = new Button("7");
        Button b8 = new Button("8");
        Button b9 = new Button("9");
        // Placement dans la grille : grid.add(node, colonne, ligne)
        grid.add(b1, 0, 0);
        grid.add(b2, 1, 0);
        grid.add(b3, 2, 0);

        grid.add(b4, 0, 1);
        grid.add(b5, 1, 1);
        grid.add(b6, 2, 1);
        
        grid.add(b7, 0, 2);
        grid.add(b8, 1, 2);
        grid.add(b9, 2, 2);
        
        Scene scene = new Scene(grid, 320, 150);
        primaryStage.setTitle("Exercice 4 - GridPane 3x2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
