package src;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import src.AppUI.CreateProjectUI;
import src.AppUI.ModalUI;
import src.AppUI.ProjectsUI;
import src.AppUI.SignInUI;
import src.AppUI.SignUpUI;
import src.DataModels.Project;
import src.DataModels.User;
import src.AppUI.CreateTaskUI;
import src.DataStructures.UserList;

public class App extends Application {

    private static Stage window;
    private static UserList users;
    private static User signedUser;

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

    public static void showSignIn() {
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

    public static void showSignUp() {
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

    public static void showProjects() {
        ProjectsUI projectsWindow = new ProjectsUI(window, signedUser.getProjects());
        projectsWindow.getAddNewProjectButton().setOnAction(e -> showCreateProject());
        projectsWindow.show();
    }
    
    public static void showCreateTask(){
        CreateTaskUI createTaskForm = new CreateTaskUI(window);
        createTaskForm.getCreateTaskButton().setOnAction(e -> {
            if(createTaskForm.validateForm()){                
                // CREATE TASK
                createTaskForm.getModalWindow().close();
            }else{
                ModalUI.alert(createTaskForm.getModalWindow(), "Please fill all the information correctly");
            }
        });
        createTaskForm.show();
    }   
    
    public static void showCreateProject(){
        CreateProjectUI createProjectForm = new CreateProjectUI(window);
        createProjectForm.getCreateProjectButton().setOnAction(e -> {
            if(createProjectForm.validateForm()){             
                if(createProject(createProjectForm.getProjectTitleField(), createProjectForm.getProjectDescriptionField(), createProjectForm.getPriorityField())){                    
                    createProjectForm.getModalWindow().close();
                    showProjects();
                }else{
                    ModalUI.alert(createProjectForm.getModalWindow(), "A project with title "+createProjectForm.getProjectTitleField()+" already exists");
                }                
            }else{
                ModalUI.alert(createProjectForm.getModalWindow(), "Please fill all the information correctly");
            }
        });
        createProjectForm.show();
    }

    public static void signIn(String username, String password) {
        User user = users.signIn(username, password);
        if(user != null){
            ModalUI.alert(window, "Signed in succesfully");
            signedUser = user;
            showProjects();
        }else{
            ModalUI.alert(window, "That username does not exist");
        }
    }

    public static void signUp(String username, String password) {
        User user = new User(username, password);
        if(users.add(user)){
            ModalUI.alert(window, "User created succesfully");
            signedUser = user;
            showProjects();
        }else{
            ModalUI.alert(window, "This user already exists");
        }     
    }
    
    public static boolean createProject(String name, String descripton, int priority){
        Project project = new Project(name, descripton, priority);
        return signedUser.getProjects().push(project);        
    }
    
    public static void signOut(){
        signedUser = null;
        showSignIn();
    }
}
