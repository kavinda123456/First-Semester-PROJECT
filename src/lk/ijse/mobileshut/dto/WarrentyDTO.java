package lk.ijse.mobileshut.dto;

public class WarrentyDTO extends BrandsModelDTO {
    private String warrantyId;
    private String customerId;
    private String mobileId;
    private String startDate;
    private String endDate;

    public WarrentyDTO(){

    }

    public WarrentyDTO(String warrantyId, String customerId, String mobileId, String startDate, String endDate) {
        this.warrantyId=warrantyId;
        this.customerId=customerId;
        this.mobileId=mobileId;
        this.startDate=startDate;
        this.endDate=endDate;
    }

    public String getWarrantyId() {
        return warrantyId;
    }

    public void setWarrantyId(String warrantyId) {
        this.warrantyId = warrantyId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
