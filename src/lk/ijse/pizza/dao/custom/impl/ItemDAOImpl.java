/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.dao.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.pizza.dao.CrudUtil;
import lk.ijse.pizza.dao.custom.ItemDAO;
import lk.ijse.pizza.entity.Item;
import lk.ijse.pizza.entity.OrderDetail;

/**
 *
 * @author PAVITHRA
 */
public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean add(Item item) throws SQLException, Exception {
        return CrudUtil.executeUpdate("INSERT INTO item VALUES(?,?,?,?,?,?)", 0, item.getItemCode(), item.getName(), item.getDescription(), item.getUnitPrice(), item.getQuantity());
    }

    @Override
    public boolean update(Item item) throws Exception {
        return CrudUtil.executeUpdate("UPDATE item SET itemCode=?,name=?,description=?,unitPrice=?,quantity=? WHERE itemID=?" , item.getItemCode(), item.getName(), item.getDescription(), item.getUnitPrice(), item.getQuantity(),item.getItemID());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM item WHERE itemID = ?", id);
    }

    @Override
    public List<Item> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM item");
        List<Item> arrayList = new ArrayList<>();
        while (rst.next()) {
            Item items = new Item();
            items.setItemID(rst.getInt(1));
            items.setItemCode(rst.getString(2));
            items.setName(rst.getString(3));
            items.setDescription(rst.getString(4));
            items.setUnitPrice(rst.getDouble(5));
            items.setQuantity(rst.getInt(6));
            arrayList.add(items);
        }
        
        return arrayList;
    }

    @Override
    public Item findByName(String name) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from item where name=?", name);
        Item item = new Item();
        if (rst.next()) {
            item = new Item(
                    rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDouble(5),
                    rst.getInt(6)
            );
        }
        return item;
    }

    @Override
    public boolean updateQty(Item item) throws Exception {
        return CrudUtil.executeUpdate("UPDATE item SET quantity = ? where itemID = ? ",item.getQuantity(),item.getItemID());
    }

    @Override
    public Item findByID(int id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from item where itemID=?", id);
        Item item = new Item();
        if (rst.next()) {
            item = new Item(
                    rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDouble(5),
                    rst.getInt(6)
            );
        }
        return item;
    }

}
