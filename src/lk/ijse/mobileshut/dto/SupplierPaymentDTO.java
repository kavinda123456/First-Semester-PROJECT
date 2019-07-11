package lk.ijse.mobileshut.dto;

public class SupplierPaymentDTO {
    private String suporderId;
    private String supplierId;
    private String suporderDate;
    private String mobileID;
    private int supqtyOnHand;
    private double supunitPrice;

    public SupplierPaymentDTO(){}

    public SupplierPaymentDTO(String suporderId,String supplierId,String suporderDate){
        this.suporderId=suporderId;
        this.supplierId=supplierId;
        this.suporderDate=suporderDate;

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

    public SupplierPaymentDTO(String suporderId, String mobileID, int supqtyOnHand, double supunitPrice){
        this.suporderId=suporderId;
        this.mobileID=mobileID;
        this.supqtyOnHand=supqtyOnHand;
        this.supunitPrice=supunitPrice;
    }

    public String getMobileID() {
        return mobileID;
    }

    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }

    public int getSupqtyOnHand() {
        return supqtyOnHand;
    }

    public void setSupqtyOnHand(int supqtyOnHand) {
        this.supqtyOnHand = supqtyOnHand;
    }

    public double getSupunitPrice() {
        return supunitPrice;
    }

    public void setSupunitPrice(double supunitPrice) {
        this.supunitPrice = supunitPrice;
    }
}
