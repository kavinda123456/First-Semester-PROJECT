package lk.ijse.mobileshut.bo.custome.impl;

import lk.ijse.mobileshut.bo.custome.SupplierBO;
import lk.ijse.mobileshut.dao.DAOFactory;
import lk.ijse.mobileshut.dao.custome.SupplierDAO;
import lk.ijse.mobileshut.dto.MobileDTO;
import lk.ijse.mobileshut.dto.SupplierDTO;
import lk.ijse.mobileshut.entity.SupplierEntity;

import java.util.ArrayList;

public class SupplierBOImpl implements SupplierBO {
    SupplierDAO dao= (SupplierDAO) DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public boolean AddSupplier(SupplierDTO ref) throws Exception {
        SupplierEntity SplEntity = new SupplierEntity(ref.getSuppierId(), ref.getSupplierName(), ref.getCompany(), ref.getStp(), ref.getSnic(), ref.getEmail());
        return dao.add(SplEntity);
    }

    @Override
    public boolean RemoveSupplier(String id) throws Exception {
        return dao.remove(id);
    }

    @Override
    public boolean UpdateSupplier(SupplierDTO ref) throws Exception {
        SupplierEntity splEntity = new SupplierEntity(ref.getSuppierId(), ref.getSupplierName(), ref.getCompany(), ref.getStp(), ref.getSnic(), ref.getEmail());
        return dao.update(splEntity);
    }

    @Override
    public SupplierDTO SearchSupplier(String id) throws Exception {
        SupplierEntity search = dao.search(id);
        return new SupplierDTO(search.getSupplierId(),search.getSupplierName(),search.getCompany(),search.getStp(),search.getSnic(),search.getEmail());
    }

    @Override
    public ArrayList<SupplierEntity> getAllSuppliers() throws Exception {
        return dao.getAll();
    }
}
