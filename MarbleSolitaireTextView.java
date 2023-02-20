package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Representing a class to view the Marble Solitaire game in text.
 */

public class MarbleSolitaireTextView implements MarbleSolitaireView {
  private MarbleSolitaireModelState m;
  private Appendable ap;

  /**
   * Default constructor that takes a model m for the game.
   *
   * @param m the model of the solitaire game
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState m) {
    if (m == null) {
      throw new IllegalArgumentException("Model is null.");
    }
    this.m = m;
    this.ap = System.out;
  }

  /**
   * New constructor which takes in an appendable.
   *
   * @param m  model of solitaire game
   * @param ap appendable
   * @throws IllegalArgumentException if either parameters are null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState m, Appendable ap)
          throws IllegalArgumentException {
    if (m == null || ap == null) {
      throw new IllegalArgumentException("Model or appendable cannot be null.");
    }
    this.m = m;
    this.ap = ap;
  }

  /**
   * Retrieves the armThickness of the model.
   *
   * @return int
   */
  private int getArmThickness() {
    return (m.getBoardSize() + 2) / 3;
  }

  /**
   * Checks if the given coordinate of the board is at the edge (for printing a character with a
   * space or without).
   *
   * @param r row
   * @param c column
   * @return boolean
   */
  private boolean atEdge(int r, int c) {
    return ((c == this.m.getBoardSize() - 1) ||
            ((c == this.getArmThickness() * 2 - 2) && (r < this.getArmThickness() - 1)) ||
            ((c == this.getArmThickness() * 2 - 2) && (r > this.getArmThickness() * 2 - 2)));
  }

  /**
   * Checks if the given coordinate is an invalid space on the left side of the board (for
   * printing a space only on the left side, no spaces on right side invalid slots).
   *
   * @param r row
   * @param c column
   * @return boolean
   */
  private boolean invalidSpace(int r, int c) {
    return ((r < this.getArmThickness() - 1) && (c < this.getArmThickness() - 1)) ||
            ((r > this.getArmThickness() * 2 - 2) && (c < this.getArmThickness() - 1));
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
    for (int i = 0; i < this.m.getBoardSize(); i++) {
      for (int j = 0; j < this.m.getBoardSize(); j++) {
        // printing invalid spaces
        if (m.getSlotAt(i, j).equals(MarbleSolitaireModelState.SlotState.Invalid)) {
          if (invalidSpace(i, j)) {
            board += "  ";
          }
          // printing empty slots
        }
        if (m.getSlotAt(i, j).equals(MarbleSolitaireModelState.SlotState.Empty)) {
          board += "_";
          // if empty slot is followed by a marble
          if (j != this.m.getBoardSize() - 1 && this.m.getSlotAt(i, j + 1)
                  != MarbleSolitaireModelState.SlotState.Invalid) {
            board += " ";
          }
          // printing marble slots
        } else if (m.getSlotAt(i, j).equals(MarbleSolitaireModelState.SlotState.Marble)) {
          board += "O";
          // if marble is followed by another marble or empty slot
          if (j != this.m.getBoardSize() - 1 && this.m.getSlotAt(i, j + 1)
                  != MarbleSolitaireModelState.SlotState.Invalid) {
            board += " ";
          }
        }
      }
      // print new line at the end of row
      if (i < this.m.getBoardSize() - 1) {
        board += "\n";
      }
    }
    return board;
  }

  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderBoard() throws IOException {
    this.ap.append(this.toString()).append("\n");
  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    this.ap.append(message);
  }
}
