package serie3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculatrice extends Application {

    private TextField display = new TextField();
    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    @Override
    public void start(Stage stage) {
        display.setEditable(false);
        display.setPrefHeight(50);

        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);

        // Ligne 0 : zone d'affichage
        grid.add(display, 0, 0, 4, 1);

        // Boutons numériques et opérateurs
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        int row = 1;
        int col = 0;
        for (String text : buttons) {
            Button btn = new Button(text);
            btn.setPrefSize(60, 60);
            grid.add(btn, col, row);

            btn.setOnAction(e -> handleButton(text));

            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
        }

        Scene scene = new Scene(grid, 260, 300);
        stage.setScene(scene);
        stage.setTitle("Calculatrice Simple");
        stage.show();
    }

    private void handleButton(String value) {
        switch (value) {
            case "C":
                display.clear();
                operator = "";
                firstNumber = 0;
                startNewNumber = true;
                break;

            case "+": case "-": case "*": case "/":
                if (!display.getText().isEmpty()) {
                    firstNumber = Double.parseDouble(display.getText());
                    operator = value;
                    startNewNumber = true;
                }
                break;

            case "=":
                if (!operator.isEmpty() && !display.getText().isEmpty()) {
                    double secondNumber = Double.parseDouble(display.getText());
                    double result = 0;

                    switch (operator) {
                        case "+": result = firstNumber + secondNumber; break;
                        case "-": result = firstNumber - secondNumber; break;
                        case "*": result = firstNumber * secondNumber; break;
                        case "/":
                            if (secondNumber != 0) result = firstNumber / secondNumber;
                            else {
                                display.setText("Erreur");
                                operator = "";
                                return;
                            }
                            break;
                    }
                    display.setText(String.valueOf(result));
                    operator = "";
                    startNewNumber = true;
                }
                break;

            default: // chiffres
                if (startNewNumber) {
                    display.setText(value);
                    startNewNumber = false;
                } else {
                    display.setText(display.getText() + value);
                }
                break;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
