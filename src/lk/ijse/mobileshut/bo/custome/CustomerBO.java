package lk.ijse.mobileshut.bo.custome;

import lk.ijse.mobileshut.bo.SuperBO;
import lk.ijse.mobileshut.dto.CustomerDTO;
import lk.ijse.mobileshut.entity.CustomerEntity;

import java.util.ArrayList;

public interface CustomerBO extends SuperBO {

    public boolean addCustomer(CustomerDTO ref)throws Exception;
    public boolean removeCustomer(String id)throws  Exception;
    public boolean updateCustomer(CustomerDTO ref)throws Exception;
    public CustomerDTO searchCustomer(String id)throws Exception;
    public ArrayList<CustomerEntity> getAllCustomer()throws Exception;
}
