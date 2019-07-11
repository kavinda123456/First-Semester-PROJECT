package lk.ijse.mobileshut.bo.custome.impl;

import lk.ijse.mobileshut.bo.custome.CustomerBO;
import lk.ijse.mobileshut.dao.DAOFactory;
import lk.ijse.mobileshut.dao.custome.CustomerDAO;
import lk.ijse.mobileshut.dto.CustomerDTO;
import lk.ijse.mobileshut.entity.CustomerEntity;

import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO dao= (CustomerDAO) DAOFactory.getInstance().getDao(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public boolean addCustomer(CustomerDTO ref)throws Exception{
        CustomerEntity custEntity = new CustomerEntity(ref.getId(), ref.getFname(), ref.getLname(), ref.getAddress(), ref.getTp(), ref.getNic(), ref.getDate());
        return dao.add(custEntity);
    }

    @Override
    public boolean removeCustomer(String id) throws Exception {
        return dao.remove(id);
    }

    @Override
    public boolean updateCustomer(CustomerDTO ref) throws Exception {
        CustomerEntity custEntity = new CustomerEntity(ref.getId(), ref.getFname(), ref.getLname(), ref.getAddress(), ref.getTp(), ref.getNic(), ref.getDate());
        return dao.update(custEntity);
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws Exception {
        CustomerEntity search = dao.search(id);
        return new CustomerDTO(search.getId(),search.getFname(),search.getLname(),search.getAddress(),search.getTp(),search.getNic(),search.getDate());
    }

    @Override
    public ArrayList<CustomerEntity> getAllCustomer() throws Exception {
        return dao.getAll();
    }


//    @Override
//    public boolean addCustomer(CustomerDTO dto) throws Exception {
//
//        CustomerEntity customerEntity = new CustomerEntity(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary());
//
//        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
//        return customerDAO.add(customerEntity);
//    }
}
