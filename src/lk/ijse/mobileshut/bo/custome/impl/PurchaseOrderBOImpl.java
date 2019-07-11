package lk.ijse.mobileshut.bo.custome.impl;

import lk.ijse.mobileshut.bo.custome.PurchaseOrderBO;
import lk.ijse.mobileshut.dao.DAOFactory;
import lk.ijse.mobileshut.dao.custome.CustomerOrderDAO;
import lk.ijse.mobileshut.dao.custome.CustomerOrderDetailsDAO;
import lk.ijse.mobileshut.dao.custome.QuaryDAO;
import lk.ijse.mobileshut.db.DBConnection;
import lk.ijse.mobileshut.dto.CustomerOrderDTO;
import lk.ijse.mobileshut.dto.CustomerOrderDetailsDTO;
import lk.ijse.mobileshut.entity.CustomEntity;
import lk.ijse.mobileshut.entity.CustomerOrder;
import lk.ijse.mobileshut.entity.CustomerOrderDetails;

import java.sql.Connection;
import java.util.ArrayList;

import static lk.ijse.mobileshut.dao.DAOFactory.DAOTypes.ORDER;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {
    CustomerOrderDAO ords= (CustomerOrderDAO) DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.ORDER);
    CustomerOrderDetailsDAO ordDs= (CustomerOrderDetailsDAO) DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.ORDERDETAILS);
    QuaryDAO quaryDAO= (QuaryDAO) DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.QUARYDAO);
    @Override
    public boolean purchaseOrder(CustomerOrderDTO ord) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        boolean add=ords.add(new CustomerOrder(ord.getOrderId(),ord.getCustomerId(),ord.getOrderDate()));
        if (add){
            boolean result=true;
            for (CustomerOrderDetailsDTO D: ord.getAllCustomerOrderDetails()) {
                boolean isAddedCustOrders = ordDs.add(new CustomerOrderDetails(D.getOrderId(), D.getMobileID(), D.getQtyOnHand(), D.getUnitPrice()));
                if(!isAddedCustOrders){
                    connection.rollback();
                    connection.setAutoCommit(true);
                     result=false;
                }
            }

//            connection.rollback();
////            connection.setAutoCommit(true);
////            return true;
            return result;
        }else {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }
    }

    @Override
    public ArrayList<CustomEntity> searchCustomerOrders(String text) throws Exception {
        return quaryDAO.searchCustomerOrders(text);
    }
}
