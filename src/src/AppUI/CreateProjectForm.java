/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.AppUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Marco
 */
public class CreateProjectForm {
    private Stage window;    
    private VBox body;
    private Text title;
    private VBox formContainer;
    private Text projectNameLabel;
    private TextField projectNameField;
    private Button createProjectButton;
    private Scene scene;
    
    
    public CreateProjectForm(Stage window) {
        this.window = window;
        setUpLayout();
        setUpTitle();
        setUpForm();
    }
    
    private void setUpLayout(){
        body = new VBox();        
        body.setAlignment(Pos.TOP_LEFT);
        body.setPadding(new Insets(50, 80, 50, 80));
        body.setSpacing(30);
    }
    
    private void setUpTitle(){
        title = new Text("Create a new Project");
        title.setFont(new Font(24));
    }
    
    private void setUpForm(){
        formContainer = new VBox();
        formContainer.setMaxWidth(400);
        formContainer.setAlignment(Pos.TOP_LEFT);    
        formContainer.setSpacing(10);
        
        projectNameLabel = new Text("Project name");        
        projectNameField = new TextField();
        projectNameField.setMaxWidth(400);
        formContainer.getChildren().addAll(projectNameLabel, projectNameField);        
        
        createProjectButton = new Button("Create project");
        createProjectButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"), CornerRadii.EMPTY, Insets.EMPTY)));
        createProjectButton.setAlignment(Pos.CENTER);
        createProjectButton.setMaxSize(500, 30);
        createProjectButton.setCursor(Cursor.HAND);
        createProjectButton.setTextFill(Color.WHITE);
        createProjectButton.setOnMouseEntered(e -> createProjectButton.setBackground(new Background(new BackgroundFill(Color.web("#67a0fd"), CornerRadii.EMPTY, Insets.EMPTY))));
        createProjectButton.setOnMouseExited(e -> createProjectButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"), CornerRadii.EMPTY, Insets.EMPTY))));                
    }
    
    
    public void show(){
        window.hide();                
        window.setHeight(300);
        window.setWidth(500);
        body.getChildren().addAll(title, formContainer, createProjectButton);        
        
        scene = new Scene(body);
        window.setScene(scene);
        window.show();
    }
    
}
