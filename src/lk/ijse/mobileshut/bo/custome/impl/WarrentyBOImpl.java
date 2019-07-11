package lk.ijse.mobileshut.bo.custome.impl;

import lk.ijse.mobileshut.bo.custome.WarrentyBO;
import lk.ijse.mobileshut.dao.DAOFactory;
import lk.ijse.mobileshut.dao.custome.WarrentyDAO;
import lk.ijse.mobileshut.dto.BrandsModelDTO;
import lk.ijse.mobileshut.dto.WarrentyDTO;
import lk.ijse.mobileshut.entity.WarrentyEntity;

import java.util.ArrayList;

public class WarrentyBOImpl implements WarrentyBO {
    WarrentyDAO dao= (WarrentyDAO) DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.WARRANTY);
    @Override
    public boolean addWarranty(WarrentyDTO ref) throws Exception {
        WarrentyEntity wrnEntity = new WarrentyEntity(ref.getWarrantyId(), ref.getCustomerId(), ref.getMobileId(), ref.getStartDate(), ref.getEndDate());
        return dao.add(wrnEntity);
    }

    @Override
    public boolean removeWarranty(String id) throws Exception {
        return dao.remove(id);
    }

    @Override
    public boolean updateWarranty(WarrentyDTO ref) throws Exception {
        return false;
    }

    @Override
    public BrandsModelDTO searchWarranty(String id) throws Exception {
        WarrentyEntity search = dao.search(id);
        return new WarrentyDTO(search.getWarrantyId(),search.getCustomerId(),search.getMobileId(),search.getStartDate(),search.getEndDate());
    }

    @Override
    public ArrayList<WarrentyEntity> getAllWarranty() throws Exception {
        return dao.getAll();
    }
}
