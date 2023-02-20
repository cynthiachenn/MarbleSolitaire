package cs3500.marblesolitaire.model.hw04;

/**
 * A class representing the model board for a Triangle Marble Solitaire game. The board is shaped
 * like a triangle with increasing number of marble slots per row.
 */
public class TriangleSolitaireModel extends AMarbleSolitaireModel {

  /**
   * Default constructor for a triangle marble solitaire game. Sets the dimensions to 5 and
   * places the empty space at (0,0).
   */
  public TriangleSolitaireModel() {
    super(5, 0, 0);
  }

  /**
   * Constructor for a triangle marble solitaire game that takes in an integer for the dimensions
   * of the board, aka the number of rows and the number of slots in the bottom most row.
   *
   * @param dimensions number of rows/number of spaces in bottom most row
   */
  public TriangleSolitaireModel(int dimensions) throws IllegalArgumentException {
    super(dimensions, 0, 0);
    if (dimensions < 1) {
      throw new IllegalArgumentException("Dimensions must be positive.");
    }
  }

  /**
   * Constructor for a triangle marble solitaire game given a coordinate for the empty space on
   * the board. The dimensions are automatically set to 5.
   *
   * @param row row of empty space
   * @param col column of empty space
   */
  public TriangleSolitaireModel(int row, int col) throws IllegalArgumentException {
    super(5, row, col);
    if (!validPosn(row, col)) {
      throw new IllegalArgumentException("Enter a valid coordinate on the board");
    }
  }

  /**
   * Constructor for a triangle marble solitaire game given both the dimensions and the
   * coordinate for the empty space.
   *
   * @param dimensions number of rows/number of spaces in bottom most row
   * @param row        row of empty space
   * @param col        column of empty space
   */
  public TriangleSolitaireModel(int dimensions, int row, int col) throws IllegalArgumentException {
    super(dimensions, row, col);
    if (dimensions < 1) {
      throw new IllegalArgumentException("Dimensions must be positive.");
    }
    if (!validPosn(row, col)) {
      throw new IllegalArgumentException("Enter a valid coordinate on the board");
    }
  }

  @Override
  protected boolean validPosn(int r, int c) {
    return r >= c;
  }

  @Override
  protected boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
    int midRow = (fromRow + toRow) / 2;
    int midCol = (fromCol + toCol) / 2;
    if (this.board[fromRow][fromCol] == SlotState.Marble &&
            this.board[toRow][toCol] == SlotState.Empty &&
            this.board[midRow][midCol] == SlotState.Marble) {
      return ((Math.abs(fromRow - toRow) == 2 && (Math.abs(fromCol - toCol) == 0))
              || (Math.abs(fromRow - toRow)) == 0 && (Math.abs(fromCol - toCol)) == 2
              || (Math.abs(fromRow - toRow)) == 2 && (Math.abs(fromCol - toCol)) == 2);
    }
    return false;
  }

  @Override
  protected boolean checkMovesLeft() {
    for (int r = 0; r < this.getBoardSize(); r++) {
      for (int c = 0; c < this.getBoardSize(); c++) {
        if (((!outOfBounds(r, c) && !outOfBounds(r + 2, c) && validMove(r, c, r + 2, c)) ||
                (!outOfBounds(r, c) && !outOfBounds(r, c + 2) && validMove(r, c, r, c + 2)) ||
                (!outOfBounds(r, c) && !outOfBounds(r - 2, c) && validMove(r, c, r - 2, c)) ||
                (!outOfBounds(r, c) && !outOfBounds(r, c - 2) && validMove(r, c, r, c - 2))
                ||
                (!outOfBounds(r, c) && !outOfBounds(r + 2, c + 2) && validMove(r, c, r + 2, c + 2))
                ||
                (!outOfBounds(r, c) && !outOfBounds(r - 2, c - 2) && validMove(r, c, r - 2, c - 2))
                ||
                (!outOfBounds(r, c) && !outOfBounds(r + 2, c - 2) && validMove(r, c, r + 2, c - 2))
                ||
                (!outOfBounds(r, c) && !outOfBounds(r - 2, c + 2) && validMove(r, c, r - 2,
                        c + 2)))) {
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
    return this.armThickness;
  }
}
