package controller;

import model.*;
import view.SimpleWindow;
import view.UI;

public class Main {

	public static void main(String[] args) {
		UI ui = new SimpleWindow("model.GuessingGame");
		RandomNumGenerator randomNumGenerator = new RandomNumGeneratorImpl();
		GuessingGameImpl game = new GuessingGameImpl();
		game.setRandomNumGenerator(randomNumGenerator);
		game.setRange(Config.RANGE);
		game.newGame();
		GuessingGameController controller = new GuessingGameController();
		controller.setGame(game);
		controller.setUi(ui);
		controller.playGame();
	}
}
