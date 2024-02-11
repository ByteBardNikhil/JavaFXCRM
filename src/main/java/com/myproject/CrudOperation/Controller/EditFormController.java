package com.myproject.CrudOperation.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.myproject.CrudOperation.All_Interfaces.WindowInterface;
import com.myproject.CrudOperation.dao.DatabaseSave;
import com.myproject.CrudOperation.model.CustomerModel;

import entity.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditFormController implements Initializable, WindowInterface {
	private DatabaseSave dataService = new DatabaseSave();

	private Stage stage;
	@FXML
	private TextField dateOfBirthTextField;

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

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@FXML
	void submitAction(ActionEvent event) {

		editCustomer(customer);
		stage.close();
	}

	public void editCustomer(Customer customer) {

		String firstName = firstNameTextField.getText();
		String surname = surnameTextField.getText();
		String dob = dateOfBirthTextField.getText();
		String occupation = occupationTextField.getText();
		String salary = salaryTextField.getText();

		customer.setName(firstName);
		customer.setLastName(surname);
		customer.setDob(dob);
		customer.setOccupation(occupation);
		customer.setSalary(salary); // Assuming salary is a double

		dataService.updateData(customer);
		CUSTOMERLIST.clear();

		CUSTOMERLIST.addAll(new CustomerModel().getAllCustomers());

	}

	public void initData(Customer customer) {
		if (customer != null) {
			firstNameTextField.setText(customer.getName());
			surnameTextField.setText(customer.getLastName());
			String dobString = customer.getDob();
//			dateOfBirthTextField.setValue(dobDate);
			occupationTextField.setText(customer.getOccupation());
			salaryTextField.setText(String.valueOf(customer.getSalary()));

		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
