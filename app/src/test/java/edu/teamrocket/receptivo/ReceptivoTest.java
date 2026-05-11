package edu.teamrocket.receptivo;

import org.junit.Test;

import edu.teamrocket.dispatchers.CrystalExpender;
import edu.teamrocket.dispatchers.UfosParkTest;
import edu.teamrocket.payment.CreditCard;
import edu.teamrocket.payment.PaymentMethod;

import static org.junit.Assert.*;

import org.junit.Before;

public class ReceptivoTest {

    private Receptivo receptivo = null;
    private UfosParkTest parkTest = null;
    private CrystalExpender packExpender = null;

    @Before
    public void setupTest() {

        parkTest = new UfosParkTest();
        parkTest.setupUfosPark();

        packExpender = new CrystalExpender(100, 50);

        receptivo = Receptivo.getReceptivo();
        receptivo.registra(parkTest.ufos);
        receptivo.registra(packExpender);
    }

    @Test
    public void SingletonReceptivo() {
        receptivo = Receptivo.getReceptivo();
        assertNotNull(receptivo);
        Receptivo otroReceptivo = Receptivo.getReceptivo();
        assertEquals(receptivo, otroReceptivo);
        assertSame(receptivo, otroReceptivo);
    }

    @Test
    public void dispatchTest() {
ricksy.business
        PaymentMethod card = new CreditCard("Abradolf Lincler", "4916119711304546");
        receptivo.dispatch(card);

        assertEquals(2450, card.credit(), 0);
        assertTrue(parkTest.ufos.containsCard(card.number()));
        assertEquals(99, packExpender.stock());
    }

    @Test
    public void dispatchNoCreditTest() {

        PaymentMethod card = new CreditCard("Abradolf Lincler", "4916119711304546");
        assertTrue(card.pay(2990));
        assertEquals(10, card.credit(), 0);
        receptivo.dispatch(card);
        assertEquals(10, card.credit(), 0);
        assertFalse(parkTest.ufos.containsCard(card.number()));
        assertEquals(100, packExpender.stock());
    }

}