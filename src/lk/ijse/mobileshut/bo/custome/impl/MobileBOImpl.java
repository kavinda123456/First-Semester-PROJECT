package lk.ijse.mobileshut.bo.custome.impl;

import lk.ijse.mobileshut.bo.custome.MobileBO;
import lk.ijse.mobileshut.dao.DAOFactory;
import lk.ijse.mobileshut.dao.custome.MobileDAO;
import lk.ijse.mobileshut.dto.MobileDTO;
import lk.ijse.mobileshut.entity.MobileEntity;

import java.util.ArrayList;

public class MobileBOImpl implements MobileBO {
    MobileDAO dao= (MobileDAO) DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.MOBILE);

    @Override
    public boolean AddMobile(MobileDTO ref) throws Exception {
        MobileEntity mblEntity = new MobileEntity(ref.getMobileID(), ref.getMobileEMI(), ref.getMobileName(), ref.getBrand(), ref.getQty(), ref.getUnitPrice());
        return dao.add(mblEntity);
    }

    @Override
    public boolean updateMobile(MobileDTO ref) throws Exception {
        MobileEntity mblEntity = new MobileEntity(ref.getMobileID(), ref.getMobileEMI(), ref.getMobileName(), ref.getBrand(), ref.getQty(), ref.getUnitPrice());
        return dao.update(mblEntity);
    }

    @Override
    public boolean removeMobile(String id) throws Exception {
        return dao.remove(id);
    }

    @Override
    public MobileDTO searchMobile(String id) throws Exception {
        MobileEntity search = dao.search(id);
        return new MobileDTO(search.getMobileID(),search.getMobileEMI(),search.getMobileName(),search.getBrand(),search.getQty(),search.getUnitPrice());
    }

    @Override
    public ArrayList<MobileEntity> getAllMobile() throws Exception {
        return dao.getAll();
    }
}
