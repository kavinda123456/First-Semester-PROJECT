package lk.ijse.mobileshut.dto;

public class CustomerOrderDetailsDTO {
    private String OrderId;
    private String MobileID;
    private int QtyOnHand;
    private double UnitPrice;

    public CustomerOrderDetailsDTO(){

    }

    public CustomerOrderDetailsDTO(String OrderId,String MobileID,int QtyOnHand,double UnitPrice){
        this.OrderId=OrderId;
        this.MobileID=MobileID;
        this.QtyOnHand=QtyOnHand;
        this.UnitPrice=UnitPrice;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getMobileID() {
        return MobileID;
    }

    public void setMobileID(String mobileID) {
        MobileID = mobileID;
    }

    public int getQtyOnHand() {
        return QtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        QtyOnHand = qtyOnHand;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }
}
