package lk.ijse.mobileshut.dao.custome.impl;
import lk.ijse.mobileshut.dao.CrudUtil;
import lk.ijse.mobileshut.dao.custome.CustomerOrderDAO;
import lk.ijse.mobileshut.entity.CustomerOrder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerOrderDAOImpl implements CustomerOrderDAO {
    @Override
    public String getLastCustomerOrder() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("select max(OId) from cusOrder");
        String n = "";
        while (rst.next()) {
            n = rst.getString(1);
        }
        return n;
    }

    @Override
    public boolean add(CustomerOrder ref) throws Exception {
        return CrudUtil.executeUpdate("insert into cusOrder values(?,?,?)",ref.getOrderId(),ref.getCustomerId(),ref.getOrderDate());
    }

    @Override
    public boolean remove(String t) throws Exception {
        return CrudUtil.executeUpdate("delete from cusOrder where OId=?",t);
    }

    @Override
    public boolean update(CustomerOrder ref) throws Exception {
        return CrudUtil.executeUpdate("update cusOrder set CustId=?,OrdDate=? where OId=?",ref.getCustomerId(),ref.getOrderDate(),ref.getOrderId());
    }

    @Override
    public CustomerOrder search(String t) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from cusOrder where OId=?", t);
        CustomerOrder customerOrder=null;
        while (rst.next()){
            customerOrder = new CustomerOrder(rst.getString(1),rst.getString(2), rst.getString(3));
        }
        return customerOrder;
    }

    @Override
    public ArrayList<CustomerOrder> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from cusOrder");
        ArrayList<CustomerOrder> allOrders=new ArrayList<>();
        while (rst.next()){
            allOrders.add(new CustomerOrder(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return allOrders;
    }
}
