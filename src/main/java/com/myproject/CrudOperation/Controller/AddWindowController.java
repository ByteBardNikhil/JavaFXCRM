package com.myproject.CrudOperation.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.myproject.CrudOperation.All_Interfaces.WindowInterface;
import com.myproject.CrudOperation.dao.DatabaseSave;
import com.myproject.CrudOperation.model.CustomerModel;

import entity.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddWindowController implements Initializable, WindowInterface {

	public AddWindowController() {
	}

	private DatabaseSave dataService = new DatabaseSave();

	@FXML
	private DatePicker dateOfBirth;

	@FXML
	private TextField firstNameTextField;

	@FXML
	private TextField occupationTextField;

	@FXML
	private TextField salaryTextField;

	@FXML
	private Button submitButton;

	@FXML
	private TextField surnameTextField;

	private Stage stage;

	// Setter method to set the stage
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@FXML
	void submit(ActionEvent event) {
		System.out.println("Action Evenr");

	}

	@FXML
	private void submitButton() {
	    // Initialize error messages
		// Initialize error messages
		String errorMessages = "";

		// Validate inputs
		if (!isValidInputs()) {
			// Concatenate error messages
		    String errorMessage = "";

		    if (!isValid(firstNameTextField.getText(), "[a-zA-Z]+")) {
		        errorMessage += "Invalid first name. Please enter letters only.\n";
		    }

		    if (!isValid(surnameTextField.getText(), "[a-zA-Z]+")) {
		        errorMessage += "Invalid surname. Please enter letters only.\n";
		    }

		    if (dateOfBirth.getValue() == null || !isValid(dateOfBirth.getValue().toString(), "\\d{4}-\\d{2}-\\d{2}")) {
		        errorMessage += "Invalid date of birth. Please enter a valid date in YYYY-MM-DD format.\n";
		    }

		    if (!isValid(occupationTextField.getText(), ".+")) {
		        errorMessage += "Invalid occupation. Please enter a valid occupation.\n";
		    }

		    if (!isValid(salaryTextField.getText(), "\\d+(\\.\\d+)?")) {
		        errorMessage += "Invalid salary. Please enter a valid number.\n";
		    }

		    if (!errorMessage.isEmpty()) {
		        // Display alert with error messages
		        Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Input Validation Error");
		        alert.setHeaderText("Please correct the following errors:");
		        alert.setContentText(errorMessage);
		        alert.showAndWait();
		    
		}

		// Method to validate all inputs
		

		} else {
			 String firstName = firstNameTextField.getText();
			    String surname = surnameTextField.getText();
			    String dob = null;

			    if (dateOfBirth.getValue() != null) {
			         dob = dateOfBirth.getValue().toString();
			    } else {
			        // Handle the case where no date is selected
			        System.out.println("No date selected!");
			        errorMessages += "No date selected!\n";
			    }
			    String occupation = occupationTextField.getText();
			    String salary = salaryTextField.getText();

			    Customer c = new Customer(firstName, surname, dob, occupation, salary);
			    System.out.println(c.toString());
			    dataService.saveData(c);

			    System.out.println("Data saved Successfully");
			    CUSTOMERLIST.clear();
			    CUSTOMERLIST.addAll(new CustomerModel().getAllCustomers());

			    handleSubmitButtonAction();
			    stage.close();   		// Method to validate individual input with regex
		
	    }
	}
	private boolean isValidInputs() {
	    // Check if all input fields are valid
	    boolean inputsValid = 
	        isValid(firstNameTextField.getText(), "[a-zA-Z]+") &&
	        isValid(surnameTextField.getText(), "[a-zA-Z]+") &&
	        (dateOfBirth.getValue() != null && isValid(dateOfBirth.getValue().toString(), "\\d{4}-\\d{2}-\\d{2}")) &&
	        isValid(occupationTextField.getText(), ".+") &&
	        isValid(salaryTextField.getText(), "\\d+(\\.\\d+)?");

	    return inputsValid;
	}
	
	private boolean isValid(String input, String regex) {
	    return input.matches(regex);
	}

		
	public void handleSubmitButtonAction() {

		firstNameTextField.clear();
		surnameTextField.clear();

		occupationTextField.clear();
		salaryTextField.clear();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		firstNameTextField.clear();
		occupationTextField.clear();
		salaryTextField.clear();
		surnameTextField.clear();
		load();
	}

	private void load() {
		CUSTOMERLIST.clear();
		CustomerModel model = new CustomerModel();

		CUSTOMERLIST.addAll(model.getAllCustomers());
		System.out.println("Inside Window Controller " + CUSTOMERLIST);

	}

}
