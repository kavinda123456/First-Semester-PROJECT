package lk.ijse.mobileshut.bo.custome;

import lk.ijse.mobileshut.bo.SuperBO;
import lk.ijse.mobileshut.dto.BrandsModelDTO;
import lk.ijse.mobileshut.entity.BrandsModelEntity;

import java.util.ArrayList;

public interface BrandsModelBO extends SuperBO {
    public boolean addBrand(BrandsModelDTO ref)throws Exception;
    public boolean removeBrand(String id)throws Exception;
    public boolean updateBrand(BrandsModelDTO ref)throws Exception;
    public BrandsModelDTO searchBrand(String id)throws Exception;
    public ArrayList<BrandsModelEntity> getAllBrands()throws Exception;

}
