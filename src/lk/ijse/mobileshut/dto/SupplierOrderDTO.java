package lk.ijse.mobileshut.dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class SupplierOrderDTO {
    private String suporderId;
    private String supplierId;
    private String suporderDate;
    private ArrayList<SupplierOrderDetailsDTO> allSupplierOrderDetails=new ArrayList<>();

    public SupplierOrderDTO(){

    }

    public SupplierOrderDTO(String suporderId, String supplierId, String suporderDate, ArrayList<SupplierOrderDetailsDTO> allSupplierOrderDetails) {
        this.suporderId = suporderId;
        this.supplierId = supplierId;
        this.suporderDate = suporderDate;
        this.allSupplierOrderDetails = allSupplierOrderDetails;
    }

    public String getSuporderId() {
        return suporderId;
    }

    public void setSuporderId(String suporderId) {
        this.suporderId = suporderId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSuporderDate() {
        return suporderDate;
    }

    public void setSuporderDate(String suporderDate) {
        this.suporderDate = suporderDate;
    }

    public ArrayList<SupplierOrderDetailsDTO> getAllSupplierOrderDetails() {
        return allSupplierOrderDetails;
    }

    public void setAllSupplierOrderDetails(ArrayList<SupplierOrderDetailsDTO> allSupplierOrderDetails) {
        this.allSupplierOrderDetails = allSupplierOrderDetails;
    }
}
