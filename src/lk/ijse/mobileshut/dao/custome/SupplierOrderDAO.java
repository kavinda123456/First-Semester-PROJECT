package lk.ijse.mobileshut.dao.custome;

import lk.ijse.mobileshut.dao.CrudDAO;
import lk.ijse.mobileshut.entity.CustomerOrder;
import lk.ijse.mobileshut.entity.SupplierOrder;

import java.sql.SQLException;

public interface SupplierOrderDAO extends CrudDAO<SupplierOrder,String> {
    public String  getLastSupplierOrder ()throws SQLException,ClassNotFoundException;
}
