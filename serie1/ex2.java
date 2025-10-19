package serie1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ex2 extends Application {

    @Override
    public void start(Stage stage) {
        // Composants
        Label lblNom = new Label("Entrez votre nom : ");
        TextField txtNom = new TextField();
        Button btnDireBonjour = new Button("Dire Bonjour");
        Label lblMessage = new Label();

        // Action du bouton
        btnDireBonjour.setOnAction(e -> {
            String nom = txtNom.getText().trim();
            if (!nom.isEmpty()) {
                lblMessage.setText("Bonjour " + nom + " !");
            } else {
                lblMessage.setText("Veuillez entrer votre nom.");
            }
        });

        // Layout
        FlowPane root = new FlowPane(10, 10);
        root.getChildren().addAll(lblNom, txtNom, btnDireBonjour, lblMessage);

        // Scene + Stage
        Scene scene = new Scene(root, 300, 150);
        stage.setTitle("Exercice 2 - Bonjour");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
