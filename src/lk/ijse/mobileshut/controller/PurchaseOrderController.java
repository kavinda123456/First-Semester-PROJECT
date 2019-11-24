package lk.ijse.mobileshut.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.mobileshut.bo.BOFactory;
import lk.ijse.mobileshut.bo.custome.BrandsModelBO;
import lk.ijse.mobileshut.bo.custome.CustomerBO;
import lk.ijse.mobileshut.bo.custome.MobileBO;
import lk.ijse.mobileshut.bo.custome.PurchaseOrderBO;
import lk.ijse.mobileshut.dto.*;
import lk.ijse.mobileshut.entity.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class PurchaseOrderController implements Initializable {

    PurchaseOrderDTO dto = new PurchaseOrderDTO();
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            loadAllCustomers();
            loadAllMobiles();
            loadAllBrands();
            setOrderID();
            setOrderDate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    ObservableList<Object> dta=FXCollections.observableArrayList();
    static PurchaseOrderBO bo= (PurchaseOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.PURCHESE);
    @FXML
    private JFXComboBox<String> cmboCustomerId;

    @FXML
    private JFXTextField txtFname;

    @FXML
    private JFXTextField txtLname;

    @FXML
    private JFXTextField txtNic;

    @FXML
    private JFXTextField txtAddress;


    @FXML
    private JFXTextField txtOrderDate;

    @FXML
    private JFXTextField txtInvoiceNo;

    @FXML
    private JFXComboBox<String> comboMobileId;

    @FXML
    private JFXComboBox<String> comboBatchId;

    @FXML
    private JFXTextField txtMobileName;

    @FXML
    private JFXTextField txtUnitPrice;

    @FXML
    private JFXTextField txtQtyOnHand;

    @FXML
    private JFXButton btnAddToCart;

    @FXML
    private JFXTextField txtBrandName;

    @FXML
    private JFXTextField txtOrderQty;

    @FXML
    private TableView<Object> tblPurchaseOrder;

    @FXML
    private JFXTextField txtBalance;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXTextField txtPaid;

    @FXML
    private JFXTextField txtDiscount;

    @FXML
    private JFXButton btnDone;


    @FXML
    private Label lblFullTotal;

    @FXML
    private Label lblSubTotal;

    @FXML
    void ClearActionPerform(ActionEvent event) {
        txtOrderDate.setText("");
        txtOrderQty.setText("");
        txtInvoiceNo.setText("");
        txtBalance.setText("");
        txtDiscount.setText("");
        txtBrandName.setText("");
        txtQtyOnHand.setText("");
        txtUnitPrice.setText("");
        txtMobileName.setText("");
        txtLname.setText("");
        txtFname.setText("");
        txtAddress.setText("");
        txtNic.setText("");
        txtPaid.setText("");
    }

    @FXML
    void DiscountActionPerform(ActionEvent event) {
        double fixTotal=Double.parseDouble(lblSubTotal.getText());
        double discount=Double.parseDouble(txtDiscount.getText());

        double fullTot=(100-discount )* fixTotal/100;
        lblFullTotal.setText(fullTot+"");
        txtDiscount.requestFocus();
    }

    @FXML
    void DoneActionPerform(ActionEvent event) throws Exception {
        String orderId = txtInvoiceNo.getText();
        String orderDate = txtOrderDate.getText();
        String customerId = cmboCustomerId.getSelectionModel().getSelectedItem().toString();
        String brandID = comboBatchId.getSelectionModel().getSelectedItem().toString();
        String mobileId = comboMobileId.getSelectionModel().getSelectedItem().toString();
        String mobileName = txtMobileName.getText();
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        int qty = Integer.parseInt(txtOrderQty.getText());

        ArrayList<CustomerOrderDetailsDTO> allOrderDetails=new ArrayList<>();
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        for (int i = 0; i < tblPurchaseOrder.getItems().size(); i++) {
            String  mobileCode = (String) tblPurchaseOrder.getColumns().get(2).getCellObservableValue(i).getValue();
            int qtyHand = (Integer) tblPurchaseOrder.getColumns().get(4).getCellObservableValue(i).getValue();
            double unitprz = (Double) tblPurchaseOrder.getColumns().get(3).getCellObservableValue(i).getValue();
            CustomerOrderDetailsDTO customerOrderDetailsDTO=new CustomerOrderDetailsDTO(orderId,mobileCode,qtyHand,unitprz);
            allOrderDetails.add(customerOrderDetailsDTO);
        }

        CustomerOrderDTO order=new CustomerOrderDTO(orderId,customerId,orderDate,allOrderDetails);
        boolean purchaseOrder=PurchaseOrderController.purchaseOrder(order);
        if (purchaseOrder){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Place Order...!", ButtonType.OK);
            alert.show();
        }
    }

    private static boolean purchaseOrder(CustomerOrderDTO order) throws Exception {
        return bo.purchaseOrder(order);
    }


    @FXML
    void PaidActionPerform(ActionEvent event) {
        double amount=Double.parseDouble(lblFullTotal.getText());
        double paidAmount=Double.parseDouble(txtPaid.getText());
        if (paidAmount>amount){
            double balance=paidAmount-amount;
            txtBalance.setText(balance+"");
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "enough amount...!", ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    void brandIdStateChange(ActionEvent event) throws Exception {
        String brandId=comboBatchId.getSelectionModel().getSelectedItem().toString();
        BrandsModelDTO searchBrand=BrandModelController.searchBrand(brandId);
        txtBrandName.setText(searchBrand.getBrandName());
    }

    @FXML
    void btnAddToCartAction(ActionEvent event) {
        int avilableQTYStock=Integer.parseInt(txtQtyOnHand.getText());
        int custRequestQTY=Integer.parseInt(txtOrderQty.getText());
        if(avilableQTYStock>=custRequestQTY) {
            String brandID = comboBatchId.getSelectionModel().getSelectedItem().toString();
            String mobileID = comboMobileId.getSelectionModel().getSelectedItem().toString();
            String mobileName = txtMobileName.getText();
            double unitPrice = Double.parseDouble(txtUnitPrice.getText());
            int qty = Integer.parseInt(txtOrderQty.getText());
            double total = unitPrice * custRequestQTY;

            dto = new PurchaseOrderDTO(mobileID,1,mobileName,"",qty,unitPrice,brandID," "," "," ",total);

            tblPurchaseOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("brandId"));
            tblPurchaseOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("mobileID"));
            tblPurchaseOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("mobileName"));
            tblPurchaseOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
            tblPurchaseOrder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("qty"));
            tblPurchaseOrder.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("total"));
            tblPurchaseOrder.setItems(FXCollections.observableArrayList(dto));

            lblSubTotal.setText(total+"");
        }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "OUT OF STOCK", ButtonType.OK);
                alert.show();
        }

    }

//    private int isRowAvailable(String brandId,String mobileId){
//        for (int i=0;i<tblPurchaseOrder.getItems().size();i++){
//            String BId=tblPurchaseOrder.getColumns().get(0).getCellObservableValue(i).getValue().toString();
//            String MId=tblPurchaseOrder.getColumns().get(1).getCellObservableValue(i).getValue().toString();
//            return (BId.equals(brandId) && MId.equals(mobileId)) ? i:-1;
//        }
//        return -1;
//    }
//    private boolean checkItemDublicate(String MobileId){
//        for (int i=0;i<tblPurchaseOrder.getItems().size();i++){
//            String rowsMobileId=tblPurchaseOrder.ge
//        }
//    }
    @FXML
    void mobileIdStateChange(ActionEvent event) throws Exception {
        String mobileId=comboMobileId.getSelectionModel().getSelectedItem().toString();
        MobileDTO searchMobile=MobileController.searchMobile(mobileId);
        txtMobileName.setText(searchMobile.getMobileName());
        txtUnitPrice.setText(searchMobile.getUnitPrice()+"");
        txtQtyOnHand.setText(searchMobile.getQty()+"");

    }


    @FXML
    void mouseClicked(MouseEvent event) {

    }

    @FXML
    void customerIdStateChange(ActionEvent event) throws Exception {
        String customerId = cmboCustomerId.getSelectionModel().getSelectedItem().toString();
        CustomerDTO searchCustomer = CustomerController.searchCustomer(customerId);
        txtFname.setText(searchCustomer.getFname());
        txtLname.setText(searchCustomer.getLname());
        txtNic.setText(searchCustomer.getNic());
        txtAddress.setText(searchCustomer.getAddress());
    }

    @FXML
    void txtInvoiceActionPerform(ActionEvent event) throws Exception {
        ArrayList<CustomEntity> searchCustomerOrders = PurchaseOrderController.searchCustomerOrders(txtInvoiceNo.getText());

        String customerID="";
        for (CustomEntity cus: searchCustomerOrders) {
            customerID=cus.getCustomerId();
            Object[] rowData={cus.getMobileID(),cus.getUnitPrice(),cus.getQtyOnHand(),(cus.getUnitPrice()*cus.getQtyOnHand())};
            dta.add(rowData);
        }
    }

    private static ArrayList<CustomEntity> searchCustomerOrders(String text) throws Exception {
        return bo.searchCustomerOrders(text);
    }


    private void setOrderID() {
        int id = new Random().nextInt(99999);
        String prefix = "OID";
        txtInvoiceNo.setText(prefix + id);
    }
    private void setOrderDate() {
        txtOrderDate.setText(LocalDate.now().toString());
//        LocalTime LocalTime2=LocalTime.of(21,30,59,11001);
//        txtOrderDate.setText(LocalTime2.toString());
    }

    private void loadAllCustomers() throws Exception {
        cmboCustomerId.getItems().removeAll();
        CustomerBO customerBO= (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.CUSTOMER);
        ArrayList<CustomerEntity> allCustomers=customerBO.getAllCustomer();
        for (CustomerEntity c :
                allCustomers) {
            cmboCustomerId.getItems().addAll(c.getId());
        }
    }

    private void loadAllMobiles() throws Exception {
        comboMobileId.getItems().removeAll();
        MobileBO mobileBO= (MobileBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.MOBILE);
        ArrayList<MobileEntity> allMobile=mobileBO.getAllMobile();
        for (MobileEntity m :
                allMobile) {
            comboMobileId.getItems().addAll(m.getMobileID());
        }
    }
    private void loadAllBrands() throws Exception {
        comboBatchId.getItems().removeAll();
        BrandsModelBO brandsModelBO= (BrandsModelBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.BRAND);
        ArrayList<BrandsModelEntity> allBrands=brandsModelBO.getAllBrands();
        for (BrandsModelEntity b :
                allBrands) {
            comboBatchId.getItems().addAll(b.getBrandId());
        }
    }
    @FXML
    void txtQtyActionPerform(ActionEvent event) {
//        int AvilableQTYStock=Integer.parseInt(txtQtyOnHand.getText());
//        int custRequestQTY=Integer.parseInt(txtOrderQty.getText());
//        if(AvilableQTYStock>=custRequestQTY){
//            String BrandID=comboBatchId.getSelectionModel().getSelectedItem().toString();
//            String MobileID=comboMobileId.getSelectionModel().getSelectedItem().toString();
//            String Mobile=txtMobileName.getText();
//            double unitPrice=Double.parseDouble(txtUnitPrice.getText());
//            int Qty=Integer.parseInt(txtOrderQty.getText());
//            double Amount=AvilableQTYStock*custRequestQTY;
//        }
    }
}
