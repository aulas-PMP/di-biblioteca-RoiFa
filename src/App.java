import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("trabajo.fxml"));
        Parent root = (Parent) loader.load();
        Controller controller = loader.getController();
        
        
        controller.setMainWindow(primaryStage);
        primaryStage.setTitle("Moody Blues");
        primaryStage.setScene(new Scene(root,850,600));
        primaryStage.show();
        controller.addButtons();
        primaryStage.getScene().getStylesheets().add("biblio.css");
    }
}
