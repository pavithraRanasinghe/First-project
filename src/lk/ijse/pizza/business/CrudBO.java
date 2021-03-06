/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.business;

import java.util.List;

/**
 *
 * @author PAVITHRA
 */
public interface CrudBO<T, ID> extends SuperBO {

    boolean add(T t) throws Exception;

    boolean update(T t) throws Exception;
    
    boolean delete(ID id) throws Exception;

    List<T> getAll() throws Exception;

}
