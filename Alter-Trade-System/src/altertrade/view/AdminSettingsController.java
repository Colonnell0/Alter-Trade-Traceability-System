/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altertrade.view;

import altertrade.alterTrade;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Colonnello
 */
public class AdminSettingsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button btnAddWorker;

    public void showAddWorker() throws IOException {
       alterTrade.addBiodata("view/BIODATA.fxml", "BIODATA");
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
