package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public interface FabbricaDiComandi {
	public AbstractComando costruisciComando(String istruzione) throws Exception;
}

