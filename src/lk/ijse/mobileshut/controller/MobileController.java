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
import lk.ijse.mobileshut.bo.custome.MobileBO;
import lk.ijse.mobileshut.dto.MobileDTO;
import lk.ijse.mobileshut.entity.MobileEntity;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MobileController implements Initializable {
    static MobileBO bo= (MobileBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.MOBILE);

    @FXML
    private JFXButton btnMbladd;

    @FXML
    private JFXButton btnMblRefresh;

    @FXML
    private JFXTextField txtUnitPrice;

    @FXML
    private JFXTextField txtmblQty;

    @FXML
    private JFXTextField txtmblID;

    @FXML
    private JFXTextField txtmblName;

    @FXML
    private JFXTextField txtmblBrand;

    @FXML
    private JFXTextField txtMobEMI;

    @FXML
    private TextField txtmblID1;

    @FXML
    private TextField txtUnitprice1;

    @FXML
    private TextField txtQty1;

    @FXML
    private TextField txtmblName1;

    @FXML
    private TableView<MobileEntity> tblmblDetails;

    @FXML
    private JFXButton btnMblUpdate;

    @FXML
    private JFXButton btnMblRemove;

    @FXML
    private JFXButton btnMblSearch;

    @FXML
    private TextField txtmblBrand1;

    @FXML
    private TextField txtMobEMI1;

    @FXML
    private TableColumn<MobileEntity, String> columnMobile;

    @FXML
    void RemovemblOnAction(ActionEvent event) throws Exception {
        String mobId = txtmblID1.getText();
        boolean isRemoved = MobileController.removeMobile(mobId);
        if (isRemoved){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Removed...!", ButtonType.OK);
            alert.show();
            clearAll();
            getAllMobile();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "failed...!", ButtonType.OK);
            alert.show();
        }
    }

    private static boolean removeMobile(String id) throws Exception {
        return bo.removeMobile(id);
    }

    @FXML
    void SearchmblOnAction(ActionEvent event) throws Exception {
        String searchId = txtmblID1.getText();
        MobileDTO SearchMobile = MobileController.searchMobile(searchId);
        txtmblID1.setText(SearchMobile.getMobileID());
        txtMobEMI1.setText(SearchMobile.getMobileEMI()+"");
        txtmblName1.setText(SearchMobile.getMobileName());
        txtmblBrand1.setText(SearchMobile.getBrand());
        txtQty1.setText(SearchMobile.getQty()+"");
        txtUnitprice1.setText(SearchMobile.getUnitPrice()+"");
    }

    public static MobileDTO searchMobile(String id) throws Exception {
        return bo.searchMobile(id);
    }

    @FXML
    void addmblOnAction(ActionEvent event) throws Exception {
        String mobileID = txtmblID.getText();
        int mobileEMI = Integer.parseInt(txtMobEMI.getText());
        String mobileName = txtmblName.getText();
        String brand = txtmblBrand.getText();
        int qty = Integer.parseInt(txtmblQty.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        MobileDTO MobiModel = new MobileDTO(mobileID, mobileEMI, mobileName, brand, qty, unitPrice);
        boolean isAded = MobileController.AddMobiles(MobiModel);
        if (isAded){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Aded...!", ButtonType.OK);
            alert.show();
            getAllMobile();
            clearAll();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "fqailed..!", ButtonType.OK);
            alert.show();
        }
    }

    private static boolean AddMobiles(MobileDTO ref) throws Exception {
        return bo.AddMobile(ref);
    }

    @FXML
    void onMouseClicked(MouseEvent event) {
        getSelecedValue();
    }

    private void getSelecedValue() {
        tblmblDetails.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MobileEntity>() {
            @Override
            public void changed(ObservableValue<? extends MobileEntity> observable, MobileEntity oldValue, MobileEntity newValue) {
                MobileEntity value=observable.getValue();
                txtmblID1.setText(value.getMobileID());
                txtmblName1.setText(value.getMobileName());
                txtmblBrand1.setText(value.getBrand());
                txtMobEMI1.setText(value.getMobileEMI()+"");
                txtQty1.setText(value.getQty()+"");
                txtUnitprice1.setText(value.getUnitPrice()+"");
            }
        });
    }

    @FXML
    void refreshmblOnAction(ActionEvent event) {
        clearAll();
    }
    public void clearAll(){
        txtmblID.setText("");
        txtMobEMI.setText("");
        txtmblName.setText("");
        txtmblBrand.setText("");
        txtmblQty.setText("");
        txtUnitPrice.setText("");
    }

    @FXML
    void searchUsingCustomerId(ActionEvent event) {

    }

    @FXML
    void updatemblOnAction(ActionEvent event) throws Exception {
        String mobileID = txtmblID1.getText();
        int mobileEMI = Integer.parseInt(txtMobEMI1.getText());
        String mobileName = txtmblName1.getText();
        String brand = txtmblBrand1.getText();
        int qty = Integer.parseInt(txtQty1.getText());
        double unitPrice = Double.parseDouble(txtUnitprice1.getText());
        MobileDTO MobiModel = new MobileDTO(mobileID, mobileEMI, mobileName, brand, qty, unitPrice);
        boolean isUpdated = MobileController.updateMobile(MobiModel);
        if(isUpdated){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Updated...!", ButtonType.OK);
            alert.show();
            clearAll();
            getAllMobile();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "failed...!", ButtonType.OK);
            alert.show();
        }

    }

    private static boolean updateMobile(MobileDTO ref) throws Exception {
        return bo.updateMobile(ref);
    }
    private void getAllMobile() throws Exception {
        ArrayList<MobileEntity> allMobile = bo.getAllMobile();
        tblmblDetails.setItems(FXCollections.observableArrayList(allMobile));
        tblmblDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("mobileID"));
        tblmblDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("mobileEMI"));
        tblmblDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("MobileName"));
        tblmblDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Brand"));
        tblmblDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Qty"));
        tblmblDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAllMobile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
