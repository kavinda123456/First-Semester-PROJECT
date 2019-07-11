package lk.ijse.mobileshut.dao.custome.impl;

import lk.ijse.mobileshut.dao.CrudUtil;
import lk.ijse.mobileshut.dao.custome.SupplierOrderDAO;
import lk.ijse.mobileshut.entity.CustomerOrder;
import lk.ijse.mobileshut.entity.SupplierOrder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierOrderDAOImpl implements SupplierOrderDAO {

    @Override
    public String getLastSupplierOrder() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select max(SupOId) from Supplier_Order");
        String n = "";
        while (rst.next()) {
            n = rst.getString(1);
        }
        return n;
    }

    @Override
    public boolean add(SupplierOrder ref) throws Exception {
        return CrudUtil.executeUpdate("insert into Supplier_Order values(?,?,?)",ref.getSuporderId(),ref.getSuporderId(),ref.getSuporderDate());
    }

    @Override
    public boolean remove(String t) throws Exception {
        return CrudUtil.executeUpdate("delete from Supplier_Order where SupOId=?",t);
    }

    @Override
    public boolean update(SupplierOrder ref) throws Exception {
        return CrudUtil.executeUpdate("Update Supplier_Order set SId=?,SupOrdDate=? where SupOId=?",ref.getSupplierId(),ref.getSuporderDate(),ref.getSuporderId());
    }

    @Override
    public SupplierOrder search(String t) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Supplier_Order where SupOId=?", t);
        SupplierOrder supplierOrder=null;
        while (rst.next()){
            supplierOrder = new SupplierOrder(rst.getString(1), rst.getString(2),rst.getString(3));
        }
        return supplierOrder;
    }

    @Override
    public ArrayList<SupplierOrder> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Supplier_Order");
        ArrayList<SupplierOrder> allSupOrder=new ArrayList<>();
        while (rst.next()){
            allSupOrder.add(new SupplierOrder(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return allSupOrder;
    }
}
