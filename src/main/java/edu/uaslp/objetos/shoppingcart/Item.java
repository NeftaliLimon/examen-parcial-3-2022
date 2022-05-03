package edu.uaslp.objetos.shoppingcart;

import java.math.BigDecimal;

public class Item {
    String ItemCode;
    String ProviderCode;
    int Quantity;
    BigDecimal UnitCost;

    public Item(String itemCode, String providerCode,BigDecimal unitCost,int quantity){
        this.ItemCode = itemCode;
        this.ProviderCode = providerCode;
        this.Quantity = quantity;
        this.UnitCost = unitCost;
    }
    public Item(){}

    public void setCode(String itemCode){
        this.ItemCode=itemCode;
    }

    public void setProviderCode(String providerCode){
        this.ProviderCode=providerCode;
    }

    public void setQuantity(int quantity){
        this.Quantity= quantity;
    }

    public void setUnitCost(BigDecimal unitCost){
        this.UnitCost=unitCost;
    }

    public String getCode(){
        return ItemCode;
    }

    public String getProviderCode(){
        return ProviderCode;
    }

    public int getQuantity(){
        return Quantity;
    }

    public BigDecimal getUnitCost(){
        return UnitCost;
    }
}
