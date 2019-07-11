package lk.ijse.mobileshut.entity;

public class CustomerOrderDetails {
    private String orderId;
    private String mobileID;
    private int qtyOnHand;
    private double unitPrice;

    public CustomerOrderDetails(){

    }

    public CustomerOrderDetails(String orderId,String mobileID,int qtyOnHand,double unitPrice){
        this.orderId=orderId;
        this.mobileID=mobileID;
        this.qtyOnHand=qtyOnHand;
        this.unitPrice=unitPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMobileID() {
        return mobileID;
    }

    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
