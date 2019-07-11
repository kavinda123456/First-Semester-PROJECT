package lk.ijse.mobileshut.dao.custome;

import lk.ijse.mobileshut.dao.CrudDAO;
import lk.ijse.mobileshut.entity.CustomerOrder;

import java.sql.SQLException;

public interface CustomerOrderDAO extends CrudDAO<CustomerOrder,String> {
    public String getLastCustomerOrder ()throws SQLException,ClassNotFoundException;
}
