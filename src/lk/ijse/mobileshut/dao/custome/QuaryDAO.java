package lk.ijse.mobileshut.dao.custome;

import lk.ijse.mobileshut.dao.SuperDAO;
import lk.ijse.mobileshut.entity.CustomEntity;
import lk.ijse.mobileshut.entity.SupplyEntity;

import java.util.ArrayList;

public interface QuaryDAO extends SuperDAO {
    public ArrayList<CustomEntity> searchCustomerOrders(String OrderId)throws Exception;
    public ArrayList<SupplyEntity> searchSupplierOrders(String SupOrderId)throws Exception;
}
