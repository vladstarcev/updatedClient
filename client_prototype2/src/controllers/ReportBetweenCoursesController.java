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

/**
 * The Class ReportBetweenCoursesController - this class present grade report between courses.
 */
public class ReportBetweenCoursesController implements IController
{

	/** The resources. */
	@FXML
	private ResourceBundle resources;

	/** The location. */
	@FXML
	private URL location;

	/** The Different courses number axis. */
	@FXML
	private NumberAxis DifferentCoursesAxis;

	/** The Display button. */
	@FXML
	private Button DisplayButton;

	/** The Semester label. */
	@FXML
	private Label SemesterLabel;

	/** The Check semester button. */
	@FXML
	private Button CheckSemesterButton;

	/** The Back button. */
	@FXML
	private Button BackButton;

	/** The Choose combo box. */
	@FXML
	private ComboBox<String> ChooseComboBox;

	/** The Report label no.1. */
	@FXML
	private Label ReportLabel1;

	/** The Choose label. */
	@FXML
	private Label ChooseLabel;

	/** The Report bar chart. */
	@FXML
	private BarChart<String, Double> ReportChart;

	/** The Specific class category axis. */
	@FXML
	private CategoryAxis SpecificClassAxis;

	/** The Report label no.2. */
	@FXML
	private Label ReportLabel2;

	/** The Semester text field. */
	@FXML
	private TextField SemesterTextField;

	/** The Semester ID. */
	private ArrayList<String> SemesterID;

	/** The Class. */
	private String Class;

	/** The Selected class. */
	private String SelectedClass;

	/** The Semester FLAG. */
	private int SemesterFLAG;

	/** The Class FLAG. */
	private int ClassFLAG;

	/**
	 * Back to menu.
	 *
	 * @param event - enter back to menu.
	 */
	@FXML
	void BackToMenu(ActionEvent event)
	{
		UserWindow.closeUserWindow(getClass(), (Stage) ReportLabel1.getScene().getWindow());
	}

	/**
	 * Choose class.
	 *
	 * @param event - choose class
	 */
	@FXML
	void ChooseClass(ActionEvent event)
	{
		Class = ChooseComboBox.getSelectionModel().getSelectedItem();
		if (Class == null)
		{
			new Alert(AlertType.ERROR, "Item Not Found.", ButtonType.OK).showAndWait();
			return;
		}
	}

	/**
	 * Load classes.
	 */
	void loadClasses()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Class List");
		data.add("select");
		data.add("class");
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Check semester ID.
	 *
	 * @param event - Check semester ID
	 */
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

	/**
	 * Display chart.
	 *
	 * @param event - Display chart
	 */
	@FXML
	void DisplayChart(ActionEvent event)
	{
		if (ClassFLAG == 1 && SemesterFLAG == 1)
		{
			SelectedClass = Class.substring(0, 4);
			if (SelectedClass == null)
				return;

			ReportChart.getData().clear();
			ArrayList<String> data = new ArrayList<String>();
			data.add("histogram 3"); // for answer
			data.add("histogram 3"); // for sql type
			data.add(SelectedClass);
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
			if (ClassFLAG == 0 && SemesterFLAG == 0)
			{
				new Alert(AlertType.ERROR, "You must choose class and 4 semesters ID first!!", ButtonType.OK)
						.showAndWait();
			}
			if (ClassFLAG == 0)
			{
				new Alert(AlertType.ERROR, "You must choose class first!!", ButtonType.OK).showAndWait();
			}
			if (SemesterFLAG == 0)
			{
				new Alert(AlertType.ERROR, "You must enter 4 semesters ID first!!", ButtonType.OK).showAndWait();
			}
		}

	}

	/**
	 * Initialize.
	 */
	@FXML
	void initialize()
	{
		assert DifferentCoursesAxis != null : "fx:id=\"DifferentCoursesAxis\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert DisplayButton != null : "fx:id=\"DisplayButton\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert SemesterLabel != null : "fx:id=\"SemesterLabel\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert CheckSemesterButton != null : "fx:id=\"CheckSemesterButton\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert ChooseComboBox != null : "fx:id=\"ChooseComboBox\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert ReportLabel1 != null : "fx:id=\"ReportLabel1\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert ChooseLabel != null : "fx:id=\"ChooseLabel\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert ReportChart != null : "fx:id=\"ReportChart\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert SpecificClassAxis != null : "fx:id=\"SpecificClassAxis\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert ReportLabel2 != null : "fx:id=\"ReportLabel2\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";
		assert SemesterTextField != null : "fx:id=\"SemesterTextField\" was not injected: check your FXML file 'ReportBetweenDiferentCoursesOfSpecificClass.fxml'.";

		Main.client.controller = this;
		Main.stack.push("ReportBetweenDiferentCoursesOfSpecificClass");

		SemesterID = new ArrayList<String>();
		Class = "";
		SelectedClass = "";
		ClassFLAG = 0;
		SemesterFLAG = 0;

		ReportChart.getXAxis().setLabel("Different Courses");
		ReportChart.getXAxis().setMaxWidth(0.3);
		ReportChart.getYAxis().setLabel("Average Grade");
		ReportChart.setTitle("");
		ReportChart.setCategoryGap(22.0);

		loadClasses();
	}

	/**
	 * Handles the answer from the server according to the type of answer.
	 */
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

		if (type.equals("histogram 3"))
		{
			XYChart.Series<String, Double> series = new XYChart.Series<>();

			for (String row : arr)
			{
				ArrayList<String> values = new ArrayList<>();
				String[] cols = row.split(";");

				for (String col : cols)
				{
					String[] field = col.split("=");
					values.add(field[1]);
				}
				series.getData().add(new XYChart.Data<>(values.get(0), Double.parseDouble(values.get(1))));
			}

			ReportChart.getData().add(series);
		}

		if (type.equals("Class List"))
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
				String ClassID = map.get("classId");
				String ClassNAME = map.get("className");
				ChooseComboBox.getItems().add(ClassID + " : " + ClassNAME);
			}
			ClassFLAG = 1;
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
