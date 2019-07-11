package lk.ijse.mobileshut.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SecondDashController {

    @FXML
    private AnchorPane secondDash;

    @FXML
    private AnchorPane subdash1;

    @FXML
    private AnchorPane subdash2;

    @FXML
    private AnchorPane subdash3;

    @FXML
    private AnchorPane subdash4;

    @FXML
    private AnchorPane subdash5;

    @FXML
    private AnchorPane subdash6;

    @FXML
    private AnchorPane subdash7;

    @FXML
    void goBrandModel(MouseEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/mobileshut/view/BrandsModelView.fxml"));
        this.secondDash.getChildren().clear();
        this.secondDash.getChildren().add(root);

    }

    @FXML
    void goCustomerView(MouseEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/mobileshut/view/CustomerView.fxml"));
        this.secondDash.getChildren().clear();
        this.secondDash.getChildren().add(root);
    }

    @FXML
    void goMobileDetail(MouseEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/mobileshut/view/MobileView.fxml"));
        this.secondDash.getChildren().clear();
        this.secondDash.getChildren().add(root);
    }

    @FXML
    void goPurchaseOrder(MouseEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/mobileshut/view/PurchaseOrderView.fxml"));
        this.secondDash.getChildren().clear();
        this.secondDash.getChildren().add(root);
    }

    @FXML
    void goSupplierPayment(MouseEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/mobileshut/view/SupplierPaymentView.fxml"));
        this.secondDash.getChildren().clear();
        this.secondDash.getChildren().add(root);
    }

    @FXML
    void goSupplierView(MouseEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/mobileshut/view/SupplierView.fxml"));
        this.secondDash.getChildren().clear();
        this.secondDash.getChildren().add(root);
    }

    @FXML
    void goWarrenty(MouseEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/mobileshut/view/WarrentyForm.fxml"));
        this.secondDash.getChildren().clear();
        this.secondDash.getChildren().add(root);
    }
}
