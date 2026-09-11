package utils;

import java.util.Comparator;

import model.Quarto;

//Exercício 22
public class ComparadorPorPreco 
	implements Comparator<Quarto> {

	@Override
	public int compare(Quarto o1, Quarto o2) {
		if(o1.getValorDiaria() > o2.getValorDiaria()) {
			return -1;
		} else if (o2.getValorDiaria() > o1.getValorDiaria()) {
			return 1;
		}
		
		// Exercício 23
		//if(o1.getValorDiaria() < o2.getValorDiaria()) {
		//		return -1;
		//} else if (o2.getValorDiaria() < o1.getValorDiaria()) {
		//		return 1;
		//}
		return 0;
	}

}
