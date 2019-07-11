package lk.ijse.mobileshut.entity;

public class SupplyEntity {
    private String supplierId;
    private String supplierName;
    private String company;
    private int stp;
    private String snic;
    private String email;
    private String suporderId;
    private String suporderDate;
    private String mobileID;
    private String SupplierId;
    private int supqtyOnHand;
    private double unitPrice;

    public SupplyEntity(){

    }

    public SupplyEntity(String supplierId, String supplierName, String company, int stp, String snic, String email) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.company = company;
        this.stp = stp;
        this.snic = snic;
        this.email = email;
    }

    public SupplyEntity(String suporderId, String suporderDate, String supplierId, String mobileID, int supqtyOnHand, double unitPrice) {
        this.suporderId = suporderId;
        this.suporderDate = suporderDate;
        this.mobileID = mobileID;
        SupplierId = supplierId;
        this.supqtyOnHand = supqtyOnHand;
        this.unitPrice = unitPrice;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
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

    public String getSuporderDate() {
        return suporderDate;
    }

    public void setSuporderDate(String suporderDate) {
        this.suporderDate = suporderDate;
    }

    public String getMobileID() {
        return mobileID;
    }

    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }
}
