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
import lk.ijse.mobileshut.bo.custome.CustomerBO;
import lk.ijse.mobileshut.dto.CustomerDTO;
import lk.ijse.mobileshut.entity.CustomerEntity;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.*;

public class CustomerController implements Initializable {
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        try {
//
//            getAllCustomer();
//
//        } catch (Exception ex) {
//            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    static CustomerBO bo= (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.CUSTOMER);
    @FXML
    private JFXTextField txtCustId;

    @FXML
    private JFXTextField txtFName;

    @FXML
    private JFXTextField txtLName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXButton btnCustomerRegis;

    @FXML
    private JFXTextField txtTp;

    @FXML
    private JFXTextField txtNic;

    @FXML
    private JFXTextField txtRegisDate;

    @FXML
    private JFXButton btnCustomerRefresh;

    @FXML
    private TableView<CustomerEntity> tblCustomerDetails;

    @FXML
    private TextField txtCustId1;

    @FXML
    private TextField txtNIC1;

    @FXML
    private TextField txtTp1;

    @FXML
    private TextField txtAddress1;

    @FXML
    private TextField txtLName1;

    @FXML
    private TextField txtFName1;

    @FXML
    private TextField txtRegisDate1;

    @FXML
    private JFXButton btnCustomerRemove;

    @FXML
    private JFXButton btnCustomerUpdate;

    @FXML
    private JFXButton btnCustomerSearch;

    @FXML
    private JFXButton btnViewAll;


    @FXML
    private TableColumn<CustomerEntity, String> coulumnCust;

    @FXML
    private boolean removeCustomer(String customerID) throws Exception {
        return CustomerController.removeCust(customerID);
    }
    //
    @FXML
    void RemoveOnAction(ActionEvent event) throws Exception {
        String customerId1 = txtCustId1.getText();
        boolean isDeleted = removeCustomer(customerId1);
        if (isDeleted){
            getAllCustomer();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Delete Successful..!", ButtonType.OK);
            alert.show();
        }
    }
    public static boolean removeCust(String id) throws Exception {
        return bo.removeCustomer(id);
    }
    @FXML
    void SearchOnAction(ActionEvent event) throws Exception {
        String searchID = txtCustId1.getText();
            CustomerDTO searchCustomer = CustomerController.searchCustomer(searchID);
            txtCustId1.setText(searchCustomer.getId());
            txtFName1.setText(searchCustomer.getFname());
            txtLName1.setText(searchCustomer.getLname());
            txtAddress1.setText(searchCustomer.getAddress());
            txtTp1.setText(searchCustomer.getTp()+"");
            txtNIC1.setText(searchCustomer.getNic());
            txtRegisDate1.setText(searchCustomer.getDate());
    }

    public static CustomerDTO searchCustomer(String id) throws Exception {
        return bo.searchCustomer(id);
    }

    @FXML
    void onMouseClicked(MouseEvent event) {
        getSelectedValue();
    }

    private void getSelectedValue() {
        tblCustomerDetails.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerEntity>() {
            @Override
            public void changed(ObservableValue<? extends CustomerEntity> observable, CustomerEntity oldValue, CustomerEntity newValue) {
                CustomerEntity value=observable.getValue();
                txtCustId1.setText(value.getId());
                txtFName1.setText(value.getFname());
                txtLName1.setText(value.getLname());
                txtAddress1.setText(value.getAddress());
                txtNIC1.setText(value.getNic());
                txtTp1.setText(value.getTp()+"");
                txtRegisDate1.setText(value.getDate());
            }
        });
    }

    @FXML
    void refreshOnAction(ActionEvent event) {
        closeAll();
    }
    public void closeAll(){
        txtCustId.setText("");
        txtFName.setText("");
        txtLName.setText("");
        txtAddress.setText("");
        txtTp.setText("");
        txtNic.setText("");
        txtRegisDate.setText("");
    }

    @FXML
    void regisOnAction(ActionEvent event) throws Exception {
        String customerId = txtCustId.getText();
        String customerFName = txtFName.getText();
        String customerLName = txtLName.getText();
        String customerAddress = txtAddress.getText();
        int customerTp = Integer.parseInt(txtTp.getText());
        String customerNic = txtNic.getText();
        String customerRegi = txtRegisDate.getText();
        CustomerDTO customerModel = new CustomerDTO(customerId,customerFName,customerLName,customerAddress,customerTp,customerNic,customerRegi);
        boolean isAdded = CustomerController.addCustomer(customerModel);
        if (isAdded){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added Successful..!", ButtonType.OK);
            alert.show();
            getAllCustomer();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "fail", ButtonType.OK);
            alert.show();
        }

    }

    private static boolean addCustomer(CustomerDTO ref) throws Exception {
        return bo.addCustomer(ref);
    }

    @FXML
    void searchUsingCustomerId(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) throws Exception {
        String customerId1 = txtCustId1.getText();
        String customerFName1 = txtFName1.getText();
        String customerLName1 = txtLName1.getText();
        String customerAddress1 = txtAddress1.getText();
        int customerTp1 = Integer.parseInt(txtTp1.getText());
        String customerNic1 = txtNIC1.getText();
        String customerRegi1 = txtRegisDate1.getText();
        CustomerDTO customerModel = new CustomerDTO(customerId1, customerFName1, customerLName1, customerAddress1, customerTp1, customerNic1, customerRegi1);
        boolean isUpdated = CustomerController.updateCustomer(customerModel);
        if (isUpdated){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Update Successful..!", ButtonType.OK);
            alert.show();
            getAllCustomer();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "fail...!", ButtonType.OK);
            alert.show();
        }

    }

    private static boolean updateCustomer(CustomerDTO ref) throws Exception {
        return bo.updateCustomer(ref);
    }

    private void getAllCustomer() throws Exception {
        ArrayList<CustomerEntity> allCustomer=bo.getAllCustomer();
        tblCustomerDetails.setItems(FXCollections.observableArrayList(allCustomer));
        tblCustomerDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomerDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fname"));
        tblCustomerDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("lname"));
        tblCustomerDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblCustomerDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("tp"));
        tblCustomerDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblCustomerDetails.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("date"));
    }
    public static ArrayList<CustomerEntity> getAllCustomers()throws Exception{
        return bo.getAllCustomer();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAllCustomer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

