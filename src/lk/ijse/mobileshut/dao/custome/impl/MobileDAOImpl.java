package lk.ijse.mobileshut.dao.custome.impl;

import lk.ijse.mobileshut.dao.CrudUtil;
import lk.ijse.mobileshut.dao.custome.MobileDAO;
import lk.ijse.mobileshut.entity.MobileEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MobileDAOImpl implements MobileDAO {
    @Override
    public void getLastMobileId(int x) throws SQLException, ClassNotFoundException {

    }



    @Override
    public boolean add(MobileEntity ref) throws Exception {
        return CrudUtil.executeUpdate("insert into mobile values(?,?,?,?,?,?)",ref.getMobileID(),ref.getMobileEMI(),ref.getMobileName(),ref.getBrand(),ref.getQty(),ref.getUnitPrice());
    }

    @Override
    public boolean remove(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from mobile where MobCode=?",id);
    }

    @Override
    public boolean update(MobileEntity ref) throws Exception {
        return CrudUtil.executeUpdate("update mobile set EMI_Number=?,MobName=?, Brand=?, QtyOnHand=?, UnitPrice=? where  MobCode=?",ref.getMobileEMI(),ref.getMobileName(),ref.getBrand(),ref.getQty(),ref.getUnitPrice(),ref.getMobileID());
    }

    @Override
    public MobileEntity search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from mobile where MobCode=?", id);
        MobileEntity mobileEntity=null;
        while (rst.next()){
            mobileEntity = new MobileEntity(rst.getString(1), rst.getInt(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getDouble(6));
        }
        return mobileEntity;
    }

    @Override
    public ArrayList<MobileEntity> getAll() throws Exception {
        ArrayList<MobileEntity> Mobiles = new ArrayList();
        ResultSet rst = CrudUtil.executeQuery("select * from mobile");
        while (rst.next()){
            Mobiles.add(new MobileEntity(rst.getString(1), rst.getInt(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getDouble(6)));
        }
        return Mobiles;
    }

    @Override
    public ArrayList<String> getAllMobileItems() throws Exception {
        ArrayList<String> allMobiles = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select MobCode from mobile");
        while (rst.next()){
            String MobCode = rst.getString("MobCode");
            allMobiles.add(MobCode);
        }
        return allMobiles;
    }

}
