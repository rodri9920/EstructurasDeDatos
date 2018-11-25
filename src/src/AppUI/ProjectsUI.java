package src.AppUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
    private BorderPane header;
    private Text title;
    private Button addNewProjectButton;
    private Scene scene;
    private VBox projectsContainer;
    

    public ProjectsUI(Stage window, Stack projects) {
        this.window = window;
        this.projects = projects;
        setUpLayout();
        setUpHeader();
        setUpProjects();
        buildScene();
    }

    private void setUpLayout() {
        body = new VBox();
        body.setSpacing(30);
        body.setPadding(new Insets(30, 80, 30, 80));
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
    
    private void setUpProjects() {
        projectsContainer = new VBox();
        projectsContainer.setSpacing(5);
        
        for(int p = 0; p < projects.getLength(); p++){
            Project project = projects.getProject(p);
            ProjectItemUI projectItem = new ProjectItemUI(window, project);
            projectsContainer.getChildren().add(projectItem);
        }                
    }

    private void buildScene() {
        body.getChildren().addAll(header, projectsContainer);
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
