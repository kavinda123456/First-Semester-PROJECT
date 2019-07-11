package lk.ijse.mobileshut.dao.custome.impl;

import lk.ijse.mobileshut.dao.CrudUtil;
import lk.ijse.mobileshut.dao.custome.CustomerOrderDetailsDAO;
import lk.ijse.mobileshut.entity.CustomerOrderDetails;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerOrderDetailsDAOImpl implements CustomerOrderDetailsDAO {
    @Override
    public boolean add(CustomerOrderDetails ref) throws Exception {
        return CrudUtil.executeUpdate("insert into cusOrder_Details values(?,?,?,?)",ref.getOrderId(),ref.getMobileID(),ref.getQtyOnHand(),ref.getUnitPrice());
    }

    @Override
    public boolean remove(String t) throws Exception {
        return CrudUtil.executeUpdate("delete from cusOrder_Details where OId =?",t);
    }

    @Override
    public boolean update(CustomerOrderDetails ref) throws Exception {
        return CrudUtil.executeUpdate("update cusOrder_Details MobCode=?,QtyOnHand=?,UnitPrice=? where OId=?",ref.getMobileID(),ref.getQtyOnHand(),ref.getUnitPrice(),ref.getOrderId());
    }

    @Override
    public CustomerOrderDetails search(String t) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from cusOrder_Details where OId=?", t);
        CustomerOrderDetails customerOrderDetails=null;
        while (rst.next()){
            customerOrderDetails = new CustomerOrderDetails(rst.getString(1), rst.getString(2), rst.getInt(3),rst.getDouble(4));
        }
        return customerOrderDetails;
    }

    @Override
    public ArrayList<CustomerOrderDetails> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from cusOrder_Details");
        ArrayList<CustomerOrderDetails> allOrderDetails=new ArrayList<>();
        while (rst.next()){
           allOrderDetails.add(new CustomerOrderDetails(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4)));
        }
        return allOrderDetails;
    }
}
