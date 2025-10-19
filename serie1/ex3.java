package serie1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ex3 extends Application {

    @Override
    public void start(Stage stage) {
        Label lblNombre = new Label("Nombre : ");
        TextField txtNombre = new TextField();
        Button btnCalcul = new Button("CALCUL");
        Label lblResult = new Label("Carré : ");

        btnCalcul.setOnAction(e -> {
            try {
                double nb = Double.parseDouble(txtNombre.getText().trim());
                double carre = nb * nb;
                lblResult.setText("Carré : " + carre);
            } catch (NumberFormatException ex) {
                lblResult.setText("Entrée invalide !");
            }
        });

        FlowPane root = new FlowPane(10, 10);
        root.getChildren().addAll(lblNombre, txtNombre, btnCalcul, lblResult);

        Scene scene = new Scene(root, 400, 100);
        stage.setTitle("Carrés");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
