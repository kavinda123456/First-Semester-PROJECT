package lk.ijse.mobileshut.bo.custome;

import lk.ijse.mobileshut.bo.SuperBO;
import lk.ijse.mobileshut.dto.CustomerDTO;
import lk.ijse.mobileshut.dto.MobileDTO;
import lk.ijse.mobileshut.entity.MobileEntity;

import java.util.ArrayList;

public interface MobileBO extends SuperBO {
    public boolean AddMobile(MobileDTO ref)throws Exception;
    public boolean updateMobile(MobileDTO ref)throws Exception;
    public boolean removeMobile(String id)throws Exception;
    public MobileDTO searchMobile(String id)throws Exception;
    public ArrayList<MobileEntity> getAllMobile()throws Exception;
}
