import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {
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

    @FXML
    private Button save;

    @FXML
    private Button slow;

    @FXML
    private Text title;

    @FXML
    private Pane video;

    @FXML
    private ScrollPane videos;

}
