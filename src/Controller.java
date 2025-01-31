import javafx.event.EventHandler;
import java.io.File;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {

    private MediaView view;

    private MediaPlayer player;

    private Stage mainWindow;

    public void setMainWindow(Stage MainWindow){
        this.mainWindow = mainWindow;
    }

    @FXML
    private Button backwards;

    public void retroceso(ActionEvent event){
        view.getMediaPlayer().seek(new Duration(view.getMediaPlayer().getCurrentTime().toMillis()-10000));
    }

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
    public void avance(ActionEvent event){
        view.getMediaPlayer().seek(new Duration(view.getMediaPlayer().getCurrentTime().toMillis()+100000));
    }

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

    public void mutear(ActionEvent event){
        if (view.getMediaPlayer().isMute()) {
            view.getMediaPlayer().setMute(false);
        }else{
            view.getMediaPlayer().setMute(true);
        }
    }

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

    @FXML
    private VBox scroller;

    @FXML
    public void addButtons(){
        File directory = new File("res");
        int horas,minutos,secs;
        directory.mkdir();
        File[] files = directory.listFiles();
        if(files != null){
            for(File file : files){
                Button added = new Button(file.getName().replaceFirst("[.][^.]+$", ""));
                Media media = new Media(new File(file.getPath()).toURI().toString());
                player = new MediaPlayer (media);
                horas = (int)(player.getTotalDuration().toHours());
                minutos = (int)(player.getTotalDuration().toMinutes()-horas*60);
                secs = (int)(player.getTotalDuration().toSeconds()-horas*3600-minutos*60);

                added.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                        video.getChildren().clear();
                        
                        view = new MediaView (player);
                        view.fitHeightProperty().bind(video.heightProperty());
                        view.fitWidthProperty().bind(video.widthProperty());

                        video.getChildren().add(view);

                        player.play();
                        view.getMediaPlayer().setRate(Double.parseDouble(videoSpeed.getSelectionModel().getSelectedItem().toString().replace("x", "")));
                        title.setText(added.getText().replaceFirst("[.][^.]+$", ""));
                        bindProgress(view.getMediaPlayer(), bar);
                        view.getMediaPlayer().volumeProperty().bind(volumenBar.valueProperty());
                    }
                });

                
                Text txt = new Text(horas+":"+minutos+":"+secs+"    "+file.getName().substring(file.getName().lastIndexOf(".")+1));
                scroller.getChildren().add(added);
                scroller.getChildren().add(txt);
            }
        }
    }

    public void bindProgress(MediaPlayer mp,ProgressBar bar){
        var binding =
        Bindings.createDoubleBinding(
            () -> {
              var currentTime = player.getCurrentTime();
              var duration = player.getMedia().getDuration();
              if (isValidDuration(currentTime) && isValidDuration(duration)) {
                return currentTime.toMillis() / duration.toMillis();
              }
              return ProgressBar.INDETERMINATE_PROGRESS;
            },
            player.currentTimeProperty(),
            player.getMedia().durationProperty());
        bar.progressProperty().bind(binding);
    }

    private boolean isValidDuration(Duration d) {
        return d != null && !d.isIndefinite() && !d.isUnknown();
      }

    @FXML
    private Button slow;

    @FXML
    private Text title;

    @FXML
    private Text volumenText;

    @FXML
    private Slider volumenBar;

    @FXML
    private ScrollPane videos;

    @FXML
    private ChoiceBox<?> videoSpeed;

    public void changeSpeed(ActionEvent event){
        if(view != null){
            view.getMediaPlayer().setRate(Double.parseDouble(videoSpeed.getSelectionModel().getSelectedItem().toString().replace("x", "")));
        }
    }

    public void cleanVideo(ActionEvent event){
        video.getChildren().clear();
        view.getMediaPlayer().dispose();
        title.setText("");
    }

}
