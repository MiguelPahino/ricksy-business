package edu.teamrocket.payment;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CreditCardTest {

    private CreditCard card = null;

    @BeforeEach
    public void setupCard() {
        card = new CreditCard("Abradolf Lincler", "4916119711304546");
        assertNotNull(card,"CreditCard creada");
    }
    @Test public void constructorTest() {  
        assertNotNull(card,"CreditCard creada");
     
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