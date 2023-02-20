package cs3500.marblesolitaire.model.hw04;

/**
 * Representing a European Marble Solitaire board, this model is similar to English solitaire
 * except has 8 sides instead of 4 and is in the shape of an octagon.
 */
public class EuropeanSolitaireModel extends AMarbleSolitaireModel {

  /**
   * Default constructor for a European Marble Solitaire model.
   */
  public EuropeanSolitaireModel() {
    super(3, 3, 3);
  }

  /**
   * Constructor for a European Marble Solitaire model when given a side length and empty space
   * in the middle.
   *
   * @param sideLength length of each side
   */
  public EuropeanSolitaireModel(int sideLength) throws IllegalArgumentException {
    super(sideLength, sideLength + ((sideLength - 3) / 2),
            sideLength + ((sideLength - 3) / 2));
    if (sideLength % 2 == 0 || sideLength < 1) {
      throw new IllegalArgumentException("Arm thickness must be an odd number!");
    }
  }

  /**
   * Constructor for a European Marble Solitaire model when given the empty space coordinate and
   * sets the side length to 3.
   *
   * @param sRow    row of empty space
   * @param sColumn column of empty space
   */
  public EuropeanSolitaireModel(int sRow, int sColumn) throws IllegalArgumentException {
    super(3, sRow, sColumn);
    if (!validPosn(sRow, sColumn)) {
      throw new IllegalArgumentException("Enter a valid coordinate on the board");
    }
  }

  /**
   * Constructor for a European Marble Solitaire model when given a side length and coordinate
   * for the empty space.
   *
   * @param sideLength length of each side
   * @param sRow       row of empty space
   * @param sColumn    column of empty space
   */
  public EuropeanSolitaireModel(int sideLength, int sRow, int sColumn)
          throws IllegalArgumentException {
    super(sideLength, sRow, sColumn);
    if (sideLength % 2 == 0 || sideLength < 1) {
      throw new IllegalArgumentException("Arm thickness must be an odd number!");
    }
    if (!validPosn(sRow, sColumn) || outOfBounds(sRow, sColumn)) {
      throw new IllegalArgumentException("Enter a valid coordinate on the board");
    }
  }

  @Override
  protected boolean validPosn(int r, int c) {
    int lower = ((getBoardSize() - armThickness) / 2) - 1;
    int upper = getBoardSize() - lower - 1;
    if ((r <= lower && c <= lower)
            || (r >= upper && c >= upper)
            || (r <= lower && c >= lower)
            || (r >= upper && c <= lower)) {
      if ((Math.abs(c - r) >= upper)
              || ((r + c <= lower)
              || (r + c >= this.getBoardSize() + upper - 1))) {
        return false;
      }
    }
    return true;
  }
}
