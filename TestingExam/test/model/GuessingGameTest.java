package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GuessingGameTest {
    RandomNumGeneratorMock randomNumGeneratorMock = new RandomNumGeneratorMock();
    GuessingGameImpl guessingGameImpl = new GuessingGameImpl(Config.RANGE);

    @BeforeEach
    void setUp() {
        guessingGameImpl.setRandomNumGenerator(randomNumGeneratorMock);
        randomNumGeneratorMock.setAnswer(1);
        guessingGameImpl.newGame();
    }

    @Test
    void makeGuess() {
        // Outer for-loop tests different answers, values 1 through to 100, steps of 9.
        // 100 could be replaced with Config.RANGE.
        for (int answer = 1; answer <= 100; answer += 9) {
            randomNumGeneratorMock.setAnswer(answer);
            guessingGameImpl.newGame();

            // Test the first 200 possible values.
            for (int guess = Integer.MIN_VALUE; guess < Integer.MIN_VALUE + 200; guess++) {
                assertEquals(GuessResult.tooSmall, guessingGameImpl.makeGuess(guess));
            }

            // Test the last 200 possible values before the tooSmall/tooSmallButClose break-point.
            for (int guess = answer - Config.CLOSE_LIMIT - 200; guess < answer - Config.CLOSE_LIMIT; guess++) {
                assertEquals(GuessResult.tooSmall, guessingGameImpl.makeGuess(guess));
            }

            // Test all the values between the tooSmall/tooSmallButClose break-point and the correct answer.
            for (int guess = answer - Config.CLOSE_LIMIT; guess < answer; guess++) {
                assertEquals(GuessResult.tooSmallButClose, guessingGameImpl.makeGuess(guess));
            }

            // Test the correct answer.
            assertEquals(GuessResult.correct, guessingGameImpl.makeGuess(answer));

            // Test all the values between the correct answer and the tooLargeButClose/tooLarge break-point.
            for (int guess = answer + 1; guess <= answer + Config.CLOSE_LIMIT; guess++) {
                assertEquals(GuessResult.tooLargeButClose, guessingGameImpl.makeGuess(guess));
            }

            // Test the first 199 values after the tooLargeButClose/tooLarge break-point.
            for (int guess = answer + Config.CLOSE_LIMIT + 1; guess < answer + Config.CLOSE_LIMIT + 200; guess++) {
                assertEquals(GuessResult.tooLarge, guessingGameImpl.makeGuess(guess));
            }

            // Test the last 200 possible values.
            for (int guess = Integer.MAX_VALUE; guess > Integer.MAX_VALUE - 200; guess--) {
                assertEquals(GuessResult.tooLarge, guessingGameImpl.makeGuess(guess));
            }

//            Night-time tests for full coverage.
//
//            for (int guess = Integer.MIN_VALUE; guess < answer - Config.CLOSE_LIMIT; guess++) {
//                assertEquals(GuessResult.tooSmall, guessingGame.makeGuess(guess));
//            }
//
//            for (int guess = answer + Config.CLOSE_LIMIT + 1; guess < Integer.MAX_VALUE; guess++) {
//                assertEquals(GuessResult.tooLarge, guessingGame.makeGuess(guess));
//            }
        }
    }

    @Test
    void newGame() {
        assertEquals(0, guessingGameImpl.getNumberOfGuesses());
        assertNotEquals(0, guessingGameImpl.getAnswer());
    }

    @Test
    void getNumberOfGuesses() {
        assertEquals(0, guessingGameImpl.getNumberOfGuesses());
        guessingGameImpl.makeGuess(50);
        assertEquals(1, guessingGameImpl.getNumberOfGuesses());
        guessingGameImpl.makeGuess(50);
        assertEquals(2, guessingGameImpl.getNumberOfGuesses());
    }

    @Test
    void getRange() {
        assertEquals(Config.RANGE, guessingGameImpl.getRange());
    }
}