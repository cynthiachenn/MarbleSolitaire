import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * For testing the European solitaire game model.
 */
public class EuropeanSolitaireTests {
  MarbleSolitaireModel m1 = new EuropeanSolitaireModel();
  MarbleSolitaireView v1 = new MarbleSolitaireTextView(m1);
  MarbleSolitaireModel m2 = new EuropeanSolitaireModel(5, 3, 10);
  MarbleSolitaireView v2 = new MarbleSolitaireTextView(m2);
  MarbleSolitaireModel m3 = new EuropeanSolitaireModel(5);
  MarbleSolitaireView v3 = new MarbleSolitaireTextView(m3);
  MarbleSolitaireModel m4 = new EuropeanSolitaireModel(1,5);
  MarbleSolitaireView v4 = new MarbleSolitaireTextView(m4);

  @Test
  public void testView() {
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", v1.toString());
    assertEquals("        O O O O O\n"
            + "      O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "  O O O O O O O O O _ O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "      O O O O O O O\n"
            + "        O O O O O", v2.toString());
    assertEquals("        O O O O O\n"
            + "      O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "      O O O O O O O\n"
            + "        O O O O O", v3.toString());
    assertEquals("    O O O" + "\n"
            + "  O O O O _" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", v4.toString());
  }

  @Test
  public void testConstructor() {
    try {
      new EuropeanSolitaireModel(0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
    try {
      new EuropeanSolitaireModel(6, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
    try {
      new EuropeanSolitaireModel(0, 6);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
    try {
      new EuropeanSolitaireModel(6, 5);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
    try {
      new EuropeanSolitaireModel(-1);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness!", e.getMessage());
    }
    try {
      new EuropeanSolitaireModel(0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness!", e.getMessage());
    }
    try {
      new EuropeanSolitaireModel(2);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Arm thickness must be an odd number!", e.getMessage());
    }
    try {
      new EuropeanSolitaireModel(3,0,0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
    try {
      new EuropeanSolitaireModel(0,0,0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness!", e.getMessage());
    }
    try {
      new EuropeanSolitaireModel(-1,0,0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness!", e.getMessage());
    }
    try {
      new EuropeanSolitaireModel(2,0,0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Arm thickness must be an odd number!", e.getMessage());
    }
  }

  /**
   * Testing move().
   */
  @Test
  public void testMove() {
    // from two rows above, same column
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(3, 3));
    m1.move(1, 3, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(3, 3));

    // from two rows below, same column
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(2, 3));
    m1.move(4, 3, 2, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(2, 3));

    // from two columns left, same row
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(4, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(4, 3));
    m1.move(4, 1, 4, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(4, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(4, 3));

    // from two columns right, same row
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(3, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(3, 3));
    m1.move(3, 5, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(3, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(3, 3));
  }

  /**
   * Testing invalid move().
   */
  @Test
  public void testMoveInvalid() {
    // Move more than two spaces
    try {
      m1.move(2, 3, 2, 6);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    try {
      m1.move(2, 3, 5, 3);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    // Move one space
    try {
      m1.move(3, 5, 3, 4);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    // Move into empty space
    try {
      m1.move(0, 3, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    // Move from out of bounds
    try {
      m1.move(-1, 0, 10, 10);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Row or column is beyond dimensions of the board.", e.getMessage());
    }
    // Move from empty space
    try {
      m1.move(3, 3, 5, 3);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    // Move into marble
    try {
      m1.move(6, 2, 6, 4);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    // Jumping over empty slot
    try {
      m1.move(2, 3, 4, 3);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    // Diagonal move two spaces
    try {
      m1.move(4, 2, 2, 4);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
  }

  @Test
  public void testGetBoardSize() {
    assertEquals(7, m1.getBoardSize());
    assertEquals(13, m2.getBoardSize());
    assertEquals(13, m3.getBoardSize());
    assertEquals(7, m4.getBoardSize());
    MarbleSolitaireModel ex1 = new EuropeanSolitaireModel(11);
    assertEquals(31, ex1.getBoardSize());
  }

  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(6,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(0,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(6,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(1,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(1,5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(5,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(5,5));
  }

  @Test
  public void testGetScoreGameOver() {
    assertEquals(36, m1.getScore());
    assertFalse(m1.isGameOver());
  }
}
