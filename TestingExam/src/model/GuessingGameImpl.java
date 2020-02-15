package model;

public class GuessingGameImpl implements GuessingGame {
	private int range;
	private int answer;
	private int numberOfGuesses;
	private RandomNumGenerator randomNumGenerator;

	public GuessingGameImpl() {
	}

	public GuessingGameImpl(int range) {
		this.range = range;
	}

	public GuessingGameImpl(int range, RandomNumGenerator randomNumGenerator){
		this.range = range;
		this.randomNumGenerator = randomNumGenerator;
		newGame();
	}

	@Override
	public void setRange(int range) {
		this.range = range;
	}

	@Override
	public void setRandomNumGenerator(RandomNumGenerator randomNumGenerator) {
		this.randomNumGenerator = randomNumGenerator;
	}

	@Override
	public void newGame() {
		answer = randomNumGenerator.generate(range);
		numberOfGuesses = 0;
    }
	
	@Override
	public GuessResult makeGuess(int guess) {
		numberOfGuesses++;
		boolean isClose = Math.abs(guess - answer == Integer.MIN_VALUE ? Integer.MAX_VALUE : guess - answer) <= Config.CLOSE_LIMIT;
		if (guess < answer) {
			return isClose ? GuessResult.tooSmallButClose : GuessResult.tooSmall;
		} else if (guess > answer) {
			return isClose ? GuessResult.tooLargeButClose : GuessResult.tooLarge;
		} else {
			return GuessResult.correct;
		}			
	}

	@Override
	public int getNumberOfGuesses() {
		return numberOfGuesses;
	}

	@Override
	public int getAnswer() {
		return answer;
	}

	@Override
	public int getRange() {
		return range;
	}
	

}


