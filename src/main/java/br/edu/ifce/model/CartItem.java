package br.edu.ifce.model;

import br.edu.ifce.utils.StringUtils;

public class CartItem {
    private Item item;
    private int itemId;
    private int quantity;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.itemId = item.getId();
        this.item = item;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice()
    {
        return item.getPrice() * quantity;
    }
    public String getFormatedPrice()
    {
        return StringUtils.FormatForMoney(getTotalPrice());
    }
}
