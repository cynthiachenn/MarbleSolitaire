import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * For testing the triangle solitaire model game.
 */
public class TriangleSolitaireTests {
  MarbleSolitaireModel t1 = new TriangleSolitaireModel();
  MarbleSolitaireView v1 = new TriangleSolitaireTextView(t1);
  MarbleSolitaireModel t2 = new TriangleSolitaireModel(8, 1, 1);
  MarbleSolitaireView v2 = new TriangleSolitaireTextView(t2);
  MarbleSolitaireModel t3 = new TriangleSolitaireModel(3);
  MarbleSolitaireView v3 = new TriangleSolitaireTextView(t3);
  MarbleSolitaireModel t4 = new TriangleSolitaireModel(4, 3);
  MarbleSolitaireView v4 = new TriangleSolitaireTextView(t4);


  @Test
  public void testToString() {
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", v1.toString());
    assertEquals("       O\n" +
            "      O _\n" +
            "     O O O\n" +
            "    O O O O\n" +
            "   O O O O O\n" +
            "  O O O O O O\n" +
            " O O O O O O O\n" +
            "O O O O O O O O", v2.toString());
    assertEquals("  _\n" +
            " O O\n" +
            "O O O", v3.toString());
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O _ O", v4.toString());
  }

  @Test
  public void testConstructor() {
    try {
      new TriangleSolitaireModel(-1, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
    try {
      new TriangleSolitaireModel(0, 1);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
    try {
      new TriangleSolitaireModel(-1);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness!", e.getMessage());
    }
    try {
      new TriangleSolitaireModel(0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid arm thickness!", e.getMessage());
    }
    try {
      new TriangleSolitaireModel(3, 0, 3);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Enter a valid coordinate on the board", e.getMessage());
    }
  }

  @Test
  public void testMove() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t2.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t2.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t2.getSlotAt(1, 1));
    t2.move(3, 3, 1, 1);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t2.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t2.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t2.getSlotAt(1, 1));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t2.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t2.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t2.getSlotAt(2, 2));
    t2.move(0, 0, 2, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t2.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t2.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t2.getSlotAt(2, 2));
  }

  @Test
  public void testInvalidMove() {
    // Move more than two spaces
    try {
      t1.move(3, 3, 0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    try {
      t1.move(3, 3, 0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    // Move one space
    try {
      t1.move(0, 1, 0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    // Move into marble
    try {
      t1.move(3, 0, 0, 1);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
    // Move from out of bounds
    try {
      t1.move(-1, 0, 10, 10);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Row or column is beyond dimensions of the board.", e.getMessage());
    }
    // Move from empty space
    try {
      t1.move(0, 0, 2, 0);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid move.", e.getMessage());
    }
  }

  @Test
  public void testBoardSize() {
    assertEquals(5, t1.getBoardSize());
    assertEquals(8, t2.getBoardSize());
    assertEquals(3, t3.getBoardSize());
    assertEquals(5, t4.getBoardSize());
    MarbleSolitaireModel ex = new TriangleSolitaireModel(15);
    assertEquals(15, ex.getBoardSize());
  }

  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(0, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(1, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, t1.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, t1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(4, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, t1.getSlotAt(4, 4));
  }

  @Test
  public void testGetScoreGameOver() {
    assertEquals(14, t1.getScore());
    assertFalse(t1.isGameOver());
  }
}
