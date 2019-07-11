package lk.ijse.mobileshut.entity;

public class SupplierOrderDetaails {
    private String suporderId;
    private String mobileID;
    private int supqtyOnHand;
    private double unitPrice;
    public SupplierOrderDetaails(){

    }
    public SupplierOrderDetaails(String suporderId,String mobileID,int supqtyOnHand,double unitPrice){
        this.suporderId=suporderId;
        this.mobileID=mobileID;
        this.supqtyOnHand=supqtyOnHand;
        this.unitPrice=unitPrice;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
