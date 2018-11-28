package src.AppUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.App;
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
    private BorderPane preHeader;
    private Text backLink;
    private Text removeProjectButton;
    
    private BorderPane header;
    private Text title;
    private Button addTaskButton;
    private Scene scene;
    private VBox tasksContainer;

    /**
     * Creates a Project Tasks Window
     * 
     * @param window 
     * @param project 
     */
    public ProjectTasksUI(Stage window, Project project) {
        this.window = window;
        this.project = project;
        setUpLayout();
        setUpPreHeader();
        setUpHeader();
        setUpTasks();
        buildScene();
    }

    private void setUpLayout() {
        body = new VBox();
        body.setSpacing(10);
        body.setPadding(new Insets(30, 80, 30, 80));
    }

    
    private void setUpPreHeader() {
        preHeader = new BorderPane();                
        
        backLink = new Text("Go back to projects");
        backLink.setFill(Color.web("#4285f4"));
        backLink.setCursor(Cursor.HAND);
        backLink.setOnMouseEntered(e -> backLink.setUnderline(true));
        backLink.setOnMouseExited(e -> backLink.setUnderline(false));
        backLink.setOnMouseClicked(e -> App.showProjects());
        
        
        removeProjectButton = new Text("Remove project");
        
        removeProjectButton.setFill(Color.web("#4285f4"));
        removeProjectButton.setCursor(Cursor.HAND);
        removeProjectButton.setOnMouseEntered(e -> removeProjectButton.setUnderline(true));
        removeProjectButton.setOnMouseExited(e -> removeProjectButton.setUnderline(false));
        removeProjectButton.setOnMouseClicked(e -> ModalUI.ask(window, "Are you sure you want to delete this project?", ev -> {
           App.signedUser.getProjects().remove(project);
                      
           App.showProjects(); //GET BACK TO PROJECTS LIST
        }));
        
        
        
        preHeader.setLeft(backLink);
        preHeader.setRight(removeProjectButton);
    }

    private void setUpHeader() {
        header = new BorderPane();
        title = new Text(project.getName());
        title.setFont(new Font(34));
        
        ComboBox filter = new ComboBox();    
        filter.setValue("Filter");
        filter.getItems().add("Priority");
        filter.getItems().add("Date");
        
        filter.valueProperty().addListener(e ->{
            applyFilter((String) filter.getValue());
        });
        
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

        HBox btnContainer = new HBox();
        btnContainer.setPadding(new Insets(10, 0, 0, 0));
        btnContainer.setSpacing(10);
        btnContainer.getChildren().addAll(filter, addTaskButton);
        header.setRight(btnContainer);
    }
    
    private void applyFilter(String filter){
        tasksContainer.getChildren().clear();
        if(filter.equals("Priority")){
            project.getTasks().orderByPriority();
        }else if(filter.equals("Date")){
            project.getTasks().orderByDate();
        }
        for (int t = 0; t < project.getTasks().getLength(); t++) {
            tasksContainer.getChildren().add(createTaskItem(project.getTasks().getTask(t)));
        }
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
        CheckBox checkBox = new CheckBox();
        checkBox.setSelected(task.isFinished());        

        VBox leftContainer = new VBox();
        HBox rightContainer = new HBox();

        leftContainer.setPadding(new Insets(0, 0, 0, 20));
        leftContainer.setAlignment(Pos.CENTER_LEFT);
        leftContainer.getChildren().addAll(taskTitleLabel, taskDescriptionLabel);

        rightContainer.setAlignment(Pos.CENTER_RIGHT);
        rightContainer.setPadding(new Insets(0, 20, 0, 0));
        rightContainer.setSpacing(10);
        rightContainer.getChildren().addAll(tasksDateLabel, checkBox);        

        item.setLeft(leftContainer);
        item.setRight(rightContainer);
        
        item.setOnMouseClicked(e -> {
            task.setFinished(!task.isFinished());
            checkBox.setSelected(!checkBox.isSelected());
        });
        checkBox.setOnMouseClicked(e -> task.setFinished(!task.isFinished()));

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
        body.getChildren().addAll(preHeader, header, tasksContainer);
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
