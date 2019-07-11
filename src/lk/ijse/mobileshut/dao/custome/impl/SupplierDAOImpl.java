package lk.ijse.mobileshut.dao.custome.impl;

import lk.ijse.mobileshut.dao.CrudUtil;
import lk.ijse.mobileshut.dao.custome.SupplierDAO;
import lk.ijse.mobileshut.entity.SupplierEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public void getLastSupplierId(int x) throws SQLException, ClassNotFoundException {

    }



    @Override
    public boolean add(SupplierEntity ref) throws Exception {
        return CrudUtil.executeUpdate("insert into supplier values(?,?,?,?,?,?)",ref.getSupplierId(),ref.getSupplierName(),ref.getCompany(),ref.getStp(),ref.getSnic(),ref.getEmail());
    }

    @Override
    public boolean remove(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from Supplier where SId=?",id);
    }

    @Override
    public boolean update(SupplierEntity ref) throws Exception {
        return CrudUtil.executeUpdate("update Supplier set Sname=?,Company=?,STP=?,Nic=?,Email=? where SId=?",ref.getSupplierName(),ref.getCompany(),ref.getStp(),ref.getSnic(),ref.getEmail(),ref.getSupplierId());
    }

    @Override
    public SupplierEntity search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from Supplier where SId=?", id);
        SupplierEntity supplierEntity=null;
        while (rst.next()){
            supplierEntity = new SupplierEntity(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getString(6));

        }
        return supplierEntity;
    }

    @Override
    public ArrayList<SupplierEntity> getAll() throws Exception {
        ArrayList <SupplierEntity> suppliers = new ArrayList();
        ResultSet rst = CrudUtil.executeQuery("select * from Supplier");
        while (rst.next()){
            suppliers.add(new SupplierEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5),rst.getString(6)));

        }
        return suppliers;
    }
    @Override
    public ArrayList<String> getAllSupplier() throws Exception {
        ArrayList<String> AllSupplier = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select SId from Supplier");
        while (rst.next()){
            String sId = rst.getString("SId");
            AllSupplier.add(sId);
        }
        return AllSupplier;
    }
}
