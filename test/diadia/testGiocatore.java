package diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.Giocatore;

class testGiocatore {
	
	
	@Test
    void testCfu() {
		Giocatore prova = new Giocatore();
		prova.setCFU(10);
        assertEquals(10, prova.getCFU(), "I CFU dovrebbero essere aggiornati correttamente.");
    }
	
	
	 @Test
	    void testPartitaFinitaPerCFUZero() {
		 Partita partita = new Partita();
		 partita.getGiocatore().setCFU(0);
	        assertTrue(partita.isFinita(), "La partita dovrebbe finire quando i CFU sono zero.");
	    }

}
