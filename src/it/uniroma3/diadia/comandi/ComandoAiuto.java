package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	static final private String[] elencoComandi = {"'vai'", "'aiuto'", "'fine'", "'prendi'", "'posa'", "'guarda'"};

    @Override
    public void esegui(Partita partita) {
        partita.getConsole().mostraMessaggio("I comandi che puoi utilizzare sono: ");
        for(int i=0; i< elencoComandi.length; i++) 
            partita.getConsole().mostraMessaggio(elencoComandi[i]+" ");
    }

    @Override
    public void setParametro(String parametro) {
        return;
    }
    
}
