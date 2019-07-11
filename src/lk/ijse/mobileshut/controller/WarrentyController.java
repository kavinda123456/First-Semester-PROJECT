package lk.ijse.mobileshut.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.mobileshut.bo.BOFactory;
import lk.ijse.mobileshut.bo.custome.CustomerBO;
import lk.ijse.mobileshut.bo.custome.MobileBO;
import lk.ijse.mobileshut.bo.custome.WarrentyBO;
import lk.ijse.mobileshut.dto.CustomerDTO;
import lk.ijse.mobileshut.dto.MobileDTO;
import lk.ijse.mobileshut.dto.WarrentyDTO;
import lk.ijse.mobileshut.entity.CustomerEntity;
import lk.ijse.mobileshut.entity.MobileEntity;
import lk.ijse.mobileshut.entity.WarrentyEntity;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.table.TableModel;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class WarrentyController implements Initializable {
    static WarrentyBO bo= (WarrentyBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.WARRANTY);
    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXTextField txtWarID;

    @FXML
    private JFXTextField txtStartDate;

    @FXML
    private JFXComboBox<String> comboCustId;

    @FXML
    private JFXComboBox<String> comboMobileId;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXTextField txtEndDate;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private TableView<WarrentyEntity> tblWarrenty;

    @FXML
    private TableColumn<WarrentyEntity, String> columnWarId;

    @FXML
    void addBrandOnAction(ActionEvent event){
        String warrantyId = txtWarID.getText();
        String customerId = comboCustId.getSelectionModel().getSelectedItem().toString();
        String mobileId = comboMobileId.getSelectionModel().getSelectedItem().toString();
        String startDate = txtStartDate.getText();
        String endDate= txtEndDate.getText();
        //jasper Report
        InputStream  is=this.getClass().getResourceAsStream("/lk/ijse/mobileshut/report/warranty.jasper");
        HashMap map=new HashMap();
        map.put("WarrantyId",warrantyId);
        map.put("CustomerId",customerId);
        map.put("MobileId",mobileId);
        map.put("StartDate",startDate);
        map.put("EndDate",endDate);
        JasperPrint print= null;
        try {
            print = JasperFillManager.fillReport(is,map,new JREmptyDataSource());
        } catch (JRException e) {
            e.printStackTrace();
        }
        JasperViewer.viewReport(print,false);
        //

        WarrentyDTO warrentyModel=new WarrentyDTO(warrantyId,customerId,mobileId,startDate,endDate);
        boolean isAdded = false;
        try {
            isAdded = WarrentyController.addWarranty(warrentyModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(isAdded){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Aded Successful..!", ButtonType.OK);
            alert.show();
            clear();
            try {
                getAllWarrenty();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Failed..!", ButtonType.OK);
            alert.show();
        }
    }
    @FXML
    void onMouseClicked(MouseEvent event) {
        getSelectedValue();
    }

    private void getSelectedValue() {
        tblWarrenty.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<WarrentyEntity>() {
            @Override
            public void changed(ObservableValue<? extends WarrentyEntity> observable, WarrentyEntity oldValue, WarrentyEntity newValue) {
                WarrentyEntity value=observable.getValue();
                txtWarID.setText(value.getWarrantyId());
                comboCustId.setId(value.getCustomerId());
                comboMobileId.setId(value.getMobileId());
                txtStartDate.setText(value.getStartDate());
                txtEndDate.setText(value.getEndDate());
            }
        });
    }

    private static boolean addWarranty(WarrentyDTO ref) throws Exception {
        return bo.addWarranty(ref);
    }

    @FXML
    void cmbCustomerChanged(ActionEvent event) throws Exception {
        String customerId = comboCustId.getSelectionModel().getSelectedItem().toString();
        CustomerDTO searchCustomer = CustomerController.searchCustomer(customerId);

    }

    @FXML
    void cmbMobileChange(ActionEvent event) throws Exception {
        String mobileId=comboMobileId.getSelectionModel().getSelectedItem().toString();
        MobileDTO searchMobile=MobileController.searchMobile(mobileId);
    }


    @FXML
    void refreshOnAction(ActionEvent event) {
        clear();

    }
    public void clear(){
        txtWarID.setText("");
        comboCustId.setId("");
        comboMobileId.setId("");
        txtStartDate.setText("");
        txtEndDate.setText("");
    }

    @FXML
    void searchOnAction(ActionEvent event) throws Exception {
        String warrentiId = txtWarID.getText();
        WarrentyDTO warrentyModel = WarrentyController.searchWarranty(warrentiId);
        txtWarID.setText(warrentyModel.getWarrantyId());
        comboCustId.setId(warrentyModel.getWarrantyId());
        comboMobileId.setId(warrentyModel.getMobileId());
        txtStartDate.setText(warrentyModel.getStartDate());
        txtEndDate.setText(warrentyModel.getEndDate());

    }

    private static WarrentyDTO searchWarranty(String id) throws Exception {
        return (WarrentyDTO) bo.searchWarranty(id);
    }

    @FXML
    void RemoveOnAction(ActionEvent event) throws Exception {
        String warrantyId = txtWarID.getText();
        boolean isDeleted = WarrentyController.removeWarranty(warrantyId);
        if (isDeleted){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Delete Successful..!", ButtonType.OK);
            alert.show();
            clear();
            getAllWarrenty();
        }
    }

    private static boolean removeWarranty(String id) throws Exception {
        return bo.removeWarranty(id);
    }

    private void setStartDate() {
        txtStartDate.setText(LocalDate.now().toString());
    }

    private void setEndDate() {
        LocalDate ld = LocalDate.now();
        LocalDate ldNew = ld.plusYears(3);
        txtEndDate.setText(ldNew.toString());
    }
    private void loadAllCustomers() throws Exception {
        comboCustId.getItems().removeAll();
        CustomerBO customerBO= (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.CUSTOMER);
        ArrayList<CustomerEntity> allCustomers=customerBO.getAllCustomer();
        for (CustomerEntity c :
                allCustomers) {
            comboCustId.getItems().addAll(c.getId());
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
    private void getAllWarrenty() throws Exception {
        ArrayList<WarrentyEntity> allwarrenty=bo.getAllWarranty();
        tblWarrenty.setItems(FXCollections.observableArrayList(allwarrenty));
        tblWarrenty.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("warrantyId"));
        tblWarrenty.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerId"));
        tblWarrenty.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("mobileId"));
        tblWarrenty.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("startDate"));
        tblWarrenty.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("endDate"));
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setStartDate();
        setEndDate();

        try {
            loadAllMobiles();
            loadAllCustomers();
            getAllWarrenty();
            tblWarrenty.getSelectionModel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
