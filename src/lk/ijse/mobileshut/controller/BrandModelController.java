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
import lk.ijse.mobileshut.bo.custome.BrandsModelBO;
import lk.ijse.mobileshut.dto.BrandsModelDTO;
import lk.ijse.mobileshut.entity.BrandsModelEntity;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BrandModelController implements Initializable {
    static BrandsModelBO bo= (BrandsModelBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.BRAND);
    @FXML
    private JFXButton btnBrndAdd;

    @FXML
    private JFXButton btnBrndRefresh;

    @FXML
    private JFXTextField txtBrandId;

    @FXML
    private JFXTextField txtBrandName;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtMadeIn;


    @FXML
    private TextField txtBrandId1;

    @FXML
    private TextField txtBrandName1;

    @FXML
    private TextField txtDescription1;

    @FXML
    private TextField txtMadeIn1;

    @FXML
    private TableView<BrandsModelEntity> tblBrandDetails;

    @FXML
    private JFXButton btnBrndUpdate;

    @FXML
    private JFXButton btnBrndRemove;

    @FXML
    private JFXButton btnBrndSearch;

    @FXML
    private TableColumn<BrandsModelEntity, String> columnBrand;

    @FXML
    void addBrandOnAction(ActionEvent event) throws Exception {
        String brandId = txtBrandId.getText();
        String brandName = txtBrandName.getText();
        String description = txtDescription.getText();
        String madeIn = txtMadeIn.getText();
        BrandsModelDTO BrandModel = new BrandsModelDTO(brandId, brandName, description, madeIn);
        boolean isAdded = BrandModelController.addBrand(BrandModel);
        if (isAdded){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added Successful..!", ButtonType.OK);
            alert.show();
            clear();
            getAllBrand();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "fail", ButtonType.OK);
            alert.show();
        }
    }
    private static boolean addBrand(BrandsModelDTO ref) throws Exception {
        return bo.addBrand(ref);
    }

    @FXML
    void deleteBrandOnAction(ActionEvent event) throws Exception {
        String brandId = txtBrandId1.getText();
        boolean isRemove = BrandModelController.deleteBrand(brandId);
        if (isRemove){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Removed...!", ButtonType.OK);
            alert.show();
            clear();
            getAllBrand();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Failed...!", ButtonType.OK);
            alert.show();
        }

    }

    private static boolean deleteBrand(String id) throws Exception {
        return bo.removeBrand(id);
    }

    @FXML
    void onMouseClicked(MouseEvent event) {
        getSelectedValue();
    }

    private void getSelectedValue() {
        tblBrandDetails.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BrandsModelEntity>() {

            @Override
            public void changed(ObservableValue<? extends BrandsModelEntity> observable, BrandsModelEntity oldValue, BrandsModelEntity newValue) {
                BrandsModelEntity value=observable.getValue();
                txtBrandId1.setText(value.getBrandId());
                txtBrandName1.setText(value.getBrandName());
                txtDescription1.setText(value.getDescription());
                txtMadeIn1.setText(value.getMadeIn());
            }
        });
    }

    @FXML
    void refreshBrandOnAction(ActionEvent event) {
        clear();
    }
    public void clear(){
        txtMadeIn1.setText("");
        txtMadeIn.setText("");
        txtDescription1.setText("");
        txtDescription.setText("");
        txtBrandName1.setText("");
        txtBrandName.setText("");
        txtBrandId1.setText("");
        txtBrandId.setText("");

    }

    @FXML
    void seaarchBrandOnAction(ActionEvent event) throws Exception {
        String brandId = txtBrandId1.getText();
        BrandsModelDTO searchBrand = BrandModelController.searchBrand(brandId);
        txtBrandId1.setText(searchBrand.getBrandId());
        txtBrandName1.setText(searchBrand.getBrandName());
        txtDescription1.setText(searchBrand.getDescription());
        txtMadeIn1.setText(searchBrand.getMadeIn());
    }

    public static BrandsModelDTO searchBrand(String id) throws Exception {
        return bo.searchBrand(id);
    }

    @FXML
    void searchUsingCustomerId(ActionEvent event) {

    }

    @FXML
    void updateBrandOnAction(ActionEvent event) throws Exception {
        String brandId = txtBrandId1.getText();
        String brandName = txtBrandName1.getText();
        String description = txtDescription1.getText();
        String madeIn = txtMadeIn1.getText();
        BrandsModelDTO brandModel = new BrandsModelDTO(brandId, brandName, description, madeIn);
        boolean isUpdated = BrandModelController.updateBrand(brandModel);
        if(isUpdated){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Updated...!", ButtonType.OK);
            alert.show();
            clear();
            getAllBrand();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "failed...!", ButtonType.OK);
            alert.show();
        }

    }

    private static boolean updateBrand(BrandsModelDTO ref) throws Exception {
        return bo.updateBrand(ref);
    }
    private void getAllBrand()throws Exception{
        ArrayList<BrandsModelEntity> allBrands=bo.getAllBrands();
        tblBrandDetails.setItems(FXCollections.observableArrayList(allBrands));
        tblBrandDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("brandId"));
        tblBrandDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brandName"));
        tblBrandDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblBrandDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("madeIn"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAllBrand();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
