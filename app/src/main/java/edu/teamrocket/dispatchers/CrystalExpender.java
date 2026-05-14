package edu.teamrocket.dispatchers;

import edu.teamrocket.payment.CreditCard;
import edu.teamrocket.receptivo.GuestDispatcher;

public class CrystalExpender implements GuestDispatcher{


    private int stock = 0;
    private double itemCost = 0d;

    public CrystalExpender(int stock, double itemCost){
        this.stock = stock;
        this.itemCost = itemCost;
    }

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();

        build.append("Stock: ");
        build.append(stock);
        build.append("\nCost: ");
        build.append(itemCost);

        return build.toString();
    }

    public int stock() {
        return stock;
    }

    @Override
    public void dispatch(CreditCard card) {
        if(stock > 0 && card.pay(itemCost)){
            stock --;
        }
    }
    
}
