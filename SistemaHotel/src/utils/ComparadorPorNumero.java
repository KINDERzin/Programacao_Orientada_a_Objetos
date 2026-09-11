package utils;

import java.util.Comparator;

import model.Quarto;

// Exercício 21
public class ComparadorPorNumero 
		implements Comparator<Quarto> {

	@Override
	public int compare(Quarto o1, Quarto o2) {
		if(o1.getNumero() > o2.getNumero()) {
			return -1;
		} else if (o2.getNumero() > o1.getNumero()) {
			return 1;
		}
		
		return 0;
	}
	
	
}
