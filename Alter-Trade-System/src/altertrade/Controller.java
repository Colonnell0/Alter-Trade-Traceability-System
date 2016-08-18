package altertrade;

import altertrade.model.model;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Controller extends model implements Initializable {

    @FXML
    Button btnHome;

    @FXML
    Button btnLogin;

    @FXML
    Button btnAdminSettings;

    @FXML
    Button btnMinimize;

    @FXML
    Pane paneGraph;

    @FXML
    Button sampleAddSupplier;
    
    @FXML 
    Pane sidebar;

    @FXML
    private AnchorPane scenePane;

    public void setDataPane(Node node) {
        scenePane.getChildren().setAll(node);
    }

    public VBox fadeAnimate(String url) throws IOException {
        VBox v = (VBox) FXMLLoader.load(getClass().getResource(url));
        FadeTransition ft = new FadeTransition(Duration.millis(900));
        ft.setNode(v);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        return v;
    }

    public void Home(ActionEvent event) throws IOException {
        setDataPane(fadeAnimate("view/Home.fxml"));
    }

    public void Login() throws IOException {
      
    }

    public void Graph() throws IOException {
        setDataPane(fadeAnimate("view/Record.fxml"));

    }

    public void AdminSettings(ActionEvent event) throws IOException {
        setDataPane(fadeAnimate("view/AdminSettings.fxml"));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            setDataPane(fadeAnimate("view/Home.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
