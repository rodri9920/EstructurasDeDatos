package src.AppUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
 * @author dcortes
 */
public class SignUpUI{

    private Scene scene;
    private Text title;
    private Text header;
    private VBox bodyBox;
    private VBox formContainer;
    private Text userNameFieldLabel;
    private Text passwordFieldLabel;
    private TextField userNameField;    
    private PasswordField passwordField;
    private Label signInLink;
    private Button signUpButton;
    private Stage window;

    public SignUpUI(Stage window) {      
        this.window = window;
        setUpLayout();
        setUpTitle();
        setUpForm();
        setUpCreateAnAccount();
        buildScene();
    }
    
    private void setUpLayout() {
        bodyBox = new VBox();
        bodyBox.setAlignment(Pos.TOP_CENTER);
        bodyBox.setPadding(new Insets(30));
    }
    
    private void setUpTitle() {
        title = new Text("Sign Up");
        title.setFont(new Font(34));
        header = new Text("Create an account to start using Tasker!");        
    }
    
    private void setUpForm(){
        formContainer = new VBox();
        formContainer.setSpacing(10);
        formContainer.setMaxWidth(300);
        formContainer.setAlignment(Pos.TOP_LEFT);
        formContainer.setPadding(new Insets(35, 0, 10, 0));
        
        userNameFieldLabel = new Text("Username");
        passwordFieldLabel = new Text("Password");                  
        userNameField = new TextField();                        
        passwordField = new PasswordField();  
        signUpButton = new Button("Sign Up");        
        
        userNameField.setMaxWidth(300);        
        passwordField.setMaxWidth(300);                        
               
        signUpButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"),CornerRadii.EMPTY, Insets.EMPTY)));
        signUpButton.setAlignment(Pos.CENTER);
        signUpButton.setMinSize(300, 30);        
        signUpButton.setCursor(Cursor.HAND);
        signUpButton.setTextFill(Color.WHITE);
        signUpButton.setOnMouseEntered(e -> signUpButton.setBackground(new Background(new BackgroundFill(Color.web("#67a0fd"),CornerRadii.EMPTY, Insets.EMPTY))));
        signUpButton.setOnMouseExited(e -> signUpButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"),CornerRadii.EMPTY, Insets.EMPTY))));
        
        formContainer.getChildren().addAll(userNameFieldLabel, userNameField, passwordFieldLabel, passwordField, new Text(), signUpButton);
    }
    
    private void setUpCreateAnAccount(){
        signInLink = new Label("Already have an account? Sign In");
        signInLink.setTextFill(Color.web("#4285f4")); 
        signInLink.setCursor(Cursor.HAND);
        signInLink.setOnMouseEntered(e -> signInLink.setUnderline(true));
        signInLink.setOnMouseExited(e -> signInLink.setUnderline(false));
    }
    
    private void buildScene() {   
        bodyBox.getChildren().addAll(title, header, formContainer, signInLink);
        scene = new Scene(bodyBox);                
    }            
   
    public void show(){
        window.hide();
        window.setTitle("Tasker - Sign Up");
        window.setMinWidth(600);
        window.setMinHeight(400);
        window.setResizable(false);
        window.setScene(scene);
        window.show();
    }

    public TextField getUserNameField() {
        return userNameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getSignUpButton() {
        return signUpButton;
    }

    public Label getSignInLink() {
        return signInLink;
    }
    
    public void cleanForm(){
        userNameField.setText("");
        passwordField.setText("");
    }
        
    public boolean validateForm(){
        return !userNameField.getText().isEmpty() &&  !passwordField.getText().isEmpty();
    }    
}
