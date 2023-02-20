import org.junit.Test;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * For testing the controller of MarbleSolitaire.
 */
public class MarbleSolitaireControllerTests {
  MarbleSolitaireModel m1 = new EnglishSolitaireModel();

  StringBuilder output = new StringBuilder();
  MarbleSolitaireView view = new MarbleSolitaireTextView(m1, output);

  /**
   * To test play the game alone.
   *
   * @param inputs user inputs
   */
  public static void main(String[] inputs) {
    MarbleSolitaireModel m1 = new EnglishSolitaireModel();
    MarbleSolitaireView v1 = new MarbleSolitaireTextView(m1);
    Readable input = new InputStreamReader(System.in);
    MarbleSolitaireController c1 = new MarbleSolitaireControllerImpl(m1, v1, input);
    c1.playGame();
  }

  /**
   * Testing for IllegalArgumentException when given a null parameter while making a controller
   * object.
   */
  @Test
  public void testConstructor() {
    MarbleSolitaireView v1 = new MarbleSolitaireTextView(m1);
    Reader input = new StringReader("");
    try {
      MarbleSolitaireController nullModel = new MarbleSolitaireControllerImpl(null, v1, input);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("At least one parameter is null.", e.getMessage());
    }
    try {
      MarbleSolitaireController nullView = new MarbleSolitaireControllerImpl(m1, null, input);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("At least one parameter is null.", e.getMessage());
    }
    try {
      MarbleSolitaireController nullReadable = new MarbleSolitaireControllerImpl(m1, v1, null);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("At least one parameter is null.", e.getMessage());
    }
  }

  /**
   * Testing for immediately quitting with lowercase q.
   */
  @Test
  public void testQuitImmediately() {
    Reader input = new StringReader("q");
    MarbleSolitaireController c1 = new MarbleSolitaireControllerImpl(m1, view, input);
    c1.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", output.toString());
  }

  /**
   * Testing for immediately quitting with uppercase Q.
   */
  @Test
  public void testQuitImmediately2() {
    Reader input = new StringReader("Q");
    MarbleSolitaireController c1 = new MarbleSolitaireControllerImpl(m1, view, input);
    c1.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", output.toString());
  }

  /**
   * Testing for 3 valid inputs then quitting.
   */
  @Test
  public void testQuitAfterInputs() {
    Reader input = new StringReader("6 4 4 q");
    MarbleSolitaireController c1 = new MarbleSolitaireControllerImpl(m1, view, input);
    c1.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", output.toString());
  }

  /**
   * Testing move from two rows down.
   */
  @Test
  public void testMoveFromTwoDown() {
    Reader input = new StringReader("6 4 4 4 q");
    MarbleSolitaireController c1 = new MarbleSolitaireControllerImpl(m1, view, input);
    c1.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", output.toString());
  }

  /**
   * Testing move from two rows up.
   */
  @Test
  public void testMoveFromTwoUp() {
    Reader input = new StringReader("2 4 4 4 q");
    MarbleSolitaireController c1 = new MarbleSolitaireControllerImpl(m1, view, input);
    c1.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", output.toString());
  }

  /**
   * Testing move from two columns left.
   */
  @Test
  public void testMoveFromTwoLeft() {
    Reader input = new StringReader("4 2 4 4 q");
    MarbleSolitaireController c1 = new MarbleSolitaireControllerImpl(m1, view, input);
    c1.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", output.toString());
  }

  /**
   * Testing move from two columns right.
   */
  @Test
  public void testMoveFromTwoRight() {
    Reader input = new StringReader("4 6 4 4 q");
    MarbleSolitaireController c1 = new MarbleSolitaireControllerImpl(m1, view, input);
    c1.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", output.toString());
  }

  /**
   * Testing move with various invalid innputs.
   */
  @Test
  public void testMoveWithInvalidInputs() {
    Reader input = new StringReader("A 0 b c q");
    MarbleSolitaireController c1 = new MarbleSolitaireControllerImpl(m1, view, input);
    c1.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Please re enter a valid input. Press Q to quit or enter a positive integer.\n" +
            "Please re enter a valid input. Press Q to quit or enter a positive integer.\n" +
            "Please re enter a valid input. Press Q to quit or enter a positive integer.\n" +
            "Please re enter a valid input. Press Q to quit or enter a positive integer.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", output.toString());
  }

  /**
   * Testing move with 1 invalid input then completing the valid move.
   */
  @Test
  public void testMoveAndInvalidInputs() {
    Reader input = new StringReader("6 4 4 0 4 q");
    MarbleSolitaireController c1 = new MarbleSolitaireControllerImpl(m1, view, input);
    c1.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Please re enter a valid input. Press Q to quit or enter a positive integer.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", output.toString());
  }

  /**
   * Testing an invalid move.
   */
  @Test
  public void testInvalidMove() {
    Reader input = new StringReader("1 1 1 1 q");
    MarbleSolitaireController c1 = new MarbleSolitaireControllerImpl(m1, view, input);
    c1.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", output.toString());
  }

  /**
   * Testing an invalid move followed by a valid move.
   */
  @Test
  public void testInvalidMoveThenValid() {
    Reader input = new StringReader("1 1 1 1 6 4 4 4 q");
    MarbleSolitaireController c1 = new MarbleSolitaireControllerImpl(m1, view, input);
    c1.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", output.toString());
  }

  /**
   * Testing for when the game is over.
   */
  @Test
  public void testGameOver() {
    Reader input = new StringReader("6 4 4 4 " +
            "5 6 5 4 " +
            "7 5 5 5 " +
            "7 3 7 5 " +
            "4 5 6 5 " +
            "7 5 5 5 " +
            "2 5 4 5 " +
            "3 7 3 5 " +
            "5 7 3 7 " +
            "3 4 3 6 " +
            "3 7 3 5 " +
            "3 2 3 4 " +
            "1 3 3 3 " +
            "1 5 1 3 " +
            "4 3 2 3 " +
            "1 3 3 3 " +
            "6 3 4 3 " +
            "5 1 5 3 " +
            "3 1 5 1 " +
            "5 4 5 2 " +
            "5 1 5 3 " +
            "3 4 3 2 " +
            "3 2 5 2 " +
            "5 2 5 4 " +
            "5 4 5 6 " +
            "5 6 3 6 " +
            "3 6 3 4 " +
            "4 4 4 2 " +
            "2 4 4 4 " +
            "4 5 4 3 " +
            "4 2 4 4");
    MarbleSolitaireController c1 = new MarbleSolitaireControllerImpl(m1, view, input);
    c1.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O _ O\n" +
            "    O _ _\n" +
            "    O O _\n" +
            "Score: 29\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O _ O\n" +
            "    O _ _\n" +
            "    _ _ O\n" +
            "Score: 28\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ O O\n" +
            "O O O O _ _ O\n" +
            "    O _ O\n" +
            "    _ _ O\n" +
            "Score: 27\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ O O\n" +
            "O O O O O _ O\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 26\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O O _ O O\n" +
            "O O O O O O O\n" +
            "O O O O O _ O\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 25\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O O O _ _\n" +
            "O O O O O O O\n" +
            "O O O O O _ O\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 24\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O O O _ O\n" +
            "O O O O O O _\n" +
            "O O O O O _ _\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 23\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O _ _ O O\n" +
            "O O O O O O _\n" +
            "O O O O O _ _\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 22\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O _ O _ _\n" +
            "O O O O O O _\n" +
            "O O O O O _ _\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 21\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O _ _ O O _ _\n" +
            "O O O O O O _\n" +
            "O O O O O _ _\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 20\n" +
            "    _ O O\n" +
            "    _ O _\n" +
            "O _ O O O _ _\n" +
            "O O O O O O _\n" +
            "O O O O O _ _\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 19\n" +
            "    O _ _\n" +
            "    _ O _\n" +
            "O _ O O O _ _\n" +
            "O O O O O O _\n" +
            "O O O O O _ _\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 18\n" +
            "    O _ _\n" +
            "    O O _\n" +
            "O _ _ O O _ _\n" +
            "O O _ O O O _\n" +
            "O O O O O _ _\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 17\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "O _ O O O _ _\n" +
            "O O _ O O O _\n" +
            "O O O O O _ _\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 16\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "O _ O O O _ _\n" +
            "O O O O O O _\n" +
            "O O _ O O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 15\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "O _ O O O _ _\n" +
            "O O O O O O _\n" +
            "_ _ O O O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 14\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ O O O _ _\n" +
            "_ O O O O O _\n" +
            "O _ O O O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 13\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ O O O _ _\n" +
            "_ O O O O O _\n" +
            "O O _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 12\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ O O O _ _\n" +
            "_ O O O O O _\n" +
            "_ _ O _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 11\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ O _ _ O _ _\n" +
            "_ O O O O O _\n" +
            "_ _ O _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 10\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O O O O _\n" +
            "_ O O _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 9\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O O O O _\n" +
            "_ _ _ O O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 8\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ O O O O _\n" +
            "_ _ _ _ _ O _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 7\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ O O _\n" +
            "_ _ O O O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 6\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ O O O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 5\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ O _ _ _\n" +
            "_ O _ _ O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 4\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O _ O O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 3\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ O O _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 2\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1", output.toString());
  }
}
