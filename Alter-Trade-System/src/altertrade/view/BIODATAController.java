/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altertrade.view;

import altertrade.model.model;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author OslecBhadz
 */
public class BIODATAController extends model implements Initializable {

    /**
     * Initializes the controller class.
     */
    String strDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    @FXML
    private TextField txtFirstname;

    @FXML
    private TextField txtMiddlename;

    @FXML
    private TextField txtLastname;

    @FXML
    private ComboBox comboPosition;

    @FXML
    private TextField txtAge;

    @FXML
    private ComboBox comboGender;

    @FXML
    private TextField txtBarangay;

    @FXML
    private TextField txtStreet;

    @FXML
    private ComboBox comboCity;

    @FXML
    private ComboBox comboProvince;

    @FXML
    private TextField txtContactNumber;

    @FXML
    private TextField txtElementary;

    @FXML
    private TextField txtHighschool;

    @FXML
    private TextField txtCollege;

    @FXML
    private TextField txtElementaryPlace;

    @FXML
    private TextField txtHighSchoolPlace;

    @FXML
    private TextField txtCollegePlace;

    @FXML
    private TextField txtElementaryGraduate;

    @FXML
    private TextField txtHighschoolGraduate;

    @FXML
    private TextField txtCollegeGraduate;

    @FXML
    private TextArea txtUndergraduate;

    @FXML
    private TextArea txtVocational;

    @FXML
    private TextField txtFirstSkill;

    @FXML
    private TextField txtSecondSkill;

    @FXML
    private TextField txtThirdSkill;

    @FXML
    private TextField txtFourthSkill;

    @FXML
    private TextField txtEmailAddress;

    @FXML
    private MenuItem menuSave;

    public void saveWorker() {

        db_connect();

        try {

            Statement stmt = conn.createStatement();
            stmt.execute(insertWorker(txtFirstname.getText(),
                    txtMiddlename.getText(),
                    txtLastname.getText(),
                    getGenderId(comboGender.getValue()),
                    txtAge.getText(),
                    txtElementary.getText() + "&*$" + txtElementaryPlace.getText() + "&*$" + txtElementaryGraduate.getText(),
                    txtHighschool.getText() + "&*$" + txtHighSchoolPlace.getText() + "&*$" + txtHighschoolGraduate.getText(),
                    txtCollege.getText() + "&*$" + txtCollegePlace.getText() + "&*$" + txtCollegeGraduate.getText(),
                    txtUndergraduate.getText(),
                    txtVocational.getText(),
                    txtFirstSkill.getText() + "&*$" + txtSecondSkill.getText() + "&*$" + txtThirdSkill.getText() + "&*$" + txtFourthSkill.getText(),
                    txtStreet.getText(),
                    txtBarangay.getText(),
                    getComboCityID(),
                    txtContactNumber.getText(),
                    txtEmailAddress.getText(),
                    getPositionID(comboPosition.getValue()),
                    strDate,
                    "1"
            ));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Data recorded");
            alert.setContentText("Succesfully Recorded");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Platform.exit();
                System.exit(0);
            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR 404");
            alert.setContentText("Please fill up some important fields *");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                
            }
        }

    }

    private void setComboGender() {

        db_connect();

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(genderCombo());
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {

                comboGender.getItems().addAll(rs.getString("description")
                );

            }
            comboGender.setValue("-gender-");
            conn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private String getGenderId(Object gender) {
        String id = "";
        db_connect();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(getGenderID(gender));
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                id = rs.getString("gender_id");

            }

            conn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }

    private String getPositionID(Object position) {
        String id = "";
        db_connect();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(positionID(position));
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                id = rs.getString("position_id");
            }

            conn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }

    private void setComboCity() {

        db_connect();

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(cityCombo());
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {

                comboCity.getItems().addAll(rs.getString("city")
                );

            }
            comboCity.setValue("Dumaguete");
            conn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private String getComboCityID() {
        String id = "";
        db_connect();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(cityID(comboCity.getValue()));
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                id = rs.getString("city_id");
            }

            conn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }

    public void setProvince() {
        comboProvince.getItems().clear();
        db_connect();

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(province());
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {

                comboProvince.getItems().addAll(rs.getString("province")
                );
                if (getComboCityID().equalsIgnoreCase(rs.getString("province_id"))) {
                    comboProvince.setValue(rs.getString("province"));
                }

            }

            conn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void setComboPosition() {

        db_connect();

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(position());
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {

                comboPosition.getItems().addAll(rs.getString("position")
                );

            }
            comboPosition.setValue("-position-");
            conn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setComboGender();
        setComboCity();
        setComboPosition();
        System.out.println(strDate);

    }

}
