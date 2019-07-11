package lk.ijse.mobileshut.entity;

public class MobileEntity {
    private String mobileID;
    private int mobileEMI;
    private String mobileName;
    private String brand;
    private int qty;
    private double unitPrice;

    public MobileEntity(){

    }
    public MobileEntity(String mobileID, int mobileEMI, String mobileName, String brand, int qty, double unitPrice){
        this.mobileID=mobileID;
        this.mobileEMI=mobileEMI;
        this.mobileName=mobileName;
        this.brand=brand;
        this.qty=qty;
        this.unitPrice=unitPrice;
    }

    public String getMobileID() {
        return mobileID;
    }

    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }

    public int getMobileEMI() {
        return mobileEMI;
    }

    public void setMobileEMI(int mobileEMI) {
        this.mobileEMI = mobileEMI;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
