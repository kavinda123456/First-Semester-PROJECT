package lk.ijse.mobileshut.bo.custome.impl;

import lk.ijse.mobileshut.bo.custome.SupplierBO;
import lk.ijse.mobileshut.bo.custome.SupplierPaymentBO;
import lk.ijse.mobileshut.dao.DAOFactory;
import lk.ijse.mobileshut.dao.custome.QuaryDAO;
import lk.ijse.mobileshut.dao.custome.SupplierOrderDAO;
import lk.ijse.mobileshut.dao.custome.SupplierOrderDetailsDAO;
import lk.ijse.mobileshut.dao.custome.impl.QuaryDAOImpl;
import lk.ijse.mobileshut.db.DBConnection;
import lk.ijse.mobileshut.dto.SupplierOrderDTO;
import lk.ijse.mobileshut.dto.SupplierOrderDetailsDTO;
import lk.ijse.mobileshut.entity.SupplierOrder;
import lk.ijse.mobileshut.entity.SupplierOrderDetaails;
import lk.ijse.mobileshut.entity.SupplyEntity;

import java.sql.Connection;
import java.util.ArrayList;

public class SupplierPaymentBOImpl implements SupplierPaymentBO {
    SupplierOrderDAO order= (SupplierOrderDAO) DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.SUPPLIERORDER);
    SupplierOrderDetailsDAO orderdetail= (SupplierOrderDetailsDAO) DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.SUPPLIERORDERDETAIL);
    QuaryDAOImpl queryDao= (QuaryDAOImpl) DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.QUARYDAO);
    @Override
    public boolean purchaseOrder(SupplierOrderDTO ord) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        boolean add = order.add(new SupplierOrder(ord.getSuporderId(), ord.getSupplierId(), ord.getSuporderDate()));
        if (add){
            for (SupplierOrderDetailsDTO o : ord.getAllSupplierOrderDetails()) {
                boolean isAdedSupplierOrders = orderdetail.add(new SupplierOrderDetaails(o.getSuporderId(), o.getMobileID(), o.getSupqtyOnHand(), o.getSupunitPrice()));
                if (!isAdedSupplierOrders){
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            connection.rollback();
            connection.setAutoCommit(true);
            return true;
        }else {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }
    }

    @Override
    public ArrayList<SupplyEntity> searchSupplierOrders(String text) throws Exception {
        return queryDao.searchSupplierOrders(text);
    }
}
