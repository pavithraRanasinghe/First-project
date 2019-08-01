/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.pizza.business.custom.ItemBO;
import lk.ijse.pizza.dao.DAOFactory;
import lk.ijse.pizza.dao.custom.ItemDAO;
import lk.ijse.pizza.dto.ItemDTO;
import lk.ijse.pizza.entity.Item;

/**
 *
 * @author PAVITHRA
 */
public class ItemBOImpl implements ItemBO {

    private static final ItemDAO itemDAO = (ItemDAO) DAOFactory.getinstance().getDAO(DAOFactory.DAOType.ITEM);

    @Override
    public boolean add(ItemDTO itemDTO) throws Exception {
        Item item = new Item();
        item.setItemID(itemDTO.getItemID());
        item.setItemCode(itemDTO.getItemCode());
        item.setName(itemDTO.getName());
        item.setDescription(itemDTO.getDescription());
        item.setUnitPrice(itemDTO.getUnitPrice());
        item.setQuantity(itemDTO.getQuantity());

        return itemDAO.add(item);
    }

    @Override
    public boolean update(ItemDTO itemDTO) throws Exception {
        Item item = new Item();
        item.setItemID(itemDTO.getItemID());
        item.setItemCode(itemDTO.getItemCode());
        item.setName(itemDTO.getName());
        item.setDescription(itemDTO.getDescription());
        item.setUnitPrice(itemDTO.getUnitPrice());
        item.setQuantity(itemDTO.getQuantity());
        return itemDAO.update(item);
    }

    @Override
    public boolean delete(Integer itemID) throws Exception {
        return itemDAO.delete(itemID);
    }

    @Override
    public List<ItemDTO> getAll() throws Exception {
        List<Item> allItems = itemDAO.getAll();
        List<ItemDTO> allItemDTOs = new ArrayList<>();
        for (Item item : allItems) {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setItemID(item.getItemID());
            itemDTO.setItemCode(item.getItemCode());
            itemDTO.setName(item.getName());
            itemDTO.setDescription(item.getDescription());
            itemDTO.setUnitPrice(item.getUnitPrice());
            itemDTO.setQuantity(item.getQuantity());
            allItemDTOs.add(itemDTO);
        }
        return allItemDTOs;

    }

    @Override
    public ItemDTO findByName(String name) throws Exception {
        Item findByName = itemDAO.findByName(name);
//        Item item = new Item();
//        item.setName(name);
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setItemID(findByName.getItemID());
        itemDTO.setItemCode(findByName.getItemCode());
        itemDTO.setName(findByName.getName());
        itemDTO.setDescription(findByName.getDescription());
        itemDTO.setQuantity(findByName.getQuantity());
        itemDTO.setUnitPrice(findByName.getUnitPrice());
        return itemDTO;
    }

}
