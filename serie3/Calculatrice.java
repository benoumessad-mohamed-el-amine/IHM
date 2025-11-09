package serie3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculatrice extends Application {

    private TextField display = new TextField();
    private double total = 0;
    private String operator = "";
    private boolean startNewNumber = true;
    private boolean justCalculated = false;

    private String lastOperator = "";
    private double lastOperand = 0;

    @Override
    public void start(Stage stage) {
        display.setEditable(false);
        display.setPrefHeight(50);

        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);

        grid.add(display, 0, 0, 4, 1);

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        int row = 1;
        int col = 0;

        // Create one handler instance
        ButtonHandler handler = new ButtonHandler();

        for (String text : buttons) {
            Button btn = new Button(text);
            btn.setPrefSize(60, 60);
            grid.add(btn, col, row);
            btn.setOnAction(handler); // use handler instead of lambda

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

    // Inner class that extends EventHandler
    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Button btn = (Button) event.getSource();
            String value = btn.getText();

            switch (value) {
                case "C":
                    display.clear();
                    total = 0;
                    operator = "";
                    lastOperator = "";
                    lastOperand = 0;
                    startNewNumber = true;
                    justCalculated = false;
                    break;

                case "+": case "-": case "*": case "/":
                    if (!display.getText().isEmpty()) {
                        if (!operator.isEmpty() && !startNewNumber) {
                            calculate(Double.parseDouble(display.getText()));
                        } else if (!justCalculated) {
                            total = Double.parseDouble(display.getText());
                        }
                        operator = value;
                        startNewNumber = true;
                        justCalculated = false;
                    }
                    break;

                case "=":
                    if (!operator.isEmpty() && !display.getText().isEmpty()) {
                        double secondNumber = Double.parseDouble(display.getText());
                        calculate(secondNumber);

                        lastOperator = operator;
                        lastOperand = secondNumber;

                        operator = "";
                        startNewNumber = true;
                        justCalculated = true;

                    } else if (justCalculated && !lastOperator.isEmpty()) {
                        calculate(lastOperand, lastOperator);
                        startNewNumber = true;
                    }
                    break;

                default:
                    if (startNewNumber || justCalculated) {
                        display.setText(value);
                        startNewNumber = false;
                        justCalculated = false;
                    } else {
                        display.setText(display.getText() + value);
                    }
                    break;
            }
        }
    }

    private void calculate(double secondNumber) {
        calculate(secondNumber, operator);
    }

    private void calculate(double secondNumber, String op) {
        switch (op) {
            case "+": total += secondNumber; break;
            case "-": total -= secondNumber; break;
            case "*": total *= secondNumber; break;
            case "/":
                if (secondNumber != 0) total /= secondNumber;
                else {
                    display.setText("Erreur");
                    operator = "";
                    return;
                }
                break;
        }
        display.setText(String.valueOf(total));
    }

    public static void main(String[] args) {
        launch();
    }
}


