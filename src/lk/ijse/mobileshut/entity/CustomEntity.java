package lk.ijse.mobileshut.entity;

public class CustomEntity {
    private String id;
    private String fname;
    private String lname;
    private String address;
    private int tp;
    private String nic;
    private String date;
    private String orderId;
    private String customerId;
    private String orderDate;
    private String mobileID;
    private int qtyOnHand;
    private double unitPrice;

    public CustomEntity(){
    }
    public CustomEntity(String id,String fname,String lname,String address,int tp,String nic,String date){
        this.id=id;
        this.fname=fname;
        this.lname=lname;
        this.address=address;
        this.tp=tp;
        this.nic=nic;
        this.date=date;
    }
    public CustomEntity(String orderId, String customerId,String orderDate,String mobileID,int qtyOnHand,double unitPrice){
        this.orderId=orderId;
        this.customerId=customerId;
        this.orderDate=orderDate;
        this.mobileID=mobileID;
        this.qtyOnHand=qtyOnHand;
        this.unitPrice=unitPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
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
