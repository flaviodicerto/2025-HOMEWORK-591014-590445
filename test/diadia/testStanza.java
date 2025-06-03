package diadia;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


class testStanza {
	private Stanza stanza;
	
	@BeforeEach
	void setUp() {
	stanza = new Stanza("prova");
	}
	

	@Test
	void testAttrezzoAggiunto() {
        // Controllo il funzionamento di getAttrezzo("nome")
		Attrezzo a=new Attrezzo("pala",2);
        stanza.addAttrezzo(a);
        assertEquals(stanza.getAttrezzo("pala"),a, "L'attrezzo è stato inserito correttamente");
		}
	
	
	@Test
	void testImpostaStanzaAdiacente() {
		Stanza b=new Stanza("b");
		stanza.impostaStanzaAdiacente("nord",b);
		
		 assertEquals(b,stanza.getStanzaAdiacente("nord"), "La stanza adiacente è corretta");
	}
	
	@Test
	void testAddAttrezzo() {
	    Attrezzo pala = new Attrezzo("pala", 2);
	    assertTrue(stanza.addAttrezzo(pala), "L'attrezzo dovrebbe essere aggiunto correttamente.");
	    assertEquals(pala, stanza.getAttrezzo("pala"), "L'attrezzo dovrebbe essere recuperato correttamente.");
	}
	

	@Test
	void testAttrezzoNonAggiuntoQuandoStanzaPiena() {
	    for (int i = 0; i < 10; i++) {
	        stanza.addAttrezzo(new Attrezzo("attrezzo" + i, 1));
	    }
	    Attrezzo nuovoAttrezzo = new Attrezzo("pala", 2);
	    assertFalse(stanza.addAttrezzo(nuovoAttrezzo), "Non dovrebbe essere possibile aggiungere un attrezzo se la stanza è piena.");
	}
	
	@Test
	void testImpostaERecuperaStanzaAdiacente() {
	    Stanza b = new Stanza("b");
	    stanza.impostaStanzaAdiacente("nord", b);
	    assertEquals(b, stanza.getStanzaAdiacente("nord"), "La stanza adiacente dovrebbe essere correttamente impostata e recuperata.");
	}
	
	@Test
	void testImpostaStanzaAdiacenteQuandoPieno() {
	    Stanza[] stanze = new Stanza[4];
	    for (int i = 0; i < 4; i++) {
	        stanze[i] = new Stanza("Stanza" + i);
	        stanza.impostaStanzaAdiacente("direzione" + i, stanze[i]);
	    }

	    Stanza nuovaStanza = new Stanza("Nuova");
	    stanza.impostaStanzaAdiacente("nord", nuovaStanza); // Questa operazione non dovrebbe essere possibile
	    assertNull(stanza.getStanzaAdiacente("nord"), "Non dovrebbe essere possibile aggiungere una stanza adiacente se non c'è spazio.");
	}
	
	@Test
	void testRemoveAttrezzo() {
	    Attrezzo pala = new Attrezzo("pala", 2);
	    stanza.addAttrezzo(pala);
	    assertTrue(stanza.removeAttrezzo(pala), "L'attrezzo dovrebbe essere rimosso correttamente.");
	    assertNull(stanza.getAttrezzo("pala"), "L'attrezzo dovrebbe essere rimosso dalla stanza.");
	}
	
	@Test
	void testHasAttrezzo() {
	    Attrezzo pala = new Attrezzo("pala", 2);
	    stanza.addAttrezzo(pala);
	    assertTrue(stanza.hasAttrezzo("pala"), "La stanza dovrebbe contenere l'attrezzo.");
	}
	
	@Test
	void testDirezioni() {
	    Stanza b = new Stanza("b");
	    Stanza c = new Stanza("c");
	    stanza.impostaStanzaAdiacente("nord", b);
	    stanza.impostaStanzaAdiacente("est", c);
	    
	    String[] direzioni = stanza.getDirezioni();
	    assertEquals(2, direzioni.length, "Dovrebbero esserci due direzioni.");
	    assertTrue(direzioni[0].equals("nord") || direzioni[1].equals("nord"), "La direzione nord dovrebbe essere presente.");
	    assertTrue(direzioni[0].equals("est") || direzioni[1].equals("est"), "La direzione est dovrebbe essere presente.");
	}
	
}
