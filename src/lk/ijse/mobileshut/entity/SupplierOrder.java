package lk.ijse.mobileshut.entity;

import java.time.LocalDate;

public class SupplierOrder {
    private String suporderId;
    private String supplierId;
    private String suporderDate;

    public SupplierOrder(){

    }

    public SupplierOrder(String suporderId, String supplierId, String suporderDate) {
        this.suporderId = suporderId;
        this.supplierId = supplierId;
        this.suporderDate = suporderDate;
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
}
