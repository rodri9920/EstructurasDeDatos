package src.AppUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
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


public class ProjectItemUI extends BorderPane{
    public ProjectItemUI(Stage window, Project project){
        super();
        BorderPane item = this;
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
        
        item.setOnMouseClicked(e -> {
            ProjectTasksUI projectTasksWindow = new ProjectTasksUI(window, project);
            projectTasksWindow.show();
        });
    }
}
