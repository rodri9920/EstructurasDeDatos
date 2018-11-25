package src;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import src.AppUI.ModalUI;
import src.AppUI.ProjectsUI;
import src.AppUI.SignInUI;
import src.AppUI.SignUpUI;
import src.AppUI.CreateProjectForm;

public class App extends Application {

    private Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {
        this.window = window;
        window.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("res/icon.png")));
        showSignIn();
    }

    public void showSignIn() {
        SignInUI signInWindow = new SignInUI(window);
        signInWindow.getCreateAnAccount().setOnMouseClicked(e -> showSignUp());
        signInWindow.getSignInButton().setOnAction(e -> {
            if (signInWindow.validateForm()) {
                signIn(signInWindow.getUserNameField().getText(), signInWindow.getPasswordField().getText());
            } else {
                ModalUI.alert(window, "Please fill the fields!");
            }
        });
        signInWindow.show();
    }

    public void showSignUp() {
        SignUpUI signUpWindow = new SignUpUI(window);
        signUpWindow.getSignInLink().setOnMouseClicked(e -> showSignIn());
        signUpWindow.getSignUpButton().setOnAction(e -> {
            if (signUpWindow.validateForm()) {
                signUp(signUpWindow.getUserNameField().getText(), signUpWindow.getPasswordField().getText());
            } else {
                ModalUI.alert(window, "Please fill the fields!");
            }
        });
        signUpWindow.show();
    }

    public void showProjects() {
        ProjectsUI projectsWindow = new ProjectsUI(window);
        projectsWindow.getAddNewProjectButton().setOnAction(e -> showCreateNewProjectForm());
        projectsWindow.show();
    }
    
    public void showCreateNewProjectForm(){
        CreateProjectForm projectForm = new CreateProjectForm(window);
        projectForm.getCreateProjectButton().setOnAction(e -> {
            if(!projectForm.getProjectNameField().getText().isEmpty()){                
                createProject(projectForm.getProjectNameField().getText());
                projectForm.getModalWindow().close();
            }else{
                ModalUI.alert(projectForm.getModalWindow(), "Please insert a Project name");
            }
        });
        projectForm.show();
    }        

    public void signIn(String username, String password) {
        showProjects();
    }

    public void signUp(String username, String password) {
        showProjects();
    }
    
    public void createProject(String name){
        
    }
}
