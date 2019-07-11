package lk.ijse.mobileshut.dao.custome.impl;

import lk.ijse.mobileshut.dao.CrudUtil;
import lk.ijse.mobileshut.dao.custome.WarrentyDAO;
import lk.ijse.mobileshut.entity.WarrentyEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WarrentyDAOImpl implements WarrentyDAO {
    @Override
    public void getLastWarranty(int x) throws SQLException, ClassNotFoundException {

    }

    @Override
    public ArrayList<String> getAllWarranty() throws Exception {
        return null;
    }

    @Override
    public boolean add(WarrentyEntity ref) throws Exception {
        return CrudUtil.executeUpdate("insert into warranty values(?,?,?,?,?)",ref.getWarrantyId(),ref.getCustomerId(),ref.getMobileId(),ref.getStartDate(),ref.getEndDate());
    }

    @Override
    public boolean remove(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from warranty where WId=?",id);
    }

    @Override
    public boolean update(WarrentyEntity warrentyEntity) throws Exception {
        return false;
    }

    @Override
    public WarrentyEntity search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from warranty where WId=?", id);
        WarrentyEntity warrentyEntity=null;
        while (rst.next()){
             warrentyEntity = new WarrentyEntity(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
        }
        return warrentyEntity;
    }

    @Override
    public ArrayList<WarrentyEntity> getAll() throws Exception {
        ArrayList<WarrentyEntity> warranties=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from warranty");
        while (rst.next()){
            warranties.add(new WarrentyEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5)));
        }
        return warranties;
    }
}
