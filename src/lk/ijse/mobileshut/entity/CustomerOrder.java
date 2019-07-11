package lk.ijse.mobileshut.entity;

public class CustomerOrder {
    private String orderId;
    private String customerId;
    private String orderDate;

    public CustomerOrder(){

    }

    public CustomerOrder(String orderId,String customerId,String orderDate){
    this.orderId=orderId;
    this.customerId=customerId;
    this.orderDate=orderDate;
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

}
