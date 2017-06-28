package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ui.UserWindow;

public class ReportBetweenClassesController implements IController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button DisplayButton;

	@FXML
	private BarChart<String, Double> ReportBarChart;

	@FXML
	private Label SemesterLabel;

	@FXML
	private CategoryAxis SpecificTeacherAxis;

	@FXML
	private Button CheckSemesterButton;

	@FXML
	private Button BackButton;

	@FXML
	private ComboBox<String> ChooseComboBox;

	@FXML
	private Label ReportLabel1;

	@FXML
	private Label ChooseLabel;

	@FXML
	private NumberAxis DifferentClassesAxis;

	@FXML
	private TextField SemesterTextField;

	private ArrayList<String> SemesterID;
	private String Teacher;
	private String SelectedTeacher;
	private int SemesterFLAG;
	private int TeacherFLAG;

	@FXML
	void BackToMenu(ActionEvent event)
	{
		UserWindow.closeUserWindow(getClass(), (Stage) ReportLabel1.getScene().getWindow());
	}

	@FXML
	void ChooseTeacher(ActionEvent event)
	{
		Teacher = ChooseComboBox.getSelectionModel().getSelectedItem();
		if (Teacher == null)
		{
			new Alert(AlertType.ERROR, "Item Not Found.", ButtonType.OK).showAndWait();
			return;
		}

	}

	void loadTeachers()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Teacher List");
		data.add("select");
		data.add("user");
		data.add("permission");
		data.add("4");
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
	void CheckSemesterID(ActionEvent event)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Semester ID");
		data.add("select field");
		data.add("semesterId");
		data.add("semester");
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
	void DisplayReport(ActionEvent event)
	{
		if (TeacherFLAG == 1 && SemesterFLAG == 1)
		{
			SelectedTeacher = Teacher.substring(0, 9);
			if (SelectedTeacher == null)
				return;

			ReportBarChart.getData().clear();
			ArrayList<String> data = new ArrayList<String>();
			data.add("histogram 1"); // for answer
			data.add("histogram 1"); // for sql type
			data.add(SelectedTeacher);
			data.add(SemesterID.get(0));
			data.add(SemesterID.get(1));
			data.add(SemesterID.get(2));
			data.add(SemesterID.get(3));

			try
			{
				Main.client.sendToServer(data);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			if (TeacherFLAG == 0 && SemesterFLAG == 0)
			{
				new Alert(AlertType.ERROR, "You must choose teacher and 4 semesters ID first!!", ButtonType.OK)
						.showAndWait();
			}
			if (TeacherFLAG == 0)
			{
				new Alert(AlertType.ERROR, "You must choose teacher first!!", ButtonType.OK).showAndWait();
			}
			if (SemesterFLAG == 0)
			{
				new Alert(AlertType.ERROR, "You must enter 4 semesters ID first!!", ButtonType.OK).showAndWait();
			}
		}

	}

	@FXML
	void initialize()
	{
		assert DisplayButton != null : "fx:id=\"DisplayButton\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert ReportBarChart != null : "fx:id=\"ReportBarChart\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert SemesterLabel != null : "fx:id=\"SemesterLabel\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert SpecificTeacherAxis != null : "fx:id=\"SpecificTeacherAxis\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert CheckSemesterButton != null : "fx:id=\"CheckSemesterButton\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert ChooseComboBox != null : "fx:id=\"ChooseComboBox\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert ReportLabel1 != null : "fx:id=\"ReportLabel1\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert ChooseLabel != null : "fx:id=\"ChooseLabel\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert DifferentClassesAxis != null : "fx:id=\"DifferentClassesAxis\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert SemesterTextField != null : "fx:id=\"SemesterTextField\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";

		Main.client.controller = this;
		
		SemesterTextField.setText("111111 222222 333333 444444");

		SemesterID = new ArrayList<String>();
		Teacher = "";
		SelectedTeacher = "";
		TeacherFLAG = 0;
		SemesterFLAG = 0;

		ReportBarChart.getXAxis().setLabel("Different Classes");
		ReportBarChart.getXAxis().setMaxWidth(0.3);
		ReportBarChart.getYAxis().setLabel("Average Grade");
		ReportBarChart.setTitle("");
		ReportBarChart.setCategoryGap(22.0);

		loadTeachers();

	}

	@Override
	public void handleAnswer(Object result)
	{
		if (result == null)
		{
			new Alert(AlertType.ERROR, "Item Not Found.", ButtonType.OK).showAndWait();

			return;
		}

		ArrayList<String> arr = (ArrayList<String>) result;
		String type = arr.remove(0);
		
		if (type.equals("histogram 1"))
		{
			XYChart.Series<String, Double> series = new XYChart.Series<>();
			//HashMap<String, String> map = new HashMap<>();
			
			for (String row : arr)
			{
				ArrayList<String> values = new ArrayList<>();
				String[] cols = row.split(";");
				
				for (String col : cols)
				{
					String[] field = col.split("=");
					//map.put(field[0], field[1]);
					values.add(field[1]);
				}
				series.getData().add(new XYChart.Data<>(values.get(0),Double.parseDouble(values.get(1))));
			}
			
			/*for(String key : map.keySet()){
				series.getData().add(new XYChart.Data<>(key,Double.parseDouble(map.get(key))));
			}*/
			
			ReportBarChart.getData().add(series);
			System.out.println("check");
			
		}
		if (type.equals("Teacher List"))
		{
			for (String row : arr)
			{
				String[] cols = row.split(";");
				HashMap<String, String> map = new HashMap<>();
				ArrayList<String> values = new ArrayList<>();
				for (String col : cols)
				{
					String[] field = col.split("=");
					map.put(field[0], field[1]);
				}
				String TeacherID = map.get("userId");
				String TeacherNAME = map.get("userFirstName");
				ChooseComboBox.getItems().add(TeacherID + " : " + TeacherNAME);
			}
			TeacherFLAG = 1;
		}

		if (type.equals("Check Semester ID"))
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
				SemesterID.add(map.get("semesterId"));
			}

			int i, j;
			String str = SemesterTextField.getText();
			String[] semesterID = str.split(" ");
			int SemesterFlag = 0;
			if (semesterID.length > 4 || semesterID.length < 4)
			{
				new Alert(AlertType.ERROR, "You can only choose 4 semesters for the report", ButtonType.OK)
						.showAndWait();
			}
			else
			{
				for (i = 0; i < semesterID.length; i++)
				{
					if (!SemesterID.contains(semesterID[i]))
					{
						SemesterFlag = 0;
						new Alert(AlertType.ERROR, "Semester ID " + semesterID[i] + " does not exist.", ButtonType.OK)
								.showAndWait();
						break;
					}
					else
					{
						SemesterFlag++;
					}
				}
			}
			if (SemesterFlag == semesterID.length)
			{
				SemesterFlag = 1;
				new Alert(AlertType.INFORMATION, "All semester ID are correct.", ButtonType.OK).showAndWait();
				SemesterID.clear();
				for (i = 0; i < semesterID.length; i++)
				{
					SemesterID.add(semesterID[i]);
				}
				SemesterFLAG = 1;
			}

		}
	}
}
