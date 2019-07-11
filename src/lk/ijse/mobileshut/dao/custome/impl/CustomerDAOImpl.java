package lk.ijse.mobileshut.dao.custome.impl;

import lk.ijse.mobileshut.dao.CrudUtil;
import lk.ijse.mobileshut.dao.custome.CustomerDAO;
import lk.ijse.mobileshut.db.DBConnection;
import lk.ijse.mobileshut.dto.CustomerDTO;
import lk.ijse.mobileshut.entity.CustomerEntity;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl  implements CustomerDAO {
    @Override
    public boolean add (CustomerEntity ref) throws Exception {
        return CrudUtil.executeUpdate("insert into customer values(?,?,?,?,?,?,?)",ref.getId(),ref.getFname(),ref.getLname(),ref.getAddress(),ref.getTp(),ref.getNic(),ref.getDate());
    }

    @Override
    public boolean remove(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from customer where CustId=?",id);
    }

    @Override
    public boolean update(CustomerEntity ref) throws Exception {
        return CrudUtil.executeUpdate("update customer set CustFName=?,CustLName=?,CustAddress=?,CustTp=?,NIC=?, RegiDate=? where CustId=?",ref.getFname(),ref.getLname(),ref.getAddress(),ref.getTp(),ref.getNic(),ref.getDate(),ref.getId());
    }

    @Override
    public CustomerEntity search(String id) throws Exception {
        ResultSet rst= CrudUtil.executeQuery("select * from Customer where CustId=?", id);
        CustomerEntity customerEntity=null;
        while (rst.next()){
            customerEntity = new CustomerEntity(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getString(6), rst.getString(7));
        }
        return customerEntity;
    }

    @Override
    public ArrayList<CustomerEntity> getAll() throws Exception {
        ArrayList<CustomerEntity> customers = new ArrayList();
        ResultSet rst = CrudUtil.executeQuery("select * from customer");
        while (rst.next()){
            customers.add(new CustomerEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getString(6),rst.getString(7)));
        }
        return customers;
    }

    @Override
    public void getLastCustomer(int x) throws SQLException, ClassNotFoundException {
        //
    }

    @Override
    public ArrayList<String> getAllCustomer() throws Exception {
        ArrayList<String> allCustomers = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select CustId from customer");
        while (rst.next()){
            String customerId = rst.getString("CustomerId");
            allCustomers.add(customerId);
        }
        return allCustomers;
    }


//    @Override
//    public boolean add(CustomerEntity entity) throws Exception {
//
//        Connection connection = DBConnection.getInstance().getConnection();
//        String query = "INSERT INTO CUSTOMER VALUES (?,?,?,?)";
//        PreparedStatement pstm = connection.prepareStatement(query);
//        pstm.setObject(1,entity.getId());
//        pstm.setObject(2,entity.getName());
//        pstm.setObject(3,entity.getAddress());
//        pstm.setObject(4,entity.getSalary());
//        int result = pstm.executeUpdate();
//        if(result>0){
//            return true;
//        }
//        return false;
//    }
//    @Override
//    public boolean searchCustomer(String id) throws Exception {
//        return false;
//    }


}
