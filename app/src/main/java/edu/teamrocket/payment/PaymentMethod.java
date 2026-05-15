package edu.teamrocket.payment;

public interface PaymentMethod {

    boolean pay(double quantity);

    String cardOwner();

    double credit();

    String number();

}