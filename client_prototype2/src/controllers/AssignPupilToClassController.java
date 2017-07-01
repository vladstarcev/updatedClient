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


/**
 * The Class AssignPupilToClassController - this class is assigning pupil to class.
 */
public class AssignPupilToClassController implements IController
{
    
    /** The resources. */
    @FXML
    private ResourceBundle resources;

    /** The location. */
    @FXML
    private URL location;

    /** The Send button 2. */
    @FXML
    private Button SendButton2;

    /** The Assign pupil class label 2. */
    @FXML
    private Label AssignPupilClassLable2;

    /** The Pupil id text field. */
    @FXML
    private TextField PupilIdTextField;

    /** The Class ID text field. */
    @FXML
    private TextField ClassIDTextField;

    /** The Assign pupil class label 1. */
    @FXML
    private Label AssignPupilClassLable1;

    /** The Assign button. */
    @FXML
    private Button AssignButton;

    /** The Class id label. */
    @FXML
    private Label ClassIdLable;

    /** The Back button. */
    @FXML
    private Button BackButton;

    /** The Pupil id label. */
    @FXML
    private Label PupilIdLable;

    /** The Send button 1. */
    @FXML
    private Button SendButton1;

	/** The Courses ID. */
	private ArrayList<String> CoursesID;
	
	/** The Pre-courses ID. */
	private ArrayList<String> PreCoursesID;
	
	/** The Old courses ID. */
	private ArrayList<String> OldCoursesID;

	/** The class ID. */
	private String classID;
	
	/** The pupil ID. */
	private String pupilID;

	/** The pupil flag. */
	private int pupilFLAG;
	
	/** The class flag. */
	private int classFLAG;
	
	/** The Assigned. */
	private int Assigned;
	
	/** The capacity. */
	private String capacity="";
	
	/** The Assigned pupils. */
	private String AssignedPupils ="";
	
	/** The Pupils courses. */
	private ArrayList<String> PupilsCourses;
	
	/** The Pupils grades. */
	private ArrayList<String> PupilsGrades;
	
	/** The Old class ID. */
	private String OldClassID;
	
	/** The Old class assigned pupils. */
	private String OldClassAssignedPupils;

	/**
	 * Function That Called When Secretary Presses On SensButton1
	 *
	 * @param event - enter the pupil ID
	 */
	@FXML
    void SendPupilID(ActionEvent event) {
		/**Query That Asks For The Field userID Where He Equals To PupilIdTextField.getText() From pupil Table**/
		
		try{
    		Integer.parseInt(PupilIdTextField.getText());
    	}
    	catch(NumberFormatException e){
    		new Alert(AlertType.ERROR, "Please enter 6-digit pupil ID", ButtonType.OK).showAndWait();
    		return;
    	}
		
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

	/**
	 * Send class ID - Function That Called When Secretary Presses On SensButton2.
	 *
	 * @param event - class ID
	 */
	@FXML
    void SendClassID(ActionEvent event) {
		/**Query That Asks For The Field classId Where He Equals To ClassIDTextField.getText() From class Table**/
		
		try{
    		Integer.parseInt(ClassIDTextField.getText());
    	}
    	catch(NumberFormatException e){
    		new Alert(AlertType.ERROR, "Please enter 4-digit Class ID", ButtonType.OK).showAndWait();
    		return;
    	}
		
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

	/**
	 * Loading all the pre-courses.
	 *
	 * @param str - string of pre-courses
	 */
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

	/**
	 * Loading the list of courses from the DB.
	 */
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

	/**
	 * Back to menu.
	 *
	 * @param event - back to Secretary Menu
	 */
	@FXML
	  void BackToMenu(ActionEvent event) {
		
		UserWindow.closeUserWindow(getClass(), (Stage) AssignPupilClassLable2.getScene().getWindow());
	}

	/**
	 * Assigning pupil to class.
	 *
	 * @param event - enter pupil ID
	 */
	@FXML
	  void AssignPupilToClass(ActionEvent event) {
		
		String currClassID = ClassIDTextField.getText();
		String currPupilID = PupilIdTextField.getText();
		if ((pupilFLAG == 1) && (classFLAG == 1) && (classID.equals(currClassID)) && (pupilID.equals(currPupilID)))
		{
			CheackIfPupilAlreadyAssignedToClass();
			loadCoursesInClass();
		}
		else
		{
			new Alert(AlertType.ERROR, "Enter Proper Pupil/Class ID And Check them Before Assigning .", ButtonType.OK).showAndWait();
		}
	}

	/**
	 * Checking if the pupil is already assigned in class.
	 */
	void CheackIfPupilAlreadyAssignedToClass()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("Check if pupil assigned");
		data.add("select");
		data.add("pupil_in_class");
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

	/**
	 * Loading courses in class.
	 */
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

	/**
	 * Insert pupil to class.
	 */
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

	/**
	 * Checking the capacity of class.
	 */
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

	/**
	 * Initialize.
	 */
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
	
	/**
	 * Update class.
	 */
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
	
	/**
	 * Insert pupil to course.
	 */
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
	
	/**
	 * Upload list of old class.
	 */
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
	
	/**
	 * Delete pupil in course.
	 */
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
		
		updateAssignedPupilsInOldClass();
	}
	
	/**
	 * Update assigned pupils in old class.
	 */
	void updateAssignedPupilsInOldClass()
	{
		int num=Integer.parseInt(OldClassAssignedPupils);
		num=num-1;
		OldClassAssignedPupils=Integer.toString(num);
				
		ArrayList<String> data = new ArrayList<String>();
		data.add("Update Assigned Pupils In Old Class");
		data.add("update");
		data.add("class");
		data.add("AssignedPupils");
		data.add(OldClassAssignedPupils);
		data.add("conditions");
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
		
		updateAssignedPupilsInClass();
		InsertPupilInCourse();
		new Alert(AlertType.INFORMATION, "PUPIL ADD SUCCESFULLY TO CLASS.", ButtonType.OK).showAndWait();
	}
	
	/**
	 * Update assigned pupils in class.
	 */
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
	
	/**
	 * Loading assigned pupil to old class.
	 */
	void loadAssignedPupilToOldClass()
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add("load Assaigned From Old Class");
		data.add("select");
		data.add("class");
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

    /**
     * Handles the answer from the server according to the type of answer.
     */   
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
				for (String row : arr)
				{
					String[] cols = row.split(";");
					HashMap<String, String> map = new HashMap<>();
					for (String col : cols)
					{
						String[] field = col.split("=");
						map.put(field[0], field[1]);
					}
					OldClassID=map.get("class_ID");
				}
				Assigned=1;
				loadAssignedPupilToOldClass();
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
					if (num < 55)
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
			if (Assigned==1) return;
			updateAssignedPupilsInClass();
			InsertPupilInCourse();
			new Alert(AlertType.INFORMATION, "PUPIL ADD SUCCESFULLY TO CLASS.", ButtonType.OK).showAndWait();
			//����� ����������������������
			
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
			//InsertPupilInCourse();
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
		
		if(type.equals("load Assaigned From Old Class"))
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
				OldClassAssignedPupils=map.get("AssignedPupils");
			}
		}
				
	}
}
