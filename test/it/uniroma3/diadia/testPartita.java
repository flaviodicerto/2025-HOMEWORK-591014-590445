package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

class testPartita {
	 private Partita partita;
		
	 		@BeforeEach
			void setUp() {
			partita = new Partita();
			}
	 		
	 		@Test
			void testVinta() {
	        // Impostiamo la stanza corrente come quella vincente
	        partita.getLabirinto().setStanzaCorrente(partita.getLabirinto().getStanzaVincente());
	        assertTrue(partita.vinta(), "La partita dovrebbe essere vinta quando la stanza corrente è quella vincente.");
			}
		
			@Test
			void testNonVinta() {
	        // Assicuriamoci che la stanza corrente NON sia quella vincente
	        assertFalse(partita.vinta(), "La partita non dovrebbe essere vinta all'inizio.");
			}
		
			@Test
		    void testPartitaFinitaPerVittoria() {
		        partita.getLabirinto().setStanzaCorrente(partita.getLabirinto().getStanzaVincente());
		        assertTrue(partita.isFinita(), "La partita dovrebbe finire quando si vince.");
		    }


		    @Test
		    void testPartitaFinitaPerSetFinita() {
		        partita.setFinita();
		        assertTrue(partita.isFinita(), "La partita dovrebbe essere segnata come finita dopo la chiamata a setFinita().");
		    }

		    @Test
		    void testPartitaNonFinitaInizialmente() {
		        assertFalse(partita.isFinita(), "La partita non dovrebbe essere finita all'inizio.");
		    }
  

		    @Test
		    void testCambiaStanzaCorrente() {
		        Stanza nuovaStanza = new Stanza("Nuova Stanza");
		        partita.getLabirinto().setStanzaCorrente(nuovaStanza);
		        assertEquals(nuovaStanza, partita.getLabirinto().getStanzaCorrente(), "La stanza corrente dovrebbe essere aggiornata correttamente.");
		    }
	
	
}

