package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import application.Main;
import interfaces.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ReportBetweenClassesController implements IController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private BarChart<String, Number> ReportBarChart;

	@FXML
	private CategoryAxis SpecificTeacherAxis;

	@FXML
	private Button BackButton;

	@FXML
	private ComboBox<String> ChooseComboBox;

	@FXML
	private Label ReportLabel1;

	@FXML
	private Label ChooseLabel;

	@FXML
	private Label ReportLable2;

	@FXML
	private NumberAxis DifferentClassesAxis;

	@FXML
	void BackToMenu(ActionEvent event)
	{

	}

	@FXML
	void ChooseTeacher(ActionEvent event)
	{
		ArrayList<String> semestersId = new ArrayList<>();
		semestersId.add("111111");
		semestersId.add("111112");
		
		String selectTeacherId = ChooseComboBox.getSelectionModel().getSelectedItem();
		if(selectTeacherId == null)
			return;
		
		ReportBarChart.getData().clear();
		ArrayList<String> data = new ArrayList<String>();
		data.add("histogram 1"); // for answer
		data.add("histogram 1"); // for sql type
		data.add(selectTeacherId);
		data.add(semestersId.get(0));

		
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
	void initialize()
	{
		assert ReportBarChart != null : "fx:id=\"ReportBarChart\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert SpecificTeacherAxis != null : "fx:id=\"SpecificTeacherAxis\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert ChooseComboBox != null : "fx:id=\"ChooseComboBox\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert ReportLabel1 != null : "fx:id=\"ReportLabel1\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert ChooseLabel != null : "fx:id=\"ChooseLabel\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert ReportLable2 != null : "fx:id=\"ReportLable2\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";
		assert DifferentClassesAxis != null : "fx:id=\"DifferentClassesAxis\" was not injected: check your FXML file 'ReportBetweenClassesOfSpecificTeacher.fxml'.";

		ReportBarChart.getXAxis().setLabel("Different Classes");
		ReportBarChart.getXAxis().setMaxWidth(0.3);
		ReportBarChart.getYAxis().setLabel("Average Grade");
		ReportBarChart.setTitle("");
		ReportBarChart.setCategoryGap(22.0);
	}

	@Override
	public void handleAnswer(Object result)
	{
		if (result == null)
		{
			// error

			return;
		}

		ArrayList<String> arr = (ArrayList<String>) result;
		String type = arr.remove(0);
		if (type.equals("histogram 1"))
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
			//	allPupils.put(map.get("userId"), map);
			}
			//loadPupilsParent();
		}
	}
}
