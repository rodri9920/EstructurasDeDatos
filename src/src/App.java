package src;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import src.AppUI.ModalUI;
import src.AppUI.ProjectsUI;
import src.AppUI.SignInUI;
import src.AppUI.SignUpUI;
import src.AppUI.CreateProjectForm;
import src.DataModels.Project;
import src.DataModels.User;
import src.DataStructures.UserList;

public class App extends Application {

    private Stage window;
    private UserList users;
    private User signedUser;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {
        this.window = window;
        users = new UserList();
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
        CreateProjectForm projectForm = new CreateProjectForm(window);
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
        User user = users.signIn(username, password);
        if(user != null){
            ModalUI.alert(window, "Signed in succesfully");
            signedUser = user;
            showProjects();
        }else{
            ModalUI.alert(window, "That username does not exist");
        }
    }

    public void signUp(String username, String password) {
        User user = new User(username, password);
        if(users.add(user)){
            ModalUI.alert(window, "User created succesfully");
            signedUser = user;
            showProjects();
        }else{
            ModalUI.alert(window, "This user already exists");
        }     
    }
    
    public void createProject(String name, String descripton, int priority){
        System.out.println("******************************");
        for(int i=0; i<signedUser.getProjects().getLength(); i++){
            System.out.println(signedUser.getProjects().getProject(i));
        }
        Project project = new Project(name, descripton, priority);
        signedUser.getProjects().push(project);
        
    }
}
