package controller;

import model.GuessResult;
import model.GuessingGameMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.UIMock;

import static org.junit.jupiter.api.Assertions.*;

class GuessingGameControllerTest {
    GuessingGameController controller;
    GuessingGameMock guessingGameMock;
    UIMock uiMock;

    @BeforeEach
    void setUp() {
        controller = new GuessingGameController();
        guessingGameMock = new GuessingGameMock();
        uiMock = new UIMock();

    }

    @Test
    void playGame() {
        controller.setGame(guessingGameMock);
        controller.setUi(uiMock);
        guessingGameMock.setGuessResult(GuessResult.correct);   // The game will make the first guess correct.
        uiMock.setString("no");                                 // The game will not play another round.
        controller.playGame();
        assertEquals(5, uiMock.getAddStringCallCount());
        assertEquals(1, uiMock.getGetIntCallCount());
        assertEquals(1, uiMock.getGetStringCallCount());
        assertEquals(1, uiMock.getExitCallCount());

        assertEquals(1, guessingGameMock.getGetRangeCallCount());
        assertEquals(1, guessingGameMock.getMakeGuessCallCount());
        assertEquals(1, guessingGameMock.getGetNumberOfGuessesCallCount());
        assertEquals(1, guessingGameMock.getNewGameCallCount());
    }

    @Test
    void playGame0() {
        controller.setGame(guessingGameMock);
        controller.setUi(uiMock);
        guessingGameMock.setGuessResult(GuessResult.correct);
        int numGames = 2;

        for (int game = 1; game <= numGames; game++) {
            uiMock.setString("no");


            controller.playGame();
            assertEquals(game * 5, uiMock.getAddStringCallCount());
            assertEquals(game, uiMock.getGetIntCallCount());
            assertEquals(game, uiMock.getGetStringCallCount());
            assertEquals(game, uiMock.getExitCallCount());

            assertEquals(game, guessingGameMock.getGetRangeCallCount());
            assertEquals(game, guessingGameMock.getMakeGuessCallCount());
            assertEquals(game, guessingGameMock.getGetNumberOfGuessesCallCount());
            assertEquals(game, guessingGameMock.getNewGameCallCount());
        }
        System.out.println(uiMock.getAddStringCallCount());
        System.out.println(uiMock.getGetIntCallCount());
        System.out.println(uiMock.getGetStringCallCount());
        System.out.println(uiMock.getExitCallCount());

        System.out.println(guessingGameMock.getGetRangeCallCount());
        System.out.println(guessingGameMock.getMakeGuessCallCount());
        System.out.println(guessingGameMock.getGetNumberOfGuessesCallCount());
        System.out.println(guessingGameMock.getNewGameCallCount());
    }

    @Test
    void setGame() {
        assertNull(controller.getGame());
        controller.setGame(guessingGameMock);
        assertNotNull(controller.getGame());
    }

    @Test
    void setUi() {
        assertNull(controller.getUi());
        controller.setUi(uiMock);
        assertNotNull(controller.getUi());
    }
}