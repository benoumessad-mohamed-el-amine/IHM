package serie2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ex1 extends Application {

    @Override
    public void start(Stage stage) {
    	
    	BorderPane root = new  BorderPane();
        MenuBar menu = new MenuBar();
        Menu f = new Menu("Fichier");
        Menu e = new Menu("Edition");
        
        menu.getMenus().addAll(f,e);
        root.setTop(menu);
        VBox left  = new VBox();
        left.setSpacing(10);
        left.setStyle("-fx-background-color:#e0f0ff; -fx-padding: 10;");
        
        left.getChildren().addAll(
        		new Label("comands:"),
        		new Button("action 1"),
        		new Button("action 2")
        );
        
        root.setLeft(left);
        		
        Label textCentral = new Label("Espace Central");
        Pane panelCentral = new Pane();
        panelCentral.getChildren().add(textCentral);
        root.setCenter(panelCentral);
        
        Label right = new Label("Barre Laterale");
        right.setStyle("-fx-min-width:100;");
        root.setRight(right);
        
        Label b = new Label("info");
        root.setBottom(b);
        
        
        Scene myscene = new Scene(root, 400, 200);
        stage.setTitle("IHM");
        stage.setScene(myscene);
        stage.show();
    }
        
        
        
        
        
    public static void main(String[] args) {
        launch(args);
    }
} 
