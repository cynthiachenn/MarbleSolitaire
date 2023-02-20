import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * For testing the model of MarbleSolitaire.
 */
public class MarbleSolitaireTests {
  MarbleSolitaireModel c1 = new EnglishSolitaireModel();
  MarbleSolitaireModel c2 = new EnglishSolitaireModel(2, 4);
  MarbleSolitaireModel c2v2 = new EnglishSolitaireModel(4, 6);
  MarbleSolitaireModel c3 = new EnglishSolitaireModel(3);
  MarbleSolitaireModel c3v2 = new EnglishSolitaireModel(1);
  MarbleSolitaireModel c3v3 = new EnglishSolitaireModel(5);
  MarbleSolitaireModel c4 = new EnglishSolitaireModel(3, 3, 3);
  MarbleSolitaireModel c4v2 = new EnglishSolitaireModel(3, 4, 6);
  MarbleSolitaireModel c4v3 = new EnglishSolitaireModel(5, 6, 12);
  MarbleSolitaireTextView viewC1 = new MarbleSolitaireTextView(c1);
  MarbleSolitaireTextView viewC2 = new MarbleSolitaireTextView(c2);
  MarbleSolitaireTextView viewC2V2 = new MarbleSolitaireTextView(c2v2);
  MarbleSolitaireTextView viewC3 = new MarbleSolitaireTextView(c3);
  MarbleSolitaireTextView viewC3V2 = new MarbleSolitaireTextView(c3v2);
  MarbleSolitaireTextView viewC3V3 = new MarbleSolitaireTextView(c3v3);
  MarbleSolitaireTextView viewC4 = new MarbleSolitaireTextView(c4);
  MarbleSolitaireTextView viewC4V2 = new MarbleSolitaireTextView(c4v2);
  MarbleSolitaireTextView viewC4V3 = new MarbleSolitaireTextView(c4v3);

  /**
   * Testing the toString() method in MarbleSolitaireTextView.
   */
  @Test
  public void testView() {
    // Constructor 1
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", viewC1.toString());
    // Constructor 2
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O _ O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", viewC2.toString());
    //                 O O O      \n" +
    //            "  O O O O O    \n" +
    //            "O O O O _ O O  \n" +
    //            "O O O O O O O  \n" +
    //            "O O O O O O O  \n" +
    //            "  O O O O O    \n" +
    //            "    O O O"
    //                       O O O O O\n"
    //            + "      O O O O O O\n"
    //            + "    O O O O O O O\n"
    //            + "  O O O O O O O O\n"
    //            + "O O O O O O O O O O O O O\n"
    //            + "O O O O O O O O O O O O O\n"
    //            + "O O O O O O _ O O O O O O\n"
    //            + "O O O O O O O O O O O O O\n"
    //            + "O O O O O O O O O O O O O\n"
    //            + "        O O O O O\n"
    //            + "        O O O O O\n"
    //            + "        O O O O O\n"
    //            + "        O O O O O"
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O _\n" +
            "    O O O\n" +
            "    O O O", viewC2V2.toString());
    // Constructor 3
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", viewC3.toString());
    assertEquals("_", viewC3V2.toString());
    assertEquals("        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O", viewC3V3.toString());
    // Constructor 4
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", viewC4.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O _\n" +
            "    O O O\n" +
            "    O O O", viewC4V2.toString());
    assertEquals("        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O _\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O", viewC4V3.toString());
  }

  @Test
  public void testConstructors() {

    // Testing IllegalArgument cases for each constructor
    try {
      new EnglishSolitaireModel(0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
    try {
      new EnglishSolitaireModel(0, 5);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
    try {
      new EnglishSolitaireModel(5, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
    try {
      new EnglishSolitaireModel(5, 5);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
    try {
      new EnglishSolitaireModel(10, 10);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
    // Constructor 3
    try {
      new EnglishSolitaireModel(2);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Arm thickness must be an odd number!", e.getMessage());
    }
    try {
      new EnglishSolitaireModel(10);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Arm thickness must be an odd number!", e.getMessage());
    }
    try {
      new EnglishSolitaireModel(0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness!", e.getMessage());
    }
    try {
      new EnglishSolitaireModel(-1);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness!", e.getMessage());
    }
    // Constructor 4
    try {
      new EnglishSolitaireModel(0, 0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness!", e.getMessage());
    }
    try {
      new EnglishSolitaireModel(-1, 0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness!", e.getMessage());
    }
    try {
      new EnglishSolitaireModel(2, 0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Arm thickness must be an odd number!", e.getMessage());
    }
    try {
      new EnglishSolitaireModel(3, 0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
    try {
      new EnglishSolitaireModel(3, 5, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
    try {
      new EnglishSolitaireModel(3, 0, 5);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
    try {
      new EnglishSolitaireModel(5, 12, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
    try {
      new EnglishSolitaireModel(5, 12, 12);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
  }


  /**
   * Testing move().
   */
  @Test
  public void testMove() {
    // from two rows above, same column
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, c1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, c1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, c1.getSlotAt(3, 3));
    c1.move(1, 3, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, c1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, c1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, c1.getSlotAt(3, 3));

    // from two rows below, same column
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, c1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, c1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, c1.getSlotAt(2, 3));
    c1.move(4, 3, 2, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, c1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, c1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, c1.getSlotAt(2, 3));

    // from two columns left, same row
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, c1.getSlotAt(4, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, c1.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, c1.getSlotAt(4, 3));
    c1.move(4, 1, 4, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, c1.getSlotAt(4, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, c1.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, c1.getSlotAt(4, 3));

    // from two columns right, same row
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, c1.getSlotAt(3, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, c1.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, c1.getSlotAt(3, 3));
    c1.move(3, 5, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, c1.getSlotAt(3, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, c1.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, c1.getSlotAt(3, 3));
  }

  /**
   * Testing invalid move().
   */
  @Test
  public void testMoveInvalid() {
    // Move more than two spaces
    try {
      c1.move(2, 3, 2, 6);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    try {
      c1.move(2, 3, 5, 3);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    // Move one space
    try {
      c1.move(3, 5, 3, 4);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    // Move into empty space
    try {
      c1.move(0, 3, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    // Move from out of bounds
    try {
      c1.move(-1, 0, 10, 10);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Row or column is beyond dimensions of the board.", e.getMessage());
    }
    // Move from empty space
    try {
      c1.move(3, 3, 5, 3);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    // Move into marble
    try {
      c1.move(6, 2, 6, 4);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    // Jumping over empty slot
    try {
      c1.move(2, 3, 4, 3);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    // Diagonal move two spaces
    try {
      c1.move(4, 2, 2, 4);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
  }

  /**
   * Testing a standard 3x3 game using move(). Tests the methods isGameOver() and getScore()
   * while playing.
   */
  @Test
  public void testGame() {
    assertFalse(c1.isGameOver());
    assertEquals(32, c1.getScore());
    c1.move(5, 3, 3, 3);
    assertEquals(31, c1.getScore());
    c1.move(4, 5, 4, 3);
    assertEquals(30, c1.getScore());
    c1.move(6, 4, 4, 4);
    assertEquals(29, c1.getScore());
    c1.move(6, 2, 6, 4);
    assertEquals(28, c1.getScore());
    c1.move(3, 4, 5, 4);
    assertEquals(27, c1.getScore());
    c1.move(6, 4, 4, 4);
    assertEquals(26, c1.getScore());
    c1.move(1, 4, 3, 4);
    assertEquals(25, c1.getScore());
    c1.move(2, 6, 2, 4);
    assertEquals(24, c1.getScore());
    c1.move(4, 6, 2, 6);
    assertEquals(23, c1.getScore());
    c1.move(2, 3, 2, 5);
    assertEquals(22, c1.getScore());
    c1.move(2, 6, 2, 4);
    assertEquals(21, c1.getScore());
    c1.move(2, 1, 2, 3);
    assertEquals(20, c1.getScore());
    c1.move(0, 2, 2, 2);
    assertEquals(19, c1.getScore());
    c1.move(0, 4, 0, 2);
    assertEquals(18, c1.getScore());
    c1.move(3, 2, 1, 2);
    assertEquals(17, c1.getScore());
    c1.move(0, 2, 2, 2);
    assertEquals(16, c1.getScore());
    assertFalse(c1.isGameOver());
    c1.move(5, 2, 3, 2);
    assertEquals(15, c1.getScore());
    c1.move(4, 0, 4, 2);
    assertEquals(14, c1.getScore());
    c1.move(2, 0, 4, 0);
    assertEquals(13, c1.getScore());
    c1.move(4, 3, 4, 1);
    assertEquals(12, c1.getScore());
    c1.move(4, 0, 4, 2);
    assertEquals(11, c1.getScore());
    c1.move(2, 3, 2, 1);
    assertEquals(10, c1.getScore());
    c1.move(2, 1, 4, 1);
    assertEquals(9, c1.getScore());
    c1.move(4, 1, 4, 3);
    assertEquals(8, c1.getScore());
    c1.move(4, 3, 4, 5);
    assertEquals(7, c1.getScore());
    c1.move(4, 5, 2, 5);
    assertEquals(6, c1.getScore());
    c1.move(2, 5, 2, 3);
    assertEquals(5, c1.getScore());
    c1.move(3, 3, 3, 1);
    assertEquals(4, c1.getScore());
    c1.move(1, 3, 3, 3);
    assertEquals(3, c1.getScore());
    c1.move(3, 4, 3, 2);
    assertEquals(2, c1.getScore());
    assertFalse(c1.isGameOver());
    c1.move(3, 1, 3, 3);
    assertEquals(1, c1.getScore());
    assertTrue(c1.isGameOver());

  }

  /**
   * Testing getBoardSize().
   */
  @Test
  public void testGetBoardSize() {
    assertEquals(7, c1.getBoardSize());
    assertEquals(7, c2.getBoardSize());
    assertEquals(7, c3.getBoardSize());
    assertEquals(1, c3v2.getBoardSize());
    assertEquals(13, c3v3.getBoardSize());
    assertEquals(7, c4.getBoardSize());
    assertEquals(7, c4v2.getBoardSize());
    assertEquals(13, c4v3.getBoardSize());
    MarbleSolitaireModel ex1 = new EnglishSolitaireModel(111);
    assertEquals(331, ex1.getBoardSize());
  }

  /**
   * Testing getSlotAt().
   */
  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, c1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, c1.getSlotAt(0, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, c1.getSlotAt(5, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, c1.getSlotAt(5, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, c1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, c1.getSlotAt(0, 3));

    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, c2.getSlotAt(5, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, c2.getSlotAt(2, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, c2.getSlotAt(0, 3));

    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, c3v3.getSlotAt(12, 12));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, c3v3.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, c3v3.getSlotAt(0, 5));

    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, c4v2.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, c4v2.getSlotAt(4, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, c4v2.getSlotAt(0, 3));

    try {
      c1.getSlotAt(0, 7);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Row or column is beyond dimensions of the board.", e.getMessage());
    }
    try {
      c1.getSlotAt(7, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Row or column is beyond dimensions of the board.", e.getMessage());
    }
    try {
      c1.getSlotAt(7, 7);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Row or column is beyond dimensions of the board.", e.getMessage());
    }
    try {
      c3v3.getSlotAt(13, 13);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Row or column is beyond dimensions of the board.", e.getMessage());
    }
  }
}
