package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * A class that correctly implements and shows the text view of a Triangle solitaire model game.
 */
public class TriangleSolitaireTextView implements MarbleSolitaireView {
  private MarbleSolitaireModelState m;
  private Appendable appendable;

  /**
   * Default constructor initializing the model state given and the appendable to System.out.
   *
   * @param m model state
   * @throws IllegalArgumentException if given model is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState m) throws IllegalArgumentException {
    if (m == null) {
      throw new IllegalArgumentException("Model is null.");
    }
    this.m = m;
    this.appendable = System.out;
  }

  /**
   * Default constructor given the model and appendable.
   *
   * @param m model state
   * @param a appendable
   * @throws IllegalArgumentException if given model is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState m, Appendable a)
          throws IllegalArgumentException {
    if (m == null || a == null) {
      throw new IllegalArgumentException("Model or appendable is null.");
    }
    this.m = m;
    this.appendable = a;
  }

  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderBoard() throws IOException {
    this.appendable.append(this.toString()).append("\n");
  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    this.appendable.append(message);
  }

  /**
   * Return a string that represents the current state of the board. The
   * string should have one line per row of the game board. Each slot on the
   * game board is a single character (O, _ or space for a marble, empty and
   * invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */
  @Override
  public String toString() {
    String board = "";
    int spaces = m.getBoardSize() - 1;
    for (int r = 0; r < m.getBoardSize(); r++) {
      for (int s = 0; s < spaces; s++) {
        board += " ";
      }
      for (int c = 0; c < m.getBoardSize(); c++) {
        if (m.getSlotAt(r, c).equals(MarbleSolitaireModelState.SlotState.Empty)) {
          board += "_";
          if (c != this.m.getBoardSize() - 1 && this.m.getSlotAt(r, c + 1)
                  != MarbleSolitaireModelState.SlotState.Invalid) {
            board += " ";
          }
        } else if (m.getSlotAt(r, c).equals(MarbleSolitaireModelState.SlotState.Marble)) {
          board += "O";
          // if marble is followed by another marble or empty slot
          if (c != this.m.getBoardSize() - 1 && this.m.getSlotAt(r, c + 1)
                  != MarbleSolitaireModelState.SlotState.Invalid) {
            board += " ";
          }
        }
      }
      spaces--;
      if (r < this.m.getBoardSize() - 1) {
        board += "\n";
      }
    }
    return board;
  }
}
