package lk.ijse.mobileshut.entity;

public class SupplierCustomEntity {
    private String mobileID;
    private int mobileEMI;
    private String mobileName;
    private String brand;
    private int qty;
    private double unitPrice;
    private String supplierId;
    private String supplierName;
    private String company;
    private int stp;
    private String snic;
    private String email;
    private String suporderId;
    private String suporderDate;
    private String suporderTime;
    private String suporderDetailsId;
    private int supqtyOnHand;

    public SupplierCustomEntity(){


    }
    public SupplierCustomEntity(String supplierId, String supplierName, String company, int stp, String snic, String email){
        this.supplierId=supplierId;
        this.supplierName=supplierName;
        this.company=company;
        this.stp=stp;
        this.snic=snic;
        this.email=email;
    }
    public SupplierCustomEntity(String mobileID, int mobileEMI, String mobileName, String brand, int qty, double unitPrice,String suporderId,String supplierId,String suporderDate,String suporderTime,String suporderDetailsId,int supqtyOnHand){
        this.mobileID=mobileID;
        this.mobileEMI=mobileEMI;
        this.mobileName=mobileName;
        this.brand=brand;
        this.qty=qty;
        this.unitPrice=unitPrice;
        this.suporderId=suporderId;
        this.supplierId=supplierId;
        this.suporderDate=suporderDate;
        this.suporderTime=suporderTime;
        this.suporderDetailsId=suporderDetailsId;
        this.supqtyOnHand=supqtyOnHand;
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

    public String getSuppierId() {
        return supplierId;
    }

    public void setSuppierId(String suppierId) {
        this.supplierId = suppierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getStp() {
        return stp;
    }

    public void setStp(int stp) {
        this.stp = stp;
    }

    public String getSnic() {
        return snic;
    }

    public void setSnic(String snic) {
        this.snic = snic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSuporderTime() {
        return suporderTime;
    }

    public void setSuporderTime(String suporderTime) {
        this.suporderTime = suporderTime;
    }

    public String getSuporderDetailsId() {
        return suporderDetailsId;
    }

    public void setSuporderDetailsId(String suporderDetailsId) {
        this.suporderDetailsId = suporderDetailsId;
    }

    public int getSupqtyOnHand() {
        return supqtyOnHand;
    }

    public void setSupqtyOnHand(int supqtyOnHand) {
        this.supqtyOnHand = supqtyOnHand;
    }
}
