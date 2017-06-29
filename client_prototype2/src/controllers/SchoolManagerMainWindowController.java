package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import ui.UserWindow;

/**
 * The Class SchoolManagerMainWindowController.
 */
public class SchoolManagerMainWindowController implements IController
{

	/** The resources. */
	@FXML
	private ResourceBundle resources;

	/** The location. */
	@FXML
	private URL location;

	/** The Handling exeptional request menu item. */
	@FXML
	private MenuItem HandlingExeptionalRequestMenuItem;

	/** The Log out button. */
	@FXML
	private Button LogOutButton;

	/** The Menu button. */
	@FXML
	private MenuButton MenuButton;

	/** The Report genaration menu item. */
	@FXML
	private MenuItem ReportGenarationMenuItem;

	/** The School manager menu label. */
	@FXML
	private Label SchoolManagerMenuLabel;

	/** The Block user menu item. */
	@FXML
	private MenuItem BlockUserMenuItem;

	/** The View system data. */
	@FXML
	private MenuItem ViewSystemData;

	/** The Choose operation label. */
	@FXML
	private Label ChooseOperationLabel;

	/**
	 * School manager menu.
	 *
	 * @param event the event
	 */
	@FXML
	void SchoolManagerMenu(ActionEvent event)
	{
		
	}

	/**
	 * Block user.
	 *
	 * @param event the event
	 */
	@FXML
	void BlockUser(ActionEvent event)
	{
		UserWindow.createUserWindow((Stage) MenuButton.getScene().getWindow(), "SchoolManagerBlockUser", getClass());  
	}

	/**
	 * Block window operation.
	 *
	 * @param event the event
	 */
	@FXML
	void BlockWindowOperation(ActionEvent event)
	{

	}

	/**
	 * Report generation.
	 *
	 * @param event the event
	 */
	@FXML
	void ReportGeneration(ActionEvent event)
	{
		Main.stack.push("SchoolManagerReportGeneration"); 
		UserWindow.createUserWindow((Stage) MenuButton.getScene().getWindow(),"SchoolManagerReportGeneration", getClass());

	}

	/**
	 * Report generation operation.
	 *
	 * @param event the event
	 */
	@FXML
	void ReportGenerationOperation(ActionEvent event)
	{

	}

	/**
	 * Handling exeptional request.
	 *
	 * @param event the event
	 */
	@FXML
	void HandlingExeptionalRequest(ActionEvent event)
	{
		UserWindow.createUserWindow((Stage) MenuButton.getScene().getWindow(),"SchoolManagerHandlingExeptionalRequest", getClass());
	}

	/**
	 * Handling exeptional request operation.
	 *
	 * @param event the event
	 */
	@FXML
	void HandlingExeptionalRequestOperation(ActionEvent event)
	{
		
	}

	/**
	 * View all data.
	 *
	 * @param event the event
	 */
	@FXML
	void ViewAllData(ActionEvent event)
	{
		UserWindow.createUserWindow((Stage) MenuButton.getScene().getWindow(),"SchoolManagerViewAllData", getClass());
	}

	/**
	 * School manager log out.
	 *
	 * @param event the event
	 */
	@FXML
	void SchoolManagerLogOut(ActionEvent event)
	{
		UserWindow.closeUserWindow(getClass(), (Stage)ChooseOperationLabel.getScene().getWindow());
	}

	/**
	 * Initialize.
	 */
	@FXML
	void initialize()
	{
        assert HandlingExeptionalRequestMenuItem != null : "fx:id=\"HandlingExeptionalRequestMenuItem\" was not injected: check your FXML file 'SchoolManagerMainWindow.fxml'.";
        assert LogOutButton != null : "fx:id=\"LogOutButton\" was not injected: check your FXML file 'SchoolManagerMainWindow.fxml'.";
        assert MenuButton != null : "fx:id=\"MenuButton\" was not injected: check your FXML file 'SchoolManagerMainWindow.fxml'.";
        assert ReportGenarationMenuItem != null : "fx:id=\"ReportGenarationMenuItem\" was not injected: check your FXML file 'SchoolManagerMainWindow.fxml'.";
        assert SchoolManagerMenuLabel != null : "fx:id=\"SchoolManagerMenuLabel\" was not injected: check your FXML file 'SchoolManagerMainWindow.fxml'.";
        assert BlockUserMenuItem != null : "fx:id=\"BlockUserMenuItem\" was not injected: check your FXML file 'SchoolManagerMainWindow.fxml'.";
        assert ViewSystemData != null : "fx:id=\"ViewSystemData\" was not injected: check your FXML file 'SchoolManagerMainWindow.fxml'.";
        assert ChooseOperationLabel != null : "fx:id=\"ChooseOperationLabel\" was not injected: check your FXML file 'SchoolManagerMainWindow.fxml'.";

		Main.client.controller = this;
		
		Main.stack.push("SchoolManagerMainWindow");
		
	}

	@Override
	public void handleAnswer(Object msg)
	{
		// TODO Auto-generated method stub

	}
}
