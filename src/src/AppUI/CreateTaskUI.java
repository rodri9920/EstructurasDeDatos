package src.AppUI;

import java.time.LocalDate;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Rodri
 * @author Dorian
 * @author Luis
 */
public class CreateTaskUI {

    private Stage modalWindow;
    private Stage window;
    private VBox body;
    private Text title;
    private VBox formContainer;
    private Text taskTitleLabel;
    private TextField taskTitleField;
    private Text taskDescriptionLabel;
    private TextArea taskDescriptionField;
    private Text priorityLabel;
    private ComboBox priorityComboBox;
    private Text projectDateLabel;
    private DatePicker projectDateField;
    private Button createTaskButton;
    private Scene scene;

    public CreateTaskUI(Stage window) {
        this.window = window;
        setUpLayout();
        setUpTitle();
        setUpForm();
    }

    private void setUpLayout() {
        body = new VBox();
        body.setAlignment(Pos.TOP_LEFT);
        body.setPadding(new Insets(50, 80, 50, 80));
        body.setSpacing(30);
    }

    private void setUpTitle() {
        title = new Text("Add Task");
        title.setFont(new Font(24));
    }

    private void setUpForm() {
        formContainer = new VBox();
        formContainer.setMaxWidth(400);
        formContainer.setAlignment(Pos.TOP_LEFT);
        formContainer.setSpacing(10);

        taskTitleLabel = new Text("Title");
        taskTitleField = new TextField();
        taskTitleField.setMaxWidth(400);

        taskDescriptionLabel = new Text("Description");
        taskDescriptionField = new TextArea();
        taskDescriptionField.setMaxWidth(400);

        priorityLabel = new Text("Priority");
        priorityComboBox = new ComboBox();
        priorityComboBox.setMaxWidth(400);
        priorityComboBox.getItems().addAll("Low", "Medium", "High", "Very High");
        priorityComboBox.setValue("Select a priority");

        projectDateLabel = new Text("Select a due to Date");
        projectDateField = new DatePicker();
        projectDateField.setMaxWidth(400);

        formContainer.getChildren().addAll(taskTitleLabel, taskTitleField, taskDescriptionLabel, taskDescriptionField, priorityLabel, priorityComboBox, projectDateLabel, projectDateField);

        createTaskButton = new Button("Create Task");
        createTaskButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"), CornerRadii.EMPTY, Insets.EMPTY)));
        createTaskButton.setAlignment(Pos.CENTER);
        createTaskButton.setMaxSize(500, 30);
        createTaskButton.setCursor(Cursor.HAND);
        createTaskButton.setTextFill(Color.WHITE);
        createTaskButton.setOnMouseEntered(e -> createTaskButton.setBackground(new Background(new BackgroundFill(Color.web("#67a0fd"), CornerRadii.EMPTY, Insets.EMPTY))));
        createTaskButton.setOnMouseExited(e -> createTaskButton.setBackground(new Background(new BackgroundFill(Color.web("#4285f4"), CornerRadii.EMPTY, Insets.EMPTY))));
    }

    public void show() {
        modalWindow = new Stage();
        modalWindow.setHeight(500);
        modalWindow.setWidth(500);
        body.getChildren().addAll(title, formContainer, createTaskButton);
        scene = new Scene(body);
        modalWindow.setScene(scene);

        modalWindow.initModality(Modality.APPLICATION_MODAL);
        modalWindow.initOwner(window);
        modalWindow.getIcons().add(window.getIcons().get(0));
        modalWindow.setTitle("Tasker - Add Task");

        modalWindow.showAndWait();
    }

    public String getTaskTitleField() {
        return taskTitleField.getText();
    }

    public String getTaskDescriptionField() {
        return taskDescriptionField.getText();
    }

    public Button getCreateTaskButton() {
        return createTaskButton;
    }

    public Stage getModalWindow() {
        return modalWindow;
    }

    public LocalDate getProjectDateField() {
        return projectDateField.getValue();
    }

    public int getPriorityField() {
        String selectedItem = (String) priorityComboBox.getValue();

        if (selectedItem.equals("Very High")) {
            return 1;
        }

        if (selectedItem.equals("High")) {
            return 2;
        }

        if (selectedItem.equals("Medium")) {
            return 3;
        }

        if (selectedItem.equals("Low")) {
            return 4;
        }

        return -1;
    }

    public boolean isValidDate(LocalDate date) {
        return date != null && !date.isBefore(LocalDate.now());
    }

    public boolean validateForm() {
        return !getTaskTitleField().isEmpty() && !getTaskDescriptionField().isEmpty() && isValidDate(getProjectDateField()) && getPriorityField() != -1;
    }
}
