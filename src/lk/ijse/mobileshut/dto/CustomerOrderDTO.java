package lk.ijse.mobileshut.dto;

import lk.ijse.mobileshut.entity.CustomerOrderDetails;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerOrderDTO {
    private String orderId;
    private String customerId;
    private String orderDate;
    private ArrayList<CustomerOrderDetailsDTO> allCustomerOrderDetails=new ArrayList<>();

    public CustomerOrderDTO(){

    }

    public CustomerOrderDTO(String orderId, String customerId, String orderDate, ArrayList<CustomerOrderDetailsDTO> allCustomerOrderDetails) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.allCustomerOrderDetails = allCustomerOrderDetails;
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

    public ArrayList<CustomerOrderDetailsDTO> getAllCustomerOrderDetails() {
        return allCustomerOrderDetails;
    }

    public void setAllCustomerOrderDetails(ArrayList<CustomerOrderDetailsDTO> allCustomerOrderDetails) {
        this.allCustomerOrderDetails = allCustomerOrderDetails;
    }
}
