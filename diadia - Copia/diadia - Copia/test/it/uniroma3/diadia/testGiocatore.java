package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
		 Giocatore prova = new Giocatore();
		  prova.setCFU(0);
		 Partita partita = new Partita(prova);
	        assertTrue(partita.isFinita(), "La partita dovrebbe finire quando i CFU sono zero.");
	    }

}
