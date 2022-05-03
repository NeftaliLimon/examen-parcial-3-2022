package edu.uaslp.objetos.shoppingcart;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {

    List<Item> shoppingCartList = new LinkedList<>();

    public boolean isEmpty(){
        return shoppingCartList.isEmpty();
    }

    public BigDecimal getTotalCost(){
        BigDecimal totalCost = BigDecimal.ZERO;
        int size = shoppingCartList.size();

        for(Item item: shoppingCartList){
            totalCost = totalCost.add(item.getUnitCost().multiply(BigDecimal.valueOf(item.getQuantity())));
        }

        if(size == 0){
            throw new EmptyShoppingCartException("cart is null");
        }
        return totalCost;
    }

    public void addItem(Item item){
        shoppingCartList.add(item);
    }

    public int getItemsCount(){
        int itemsCount = shoppingCartList.size();
        return itemsCount;
    }

    public List<Item> getItems(){
        return shoppingCartList;
    }

    public void removeItem(String itemcode){
        shoppingCartList.remove(itemcode);
    }
}
