package lk.ijse.mobileshut.dao;

import lk.ijse.mobileshut.entity.CustomerEntity;

import java.util.ArrayList;

public interface CrudDAO<T,ID> extends SuperDAO {

    public boolean add(T t)throws Exception;
    public boolean remove(ID t)throws Exception;
    public boolean update(T t)throws Exception;
    public T search(ID t)throws Exception;
    public ArrayList<T> getAll() throws Exception;

}
