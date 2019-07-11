package lk.ijse.mobileshut.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.mobileshut.bo.BOFactory;
import lk.ijse.mobileshut.bo.custome.MobileBO;
import lk.ijse.mobileshut.bo.custome.SupplierBO;
import lk.ijse.mobileshut.bo.custome.SupplierPaymentBO;
import lk.ijse.mobileshut.dto.*;
import lk.ijse.mobileshut.entity.MobileEntity;
import lk.ijse.mobileshut.entity.SupplierEntity;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class SupplierPaymentController implements Initializable {
    static SupplierPaymentBO bo= (SupplierPaymentBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.PAYMENT);
    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXTextField txtSupPayId;

    @FXML
    private JFXTextField txtQtyHand;

    @FXML
    private JFXComboBox<String> comboSupId;

    @FXML
    private JFXComboBox<String> comboMobileId;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXTextField txtQTY;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnSearch1;

    @FXML
    private JFXTextField txtSupPrice;

    @FXML
    private TableView<SupplierPaymentDTO> tblSupPayment;

    @FXML
    private TableColumn<?, ?> columnSPID;

    @FXML
    private JFXTextField txtDate;

    @FXML
    private Label lblPayment;

    @FXML
    private JFXButton btndone;

    @FXML
    void doneOnAction(ActionEvent event) throws Exception {
        String supplierOrderId = txtSupPayId.getText();
        String SupplierId = comboSupId.getSelectionModel().getSelectedItem().toString();
        String mobileId = comboMobileId.getSelectionModel().getSelectedItem().toString();
        int qty = Integer.parseInt(txtQTY.getText());
        double supplierPrice = Double.parseDouble(txtSupPrice.getText());
        String ordDate = txtDate.getText();
        ArrayList<SupplierOrderDetailsDTO> allorders=new ArrayList<>();
        for (int i = 0; i < tblSupPayment.getItems().size(); i++) {
            String SupOrderDetail = (String) tblSupPayment.getColumns().get(1).getCellObservableValue(i).getValue();
            String mobileCode = (String) tblSupPayment.getColumns().get(2).getCellObservableValue(i).getValue();
            int Qty = (Integer)tblSupPayment.getColumns().get(3).getCellObservableValue(i).getValue();
            double unitPrice = (Double)tblSupPayment.getColumns().get(4).getCellObservableValue(i).getValue();
            SupplierOrderDetailsDTO supplierOrderDetailsDTO=new SupplierOrderDetailsDTO(SupOrderDetail,mobileCode,Qty,unitPrice);
            allorders.add(supplierOrderDetailsDTO);
        }
        SupplierOrderDTO order=new SupplierOrderDTO(supplierOrderId,SupplierId,ordDate,allorders);
        boolean purchaseOrder = SupplierPaymentController.paymentSupplier(order);
        if (purchaseOrder){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Place Order...!", ButtonType.OK);
            alert.show();
        }

    }

    private static boolean paymentSupplier(SupplierOrderDTO order) throws Exception {
        return bo.purchaseOrder(order);
    }

    @FXML
    void addOnAction(ActionEvent event) {
        String supplierOrderId = txtSupPayId.getText();
        String SupplierId = comboSupId.getSelectionModel().getSelectedItem().toString();
        String mobileId = comboMobileId.getSelectionModel().getSelectedItem().toString();
        int qty = Integer.parseInt(txtQTY.getText());
        double supplierPrice = Double.parseDouble(txtSupPrice.getText());
        SupplierPaymentDTO paymentModel = new SupplierPaymentDTO(supplierOrderId, mobileId, qty, supplierPrice);
        tblSupPayment.setItems(FXCollections.observableArrayList(paymentModel));
        tblSupPayment.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("suporderId"));
        tblSupPayment.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("mobileID"));
        tblSupPayment.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("supqtyOnHand"));
        tblSupPayment.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("supunitPrice"));
        double amount= qty*supplierPrice;
        lblPayment.setText(amount+"");

    }

    @FXML
    void cmbMobIdChange(ActionEvent event) throws Exception {
        String mobileId = comboMobileId.getSelectionModel().getSelectedItem().toString();
        MobileDTO searchMobile=MobileController.searchMobile(mobileId);
        txtQtyHand.setText(searchMobile.getQty()+"");
    }
    private void getallmobile() throws Exception {
        comboMobileId.getItems().removeAll();
        MobileBO mobileBO= (MobileBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.MOBILE);
        ArrayList<MobileEntity> allMobile=mobileBO.getAllMobile();
        for (MobileEntity m :
                allMobile) {
            comboMobileId.getItems().addAll(m.getMobileID());
        }
    }

    @FXML
    void cmbSupIdChange(ActionEvent event) throws Exception {
        String supplierId = comboSupId.getSelectionModel().getSelectedItem().toString();
        SupplierDTO searchSupplier=SupplierController.SearchSupplier(supplierId);
    }
    private void getAllSupplier() throws Exception {
        comboSupId.getItems().removeAll();
        SupplierBO supplierBO= (SupplierBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.SUPPLIER);
        ArrayList<SupplierEntity> allSupplier=supplierBO.getAllSuppliers();
        for (SupplierEntity s :
                allSupplier) {
            comboSupId.getItems().addAll(s.getSupplierId());
        }
    }
    private void setOrderID() {
        int id = new Random().nextInt(99999);
        String prefix = "SOID";
        txtSupPayId.setText(prefix + id);
    }
    private void setOrderDate() {
        txtDate.setText(LocalDate.now().toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setOrderDate();
        setOrderID();
        try {
            getallmobile();
            getAllSupplier();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
