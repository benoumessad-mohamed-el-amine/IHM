package serie1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ex4 extends Application {

    @Override
    public void start(Stage stage) {
        Label lblLogin = new Label("Login : ");
        TextField txtLogin = new TextField();
        Label lblMdp = new Label("Mot de passe : ");
        PasswordField txtMdp = new PasswordField();
        Button btnEntrer = new Button("Entrer");
        Label lblMessage = new Label();

        btnEntrer.setOnAction(e -> {
            String login = txtLogin.getText().trim();
            String mdp = txtMdp.getText().trim();

            if (login.equals("administrateur") && mdp.equals("1234")) {
                lblMessage.setText("✅ Authentification réussie !");
            } else {
                lblMessage.setText("❌ Identifiants incorrects.");
            }
        });

        FlowPane root = new FlowPane(10, 10);
        root.getChildren().addAll(lblLogin, txtLogin, lblMdp, txtMdp, btnEntrer, lblMessage);

        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Identification");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
