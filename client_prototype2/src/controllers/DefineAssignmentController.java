package controllers;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ui.UserWindow;

public class DefineAssignmentController implements IController {

	@FXML
	private TextField EnterAssNameTF;

	@FXML
	private DatePicker DueDatePicker;

	@FXML
	private Label EnterDueDateLabel;

	@FXML
	private Label DefineAssignmentLabel;

	@FXML
	private Button BackButton;

	@FXML
	private TextField EnterClassIDTextField;

	@FXML
	private Hyperlink UploadFileHyperLink;

	@FXML
	private Button DefineAssignmentButton;

	@FXML
	private Label EnterClassIdLabel;

	private File AssignmentFile;
	private boolean flagAss=false;
	private boolean flagCourse=false;

	@FXML
	void EnterClassID(ActionEvent event) {

	}

	@FXML
	void EnterDueDate(ActionEvent event) {
		if (DueDatePicker.getValue().isBefore(LocalDate.now())) {
			// TODO display error
		}
	}

	@FXML
	void EnterAssName(ActionEvent event) {

	}

	void checkExistingAss(String assName,String courseId)
	{

		ArrayList<String> data = new ArrayList<String>();
		data.add("check assignment name");
		data.add("select");
		data.add("assignment_in_course");
		data.add("assignmentName");
		data.add(assName);
		data.add("courseID");
		data.add(courseId);
		
		
		
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	void searchCourseId(String courseId)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("search courseId");
		data.add("select");
		data.add("courses");
		data.add("courseId");
		data.add(courseId);
		
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	@FXML
	void DefineAssignment(ActionEvent event) {
		// TODO change class id to course id
		String courseId = EnterClassIDTextField.getText();
		String assName = EnterAssNameTF.getText();

		if (AssignmentFile == null) {
			new Alert(AlertType.ERROR, "Missing assignment file!", ButtonType.OK).showAndWait();
			return;
		}
		else if(assName.equals("")) {
			new Alert(AlertType.ERROR, "Missing assignment name!", ButtonType.OK).showAndWait();
			return;
		}
		else if(courseId.equals("")){
			new Alert(AlertType.ERROR, "Missing course Id!", ButtonType.OK).showAndWait();
			return;
		}
		else if(DueDatePicker.getValue()==null)
			new Alert(AlertType.ERROR, "Missing date!", ButtonType.OK).showAndWait();
		else{
			byte[] contents;
			try {
				contents = Files.readAllBytes(AssignmentFile.toPath());
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				return;
			}
			searchCourseId(courseId);
			if(flagCourse)
			{
				checkExistingAss(assName,courseId);
				if(flagAss)
				{
					LocalDateTime dueDate = DueDatePicker.getValue().atStartOfDay();
		
					java.util.List<Object> values = new ArrayList<>();
					values.add("add assignment");
					values.add(dueDate);
					values.add(courseId);
					values.add(contents);
					values.add(AssignmentFile.getName());
					values.add(EnterAssNameTF.getText());
			
					try 
					{
						Main.client.sendToServer(values);
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
					new Alert(AlertType.INFORMATION, "Assignment was defined successfully!", ButtonType.OK).showAndWait();
				}

			}
		}

	}

	@FXML
	void BackToMenu(ActionEvent event) {
	     UserWindow.closeUserWindow(getClass(), (Stage)BackButton.getScene().getWindow());     

	}

	@FXML
	void ChooseFileToUpload(ActionEvent event) {
		FileChooser chooser = new FileChooser();

		// TODO add extension filter from DB
		chooser.setTitle("Choose assignment file");

		AssignmentFile = chooser.showOpenDialog(DefineAssignmentButton.getScene().getWindow());
	}

	@FXML
	void initialize() {
		assert DueDatePicker != null : "fx:id=\"DueDatePicker\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";
		assert EnterDueDateLabel != null : "fx:id=\"EnterDueDateLabel\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";
		assert DefineAssignmentLabel != null : "fx:id=\"DefineAssignmentLabel\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";
		assert EnterClassIDTextField != null : "fx:id=\"EnterClassIDTextField\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";
		assert UploadFileHyperLink != null : "fx:id=\"UploadFileHyperLink\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";
		assert DefineAssignmentButton != null : "fx:id=\"DefineAssignmentButton\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";
		assert EnterClassIdLabel != null : "fx:id=\"EnterClassIdLabel\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";
		assert EnterAssNameTF != null : "fx:id=\"EnterAssNameTF\" was not injected: check your FXML file 'TeacherDefineAssignment.fxml'.";

		Main.client.controller = this;
	}

	@Override
	public void handleAnswer(Object result) {
		if (result == null)
		{
			// error

			return;
		}

		ArrayList<String> arr = (ArrayList<String>) result;
		String type = arr.remove(0);
		if (type.equals("search courseId"))
		{
			for (String row : arr)
			{
				String[] cols = row.split(";");
				HashMap<String, String> map = new HashMap<>();
			
				for (String col : cols)
				{
					String[] field = col.split("=");
					map.put(field[0], field[1]);
				}

			}
			if(arr.size()==0){
				new Alert(AlertType.ERROR, "Course Id is not exist!", ButtonType.OK).showAndWait();
				flagCourse=false;
			}
			else flagCourse=true;

		}
		else if (type.equals("check assignment name"))
		{
			for (String row : arr)
			{
				String[] cols = row.split(";");
				HashMap<String, String> map = new HashMap<>();
			
				for (String col : cols)
				{
					String[] field = col.split("=");
					map.put(field[0], field[1]);
				}

			}
			if(arr.size()!=0){
				new Alert(AlertType.ERROR, "Assignment name is already exist!", ButtonType.OK).showAndWait();
				flagAss=false;
			}
			else flagAss=true;
		}
	}
}
