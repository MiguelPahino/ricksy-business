package edu.teamrocket.receptivo;

import edu.teamrocket.payment.PaymentMethod;

public interface GuestDispatcher {

    public void dispatch(PaymentMethod card);
} 
