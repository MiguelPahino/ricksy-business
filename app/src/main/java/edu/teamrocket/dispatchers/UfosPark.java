package edu.teamrocket.dispatchers;


import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;


import edu.teamrocket.payment.CreditCard;
import edu.teamrocket.receptivo.GuestDispatcher;

public class UfosPark implements GuestDispatcher {
    
    private double fee = 500d;
    private final Map<String,String> flota = new LinkedHashMap<String,String>();

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
        .filter(x-> x.getValue().equals(cardNumber))
        .map(x -> x.getKey())
        .findFirst()
        .orElse(null);

        return ufoID;
    }

    public boolean containsCard(String card){
        return flota.entrySet().stream().anyMatch(x-> x.getValue().equals(card));
    }

    public Collection<String> cardNumbers(){
       return flota.values();
    }




    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        
        flota.entrySet()
        .stream()
        .forEach(x -> {build.append( x.getKey());
            build.append(": ");
            build.append(x.getKey());
            build.append( "\n");
        });

        return build.toString();
    }


}
