package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class testStanzaBloccata {

    private StanzaBloccata stanzaBloccata;
    private String descrizione;

    @Before
    public void setUp() {
        this.descrizione = "N18"+"\n-> DIREZIONE sud BLOCCATA <-"
                            + "\nUscite:  sud"+"\nAttrezzi nella stanza: ";
        this.stanzaBloccata = new StanzaBloccata("N18","sud");
        this.stanzaBloccata.impostaStanzaAdiacente("sud", new Stanza("N17"));
    }

    @Test
    public void testDescrizioneBloccata() {
        assertNotEquals(this.stanzaBloccata.toString(), this.stanzaBloccata.getDescrizione());
        assertEquals(this.stanzaBloccata.getDescrizione(),this.descrizione);
    }

    @Test
    public void testDescrizioneNonBloccata(){
        this.stanzaBloccata.addAttrezzo(new Attrezzo("chiave",1));
        assertEquals(this.stanzaBloccata.toString(), this.stanzaBloccata.getDescrizione());
    }

    @Test
    public void testGetStanzaAdiacenteConAttrezzo() {
        this.stanzaBloccata.addAttrezzo(new Attrezzo("chiave",1));
        assertEquals(this.stanzaBloccata.getStanzaAdiacente("sud").getNome(),"N17");
    }

    @Test
    public void testGetStanzaAdiacenteSenzaAttrezzo() {
        assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente("sud"));
    }

}