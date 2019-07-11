package lk.ijse.mobileshut.bo.custome;

import lk.ijse.mobileshut.bo.SuperBO;
import lk.ijse.mobileshut.dto.CustomerOrderDTO;
import lk.ijse.mobileshut.entity.CustomEntity;

import java.util.ArrayList;

public interface PurchaseOrderBO extends SuperBO {
    public boolean purchaseOrder(CustomerOrderDTO ord)throws Exception;
    public ArrayList<CustomEntity> searchCustomerOrders(String text)throws Exception;
}
