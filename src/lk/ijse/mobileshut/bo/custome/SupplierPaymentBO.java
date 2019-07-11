package lk.ijse.mobileshut.bo.custome;

import lk.ijse.mobileshut.bo.SuperBO;
import lk.ijse.mobileshut.dto.CustomerOrderDTO;
import lk.ijse.mobileshut.dto.SupplierOrderDTO;
import lk.ijse.mobileshut.dto.SupplierPaymentDTO;
import lk.ijse.mobileshut.entity.CustomEntity;
import lk.ijse.mobileshut.entity.SupplyEntity;

import java.util.ArrayList;

public interface SupplierPaymentBO extends SuperBO {
    public boolean purchaseOrder(SupplierOrderDTO ord)throws Exception;
    public ArrayList<SupplyEntity> searchSupplierOrders(String text)throws Exception;
}
