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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import ui.UserWindow;

/**
 * The Class PupilMainWindow.
 */
public class PupilMainWindow implements IController{

    /** The resources. */
    @FXML
    private ResourceBundle resources;

    /** The location. */
    @FXML
    private URL location;

    /** The Choose menu button. */
    @FXML
    private MenuButton ChooseMenuButton;
    
    /** The upload ass. */
    @FXML
    private MenuItem uploadAss;

    /** The Pupil file. */
    @FXML
    private MenuItem PupilFile;

    /** The Pupil menu lable. */
    @FXML
    private Label PupilMenuLable;

    /** The Log out button. */
    @FXML
    private Button LogOutButton;

    /** The Choose operation lable. */
    @FXML
    private Label ChooseOperationLable;
   
    /**
     * Pupil choose operation.
     *
     * @param event the event
     */
    @FXML
    void PupilChooseOperation(ActionEvent event) {
     System.out.println("TUDO BOM");
    }

    /**
     * Pupil log out.
     *
     * @param event the event
     */
    @FXML
    void PupilLogOut(ActionEvent event) {
     UserWindow.createUserWindow((Stage) ChooseMenuButton.getScene().getWindow(), "loginFrame", getClass());
    }
    
    /**
     * Upload ass.
     *
     * @param event the event
     */
    @FXML
    void uploadAss(ActionEvent event) {
  UserWindow.createUserWindow((Stage) ChooseMenuButton.getScene().getWindow(), "PupilAssignment", getClass());  

    }

    /**
     * Open pupil file.
     *
     * @param event the event
     */
    @FXML
    void openPupilFile(ActionEvent event) {
  UserWindow.createUserWindow((Stage) ChooseMenuButton.getScene().getWindow(), "PupilFile", getClass());

    }
    
    /**
     * Initialize.
     */
    @FXML
    void initialize() {
        assert ChooseMenuButton != null : "fx:id=\"ChooseMenuButton\" was not injected: check your FXML file 'PupilMainWindow.fxml'.";
        assert PupilMenuLable != null : "fx:id=\"PupilMenuLable\" was not injected: check your FXML file 'PupilMainWindow.fxml'.";
        assert LogOutButton != null : "fx:id=\"LogOutButton\" was not injected: check your FXML file 'PupilMainWindow.fxml'.";
        assert uploadAss != null : "fx:id=\"uploadAss\" was not injected: check your FXML file 'PupilMainWindow.fxml'.";
        assert PupilFile != null : "fx:id=\"PupilFile\" was not injected: check your FXML file 'PupilMainWindow.fxml'.";
        assert ChooseOperationLable != null : "fx:id=\"ChooseOperationLable\" was not injected: check your FXML file 'PupilMainWindow.fxml'.";

        Main.client.controller=this; 
        loadPupil();
    }

 /**
  * Load pupil.
  */
 void loadPupil()
 {
  ArrayList<String> data = new ArrayList<String>();
  data.add("Client Pupil");
  data.add("select");
  data.add("pupil");
  data.add("userID");
  data.add(Main.userId);

  try
  {
   Main.client.sendToServer(data);
  }
  catch (IOException e)
  {
   e.printStackTrace();
  }
 }

 
 /* (non-Javadoc)
  * @see interfaces.IController#handleAnswer(java.lang.Object)
  */
 @Override
 public void handleAnswer(Object result) {
  if (result == null)
  {
   // error

   return;
  }
  ArrayList<String> arr = (ArrayList<String>) result;
  String type = arr.remove(0);
  if (type.equals("Client Pupil"))
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
  }
 }
}