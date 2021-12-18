package com.SoumyadevSanyal.javafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public Label welcomeLabel;

	@FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public TextField userInputField;

	@FXML
	public Button convertBtn;

	private static final String C_TO_F_TEXT = "Celsius to Farenheit";
	private static final String F_TO_C_TEXT = "Farenheit to Celsius";

	private boolean isC_TO_F = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choiceBox.getItems().add(C_TO_F_TEXT);
		choiceBox.getItems().add(F_TO_C_TEXT);

		choiceBox.setValue(C_TO_F_TEXT);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			isC_TO_F = newValue.equals(C_TO_F_TEXT);
		});

		convertBtn.setOnAction(event -> {
//			double temp = convert(Double.parseDouble(userInputField.getText()), isC_TO_F);
//			System.out.println(temp);
//			Alert resultDialog = new Alert(Alert.AlertType.INFORMATION);
//			resultDialog.setTitle("Result");
//			if (isC_TO_F) {
//				resultDialog.setHeaderText(temp + " *F");
//			}else {
//				resultDialog.setHeaderText(temp + " *C");
//			}
//			resultDialog.setContentText("Temperature Converted");
//			resultDialog.show();
			convert();
		});

	}

	private void convert() {
		double input = 0.0;
		try{
			input = Double.parseDouble(userInputField.getText());
		}catch (Exception e){
			warnUser();
			return;
		}
		double newTemp = 0.0;

		if (isC_TO_F){
			newTemp = (input * 9 / 5) + 32;
		}else{
			newTemp = (input - 32) * 5 / 9;
		}
		display(newTemp);
	}

	private void warnUser() {
		Alert warning = new Alert(Alert.AlertType.WARNING);
		warning.setContentText("Please input a valid temperature.");
		warning.show();
	}

	private void display(double newTemp) {
		String unit = isC_TO_F? " F" : " C";
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setHeaderText(newTemp+unit);
		alert.show();
	}


//	private double convert(double temp, boolean isCelsius) {
//		if(isCelsius){
//			return (((9*temp)/5)+32);
//		} else{
//			return (temp-32)*5/9;
//		}
//	}
}
