package core;

import view.FilmeView;
import controller.FilmeController;
import repository.FilmeRepository;

public class Main {
	public static void main(String[] args) {
		FilmeView view = new FilmeView();
		FilmeRepository repository = new FilmeRepository();
		FilmeController controller = new FilmeController(view, repository);
		
		view.setVisible(true);
	}
}