package lk.ijse.mobileshut.dao.custome;

import lk.ijse.mobileshut.dao.CrudDAO;
import lk.ijse.mobileshut.dao.CrudUtil;
import lk.ijse.mobileshut.dao.SuperDAO;
import lk.ijse.mobileshut.dto.CustomerDTO;
import lk.ijse.mobileshut.entity.CustomerEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<CustomerEntity,String> {
    public void getLastCustomer(int x)throws SQLException,ClassNotFoundException;
    public ArrayList<String> getAllCustomer() throws Exception;


}
