package edu.teamrocket.dispatchers;

import edu.teamrocket.payment.PaymentMethod;

public interface GuestDispatcher {

    public void dispatch(PaymentMethod card);
}