import java.io.File;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
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
        primaryStage.setScene(new Scene(root,800,800));
        primaryStage.show();
        Media media = new Media (new File("VID-20250110-WA0003.mp4").toURI().toString());
        MediaPlayer player = new MediaPlayer (media);
        MediaView view = new MediaView (player);


        Group full = new Group ();
        full.getChildren().addAll(view);


        Scene scene1 = new Scene (full,600,600);
        primaryStage.setScene(scene1);
        primaryStage.show();

        player.play();
    }
}
