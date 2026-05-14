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

    public boolean pay(double quantity){
        if (this.credit()-1 >= quantity){
            this.credit -= quantity;
            return true;
        }
        else{
            return false;
        }
    }
    
    public String cardOwner() {
        return owner;
    }

    public double credit(){
        return this.credit;
    }

    public String number(){
        return this.number;
    }

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();

        build.append("owner: ");
        build.append(this.owner);
        build.append("\nnumber: ");
        build.append(this.number());
        build.append("\ncredit: ");
        build.append(this.credit());
        build.append(this.SYMBOL);

        return build.toString();

    }
}