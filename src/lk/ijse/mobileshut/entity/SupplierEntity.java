package lk.ijse.mobileshut.entity;

public class SupplierEntity {
    private String supplierId;
    private String supplierName;
    private String company;
    private int stp;
    private String snic;
    private String email;

    public SupplierEntity(){

    }

    public SupplierEntity(String supplierId, String supplierName, String company, int stp, String snic, String email) {
        this.supplierId=supplierId;
        this.supplierName=supplierName;
        this.company=company;
        this.stp=stp;
        this.snic=snic;
        this.email=email;

    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String suppierId) {
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
}
