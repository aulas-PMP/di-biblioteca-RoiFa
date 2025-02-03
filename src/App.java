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
        primaryStage.setTitle("mis bolas");
        primaryStage.setScene(new Scene(root,800,400));
        primaryStage.show();
        controller.addButtons();
        controller.volumeConf();
        primaryStage.getScene().getStylesheets().add("biblio.css");
    }
}
