package lk.ijse.mobileshut.dao.custome;

import lk.ijse.mobileshut.dao.CrudDAO;
import lk.ijse.mobileshut.dao.custome.impl.MobileDAOImpl;
import lk.ijse.mobileshut.entity.MobileEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MobileDAO extends CrudDAO<MobileEntity,String>  {
    public void getLastMobileId(int x)throws SQLException,ClassNotFoundException;
    public ArrayList<String> getAllMobileItems() throws Exception;
}
