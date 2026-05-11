package edu.teamrocket.payment;

public class CreditCard {

    private final String owner;
    private final String number;
    private double credit = 3000d;
    private final String SYMBOL = "EZI";

    public CreditCard(String owner, String number){
        this.owner = owner;
        this.number = number;
    }

    public boolean pay(double credit){
        return this.credit >= credit;
    }


}