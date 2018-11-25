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
import src.DataModels.Project;
import src.DataModels.Task;

/**
 * @author Rodri
 * @author Dorian
 * @author Luis
 */
public class ProjectTasksUI {

    private Stage window;
    private Project project;
    private VBox body;
    private Text backLink;
    private BorderPane header;
    private Text title;
    private Button addTaskButton;
    private Scene scene;
    private VBox tasksContainer;

    public ProjectTasksUI(Stage window, Project project) {
        this.window = window;
        this.project = project;
        setUpLayout();
        setUpBackLink();
        setUpHeader();
        setUpTasks();
        buildScene();
    }

    private void setUpLayout() {
        body = new VBox();
        body.setSpacing(10);
        body.setPadding(new Insets(30, 80, 30, 80));
    }

    private void setUpBackLink() {
        backLink = new Text("Go back to projects");
        backLink.setFill(Color.web("#4285f4"));
        backLink.setCursor(Cursor.HAND);
        backLink.setOnMouseEntered(e -> backLink.setUnderline(true));
        backLink.setOnMouseExited(e -> backLink.setUnderline(false));
    }

    private void setUpHeader() {
        header = new BorderPane();
        title = new Text(project.getName());
        title.setFont(new Font(34));
        addTaskButton = new Button("Add Task");

        addTaskButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"), CornerRadii.EMPTY, Insets.EMPTY)));
        addTaskButton.setAlignment(Pos.CENTER);
        addTaskButton.setMinSize(150, 30);
        addTaskButton.setCursor(Cursor.HAND);
        addTaskButton.setTextFill(Color.WHITE);
        addTaskButton.setOnMouseEntered(e -> addTaskButton.setBackground(new Background(new BackgroundFill(Color.web("#67a0fd"), CornerRadii.EMPTY, Insets.EMPTY))));
        addTaskButton.setOnMouseExited(e -> addTaskButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"), CornerRadii.EMPTY, Insets.EMPTY))));

        addTaskButton.setOnAction(e -> showCreateTaskForm());

        header.setLeft(title);

        VBox btnContainer = new VBox();
        btnContainer.setPadding(new Insets(10, 0, 0, 0));
        btnContainer.getChildren().add(addTaskButton);
        header.setRight(btnContainer);
    }

    private BorderPane createTaskItem(Task task) {
        BorderPane item = new BorderPane();
        item.setPadding(new Insets(10));
        item.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        item.setBorder(new Border(new BorderStroke(Color.web("#cecece"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        item.setMinHeight(40);
        item.setCursor(Cursor.HAND);

        item.setOnMouseEntered(e -> item.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY))));
        item.setOnMouseExited(e -> item.setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY))));

        Text taskTitleLabel = new Text(task.getTitle());
        taskTitleLabel.setFont(new Font(16));
        Text taskDescriptionLabel = new Text(task.getDescription());
        taskDescriptionLabel.setFill(Color.web("#545454"));

        Text tasksDateLabel = new Text(task.getDay() + "/" + task.getMonth() + "/" + task.getYear());

        VBox nameContainer = new VBox();
        VBox dateContainer = new VBox();

        nameContainer.setPadding(new Insets(0, 0, 0, 20));
        nameContainer.setAlignment(Pos.CENTER_LEFT);
        nameContainer.getChildren().addAll(taskTitleLabel, taskDescriptionLabel);

        dateContainer.setAlignment(Pos.CENTER_RIGHT);
        dateContainer.setPadding(new Insets(0, 20, 0, 0));
        dateContainer.getChildren().add(tasksDateLabel);

        item.setLeft(nameContainer);
        item.setRight(dateContainer);

        return item;
    }

    private void setUpTasks() {
        tasksContainer = new VBox();
        tasksContainer.setSpacing(5);
        tasksContainer.setPadding(new Insets(30, 0, 30, 0));

        for (int t = 0; t < project.getTasks().getLength(); t++) {
            tasksContainer.getChildren().add(createTaskItem(project.getTasks().getTask(t)));
        }
    }

    private void buildScene() {
        body.getChildren().addAll(backLink, header, tasksContainer);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(body);
        scene = new Scene(scrollPane);
    }

    public void show() {
        window.hide();
        window.setTitle("Tasker - " + project.getName());
        window.setWidth(800);
        window.setHeight(500);
        window.setResizable(false);
        window.setScene(scene);
        window.show();
    }

    public Button getAddTaskButton() {
        return addTaskButton;
    }

    private void showCreateTaskForm() {
        CreateTaskUI createTask = new CreateTaskUI(window);
        createTask.getCreateTaskButton().setOnAction(e -> {
            if (createTask.validateForm()) {
                Task task = new Task(createTask.getTaskTitleField(), createTask.getTaskDescriptionField(), createTask.getPriorityField(), createTask.getProjectDateField().getDayOfMonth(), createTask.getProjectDateField().getMonthValue(), createTask.getProjectDateField().getYear());
                project.getTasks().enqueue(task);
                ProjectTasksUI refreshed = new ProjectTasksUI(window, project);
                refreshed.getBackLink().setOnMouseClicked(backLink.getOnMouseClicked());
                refreshed.show();
            } else {
                ModalUI.alert(createTask.getModalWindow(), "Please fill all the fields correctly");
            }
        });
        createTask.show();
    }

    public Text getBackLink() {
        return backLink;
    }
    
    

}
