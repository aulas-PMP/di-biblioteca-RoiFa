import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {

    private MediaView view;

    private MediaPlayer player;

    private Stage mainWindow;

    public void setMainWindow(Stage MainWindow){
        this.mainWindow = mainWindow;
    }

    @FXML
    private Button Acelerar;

    @FXML
    private Button backwards;

    @FXML
    private ProgressBar bar;

    @FXML
    private Button cut;

    @FXML
    private VBox editores;

    @FXML
    private HBox editors;

    @FXML
    private Button forward;

    @FXML
    private Separator library;

    @FXML
    private HBox lalibreria;

    @FXML
    private Button juan;

    @FXML
    private Button displayL;

    @FXML
    private Button displayR;

    public void hideLib(ActionEvent event){
        if(lalibreria.isVisible()){
            lalibreria.setVisible(false);
            lalibreria.setManaged(false);
        }else{
            lalibreria.setVisible(true);
            lalibreria.setManaged(true);
        }
    }

    public void hideEdit(ActionEvent event){
        if(editors.isVisible()){
            editors.setVisible(false);
            editors.setManaged(false);
        }else{
            editors.setVisible(true);
            editors.setManaged(true);
        }
    }

    @FXML
    private Button mute;

    @FXML
    private Button play;

    public void pause(ActionEvent event){
        if (!(view.getMediaPlayer().getStatus()==MediaPlayer.Status.PLAYING)) {
            view.getMediaPlayer().play();
        }else{
            view.getMediaPlayer().pause();
        }
    }

    @FXML
    private Button save;

    @FXML
    private Button videoStart;

    @FXML
    private HBox video;

    public void playVideo(ActionEvent event){
        video.getChildren().clear();
        Media media = new Media (new File("VID-20250110-WA0003.mp4").toURI().toString());
        player = new MediaPlayer (media);
        view = new MediaView (player);
        view.fitHeightProperty().bind(video.heightProperty());
        view.fitWidthProperty().bind(video.widthProperty());

        video.getChildren().add(view);

        player.play();
    }

    @FXML
    private Button slow;

    @FXML
    private Text title;

    @FXML
    private ScrollPane videos;

}
