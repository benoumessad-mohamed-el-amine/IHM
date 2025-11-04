package serie3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.input.MouseButton;

public class DetectClick extends Application {
    @Override
    public void start(Stage stage) {
    	Label label = new Label("Now click");
    	
    	label.setOnMouseClicked(e -> {
    		if(e.getButton() == MouseButton.PRIMARY) {
            label.setText("Click is detected !");}
        });
        
        Scene s = new Scene(label, 300, 200);
        stage.setScene(s);
        stage.setTitle("Mousse Click");
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}

