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
public class SignInUI {

    private Scene scene;
    private Text title;
    private VBox bodyBox;
    private VBox formContainer;
    private Text userNameFieldLabel;
    private Text passwordFieldLabel;
    private TextField userNameField;
    private PasswordField passwordField;
    private Label createAnAccount;
    private Button signInButton;
    private Stage window;

    public SignInUI(Stage window) {
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
        title = new Text("Sign In");
        title.setFont(new Font(34));
    }

    private void setUpForm() {
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

        signInButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"), CornerRadii.EMPTY, Insets.EMPTY)));
        signInButton.setAlignment(Pos.CENTER);
        signInButton.setMinSize(300, 30);
        signInButton.setCursor(Cursor.HAND);
        signInButton.setTextFill(Color.WHITE);
        signInButton.setOnMouseEntered(e -> signInButton.setBackground(new Background(new BackgroundFill(Color.web("#67a0fd"), CornerRadii.EMPTY, Insets.EMPTY))));
        signInButton.setOnMouseExited(e -> signInButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"), CornerRadii.EMPTY, Insets.EMPTY))));

        formContainer.getChildren().addAll(userNameFieldLabel, userNameField, passwordFieldLabel, passwordField, new Text(), signInButton);
    }

    private void setUpCreateAnAccount() {
        createAnAccount = new Label("Don't have an account? Sign Up");
        createAnAccount.setTextFill(Color.web("#4285f4"));
        createAnAccount.setCursor(Cursor.HAND);
        createAnAccount.setOnMouseEntered(e -> createAnAccount.setUnderline(true));
        createAnAccount.setOnMouseExited(e -> createAnAccount.setUnderline(false));
    }

    private void buildScene() {
        bodyBox.getChildren().addAll(title, formContainer, createAnAccount);
        scene = new Scene(bodyBox);
    }

    public void show() {
        window.hide();
        window.setTitle("Tasker - Sign In");
        window.setWidth(600);
        window.setHeight(400);
        window.setResizable(false);
        window.setScene(scene);
        window.show();
    }

    public String getUserNameField() {
        return userNameField.getText();
    }

    public String getPasswordField() {
        return passwordField.getText();
    }

    public Button getSignInButton() {
        return signInButton;
    }

    public Label getCreateAnAccount() {
        return createAnAccount;
    }

    public void cleanForm() {
        userNameField.setText("");
        passwordField.setText("");
    }

    public boolean validateForm() {
        return !userNameField.getText().isEmpty() && !passwordField.getText().isEmpty();
    }
}
