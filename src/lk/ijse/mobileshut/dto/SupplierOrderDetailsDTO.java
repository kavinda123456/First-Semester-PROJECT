package lk.ijse.mobileshut.dto;

public class SupplierOrderDetailsDTO {
    private String suporderId;
    private String mobileID;
    private int supqtyOnHand;
    private double supunitPrice;

    public SupplierOrderDetailsDTO(){

    }
    public SupplierOrderDetailsDTO(String suporderId,String mobileID,int supqtyOnHand,double supunitPrice){
        this.suporderId=suporderId;
        this.mobileID=mobileID;
        this.supqtyOnHand=supqtyOnHand;
        this.supunitPrice=supunitPrice;
    }

    public String getSuporderId() {
        return suporderId;
    }

    public void setSuporderId(String suporderId) {
        this.suporderId = suporderId;
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
