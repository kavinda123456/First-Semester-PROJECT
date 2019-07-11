package lk.ijse.mobileshut.dao.custome.impl;

import lk.ijse.mobileshut.dao.CrudUtil;
import lk.ijse.mobileshut.dao.custome.SupplierOrderDetailsDAO;
import lk.ijse.mobileshut.entity.SupplierOrderDetaails;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SupplierOrderDetailsDAOImpl implements SupplierOrderDetailsDAO {
    @Override
    public boolean add(SupplierOrderDetaails supplierOrderDetaails) throws Exception {
        return CrudUtil.executeUpdate("insert into Supplier_OrderDetails values(?,?,?,?)");
    }

    @Override
    public boolean remove(String t) throws Exception {
        return CrudUtil.executeUpdate("delete from Supplier_OrderDetails where SupId=?",t);
    }

    @Override
    public boolean update(SupplierOrderDetaails ref) throws Exception {
        return CrudUtil.executeUpdate("update Supplier_OrderDetails set MobCode=?,SupQtyOnHand=?,SupUnitPrice=? where SupOId=?",ref.getMobileID(),ref.getSupqtyOnHand(),ref.getUnitPrice(),ref.getSuporderId());
    }

    @Override
    public SupplierOrderDetaails search(String t) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Supplier_OrderDetails where SupOId=?",t);
        SupplierOrderDetaails supplierOrderDetaails=null;
        while (rst.next()){
            supplierOrderDetaails = new SupplierOrderDetaails(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getDouble(4));
        }
        return supplierOrderDetaails;
    }

    @Override
    public ArrayList<SupplierOrderDetaails> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Supplier_OrderDetails");
        ArrayList<SupplierOrderDetaails> allSupplierDetails=new ArrayList<>();
        while (rst.next()){
            allSupplierDetails.add(new SupplierOrderDetaails(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4)));
        }
        return allSupplierDetails;
    }
}
