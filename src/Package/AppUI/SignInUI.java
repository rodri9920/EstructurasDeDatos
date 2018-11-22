package Package.AppUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class SignInUI extends Application {

    private Stage window;
    private Scene scene;
    private Text title;
    private VBox bodyBox;
    private VBox formContainer;
    private Text userNameFieldLabel;
    private Text passwordFieldLabel;
    private TextField userNameField;    
    private PasswordField passwordField;
    private Text createAnAccount;
    private Button signInButton;

    public SignInUI() {

    }

    @Override
    public void start(Stage window) {
        setUpWindow(window);
        setUpLayout();
        setUpTitle();
        setUpForm();
        setUpCreateAnAccount();
        buildUI();
    }
    
    private void addToBody(Node component){
        bodyBox.getChildren().add(component);
    }

    private void buildUI() {       
        addToBody(title);
        addToBody(formContainer);   
        addToBody(createAnAccount);
        scene = new Scene(bodyBox);
        window.setScene(scene);
        window.show();
    }
    
    private void setUpWindow(Stage window){
        this.window = window;
        window.setTitle("Sign In");
        window.setMinWidth(600);
        window.setMinHeight(400);
        window.setResizable(false);
    }

    private void setUpLayout() {
        bodyBox = new VBox();
        bodyBox.setAlignment(Pos.TOP_CENTER);
        bodyBox.setPadding(new Insets(30));
    }

    private void setUpTitle() {
        title = new Text("Sign In");
        title.setFont(new Font(34));
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
        signInButton = new Button("Sign In"); 
        
        userNameField.setMaxWidth(300);        
        passwordField.setMaxWidth(300);                        
               
        signInButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"),CornerRadii.EMPTY, Insets.EMPTY)));
        signInButton.setAlignment(Pos.CENTER);
        signInButton.setMinSize(300, 30);        
        signInButton.setCursor(Cursor.HAND);
        signInButton.setTextFill(Color.WHITE);
        signInButton.setOnMouseEntered(e -> signInButton.setBackground(new Background(new BackgroundFill(Color.web("#67a0fd"),CornerRadii.EMPTY, Insets.EMPTY))));
        signInButton.setOnMouseExited(e -> signInButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"),CornerRadii.EMPTY, Insets.EMPTY))));
        
        formContainer.getChildren().addAll(userNameFieldLabel, userNameField, passwordFieldLabel, passwordField, new Text(), signInButton);
    }
    
    private void setUpCreateAnAccount(){
        createAnAccount = new Text("Create an account");
        createAnAccount.setFill(Color.web("#4285f4"));  
        createAnAccount.setCursor(Cursor.HAND);
        createAnAccount.setOnMouseEntered(e -> createAnAccount.setUnderline(true));
        createAnAccount.setOnMouseExited(e -> createAnAccount.setUnderline(false));
    }
   
}
