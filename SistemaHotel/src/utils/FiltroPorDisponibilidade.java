package utils;

import java.util.function.Predicate;

import model.Disponibilidade;
import model.Quarto;

public class FiltroPorDisponibilidade 
	implements Predicate<Quarto>{

	@Override
	public boolean test(Quarto t) {
		if(t.getDisponibilidade() == 
				Disponibilidade.DISPONIVEL) {
			return true;
		}
		
		return false;
	}

}
