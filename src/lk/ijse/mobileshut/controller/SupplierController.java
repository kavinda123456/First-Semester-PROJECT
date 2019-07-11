package lk.ijse.mobileshut.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.mobileshut.bo.BOFactory;
import lk.ijse.mobileshut.bo.custome.SupplierBO;
import lk.ijse.mobileshut.dto.SupplierDTO;
import lk.ijse.mobileshut.entity.SupplierEntity;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SupplierController  implements Initializable {
    static SupplierBO bo= (SupplierBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.SUPPLIER);

    public void initialize(URL url, ResourceBundle rb){
        try {
            getAllSupplier();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private JFXTextField txtSplId;

    @FXML
    private JFXTextField txtSplName;

    @FXML
    private JFXTextField txtCompany;

    @FXML
    private JFXButton btnSupplierRegis;

    @FXML
    private JFXTextField txtTp;

    @FXML
    private JFXTextField txtNic;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXButton btnSupplierRefresh;

    @FXML
    private TableView<SupplierEntity> tblSupplierDetails;

    @FXML
    private TextField txtSpld1;

    @FXML
    private TextField txtNIC1;

    @FXML
    private TextField txtTp1;

    @FXML
    private TextField txtEmail1;

    @FXML
    private TextField txtCompany1;

    @FXML
    private TextField txtSplName1;

    @FXML
    private JFXButton btnSupplierRemove;

    @FXML
    private JFXButton btnSupplierUpdate;

    @FXML
    private JFXButton btnSupplierSearch;

    @FXML
    private TableColumn<SupplierEntity, String> columnSupplier;

    @FXML
    void RemoveOnAction(ActionEvent event) throws Exception {
        String supplierId = txtSpld1.getText();
        boolean isRemove = SupplierController.removeSupplier(supplierId);
        if (isRemove){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Removed...!", ButtonType.OK);
            alert.show();
            clearAllSupplier();
            getAllSupplier();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Failed...!", ButtonType.OK);
            alert.show();
        }
    }

    private static boolean removeSupplier(String Id) throws Exception {
        return bo.RemoveSupplier(Id);
    }

    @FXML
    void SearchOnAction(ActionEvent event) throws Exception {
        String supplierId = txtSpld1.getText();
        SupplierDTO SearchSupplier = SupplierController.SearchSupplier(supplierId);
        txtSpld1.setText(SearchSupplier.getSuppierId());
        txtSplName1.setText(SearchSupplier.getSupplierName());
        txtCompany1.setText(SearchSupplier.getCompany());
        txtTp1.setText(SearchSupplier.getStp()+"");
        txtNIC1.setText(SearchSupplier.getSnic());
        txtEmail1.setText(SearchSupplier.getEmail());
    }

    public static SupplierDTO SearchSupplier(String id) throws Exception {
        return bo.SearchSupplier(id);
    }

    @FXML
    void onMouseClicked(MouseEvent event) {
        getSelectedValue();
    }

    private void getSelectedValue() {
        tblSupplierDetails.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SupplierEntity>() {
            @Override
            public void changed(ObservableValue<? extends SupplierEntity> observable, SupplierEntity oldValue, SupplierEntity newValue) {
                SupplierEntity value=observable.getValue();
                txtSpld1.setText(value.getSupplierId());
                txtCompany1.setText(value.getCompany());
                txtEmail1.setText(value.getEmail());
                txtNIC1.setText(value.getSnic());
                txtTp1.setText(value.getStp()+"");
                txtSplName1.setText(value.getSupplierName());
            }
        });
    }

    @FXML
    void refreshOnAction(ActionEvent event) {
        clearAllSupplier();
    }

    public void clearAllSupplier() {
        txtSpld1.setText("");
        txtSplName1.setText("");
        txtCompany1.setText("");
        txtTp1.setText("");
        txtNIC1.setText("");
        txtEmail1.setText(" ");
        txtSplId.setText("");
        txtSplName.setText("");
        txtCompany.setText("");
        txtTp.setText("");
        txtNic.setText("");
        txtEmail.setText("");
    }

    @FXML
    void regisOnAction(ActionEvent event) throws Exception {
        String supplierId = txtSplId.getText();
        String supplierName = txtSplName.getText();
        String company = txtCompany.getText();
        int sTP = Integer.parseInt(txtTp.getText());
        String sNIC = txtNic.getText();
        String email = txtEmail.getText();
        SupplierDTO suppierModel = new SupplierDTO(supplierId, supplierName, company, sTP, sNIC, email);
        boolean isAdded = SupplierController.addSupplier(suppierModel);
        if (isAdded){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Aded...!", ButtonType.OK);
            alert.show();
            clearAllSupplier();
            getAllSupplier();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Failed...!", ButtonType.OK);
            alert.show();
        }

    }

    private static boolean addSupplier(SupplierDTO ref) throws Exception {

        return bo.AddSupplier(ref);
    }

    @FXML
    void searchUsingSupplierId(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) throws Exception {
        String supplierId = txtSpld1.getText();
        String supplierName = txtSplName1.getText();
        String company = txtCompany1.getText();
        int sTP = Integer.parseInt(txtTp1.getText());
        String sNIC = txtNIC1.getText();
        String email = txtEmail1.getText();
        SupplierDTO splModel = new SupplierDTO(supplierId, supplierName, company, sTP, sNIC, email);
        boolean isUpdate = SupplierController.UpdateSupplier(splModel);
        if (isUpdate){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Updated...!", ButtonType.OK);
            alert.show();
            clearAllSupplier();
            getAllSupplier();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Failed...!", ButtonType.OK);
            alert.show();
        }
    }

    private static boolean UpdateSupplier(SupplierDTO ref) throws Exception {
        return bo.UpdateSupplier(ref);
    }

    private void getAllSupplier() throws Exception {
        ArrayList<SupplierEntity> allSupplier=bo.getAllSuppliers();
        tblSupplierDetails.setItems(FXCollections.observableArrayList(allSupplier));
        tblSupplierDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        tblSupplierDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        tblSupplierDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("company"));
        tblSupplierDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("stp"));
        tblSupplierDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("snic"));
        tblSupplierDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("Email"));
    }

}
