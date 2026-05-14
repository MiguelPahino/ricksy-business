package edu.teamrocket.dispatchers;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import edu.teamrocket.payment.CreditCard;
import edu.teamrocket.receptivo.GuestDispatcher;

public class UfosPark implements GuestDispatcher {
    
    private double fee = 500d;
    private final Map<String,String> flota = new HashMap<String,String>();

    public UfosPark(){}

    public void add(String ufo){
        flota.putIfAbsent(ufo, null);
    }

    @Override
    public void dispatch(CreditCard card) {
        if (!containsCard(card.number())){
            String ufo = flota.entrySet().stream().filter(x-> x.getValue() == null).map(Map.Entry::getKey).findFirst().orElse(null);

            if (ufo != null && card.pay(fee)){
                flota.put(ufo, card.number());
            }
        }
    }

    public String getUfoOf(String cardNumber){
        String ufoID = flota.entrySet().stream()
        .filter(x-> x.getValue() == cardNumber)
        .map(x -> x.getKey())
        .findFirst()
        .orElse(null);

        return ufoID;
    }

    public boolean containsCard(String card){
        return flota.values().stream().anyMatch(x-> x == card);
    }

    public Collection<String> cardNumbers(){
       return flota.values();
    }




    @Override
    public String toString() {
        return flota.keySet().stream().sorted().toList().toString();
    }


}
