/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.business;

 import lk.ijse.pizza.business.custom.PlaceOrderBO;
import lk.ijse.pizza.business.custom.CustomerBO;
import lk.ijse.pizza.business.custom.ItemBO;
import lk.ijse.pizza.business.custom.impl.CustomerBOImpl;
import lk.ijse.pizza.business.custom.impl.ItemBOImpl;
import lk.ijse.pizza.business.custom.impl.PlaceOrderBOImpl;

/**
 *
 * @author PAVITHRA
 */
public class BOFactory {

    private static BOFactory bOFactory;

//    private final CustomerBO customerBO;
    private final ItemBO itemBO;
    private final PlaceOrderBO placeOrderBO;

    public enum BOType {
        CUSTOMER, ITEM, PLACE_ORDER;
    }

    private BOFactory() {
        itemBO = new ItemBOImpl();
        placeOrderBO = new PlaceOrderBOImpl();
    }

    public static BOFactory getInstance() {
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }

    public SuperBO getBO(BOType bOType) {
        switch (bOType) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return itemBO;
            case PLACE_ORDER:
                return placeOrderBO;
            default:
                return null;
        }
    }

}
