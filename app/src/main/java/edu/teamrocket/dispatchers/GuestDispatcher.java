package edu.teamrocket.dispatchers;

import edu.teamrocket.payment.CreditCard;

public interface GuestDispatcher {

    public void dispatch(CreditCard card);
}