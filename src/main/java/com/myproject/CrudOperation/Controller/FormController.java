package com.myproject.CrudOperation.Controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.myproject.CrudOperation.All_Interfaces.WindowInterface;
import com.myproject.CrudOperation.dao.DatabaseSave;
import com.myproject.CrudOperation.model.CustomerModel;

import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FormController implements Initializable, WindowInterface {

	private DatabaseSave dataService = new DatabaseSave();

	public FormController() {
	}

	// Parameterized constructor
	public FormController(DatabaseSave dataService) {
		this.dataService = dataService;
	}
	@FXML
	private Button addbutton;
	@FXML
	private Button deletebutton;

	@FXML
	private Button editbutton;

	@FXML
	private TableColumn<Customer, ?> dateOfBirthColumn;

	@FXML
	private TableColumn<Customer, ?> firstName;

	@FXML
	private TableColumn<Customer, ?> occupation;

	@FXML
	private TableColumn<Customer, ?> salaryColumn;

	@FXML
	private TableColumn<Customer, ?> surname;

	@FXML
	private TableView<Customer> table;

	CustomerModel model = new CustomerModel();
	private ObservableList<Customer> data = CUSTOMERLIST;

	@FXML
	private void handleAddButtonClick() {
		try {
			// Load the new FXML file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/form.fxml"));

			AddWindowController controller = new AddWindowController();

			loader.setController(controller);
			Parent root = loader.load();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			controller.setStage(stage);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void handleEditButtonClick() {
		try {
			// Load the new FXML file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EditForm.fxml"));

			EditFormController controller = new EditFormController();

			loader.setController(controller);
			Parent root = loader.load();

			Customer selectedCustomer = table.getSelectionModel().getSelectedItem();

			if (selectedCustomer != null) {

				controller.initData(selectedCustomer);

				controller.setCustomer(selectedCustomer);

				setForm();
			
			} else {
				System.out.println("No customer selected.");
			}

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			controller.setStage(stage);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	private void setDataIntoTable() {

		data = FXCollections.observableArrayList(model.getAllCustomers());

		firstName.setCellValueFactory(new PropertyValueFactory<>("name"));
		surname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
		occupation.setCellValueFactory(new PropertyValueFactory<>("occupation"));
		salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		disableController();

		setDataIntoTable();

		deleteButton();

		System.out.println("Initialize method of FormController" + CUSTOMERLIST);

	}
	private void deleteButton() {

		deletebutton.setOnAction(event -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Are you sure you want to delete?");

			// Add confirm and deny buttons
			ButtonType confirmButton = new ButtonType("Confirm", ButtonData.OK_DONE);
			ButtonType denyButton = new ButtonType("Deny", ButtonData.CANCEL_CLOSE);
			alert.getButtonTypes().setAll(confirmButton, denyButton);

			// Show the dialog and wait for user input
			Optional<ButtonType> result = alert.showAndWait();

			// Check which button was clicked
			if (result.isPresent() && result.get() == confirmButton) {
				System.out.println("User clicked Confirm");

				Customer selectedCustomer = table.getSelectionModel().getSelectedItem();

				if (selectedCustomer != null) {
					// Remove the selected Customer object using the data service
					dataService.removeData(selectedCustomer);
					// You may want to handle success or failure of removal here
				} else {
					System.out.println("No customer selected.");
				}

				setForm();

			} else {
				System.out.println("User clicked Deny");

			}
		});
	}

	public void setForm() {

		load();
		System.out.println("setForm method running");
		table.setItems(CUSTOMERLIST);
	}

	private void load() {

		if (!CUSTOMERLIST.isEmpty()) {
			CUSTOMERLIST.clear();
		}
		CUSTOMERLIST.addAll(new CustomerModel().getAllCustomers());

		setDataIntoTable();

		System.out.println("inside load method" + CUSTOMERLIST);

	}

	private void disableController() {
		deletebutton.setDisable(true);
		editbutton.setDisable(true);

		// Listen for row selection changes
		table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				// Enable delete button if a row is selected
				deletebutton.setDisable(false);
				editbutton.setDisable(false);

			} else {
				// Disable delete button if no row is selected
				deletebutton.setDisable(true);
				editbutton.setDisable(true);
			}
		});
	}

}
