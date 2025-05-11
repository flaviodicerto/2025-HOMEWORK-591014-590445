package diadia;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

import org.junit.jupiter.api.BeforeEach;

class testBorsa {
	
	public class BorsaTest {

	    private Borsa borsa;
	    private Attrezzo attrezzo1;
	    private Attrezzo attrezzo2;
	    private Attrezzo attrezzo3;
	    private Attrezzo attrezzo4;
	    private Attrezzo attrezzo5;

	    @BeforeEach
	    public void setUp() {
	        borsa = new Borsa();
	        attrezzo1 = new Attrezzo("Martello", 3);
	        attrezzo2 = new Attrezzo("Cacciavite", 1);
	        attrezzo3 = new Attrezzo("Chiave", 2);
	        attrezzo4 = new Attrezzo("Piede di porco", 5);
	        attrezzo5 = new Attrezzo("Pala", 11);
	    }

	    
	    @Test
	    public void testAddAttrezzo() {
	        assertTrue(borsa.addAttrezzo(attrezzo1));  // Dovrebbe restituire true
	        assertTrue(borsa.addAttrezzo(attrezzo2));  // Dovrebbe restituire true
	        assertTrue(borsa.addAttrezzo(attrezzo3));  // Dovrebbe restituire true
	        assertTrue(borsa.addAttrezzo(attrezzo4));  // Dovrebbe restituire true
	        assertFalse(borsa.addAttrezzo(attrezzo5)); // Dovrebbe restituire false, borsa piena
	    }

	    @Test
	    public void testGetPeso() {
	        borsa.addAttrezzo(attrezzo1);
	        borsa.addAttrezzo(attrezzo2);
	        borsa.addAttrezzo(attrezzo3);
	        assertEquals(6, borsa.getPeso());  // Peso totale = 3 + 1 + 2 = 6
	    }

	    @Test
	    public void testGetAttrezzo() {
	        borsa.addAttrezzo(attrezzo1);
	        borsa.addAttrezzo(attrezzo2);
	        assertEquals(attrezzo1, borsa.getAttrezzo("Martello"));  // Dovrebbe restituire Martello
	        assertNull(borsa.getAttrezzo("Pala"));  // Dovrebbe restituire null, non presente
	    }

	    @Test
	    public void testRemoveAttrezzo() {
	        // Verifica che ci siano 3 attrezzi prima della rimozione
	        assertEquals(3, borsa.getNumeroAttrezzi());

	        // Rimuovi l'attrezzo "scudo"
	        Attrezzo rimosso = borsa.removeAttrezzo("scudo");

	        // Verifica che l'attrezzo rimosso sia corretto
	        assertEquals(attrezzo2, rimosso);

	        // Verifica che ci siano 2 attrezzi dopo la rimozione
	        assertEquals(2, borsa.getNumeroAttrezzi());

	        // Verifica che l'attrezzo "scudo" non sia più nella borsa
	        assertNull(borsa.getAttrezzo("scudo"));

	        // Verifica che gli altri attrezzi siano ancora presenti
	        assertNotNull(borsa.getAttrezzo("spada"));
	        assertNotNull(borsa.getAttrezzo("elmo"));
	    }

	    @Test
	    public void testIsEmpty() {
	        assertTrue(borsa.isEmpty());  // La borsa è vuota inizialmente
	        borsa.addAttrezzo(attrezzo1);
	        assertFalse(borsa.isEmpty());  // La borsa non è vuota dopo aver aggiunto un attrezzo
	    }

	    @Test
	    public void testHasAttrezzo() {
	        borsa.addAttrezzo(attrezzo1);
	        assertTrue(borsa.hasAttrezzo("Martello"));  // Dovrebbe restituire true
	        assertFalse(borsa.hasAttrezzo("Pala"));    // Dovrebbe restituire false
	    }

	    @Test
	    public void testToString() {
	        borsa.addAttrezzo(attrezzo1);
	        borsa.addAttrezzo(attrezzo2);
	        assertTrue(borsa.toString().contains("Martello"));
	        assertTrue(borsa.toString().contains("Cacciavite"));
	    }
	}


}
