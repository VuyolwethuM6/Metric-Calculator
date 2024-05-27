package sample;

import javafx.application.Application;
import javafx.geometry.Insets; 
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    private ComboBox<String> fromUnitCombo, toUnitCombo;
    private TextField quantityField;
    private Label resultLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        // Create components
        String[] units = {"Feet", "Meters", "Pounds", "Kilograms", "Fahrenheit", "Celsius"};
        fromUnitCombo = new ComboBox<>();
        toUnitCombo = new ComboBox<>();
        quantityField = new TextField();
        Button convertButton = new Button("Convert");
        resultLabel = new Label("Result: ");

        resultLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        // resultLabel.setTextFill(Color.BLUE);

        // Set up event handling for the convert button
        convertButton.setOnAction(e -> convert());

        // Set layout manager
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // Add a big heading at the top
        Text heading = new Text("Metric Converter");
        heading.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        grid.add(heading, 0, 0, 2, 1);
        GridPane.setMargin(heading, new Insets(0, 0, 10, 70));
        // GridPane.setAlignment(heading, Pos.CENTER); 
       


        // Add components to the grid
        grid.add(new Label("From Unit:"), 0, 1);
        grid.add(fromUnitCombo, 1, 1);
        grid.add(new Label("To Unit:"), 0, 2);
        grid.add(toUnitCombo, 1, 2);
        grid.add(new Label("Quantity:"), 0, 3);
        grid.add(quantityField, 1, 3);
        grid.add(convertButton, 1, 4);
        grid.add(resultLabel, 1, 5);

        // Set up the scene
        Scene scene = new Scene(grid, 400, 250);

        // Set the stage scene
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);

        // Show the stage
        primaryStage.show();

        // Initialize combo boxes
        fromUnitCombo.getItems().addAll(units);
        toUnitCombo.getItems().addAll(units);
        fromUnitCombo.setValue(units[0]);
        toUnitCombo.setValue(units[1]);
    }

    private void convert() {
        try {
            double quantity = Double.parseDouble(quantityField.getText());
            String fromUnit = fromUnitCombo.getValue();
            String toUnit = toUnitCombo.getValue();
            double result;

            switch (fromUnit) {
                case "Feet":
                    result = convertFeet(quantity, toUnit);
                    break;
                case "Meters":
                    result = convertMeters(quantity, toUnit);
                    break;
                case "Pounds":
                    result = convertPounds(quantity, toUnit);
                    break;
                case "Kilograms":
                    result = convertKgs(quantity, toUnit);
                    break;
                case "Fahrenheit":
                    result = convertFahrenheit(quantity, toUnit);
                    break;
                case "Celsius":
                    result = convertCelsius(quantity, toUnit);
                    break;
                default:
                    result = Double.NaN;
            }
            
            // resultLabel.setText("Result: " + (Double.isNaN(result) ? "Invalid conversion" : String.format("%.2f %s", result, toUnit)));
            if(Double.isNaN(result)){
                resultLabel.setTextFill(Color.BLUE);
                resultLabel.setText("Invalid conversion");
            }else{
                resultLabel.setTextFill(Color.GREEN);
                resultLabel.setText("Result: " +  String.format("%.2f %s", result, toUnit));
            }


        } catch (NumberFormatException ex) {
            resultLabel.setTextFill(Color.RED);
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    private double convertFeet(double quantity, String toUnit) {
        if (toUnit.equals("Meters" ) && quantity >= 0)
            return quantity * 0.3048;
        else
            return Double.NaN;
    }

    private double convertMeters(double quantity, String toUnit) {
        if (toUnit.equals("Feet") && quantity >= 0)
            return quantity / 0.3048;
        else
            return Double.NaN;
    }

    private double convertPounds(double quantity, String toUnit) {
        if (toUnit.equals("Kilograms") && quantity >= 0)
            return quantity * 0.453592;
        else
            return Double.NaN;
    }

    private double convertKgs(double quantity, String toUnit) {
        if (toUnit.equals("Pounds") && quantity >= 0)
            return quantity / 0.453592;
        else
            return Double.NaN;
    }

    private double convertFahrenheit(double quantity, String toUnit) {
        if (toUnit.equals("Celsius"))
            return (quantity - 32) * 5 / 9;
        else
            return Double.NaN;
    }

    private double convertCelsius(double quantity, String toUnit) {
        if (toUnit.equals("Fahrenheit"))
            return (quantity * 9 / 5) + 32;
        else
            return Double.NaN;
    }
}

