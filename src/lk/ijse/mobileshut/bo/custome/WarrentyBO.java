package lk.ijse.mobileshut.bo.custome;

import lk.ijse.mobileshut.bo.SuperBO;
import lk.ijse.mobileshut.dto.BrandsModelDTO;
import lk.ijse.mobileshut.dto.WarrentyDTO;
import lk.ijse.mobileshut.entity.BrandsModelEntity;
import lk.ijse.mobileshut.entity.WarrentyEntity;

import java.util.ArrayList;

public interface WarrentyBO extends SuperBO {
    public boolean addWarranty(WarrentyDTO ref)throws Exception;
    public boolean removeWarranty(String id)throws Exception;
    public boolean updateWarranty(WarrentyDTO ref)throws Exception;
    public BrandsModelDTO searchWarranty(String id)throws Exception;
    public ArrayList<WarrentyEntity> getAllWarranty()throws Exception;

}
