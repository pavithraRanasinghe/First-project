/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.business.custom;

import lk.ijse.pizza.business.CrudBO;
import lk.ijse.pizza.dto.CustomerDTO;

/**
 *
 * @author PAVITHRA
 */
public interface CustomerBO extends CrudBO<CustomerDTO, Integer>{
    CustomerDTO searchByName(String name)throws Exception;
    
}
