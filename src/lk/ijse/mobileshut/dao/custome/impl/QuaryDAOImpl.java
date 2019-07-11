package lk.ijse.mobileshut.dao.custome.impl;

import jdk.nashorn.internal.ir.WhileNode;
import lk.ijse.mobileshut.dao.CrudUtil;
import lk.ijse.mobileshut.dao.custome.QuaryDAO;
import lk.ijse.mobileshut.entity.CustomEntity;
import lk.ijse.mobileshut.entity.SupplyEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class QuaryDAOImpl implements QuaryDAO {
    @Override
    public ArrayList<CustomEntity> searchCustomerOrders(String OrderId) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("select cusOrder.OId,"
        +"cusOrder.CustId,cusOrder.OrdDate,"
        +"cusOrder_detail.OId,cusOrder_detail.MobCode,"
        +"cusOrder_detail.QtyOnHand,cusOrder_detail.UnitPrice"
        +"from cusOrder inner join cusOrder_detail"
        +"on cusOrder.Oid=cusOrder_detail.OId"
        +"where cusOrder.OId",OrderId);
        ArrayList<CustomEntity> allDetails = new ArrayList<>();
        while (rst.next()) {
            allDetails.add(new CustomEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(5),rst.getInt(6),rst.getDouble(7)));
        }
        return allDetails;
    }

    @Override
    public ArrayList<SupplyEntity> searchSupplierOrders(String SupOrderId) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select Supplier_Order.SupOId,"
                + "Supplier_Order.SId, Supplier_Order.SupOrdDate"
                + "Supplier_OrderDetails.SupOId, Supplier_OrderDetails.MobCode"
                + "Supplier_OrderDetails.SupQtyOnHand, Supplier_OrderDetails.SupUnitPrice"
                + "from Supplier_Order inner join Supplier_OrderDetails"
                + "on Supplier_Order.OId = Supplier_OrderDetails.Oid"
                + "where Supplier_Order.OId", SupOrderId);
        ArrayList<SupplyEntity> allDetails=new ArrayList<>();
        while (rst.next()){
            allDetails.add(new SupplyEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(5),rst.getInt(6),rst.getDouble(7)));
        }
        return allDetails;
    }
}
