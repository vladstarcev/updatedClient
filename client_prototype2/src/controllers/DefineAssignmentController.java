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
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

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

	@FXML
	void DefineAssignment(ActionEvent event) {
		System.out.println("Defining assignment");

		// TODO change class id to course id
		LocalDateTime dueDate = DueDatePicker.getValue().atStartOfDay();
		String classId = EnterClassIDTextField.getText();

		if (AssignmentFile == null) {
			System.out.println("Assignment file is null!");
			// TODO show error (must pick a file before sending)
			return;
		}

		byte[] contents;
		try {
			contents = Files.readAllBytes(AssignmentFile.toPath());
		} catch (IOException e) {
			System.out.println("Exception while reading file");
			// TODO show error
			e.printStackTrace();
			return;
		}

		java.util.List<Object> values = new ArrayList<>();
		values.add("add assignment");
		values.add(dueDate);
		values.add(classId);
		values.add(contents);
		values.add(AssignmentFile.getName());
		values.add(EnterAssNameTF.getText());

		try {
			System.out.println("Sending to server");
			Main.client.sendToServer(values);
			System.out.println("Sent!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void BackToMenu(ActionEvent event) {

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
	public void handleAnswer(Object msg) {
		// TODO Auto-generated method stub
		System.out.println("got answer! " + msg);
	}
}
