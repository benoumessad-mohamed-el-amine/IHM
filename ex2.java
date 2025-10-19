import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exo2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Test with StackPane");

        // Conteneur principal
        BorderPane root = new BorderPane();

        // Panneau central (équivalent CardLayout)
        StackPane cardPane = new StackPane();

        // Création des cartes
        Pane card1 = new Pane();
        Pane card2 = new Pane();
        card1.setStyle("-fx-background-color: WHITE;");
        card2.setStyle("-fx-background-color: BLACK;");

        // Ajout des cartes dans le StackPane
        cardPane.getChildren().addAll(card1, card2);

        // Seule la première carte est visible au départ
        card1.setVisible(true);
        card2.setVisible(false);

        // Boutons pour basculer entre les cartes
        Button btn1 = new Button("Show Card 1");
        Button btn2 = new Button("Show Card 2");

        // Actions des boutons
        btn1.setOnAction(e -> {
            card1.setVisible(true);
            card2.setVisible(false);
        });

        btn2.setOnAction(e -> {
            card1.setVisible(false);
            card2.setVisible(true);
        });

        // Barre de boutons en bas
        HBox buttonBox = new HBox(10, btn1, btn2);
        buttonBox.setStyle("-fx-alignment: center; -fx-padding: 10;");

        // Placement dans le BorderPane
        root.setCenter(cardPane);
        root.setBottom(buttonBox);

        // Création de la scène
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
