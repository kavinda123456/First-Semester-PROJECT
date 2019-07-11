package lk.ijse.mobileshut.bo.custome;

import lk.ijse.mobileshut.bo.SuperBO;
import lk.ijse.mobileshut.dto.SupplierDTO;
import lk.ijse.mobileshut.entity.SupplierEntity;

import java.util.ArrayList;

public interface SupplierBO extends SuperBO {
    public boolean AddSupplier(SupplierDTO ref)throws Exception;
    public boolean RemoveSupplier(String id)throws Exception;
    public boolean UpdateSupplier(SupplierDTO ref)throws Exception;
    public SupplierDTO SearchSupplier(String id)throws Exception;
    public ArrayList<SupplierEntity> getAllSuppliers()throws Exception;
}
