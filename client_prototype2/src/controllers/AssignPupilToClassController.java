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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ui.UserWindow;

public class AssignPupilToClassController implements IController
{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SendButton2;

    @FXML
    private Label AssignPupilClassLable2;

    @FXML
    private TextField PupilIdTextField;

    @FXML
    private TextField ClassIDTextField;

    @FXML
    private Label AssignPupilClassLable1;

    @FXML
    private Button AssignButton;

    @FXML
    private Label ClassIdLable;

    @FXML
    private Button BackButton;

    @FXML
    private Label PupilIdLable;

    @FXML
    private Button SendButton1;

	private ArrayList<String> CoursesID;
	private ArrayList<String> PreCoursesID;
	private ArrayList<String> OldCoursesID;

	private String classID;
	private String pupilID;

	private int pupilFLAG;
	private int classFLAG;
	private int Assigned;
	private String capacity="";
	private String AssignedPupils ="";
	private ArrayList<String> PupilsCourses;
	private ArrayList<String> PupilsGrades;
	private String OldClassID;
	private String OldClassAssignedPupils;

	@FXML
	/**Function That Called When Secretary Presses On SensButton1**/
    void SendPupilID(ActionEvent event) {
		/**Query That Asks For The Field userID Where He Equals To PupilIdTextField.getText() From pupil Table**/
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Pupil");
		data.add("select");
		data.add("pupil");
		data.add("userID");
		pupilID = PupilIdTextField.getText();
		data.add(pupilID);
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
	/**Function That Called When Secretary Presses On SensButton2**/
    void SendClassID(ActionEvent event) {

		/**Query That Asks For The Field classId Where He Equals To ClassIDTextField.getText() From class Table**/
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Class");
		data.add("select");
		data.add("class");
		data.add("classId");
		classID = ClassIDTextField.getText();
		data.add(classID);

		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	void loadPreCourses(String str)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Pre Courses");
		data.add("select");
		data.add("pre_course");
		data.add("course_id");
		data.add(str);
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	void loadCourses()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Course Of Pupil");
		data.add("select");
		data.add("pupil_in_course");
		data.add("userID");
		data.add(pupilID);
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
	  void BackToMenu(ActionEvent event) {
		
		UserWindow.closeUserWindow(getClass(), (Stage) AssignPupilClassLable2.getScene().getWindow());
	}

	@FXML
	  void AssignPupilToClass(ActionEvent event) {
		
		String currClassID = ClassIDTextField.getText();
		String currPupilID = PupilIdTextField.getText();
		if ((pupilFLAG == 1) && (classFLAG == 1) && (classID.equals(currClassID)) && (pupilID.equals(currPupilID)))
		{
			CheackIfPupilAlreadyAssignedToClass();

				loadCoursesInClass();
			//	loadCourses();

		}
		else
		{
			new Alert(AlertType.ERROR, "Enter Proper Pupil/Class ID And Ceack them Before Assigning .", ButtonType.OK)
					.showAndWait();
		}
	}

	void CheackIfPupilAlreadyAssignedToClass()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check if pupil assigned");
		data.add("select");
		data.add("pupil_in_class");
		data.add("pupil_ID");
		data.add(PupilIdTextField.getText());
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	void loadCoursesInClass()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Course In Class");
		data.add("select");
		data.add("course_in_class");
		data.add("classId");
		data.add(classID);
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	void InsertPupilToClass()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Assign Pupil To Class");
		data.add("insert");
		data.add("pupil_in_class");
		data.add("pupil_ID");
		data.add("class_ID");
		data.add("values");
		data.add(pupilID);
		data.add(classID);
		
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	void CheckClassCapacity()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check Class Capacity");
		data.add("select");
		data.add("class");
		data.add("classId");
		data.add(classID);
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
        assert SendButton2 != null : "fx:id=\"SendButton2\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert AssignPupilClassLable2 != null : "fx:id=\"AssignPupilClassLable2\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert PupilIdTextField != null : "fx:id=\"PupilIdTextField\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert ClassIDTextField != null : "fx:id=\"ClassIDTextField\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert AssignPupilClassLable1 != null : "fx:id=\"AssignPupilClassLable1\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert AssignButton != null : "fx:id=\"AssignButton\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert ClassIdLable != null : "fx:id=\"ClassIdLable\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert PupilIdLable != null : "fx:id=\"PupilIdLable\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
        assert SendButton1 != null : "fx:id=\"SendButton1\" was not injected: check your FXML file 'SecretaryAssignPupilToClass.fxml'.";
		Main.client.controller = this;
		Main.stack.push("SecretaryAssignPupilToClass");

		PreCoursesID = new ArrayList<String>();
		CoursesID = new ArrayList<String>();
		OldCoursesID = new ArrayList<String>();
		Assigned = 0;
		pupilFLAG = 0;
		classFLAG = 0;
		pupilID = "";
		classID = "";
		capacity="";
		OldClassID="";
		AssignedPupils ="";
		PupilsCourses = new ArrayList<String>();
		PupilsGrades = new ArrayList<String>();
		OldClassAssignedPupils="";
	}
	
	void UpdateClass()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("UpdateClass");
		data.add("update");
		data.add("pupil_in_class");
		data.add("class_ID");
		data.add(classID);
		data.add("conditions");
		data.add("pupil_ID");
		data.add(pupilID);
	
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	void InsertPupilInCourse()
	{
			int i=0;
			for(i=0;i<CoursesID .size();i++)
			{
			ArrayList<String> data = new ArrayList<String>();
			data.add("Insert Pupil In Course");
			data.add("insert");
			data.add("pupil_in_course");
			data.add("userID");
			data.add("courseID");
			data.add("gradeInCourse");
			data.add("values");
			data.add(pupilID);
			data.add(CoursesID.get(i));
			data.add("0");
			try
			{
				Main.client.sendToServer(data);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			}
	}
	
	void UploadListOfOldClass()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("load Courses of old class");
		data.add("select");
		data.add("course_in_class");
		data.add("classId");
		data.add(OldClassID);
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	void deletePupilInCourse()
	{
		for(int i=0;i<OldCoursesID.size();i++)
		{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Delete Pupil From Courses");
		data.add("delete");
		data.add("pupil_in_course");
		data.add("userID");
		data.add(pupilID);
		data.add("courseID");
		data.add(OldCoursesID.get(i));
		data.add("gradeInCourse");
		data.add("0");

		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		}
	}
	
	void updateAssignedPupilsInOldClass()
	{
		int num=Integer.parseInt(OldClassAssignedPupils);
		num=num-1;
		OldClassAssignedPupils=Integer.toString(num);
				
		ArrayList<String> data = new ArrayList<String>();
		data.add("UpdateAssignedPupils");
		data.add("update");
		data.add("class");
		data.add("AssignedPupils");
		data.add(OldClassAssignedPupils);
		data.add("classId");
		data.add(OldClassID);
	
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	void updateAssignedPupilsInClass()
	{
		int num=Integer.parseInt(AssignedPupils);
		num=num+1;
		AssignedPupils=Integer.toString(num);
				
		ArrayList<String> data = new ArrayList<String>();
		data.add("UpdateAssignedPupils");
		data.add("update");
		data.add("class");
		data.add("AssignedPupils");
		data.add(AssignedPupils);
		data.add("conditions");
		data.add("classId");
		data.add(classID);
	
		try
		{
			Main.client.sendToServer(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void handleAnswer(Object result)
	{
		if (result == null)
		{
			// error
			new Alert(AlertType.ERROR, "Item has not found.", ButtonType.OK).showAndWait();
			return;
		}
		ArrayList<String> arr = (ArrayList<String>) result;
		String type = arr.remove(0);

		if (type.equals("Check Pupil"))
		{
			if (arr.size() == 0)
			{
				pupilFLAG = 0;
				new Alert(AlertType.ERROR, "Pupil has not found.", ButtonType.OK).showAndWait();
			}
			else
			{
				pupilFLAG = 1;
				new Alert(AlertType.INFORMATION, "Pupil has found.", ButtonType.OK).showAndWait();
			}
		}
		if (type.equals("Check Class"))
		{
			if (arr.size() == 0)
			{
				classFLAG = 0;
				new Alert(AlertType.ERROR, "Class has not found.", ButtonType.OK).showAndWait();
			}
			else
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
					classID=map.get("classId");
					AssignedPupils=map.get("AssignedPupils");
					//OldClassID=map.get("classId");
					//OldClassAssignedPupils=map.get("AssignedPupils");
				}
				classFLAG = 1;
				new Alert(AlertType.INFORMATION, "Class has found.", ButtonType.OK).showAndWait();
			}
		}

		if (type.equals("Check if pupil assigned"))
		{
			if (arr.size() != 0)
			{
				Assigned=1;
				new Alert(AlertType.INFORMATION, "Pay Attention-Pupil Already Assigned To Class.", ButtonType.OK).showAndWait();
			}
		}

		if (type.equals("Check Course In Class"))
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
				CoursesID.add(map.get("courseId"));
			}
			for (int i = 0; i < CoursesID.size(); i++)
			{
				loadPreCourses(CoursesID.get(i));
			}
			loadCourses();
		}
		if (type.equals("Check Pre Courses"))
		{
			HashMap<String, String> map = new HashMap<>();
			for (String row : arr)
			{
				String[] cols = row.split(";");

				for (String col : cols)
				{
					String[] field = col.split("=");
					map.put(field[0], field[1]);
				}
				String pre_course = map.get("pre_course_id");
				PreCoursesID.add(pre_course);
			}
		}

		if (type.equals("Check Course Of Pupil"))
		{
			int flag = 0;
			for (String row : arr)
			{
				String[] cols = row.split(";");
				HashMap<String, String> map = new HashMap<>();
				for (String col : cols)
				{
					String[] field = col.split("=");
					map.put(field[0], field[1]);
				}
				PupilsCourses.add(map.get("courseID"));
				PupilsGrades.add(map.get("gradeInCourse"));
			}
			for (int i = 0; i < PreCoursesID.size(); i++)
			{
				if (!PupilsCourses.contains(PreCoursesID.get(i)))
				{
					flag = 1;
					break;
				}
				if (PupilsCourses.contains(PreCoursesID.get(i)))
				{
					int j;
					int num;
					j = PupilsCourses.indexOf(PreCoursesID.get(i));
					num = Integer.parseInt(PupilsGrades.get(j));
					if (num == 0)
					{
						flag = 1;
						break;
					}
				}
			}
			if (flag == 0)
			{
				CheckClassCapacity();

				//new Alert(AlertType.INFORMATION, "Pupil has pre-courses for this class.", ButtonType.OK).showAndWait();
			}
			else
			{
				new Alert(AlertType.ERROR, "Pupil has not pre-courses for this class.", ButtonType.OK).showAndWait();
			}
		}
		if (type.equals("Assign Pupil To Class"))
		{
			updateAssignedPupilsInClass();
			InsertPupilInCourse();
			new Alert(AlertType.INFORMATION, "Pupil add succesfully to class.", ButtonType.OK).showAndWait();

		}
		if (type.equals("Check Class Capacity"))
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

				capacity = map.get("capacity");
				AssignedPupils = map.get("AssignedPupils");
				int num = Integer.parseInt(capacity) - Integer.parseInt(AssignedPupils);
				if (num == 0)
					new Alert(AlertType.ERROR, "This Class Is Already Full", ButtonType.OK).showAndWait();
				else if(Assigned==0)
				{
					InsertPupilToClass();
				}
				else UpdateClass();
			}
		}
		
		if(type.equals("UpdateClass"))
		{
			InsertPupilInCourse();
			UploadListOfOldClass();
		}
		
		if(type.equals("load Courses of old class"))
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
				OldCoursesID.add(map.get("courseId"));
			}
			deletePupilInCourse();
		}
		
		if(type.equals("Delete Pupil From Courses"))
		{
			updateAssignedPupilsInOldClass();
		}
	}
}
