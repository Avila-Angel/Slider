package com.example.slider;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label myLabel;
    @FXML
    private Slider mySlider;

    int myTemperature;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // put bottom code in initialize section to make the initial label set to current temp
        myTemperature = (int) mySlider.getValue();
        myLabel.setText(Integer.toString(myTemperature) + "°C");

        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                // gets current value of mySlider and stores it in myTemperature
                myTemperature = (int) mySlider.getValue(); // cast as an integer because it starts off as a double and we're working with ints
                myLabel.setText(Integer.toString(myTemperature) + "°C");
            }
        });
    }
}