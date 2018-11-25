package src.AppUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.App;
import src.DataModels.Project;
import src.DataStructures.Stack;

/**
 * @author Rodri
 * @author Dorian
 * @author Luis
 */
public class ProjectsUI {
    
    private Stage window;
    private Stack projects;
    private VBox body;
    private Text signOutLink;
    private BorderPane header;
    private Text title;
    private Button addNewProjectButton;
    private Scene scene;
    private VBox projectsContainer;
    

    public ProjectsUI(Stage window, Stack projects) {
        this.window = window;
        this.projects = projects;
        setUpLayout();
        setUpBackLink();
        setUpHeader();
        setUpProjects();
        buildScene();
    }

    private void setUpLayout() {
        body = new VBox();
        body.setSpacing(10);
        body.setPadding(new Insets(30, 80, 30, 80));
    }
    
    private void setUpBackLink() {
        signOutLink = new Text("Sign out");
        signOutLink.setFill(Color.web("#4285f4"));
        signOutLink.setCursor(Cursor.HAND);
        signOutLink.setOnMouseEntered(e -> signOutLink.setUnderline(true));
        signOutLink.setOnMouseExited(e -> signOutLink.setUnderline(false));
        signOutLink.setOnMouseClicked(e -> App.signOut());
    }

    private void setUpHeader() {
        header = new BorderPane();
        title = new Text("Your Projects");
        title.setFont(new Font(34));
        addNewProjectButton = new Button("Add a new Project");

        addNewProjectButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"), CornerRadii.EMPTY, Insets.EMPTY)));
        addNewProjectButton.setAlignment(Pos.CENTER);
        addNewProjectButton.setMinSize(150, 30);
        addNewProjectButton.setCursor(Cursor.HAND);
        addNewProjectButton.setTextFill(Color.WHITE);
        addNewProjectButton.setOnMouseEntered(e -> addNewProjectButton.setBackground(new Background(new BackgroundFill(Color.web("#67a0fd"), CornerRadii.EMPTY, Insets.EMPTY))));
        addNewProjectButton.setOnMouseExited(e -> addNewProjectButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"), CornerRadii.EMPTY, Insets.EMPTY))));

        header.setLeft(title);

        VBox btnContainer = new VBox();
        btnContainer.setPadding(new Insets(10, 0, 0, 0));
        btnContainer.getChildren().add(addNewProjectButton);
        header.setRight(btnContainer);
    }
    
    private BorderPane createProjectItem(Project project){
        BorderPane item = new BorderPane();
        item.setPadding(new Insets(10));
        item.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        item.setBorder(new Border(new BorderStroke(Color.web("#cecece"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        item.setMinHeight(40);
        item.setCursor(Cursor.HAND);

        item.setOnMouseEntered(e -> item.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY))));
        item.setOnMouseExited(e -> item.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY))));

        Text projectNameLabel = new Text(project.getName());
        projectNameLabel.setFont(new Font(16));
        Text projectDescriptionLabel = new Text(project.getDescription());
        projectDescriptionLabel.setFill(Color.web("#545454"));
        
        Text tasksCountLabel = new Text(String.valueOf(project.getTasks().getLength()));
        
        VBox nameContainer = new VBox();
        VBox countsContainer = new VBox();

        nameContainer.setPadding(new Insets(0, 0, 0, 20));
        nameContainer.setAlignment(Pos.CENTER_LEFT);
        nameContainer.getChildren().addAll(projectNameLabel, projectDescriptionLabel);

        countsContainer.setAlignment(Pos.CENTER_RIGHT);
        countsContainer.setPadding(new Insets(0, 20, 0, 0));
        countsContainer.getChildren().add(tasksCountLabel);

        item.setLeft(nameContainer);
        item.setRight(countsContainer);
        
        return item;
    }
    
    private void setUpProjects() {
        projectsContainer = new VBox();
        projectsContainer.setSpacing(5);
        projectsContainer.setPadding(new Insets(30, 0, 30, 0));
        for(int p = 0; p < projects.getLength(); p++){
            Project project = projects.getProject(p);
            BorderPane projectItem = createProjectItem(project);
            projectItem.setOnMouseClicked(e -> {
                ProjectTasksUI projectTasksWindow = new ProjectTasksUI(window, project);
                projectTasksWindow.getBackLink().setOnMouseClicked(ev->{
                    show();
                });
                projectTasksWindow.show();
            });
            projectsContainer.getChildren().add(projectItem);
        }                
    }

    private void buildScene() {
        body.getChildren().addAll(signOutLink, header, projectsContainer);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(body);
        scene = new Scene(scrollPane);
    }

    public void show() {
        window.hide();
        window.setTitle("Tasker - Your Projects");
        window.setWidth(800);
        window.setHeight(500);
        window.setResizable(false);
        window.setScene(scene);
        window.show();
    }

    public Button getAddNewProjectButton() {
        return addNewProjectButton;
    }        
    
}
