package lk.ijse.mobileshut.dao.custome;

import lk.ijse.mobileshut.dao.CrudDAO;
import lk.ijse.mobileshut.entity.BrandsModelEntity;
import lk.ijse.mobileshut.entity.WarrentyEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface WarrentyDAO extends CrudDAO<WarrentyEntity,String> {
    public void getLastWarranty(int x)throws SQLException,ClassNotFoundException;
    public ArrayList<String> getAllWarranty() throws Exception;


}
