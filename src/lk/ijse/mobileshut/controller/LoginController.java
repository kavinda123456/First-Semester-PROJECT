package lk.ijse.mobileshut.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.ijse.mobileshut.db.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private AnchorPane anchorPane1;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPW;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private AnchorPane loginAnchor;

    private Connection connection;
    private PreparedStatement pstm;
    private ResultSet rst;

    @FXML
    private void handleLogin(ActionEvent event) throws Exception {

        if(txtUserName.getText().equalsIgnoreCase("Admin") && txtPW.getText().equalsIgnoreCase("Admin")){

            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/mobileshut/view/Dashboad.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) this.loginAnchor.getScene().getWindow();
            stage.setScene(scene);


        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING, "Error", ButtonType.OK);
            alert.show();


        }
//        if (txtUserName.getText().equals(GetEmail()) && txtPW.getText().equals(GetPassword())){
//
//            Stage stage = (Stage) anchorPane1.getScene().getWindow();
//            stage.close();
//            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/mobileshut/view/Login.fxml"));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//
//        }
    }
    private String GetEmail(){
        String Email="";
        try {
            pstm=connection.prepareStatement("SELECT EMAIL FROM USERS WHERE EMAIL=?");
            pstm.setString(1,txtUserName.getText());
            if (rst.next()) {
                Email=rst.getString(1);
                rst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Email;
    }
    private String GetPassword(){
        String Password="";
        try {
            pstm=connection.prepareStatement("SELECT PASSWORD FROM USERS WHERE PASSWORD=?");
            pstm.setString(1,txtUserName.getText());
            if (rst.next()) {
                Password=rst.getString(1);
                rst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Password;
    }

    @FXML
    private void insertOnAction(ActionEvent event) {

    }

}
