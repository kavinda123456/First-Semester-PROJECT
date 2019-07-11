package lk.ijse.mobileshut.dao;

import lk.ijse.mobileshut.dao.custome.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }
    public static DAOFactory getInstance(){
        if (daoFactory==null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public enum DAOTypes{
        CUSTOMER,MOBILE,SUPPLIER,ORDER,ORDERDETAILS,BRAND,QUARYDAO,WARRANTY,SUPPLIERORDER,SUPPLIERORDERDETAIL
    }
    public SuperDAO getDao(DAOTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case MOBILE:
                return  new MobileDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            case ORDER:
                return new CustomerOrderDAOImpl();
            case ORDERDETAILS:
                return new CustomerOrderDetailsDAOImpl();
            case BRAND:
                return new BrandsModelDAOImpl();
            case QUARYDAO:
                return new QuaryDAOImpl();
            case WARRANTY:
                return new WarrentyDAOImpl();
            case SUPPLIERORDER:
                return new SupplierOrderDAOImpl();
            case SUPPLIERORDERDETAIL:
                return new SupplierOrderDetailsDAOImpl();
            default:
                return null;
        }
    }
}
