package lk.ijse.mobileshut.dto;

public class PurchaseOrderDTO {
    private String mobileID;
    private int mobileEMI;
    private String mobileName;
    private String brand;
    private int qty;
    private double unitPrice;
    private String brandId;
    private String brandName;
    private String description;
    private String madeIn;
    private double total;

    public PurchaseOrderDTO(String mobileID, int mobileEMI, String mobileName, String brand, int qty, double unitPrice, String brandId, String brandName, String description, String madeIn,double total) {
        this.mobileID = mobileID;
        this.mobileEMI = mobileEMI;
        this.mobileName = mobileName;
        this.brand = brand;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.brandId = brandId;
        this.brandName = brandName;
        this.description = description;
        this.madeIn = madeIn;
        this.total=total;
    }

    public PurchaseOrderDTO() {
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

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }
}
