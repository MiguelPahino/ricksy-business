package edu.teamrocket.receptivo;

import java.util.ArrayList;
import java.util.List;

import edu.teamrocket.payment.CreditCard;

public class RickMenuDispatcher implements GuestDispatcher {
    
    private int stock = 100;
    private double price = 10d;
    private List<CreditCard> invitados = new ArrayList<>();


    @Override
    public void dispatch(CreditCard card) {
        if(stock > 0 && card.pay(price)){
            stock --;
        }
    }

    

    public int stock() {
        return stock;
    }



    @Override
    public String toString() {
        StringBuilder build =new StringBuilder();
        invitados.stream()
        .forEach(x-> {
            build.append(x.cardOwner());
            build.append("\n");
        });

        return build.toString();
    }
}
