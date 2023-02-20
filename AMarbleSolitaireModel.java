package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Abstract class to represent different types of marble solitaire models.
 */
public abstract class AMarbleSolitaireModel implements MarbleSolitaireModel {
  protected int armThickness;
  protected SlotState[][] board;

  protected AMarbleSolitaireModel(int armThickness, int sRow, int sColumn) throws
          IllegalArgumentException {
    if (armThickness < 1) {
      throw new IllegalArgumentException("Invalid arm thickness!");
    }
    this.armThickness = armThickness;
    setUpBoard(sRow, sColumn);
  }

  /**
   * Sets up and initializes the board of the marble solitaire game.
   *
   * @param sRow    the row
   * @param sColumn the column
   */
  protected void setUpBoard(int sRow, int sColumn) {
    board = new MarbleSolitaireModelState.SlotState[this.getBoardSize()][this.getBoardSize()];
    for (int r = 0; r < this.getBoardSize(); r++) {
      for (int c = 0; c < this.getBoardSize(); c++) {
        if (!validPosn(r, c)) {
          board[r][c] = MarbleSolitaireModelState.SlotState.Invalid;
        } else if (r == sRow && c == sColumn) {
          board[r][c] = MarbleSolitaireModelState.SlotState.Empty;
        } else {
          board[r][c] = MarbleSolitaireModelState.SlotState.Marble;
        }
      }
    }
  }

  /**
   * ((Math.abs(fromRow - toRow) == 2 && (Math.abs(fromCol - toCol) == 0))
   * || (Math.abs(fromRow - toRow)) == 0 && (Math.abs(fromCol - toCol)) == 2)
   * Checks if the move is valid. The from position must have a marble,the to position must be
   * empty, and the slot between the from and to position must also have a marble.
   *
   * @param fromRow the row being moved from
   * @param fromCol the column being moved from
   * @param toRow   the row being moved to
   * @param toCol   the column being moved to
   * @return boolean
   */
  protected boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
    int midRow = (fromRow + toRow) / 2;
    int midCol = (fromCol + toCol) / 2;
    if (this.board[fromRow][fromCol] == SlotState.Marble &&
            this.board[toRow][toCol] == SlotState.Empty &&
            this.board[midRow][midCol] == SlotState.Marble) {
      return ((Math.abs(fromRow - toRow) == 2 && (Math.abs(fromCol - toCol) == 0))
              || (Math.abs(fromRow - toRow)) == 0 && (Math.abs(fromCol - toCol)) == 2);
    }
    return false;
  }

  /**
   * Checks if the given position is a valid space on the board.
   *
   * @param r row
   * @param c column
   * @return boolean
   */
  abstract protected boolean validPosn(int r, int c);

  /**
   * Checks if the given coordinate is out of bounds of the board size.
   *
   * @param r row
   * @param c column
   * @return boolean
   */
  protected boolean outOfBounds(int r, int c) {
    return (r < 0 || c < 0 || r >= this.getBoardSize() || c >= this.getBoardSize());
  }

  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is not possible or out of bounds
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (outOfBounds(fromRow, fromCol) || (outOfBounds(toRow, toCol))) {
      throw new IllegalArgumentException("Row or column is beyond dimensions of the board.");
    }
    if (!validMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("Invalid move.");
    }
    this.board[fromRow][fromCol] = SlotState.Empty;
    int midRow = (fromRow + toRow) / 2;
    int midCol = (fromCol + toCol) / 2;
    this.board[midRow][midCol] = SlotState.Empty;
    this.board[toRow][toCol] = SlotState.Marble;
  }

  /**
   * Determine and return if the game is over or not. A game is over if no
   * more moves can be made.
   *
   * @return false if valid moves can be made, true otherwise
   */
  @Override
  public boolean isGameOver() {
    return !this.checkMovesLeft();
  }

  /**
   * Check if there are any possible moves left.
   *
   * @return boolean
   */
  protected boolean checkMovesLeft() {
    for (int r = 0; r < this.getBoardSize(); r++) {
      for (int c = 0; c < this.getBoardSize(); c++) {
        if (((!outOfBounds(r, c) && !outOfBounds(r + 2, c) && validMove(r, c, r + 2, c)) ||
                (!outOfBounds(r, c) && !outOfBounds(r, c + 2) && validMove(r, c, r, c + 2)) ||
                (!outOfBounds(r, c) && !outOfBounds(r - 2, c) && validMove(r, c, r - 2, c)) ||
                (!outOfBounds(r, c) && !outOfBounds(r, c - 2) && validMove(r, c, r, c - 2)))) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Return the size of this board. The size is roughly the longest dimension of a board
   *
   * @return the size as an integer
   */
  @Override
  public int getBoardSize() {
    return this.armThickness * 3 - 2;
  }

  /**
   * Get the state of the slot at a given position on the board.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the slot at the given row and column
   * @throws IllegalArgumentException if the row or the column are beyond
   *                                  the dimensions of the board
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (outOfBounds(row, col)) {
      throw new IllegalArgumentException("Row or column is beyond dimensions of the board.");
    }
    return this.board[row][col];
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  @Override
  public int getScore() {
    int score = 0;
    for (int r = 0; r < this.getBoardSize(); r++) {
      for (int c = 0; c < this.getBoardSize(); c++) {
        if (this.getSlotAt(r, c).equals(SlotState.Marble)) {
          score++;
        }
      }
    }
    return score;
  }

}
