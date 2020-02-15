package model;

public class GuessingGameMock implements GuessingGame {
    private int getRangeCallCount;              // Should equal 1 per game.
    private int makeGuessCallCount;             // Should equal 1 per game.
    private int getNumberOfGuessesCallCount;    // Should equal 1 per game.
    private int newGameCallCount;               // Should equal 1 per game.
    private GuessResult guessResult;

    @Override
    public int getRange() {
        getRangeCallCount++;
        return Config.RANGE;
    }

    @Override
    public GuessResult makeGuess(int guess) {
        makeGuessCallCount++;
        return guessResult;
    }

    @Override
    public int getNumberOfGuesses() {
        getNumberOfGuessesCallCount++;
        return 1337;
    }

    @Override
    public void newGame() {
        newGameCallCount++;
    }

    @Override
    public void setRange(int range) {

    }

    @Override
    public void setRandomNumGenerator(RandomNumGenerator randomNumGenerator) {

    }

    @Override
    public int getAnswer() {
        return 0;
    }

    public void setGuessResult(GuessResult guessResult) {
        this.guessResult = guessResult;
    }

    public int getGetRangeCallCount() {
        return getRangeCallCount;
    }

    public int getMakeGuessCallCount() {
        return makeGuessCallCount;
    }

    public int getGetNumberOfGuessesCallCount() {
        return getNumberOfGuessesCallCount;
    }

    public int getNewGameCallCount() {
        return newGameCallCount;
    }
}
