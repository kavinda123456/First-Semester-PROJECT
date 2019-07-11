package lk.ijse.mobileshut.dao.custome;

import lk.ijse.mobileshut.dao.CrudDAO;
import lk.ijse.mobileshut.entity.BrandsModelEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BrandsModelDAO extends CrudDAO<BrandsModelEntity,String> {
    public void getLastBrands(int x)throws SQLException,ClassNotFoundException;
    public ArrayList<String> getAllBrands() throws Exception;


}
