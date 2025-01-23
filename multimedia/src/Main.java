import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("trabajo.fxml"));
        Parent root = (Parent) loader.load();
        Screen controller = loader.getController();
        controller.setMainWindow(primaryStage);
        primaryStage.setTitle("mis bolas");
        primaryStage.setScene(new Scene(root,800,800));
        primaryStage.show();
        Media media = new Media("VID-20250110-WA0003.mp4");
        MediaPlayer mp = new MediaPlayer(media);
        mp.setAutoPlay(true);
        MediaView mv = new MediaView(mp);
        Group rt = new Group();
        rt.getChildren().add(mv);
        Scene scene = new Scene(rt,600,400);
        primaryStage.setTitle("si");
        primaryStage.show();
    }
}