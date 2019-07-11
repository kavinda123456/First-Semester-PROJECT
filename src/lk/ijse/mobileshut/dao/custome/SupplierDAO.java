package lk.ijse.mobileshut.dao.custome;

import lk.ijse.mobileshut.dao.CrudDAO;
import lk.ijse.mobileshut.entity.MobileEntity;
import lk.ijse.mobileshut.entity.SupplierEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierDAO extends CrudDAO<SupplierEntity,String>  {
    public void getLastSupplierId(int x)throws SQLException,ClassNotFoundException;
    public ArrayList<String> getAllSupplier() throws Exception;
}
