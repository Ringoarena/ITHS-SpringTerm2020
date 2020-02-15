package model;

public interface GuessingGame {
    void setRange(int range);

    void setRandomNumGenerator(RandomNumGenerator randomNumGenerator);

    void newGame();

    GuessResult makeGuess(int guess);

    int getNumberOfGuesses();

    int getAnswer();

    int getRange();
}
