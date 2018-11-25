package src;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import src.AppUI.ModalUI;
import src.AppUI.ProjectsUI;
import src.AppUI.SignInUI;
import src.AppUI.SignUpUI;
import src.DataModels.Project;
import src.DataModels.User;
import src.AppUI.CreateProjectUI;

public class App extends Application {

    private Stage window;

    public static void main(String[] args) {
        launch(args);
        User user = new User("Pepe", "555");
        user.getProjects().enqueue(new Project("Jaja", 4, 0, 0, 0));
        System.out.println(user.getProjects().getProject("Jaj").getName());
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
                signIn(signInWindow.getUserNameField(), signInWindow.getPasswordField());
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
                signUp(signUpWindow.getUserNameField(), signUpWindow.getPasswordField());
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
        CreateProjectUI projectForm = new CreateProjectUI(window);
        projectForm.getCreateProjectButton().setOnAction(e -> {
            if(projectForm.validateForm()){                
                createProject(projectForm.getProjectNameField(), projectForm.getPriorityField(),  projectForm.getProjectDateField().getDayOfMonth(),  projectForm.getProjectDateField().getMonthValue(), projectForm.getProjectDateField().getYear());
                projectForm.getModalWindow().close();
            }else{
                ModalUI.alert(projectForm.getModalWindow(), "Please fill all the information");
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
    
    public void createProject(String name, int priority, int day, int month, int year){
        
    }
}
