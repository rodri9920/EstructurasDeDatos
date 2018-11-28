package src.AppUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Rodri
 * @author Dorian
 * @author Luis
 */
public class ModalUI{
    
    public static void alert(Stage parentWindow, String message){
        Stage modalWindow = new Stage();    
        
        modalWindow.initModality(Modality.APPLICATION_MODAL);
        modalWindow.initOwner(parentWindow);        
        modalWindow.getIcons().add(parentWindow.getIcons().get(0));
        modalWindow.setTitle("Tasker - Alert");
        
        modalWindow.setMinHeight(150);
        modalWindow.setMinWidth(350);
        modalWindow.setResizable(false);
        
        HBox flex = new HBox();
        flex.setAlignment(Pos.CENTER_LEFT);
        flex.setSpacing(10);
        flex.setPadding(new Insets(0, 40, 0, 40));
        
        ImageView alertIcon = new ImageView(new Image(ModalUI.class.getClassLoader().getResourceAsStream("res/alert.png")));                
        alertIcon.setFitHeight(40);
        alertIcon.setFitWidth(40);
        
        Label modalMessage = new Label(message);        
        modalMessage.setFont(new Font(14));
        modalMessage.setPadding(new Insets(0, 0, 0, 20));
        
        
        flex.getChildren().addAll(alertIcon, modalMessage);
        
        Button acceptBtn = new Button("Accept");
        acceptBtn.setOnAction(e -> modalWindow.close());
        
        VBox modalBody = new VBox();
        modalBody.setPadding(new Insets(30));
        modalBody.setSpacing(20);
        modalBody.setAlignment(Pos.CENTER);
        modalBody.getChildren().addAll(flex, acceptBtn);
        
        Scene modalScene = new Scene(modalBody);
        
        modalWindow.setScene(modalScene);
        modalWindow.showAndWait();
    }
    
    
    public static void ask(Stage parentWindow, String message, EventHandler<ActionEvent> acceptHandler){
        Stage modalWindow = new Stage();    
        
        modalWindow.initModality(Modality.APPLICATION_MODAL);
        modalWindow.initOwner(parentWindow);        
        modalWindow.getIcons().add(parentWindow.getIcons().get(0));
        modalWindow.setTitle("Tasker - Alert");
        
        modalWindow.setMinHeight(150);
        modalWindow.setMinWidth(350);
        modalWindow.setResizable(false);
        
        HBox flex = new HBox();
        flex.setAlignment(Pos.CENTER_LEFT);
        flex.setSpacing(10);
        flex.setPadding(new Insets(0, 40, 0, 40));
        
        ImageView alertIcon = new ImageView(new Image(ModalUI.class.getClassLoader().getResourceAsStream("res/alert.png")));                
        alertIcon.setFitHeight(40);
        alertIcon.setFitWidth(40);
        
        Label modalMessage = new Label(message);        
        modalMessage.setFont(new Font(14));
        modalMessage.setPadding(new Insets(0, 0, 0, 20));
        
        
        flex.getChildren().addAll(alertIcon, modalMessage);
        
        HBox flexButtons = new HBox();
        flexButtons.setAlignment(Pos.CENTER);
        flexButtons.setSpacing(10);
        flexButtons.setPadding(new Insets(0, 40, 0, 40));
        
        Button acceptBtn = new Button("Accept");
        acceptBtn.setOnAction(e -> {            
            acceptHandler.handle(e);
            modalWindow.close();
        });        
        
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> modalWindow.close());
        
        flexButtons.getChildren().addAll(acceptBtn, cancelButton);
        
        VBox modalBody = new VBox();
        modalBody.setPadding(new Insets(30));
        modalBody.setSpacing(20);
        modalBody.setAlignment(Pos.CENTER);
        modalBody.getChildren().addAll(flex, flexButtons);
        
        Scene modalScene = new Scene(modalBody);
        
        modalWindow.setScene(modalScene);
        modalWindow.showAndWait();
    }
}
