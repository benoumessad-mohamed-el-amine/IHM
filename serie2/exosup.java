package serie2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class exosup extends Application {

    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // ---------- CENTRE ----------
        BorderPane centerPane = new BorderPane();

        // Grid for name / surname / adresse field line
        VBox gridInfo = new VBox();
        

        Label lblNom = new Label("Nom :");
        TextField txtNom = new TextField();

        Label lblPrenom = new Label("Prénom :");
        TextField txtPrenom = new TextField();

        Label lblAdresse = new Label("Adresse :");
        TextArea txtAdresse = new TextArea();
        txtAdresse.setPrefRowCount(8);
        
        gridInfo.getChildren().addAll(lblNom,txtNom,lblPrenom,txtPrenom,lblAdresse,txtAdresse);
        
        centerPane.setPadding(new Insets(0, 20, 0, 0));

        centerPane.setTop(gridInfo);

        // TextArea for Adresse details
        
        

        // Sexe radio buttons (HBox bottom)
        HBox boxSexe = new HBox(15);
        ToggleGroup sexeGroup = new ToggleGroup();
        RadioButton rbHomme = new RadioButton("Homme");
        RadioButton rbFemme = new RadioButton("Femme");

        rbHomme.setToggleGroup(sexeGroup);
        rbFemme.setToggleGroup(sexeGroup);

        boxSexe.getChildren().addAll(new Label("Sexe :"), rbHomme, rbFemme);
        boxSexe.setPadding(new Insets(10, 0, 0, 0));

        centerPane.setBottom(boxSexe);
        boxSexe.setPadding(new Insets(0, 0, 0, 10));
        root.setCenter(centerPane);

        // ---------- DROITE ----------
        GridPane rightBox = new GridPane();
        rightBox.setVgap(15);  // vertical spacing
        rightBox.setHgap(10);
        String[] sports = { "Tennis", "Squash", "Natation", "Athlétisme", "Randonnée", "Foot", "Basket","volley" ,"Pétanque" };
        for (int i=0; i <8 ;i++) {
            rightBox.add(new CheckBox(sports[i]),0 ,i);
        }
        

        root.setRight(rightBox);
        

        // ---------- BAS (boutons) ----------
        HBox bottomBox = new HBox(10);
        bottomBox.setPadding(new Insets(10, 0, 0, 200));

        Button btnOK = new Button("OK");
        Button btnCancel = new Button("Annuler");

        bottomBox.getChildren().addAll(btnOK, btnCancel);

        root.setBottom(bottomBox);

        // ---------- Scene ----------
        Scene scene = new Scene(root, 550, 300);
        stage.setTitle("Mon dialogue");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
