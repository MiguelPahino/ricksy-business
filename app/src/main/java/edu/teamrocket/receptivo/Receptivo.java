package edu.teamrocket.receptivo;

import java.util.LinkedHashSet;
import java.util.Set;

import edu.teamrocket.payment.CreditCard;

public class Receptivo implements GuestDispatcher {

    private static Receptivo instance = null;
    
    private final Set<GuestDispatcher> registrados = new LinkedHashSet<>();

    private Receptivo(){};

    public static Receptivo getReceptivo(){
        return  instance == null ? instance = new Receptivo() : instance;
    }

    public void registra(GuestDispatcher registrado){
        this.registrados.add(registrado);
    }

    @Override
    public void dispatch(CreditCard card) {
        this.registrados.stream().forEach(x-> x.dispatch(card));
    }
}
