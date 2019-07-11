package lk.ijse.mobileshut.bo.custome.impl;

import lk.ijse.mobileshut.bo.custome.BrandsModelBO;
import lk.ijse.mobileshut.dao.DAOFactory;
import lk.ijse.mobileshut.dao.custome.BrandsModelDAO;
import lk.ijse.mobileshut.dto.BrandsModelDTO;
import lk.ijse.mobileshut.entity.BrandsModelEntity;

import java.util.ArrayList;

public class BrandsModelBOImpl implements BrandsModelBO {
    BrandsModelDAO dao= (BrandsModelDAO) DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.BRAND);
    @Override
    public boolean addBrand(BrandsModelDTO ref) throws Exception {
        BrandsModelEntity brandEntity = new BrandsModelEntity(ref.getBrandId(), ref.getBrandName(), ref.getDescription(), ref.getMadeIn());
        return dao.add(brandEntity);
    }

    @Override
    public boolean removeBrand(String id) throws Exception {
        return dao.remove(id);
    }

    @Override
    public boolean updateBrand(BrandsModelDTO ref) throws Exception {
        BrandsModelEntity brandEntity = new BrandsModelEntity(ref.getBrandId(),ref.getBrandName(), ref.getDescription(), ref.getMadeIn());
        return dao.update(brandEntity);
    }

    @Override
    public BrandsModelDTO searchBrand(String id) throws Exception {
        BrandsModelEntity search = dao.search(id);
        return new BrandsModelDTO(search.getBrandId(), search.getBrandName(), search.getDescription(), search.getMadeIn());
    }

    @Override
    public ArrayList<BrandsModelEntity> getAllBrands() throws Exception {
        return dao.getAll();
    }
}
