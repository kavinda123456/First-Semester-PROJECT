package lk.ijse.mobileshut.bo;

import lk.ijse.mobileshut.bo.custome.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    public BOFactory() {
    }
    public static BOFactory getInstance(){
        if (boFactory==null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    public enum BOTyepes{
        CUSTOMER,MOBILE,SUPPLIER,PURCHESE,BRAND,WARRANTY,PAYMENT
    }
    public SuperBO getBO(BOTyepes tyepes){
        switch (tyepes){
            case CUSTOMER:
                return new CustomerBOImpl();
            case MOBILE:
                return new MobileBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case PURCHESE:
                return new PurchaseOrderBOImpl();
            case BRAND:
                return new BrandsModelBOImpl();
            case WARRANTY:
                return new WarrentyBOImpl();
            case PAYMENT:
                return new SupplierPaymentBOImpl();
            default:
                return null;
        }
    }
}
