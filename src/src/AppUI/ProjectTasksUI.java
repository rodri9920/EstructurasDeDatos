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

/**
 * @author Rodri
 * @author Dorian
 * @author Luis
 */
public class ProjectTasksUI {

    Stage window;
    VBox body;
    BorderPane header;
    Text title;
    Button addTaskButton;
    Scene scene;
    VBox tasksContainer;

    public ProjectTasksUI(Stage window) {
        this.window = window;
        setUpLayout();
        setUpHeader();
        setUpTasks();
        buildScene();
    }

    private void setUpLayout() {
        body = new VBox();
        body.setSpacing(30);
        body.setPadding(new Insets(30, 80, 30, 80));
    }

    private void setUpHeader() {
        header = new BorderPane();
        title = new Text("Project's name");
        title.setFont(new Font(34));
        addTaskButton = new Button("Add Task");

        addTaskButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"), CornerRadii.EMPTY, Insets.EMPTY)));
        addTaskButton.setAlignment(Pos.CENTER);
        addTaskButton.setMinSize(150, 30);
        addTaskButton.setCursor(Cursor.HAND);
        addTaskButton.setTextFill(Color.WHITE);
        addTaskButton.setOnMouseEntered(e -> addTaskButton.setBackground(new Background(new BackgroundFill(Color.web("#67a0fd"), CornerRadii.EMPTY, Insets.EMPTY))));
        addTaskButton.setOnMouseExited(e -> addTaskButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"), CornerRadii.EMPTY, Insets.EMPTY))));

        header.setLeft(title);

        VBox btnContainer = new VBox();
        btnContainer.setPadding(new Insets(10, 0, 0, 0));
        btnContainer.getChildren().add(addTaskButton);
        header.setRight(btnContainer);
    }

    private BorderPane createTaskItem(String projectName, String priority) {
        BorderPane item = new BorderPane();
        item.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        item.setBorder(new Border(new BorderStroke(Color.web("#cecece"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        item.setMinHeight(40);
        item.setCursor(Cursor.HAND);

        item.setOnMouseEntered(e -> item.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY))));
        item.setOnMouseExited(e -> item.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY))));

        Text projectNameLabel = new Text(projectName);
        projectNameLabel.setFont(new Font(14));
        Text tasksCountLabel = new Text(priority);

        VBox nameContainer = new VBox();
        VBox countsContainer = new VBox();

        nameContainer.setPadding(new Insets(0, 0, 0, 20));
        nameContainer.setAlignment(Pos.CENTER_LEFT);
        nameContainer.getChildren().add(projectNameLabel);

        countsContainer.setAlignment(Pos.CENTER_RIGHT);
        countsContainer.setPadding(new Insets(0, 20, 0, 0));
        countsContainer.getChildren().add(tasksCountLabel);

        item.setLeft(nameContainer);
        item.setRight(countsContainer);

        return item;
    }

    private void setUpTasks() {
        tasksContainer = new VBox();
        tasksContainer.setSpacing(5);
        // For testing
        tasksContainer.getChildren().addAll(
            createTaskItem("Task 1", "Very High"),
            createTaskItem("Task 2", "High"),
            createTaskItem("Task 3", "Medium"),
            createTaskItem("Task 4", "Low")
        );
    }

    private void buildScene() {
        body.getChildren().addAll(header, tasksContainer);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(body);
        scene = new Scene(scrollPane);
    }

    public void show() {
        window.hide();
        window.setTitle("Tasker - Project's name");
        window.setWidth(800);
        window.setHeight(500);
        window.setResizable(false);
        window.setScene(scene);
        window.show();
    }

    public Button getAddTaskButton() {
        return addTaskButton;
    }
    
}
