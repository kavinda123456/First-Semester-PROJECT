package lk.ijse.mobileshut.entity;

public class BrandsModelEntity {
    private String brandId;
    private String brandName;
    private String description;
    private String madeIn;

    public  BrandsModelEntity(){

    }

    public BrandsModelEntity(String brandId,String brandName,String description,String madeIn){
        this.brandId=brandId;
        this.brandName=brandName;
        this.description=description;
        this.madeIn=madeIn;
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

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }
}
