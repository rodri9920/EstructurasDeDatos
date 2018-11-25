package src.AppUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Rodri
 * @author Dorian
 * @author Luis
 */
public class CreateProjectUI {
    private Stage modalWindow;
    private Stage window;
    private VBox body;
    private Text title;
    private VBox formContainer;
    private Text projectTitleLabel;
    private TextField projectTitleField;
    private Text projectDescriptionLabel;
    private TextArea projectDescriptionField;
    private Text priorityLabel;
    private ComboBox priorityComboBox;
    private Button createProjectButton;
    private Scene scene;        
    
    public CreateProjectUI(Stage window) {
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
        title = new Text("Create a Project");
        title.setFont(new Font(24));
    }
    
    private void setUpForm(){
        formContainer = new VBox();
        formContainer.setMaxWidth(400);
        formContainer.setAlignment(Pos.TOP_LEFT);    
        formContainer.setSpacing(10);
        
        projectTitleLabel = new Text("Title");        
        projectTitleField = new TextField();
        projectTitleField.setMaxWidth(400);
        
        projectDescriptionLabel = new Text("Description");
        projectDescriptionField = new TextArea();
        projectDescriptionField.setMaxWidth(400);
        
        priorityLabel = new Text("Priority");
        priorityComboBox = new ComboBox();
        priorityComboBox.setMaxWidth(400);
        priorityComboBox.getItems().addAll("Low", "Medium", "High", "Very High");
        priorityComboBox.setValue("Select a priority");        
         
        
        formContainer.getChildren().addAll(projectTitleLabel, projectTitleField, projectDescriptionLabel, projectDescriptionField, priorityLabel, priorityComboBox);  
        
        createProjectButton = new Button("Create Project");
        createProjectButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"), CornerRadii.EMPTY, Insets.EMPTY)));
        createProjectButton.setAlignment(Pos.CENTER);
        createProjectButton.setMaxSize(500, 30);
        createProjectButton.setCursor(Cursor.HAND);
        createProjectButton.setTextFill(Color.WHITE);
        createProjectButton.setOnMouseEntered(e -> createProjectButton.setBackground(new Background(new BackgroundFill(Color.web("#67a0fd"), CornerRadii.EMPTY, Insets.EMPTY))));
        createProjectButton.setOnMouseExited(e -> createProjectButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"), CornerRadii.EMPTY, Insets.EMPTY))));                
    }
    
    
    public void show(){
        modalWindow = new Stage();
        modalWindow.setHeight(450);
        modalWindow.setWidth(500);                                   
        body.getChildren().addAll(title, formContainer, createProjectButton);                
        scene = new Scene(body);
        modalWindow.setScene(scene);
        
        modalWindow.initModality(Modality.APPLICATION_MODAL);
        modalWindow.initOwner(window);        
        modalWindow.getIcons().add(window.getIcons().get(0));
        modalWindow.setTitle("Tasker - Create a Project");
        
        modalWindow.showAndWait();
    }

    public String getProjectTitleField() {
        return projectTitleField.getText();
    }  
    
    public String getProjectDescriptionField(){
        return projectDescriptionField.getText();
    }

    public Button getCreateProjectButton() {
        return createProjectButton;
    }

    public Stage getModalWindow() {
        return modalWindow;
    }
    
    public int getPriorityField(){
        String selectedItem = (String) priorityComboBox.getValue();

        if(selectedItem.equals("Very High")) return 1;
        
        if(selectedItem.equals("High")) return 2;
        
        if(selectedItem.equals("Medium")) return 3;
        
        if(selectedItem.equals("Low")) return 4;
        
        return -1;
    }
    
    public boolean validateForm(){
        return !getProjectTitleField().isEmpty() && !getProjectDescriptionField().isEmpty() && getPriorityField() != -1;
    }
}
