package com.myproject.CrudOperation.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.myproject.CrudOperation.All_Interfaces.WindowInterface;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class MainController implements Initializable,WindowInterface {

	
	 @FXML
	    private Label classesCount;

	    @FXML
	    private Label facultyCount;

	    @FXML
	    private Label studentCount;

	    @FXML
	    private Label subjectsCount;

		@Override
		public void initialize(URL location, ResourceBundle resources) {
		
			
			
		}
	    
	    
}
