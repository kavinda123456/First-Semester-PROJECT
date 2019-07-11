package lk.ijse.mobileshut.dao.custome.impl;

import lk.ijse.mobileshut.dao.CrudUtil;
import lk.ijse.mobileshut.dao.custome.BrandsModelDAO;
import lk.ijse.mobileshut.entity.BrandsModelEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrandsModelDAOImpl implements BrandsModelDAO {

    @Override
    public boolean add(BrandsModelEntity ref) throws Exception {
        return CrudUtil.executeUpdate("insert into BrandsModel values(?,?,?,?)",ref.getBrandId(),ref.getBrandName(),ref.getDescription(),ref.getMadeIn());
    }

    @Override
    public boolean remove(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from BrandsModel where BMId=?",id);
    }

    @Override
    public boolean update(BrandsModelEntity ref) throws Exception {
        return CrudUtil.executeUpdate("update BrandsModel set BMName=?,Description=?,MadeIn=? where BMId=?",ref.getBrandName(),ref.getDescription(),ref.getMadeIn(),ref.getBrandId());
    }

    @Override
    public BrandsModelEntity search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from BrandsModel where BMId=?", id);
        BrandsModelEntity brandsModelEntity=null;
        while (rst.next()){
            brandsModelEntity = new BrandsModelEntity(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
        }
        return brandsModelEntity;
    }

    @Override
    public ArrayList<BrandsModelEntity> getAll() throws Exception {
        ArrayList<BrandsModelEntity> Brands = new ArrayList();
        ResultSet rst = CrudUtil.executeQuery("select * from BrandsModel");
        while (rst.next()){
            Brands.add(new BrandsModelEntity(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
        }
        return Brands;
    }

    @Override
    public void getLastBrands(int x) throws SQLException, ClassNotFoundException {

    }

    @Override
    public ArrayList<String> getAllBrands() throws Exception {
        ArrayList<String> allBrands = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select BMId from BrandsModel");
        while (rst.next()){
            String brandId = rst.getString("BMId");
            allBrands.add(brandId);
        }
        return allBrands;
    }
}
