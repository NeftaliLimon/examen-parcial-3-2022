package edu.uaslp.objetos.shoppingcart;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {

    private List<Item> shoppingCartList = new LinkedList<>();
    private int itemsCount;

    public boolean isEmpty() {
        return shoppingCartList.size() == 0;
    }

    public BigDecimal getTotalCost() {
        if (shoppingCartList.isEmpty()) {
            throw new EmptyShoppingCartException();
        }
        BigDecimal totalCost = BigDecimal.ZERO;
        for (Item item : shoppingCartList) {
            totalCost = totalCost.add(item.getUnitCost().multiply(BigDecimal.valueOf(item.getQuantity())));
        }

        return totalCost;
    }

    public void addItem(Item item) {
        if ((item.getCode() == null) || (item.getCode() == "")) {
            throw new InvalidDataException("Null or empty string not allowed for item code");
        }
        if ((item.getProviderCode() == null) || (item.getProviderCode() == "")) {
            throw new InvalidDataException("Null or empty string not allowed for provider code");
        }
        if (item.getUnitCost().compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidDataException("Cost must be greater than zero");
        }
        if ((item.getQuantity() < 1) || (item.getQuantity() > 5)) {
            throw new InvalidDataException("Quantity must be greater than zero and lower than 5");
        }

        for (Item addItem : shoppingCartList) {
            if (addItem.getCode() == item.getCode() && addItem.getUnitCost().compareTo(item.getUnitCost()) == 0) {
                addItem.setQuantity(addItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        shoppingCartList.add(item);
    }

    public int getItemsCount() {
        for (Item item : shoppingCartList) {
            itemsCount = itemsCount + item.getQuantity();
        }
        return itemsCount;
    }

    public List<Item> getItems() {
        return shoppingCartList;
    }

    public void removeItem(String itemcode) {
        for (Item removeItem : shoppingCartList) {
            if (removeItem.getCode() == itemcode) {
                removeItem.setQuantity(removeItem.getQuantity() - 1);
                if (removeItem.getQuantity() == 0)
                    shoppingCartList.remove(removeItem);
                return;
            }
        }

    }
}
