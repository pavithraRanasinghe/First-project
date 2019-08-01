/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.controller;

import java.util.List;
import lk.ijse.pizza.business.BOFactory;
import lk.ijse.pizza.business.custom.CustomerBO;
import lk.ijse.pizza.dto.CustomerDTO;

/**
 *
 * @author PAVITHRA
 */
public class CustomerController {

    private static final CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOType.CUSTOMER);

    public static boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        return customerBO.add(customerDTO);
    }

    public static List<CustomerDTO> getAll() throws Exception {
        return customerBO.getAll();
    }

    public static boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        return customerBO.update(customerDTO);
    }

    public static boolean deleteCustomer(int customerID) throws Exception {
        return customerBO.delete(customerID);
    }
    public static CustomerDTO searchCustomer(String name) throws Exception{
        return customerBO.searchByName(name);
    }
}