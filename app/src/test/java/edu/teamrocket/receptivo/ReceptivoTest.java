package edu.teamrocket.receptivo;

import edu.teamrocket.payment.CreditCard;
import edu.teamrocket.dispatchers.*;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ReceptivoTest {

    private Receptivo receptivo = null;
    private UfosParkTest parkTest = null;
    private CrystalExpender packExpender = null;

    @BeforeEach
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
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        receptivo.dispatch(card);

        assertEquals(2450, card.credit(), 0);
        assertTrue(parkTest.ufos.containsCard(card.number()));
        assertEquals(99, packExpender.stock());
    }

    @Test
    public void dispatchNoCreditTest() {

        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        assertTrue(card.pay(2990));
        assertEquals(10, card.credit(), 0);
        receptivo.dispatch(card);
        assertEquals(10, card.credit(), 0);
        assertFalse(parkTest.ufos.containsCard(card.number()));
        assertEquals(100, packExpender.stock());
    }

}