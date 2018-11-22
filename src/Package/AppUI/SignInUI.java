package Package.AppUI;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author dcortes
 */
public class SignInUI  extends Application{
    private Stage window;    

    public SignInUI() {
        launch();                
    }    
    
    @Override
    public void start(Stage window) {
        this.window = window;
        window.setTitle("Sign In");
        buildUI();
    }
    
    public void buildUI(){
        
    }
}
