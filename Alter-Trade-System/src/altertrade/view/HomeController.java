package altertrade.view;

import altertrade.model.Supplier;
import altertrade.model.Worker;
import altertrade.model.model;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HomeController extends model implements Initializable {

    ObservableList<Supplier> supplier = FXCollections.observableArrayList();
    ObservableList<Worker> worker = FXCollections.observableArrayList();

    @FXML
    Button btnViewSupplier;

    @FXML
    Button btnViewWorker;

    @FXML
    Label lblDateCreated;

    @FXML
    Label lblAddress;

    @FXML
    Label lblSupplierName;

    @FXML
    Label lblWorkerName;

    @FXML
    Label lblAddressWorker;

    @FXML
    Label lblDateStarted;
    
    @FXML
    TableView<Supplier> tbl_supplier;

    @FXML
    TableColumn<Supplier, Integer> tbl_supplier_id;

    @FXML
    TableColumn<Supplier, String> tbl_supplier_name;
    
    @FXML
    TableView<Worker> tbl_worker;

    @FXML
    TableColumn<Worker, Integer> tbl_worker_id;

    @FXML
    TableColumn<Worker, String> tbl_worker_name;

    public void loadDatabaseDataSupplier() {

        db_connect();

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(SupplierDetails());
            ResultSet rs;
            rs = stmt.getResultSet();
            while (rs.next()) {
                supplier.add(new Supplier(
                        rs.getString("pID"),
                        rs.getString("name"),
                        rs.getString("street"),
                        rs.getString("barangay"),
                        rs.getString("city"),
                        rs.getString("color_code"),
                        rs.getString("risk_containment"),
                        rs.getString("price_description"),
                        rs.getString("price_value"),
                        rs.getString("date_created"),
                        rs.getString("status")
                ));

                tbl_supplier.setItems(supplier);

            }
            conn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void loadDatabaseDataWorker() {

        db_connect();

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(workerDetails());
            ResultSet rs;
            rs = stmt.getResultSet();
            while (rs.next()) {
                worker.add(new Worker(
                        rs.getString("worker_id"),
                        rs.getString("firstname"),
                        rs.getString("middlename"),
                        rs.getString("lastname"),
                        rs.getString("gender"),
                        rs.getString("age"),
                        rs.getString("elementary"),
                        rs.getString("highschool"),
                        rs.getString("college"),
                        rs.getString("undergraduate"),
                        rs.getString("vocational"),
                        rs.getString("skills"),
                        rs.getString("street"),
                        rs.getString("barangay"),
                        rs.getString("city"),
                        rs.getString("contact_number"),
                        rs.getString("email_address"),
                        rs.getString("position"),
                        rs.getString("start_date"),
                        rs.getString("status")
                ));

                tbl_worker.setItems(worker);
            }
            conn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void showWorkerDetails(){
        System.out.println("hi");
    }
    
    
    public void showSelectedValueSupplier(Object val) {
        db_connect();

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(SupplierDetails(val));
            ResultSet rs;
            rs = stmt.getResultSet();
            while (rs.next()) {

                lblSupplierName.setText(rs.getString("name"));
                lblAddress.setText(rs.getString("street") + ", " + rs.getString("barangay") + ", " + rs.getString("city"));
                lblDateCreated.setText(rs.getString("date_created"));

            }
            conn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void showSelectedValueWorker(Object val) {
        db_connect();

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(workerDetails(val));
            ResultSet rs;
            rs = stmt.getResultSet();
            while (rs.next()) {

                lblWorkerName.setText(rs.getString("firstname") + " " + rs.getString("middlename") + " " + rs.getString("lastname"));
                lblAddressWorker.setText(rs.getString("street") + ", " + rs.getString("barangay") + ", " + rs.getString("city"));
                lblDateStarted.setText(rs.getString("start_date"));

            }
            conn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbl_supplier_id.setCellValueFactory(new PropertyValueFactory<>("GrowersID"));
        tbl_supplier_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        loadDatabaseDataSupplier();

        tbl_supplier.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    showSelectedValueSupplier(newValue.getGrowersID());
                }
        );

        tbl_worker_id.setCellValueFactory(new PropertyValueFactory<>("WorkerID"));
        tbl_worker_name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        loadDatabaseDataWorker();

        tbl_worker.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    showSelectedValueWorker(newValue.getWorkerID());
                }
        );
    }
}
