package edu.teamrocket.payment;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class CreditCardTest {

    private PaymentMethod card = null;

    @Before
    public void setupCard() {
        card = new CreditCard("Abradolf Lincler", "4916119711304546");
        assertNotNull("CreditCard creada", card);
    }
    @Test public void constructorTest() {  
        assertNotNull("CreditCard creada", card);      
        assertEquals("4916119711304546", card.number());
    }

    @Test
    public void payTestOK() {
        assertTrue(card.pay(2999.0));
        assertEquals(1.0, card.credit(), 0);
    }

    @Test
    public void payTestNOTOKZERO() {
        assertFalse(card.pay(2999.1));
        assertEquals(3000, card.credit(), 0.1);
    }

    @Test
    public void payTestNOTOK() {
        assertFalse(card.pay(4000));
        assertEquals(3000, card.credit(), 0);
    }
}