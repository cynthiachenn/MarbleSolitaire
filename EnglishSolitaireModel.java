package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AMarbleSolitaireModel;

/**
 * Representing a model for the English Solitaire game which includes all the relevant methods to
 * run the game.
 */
public class EnglishSolitaireModel extends AMarbleSolitaireModel {

  /**
   * Empty constructor for the game. Assigns a starting armThickness and empty space at (3,3).
   */
  public EnglishSolitaireModel() {
    super(3, 3, 3);
  }

  /**
   * Constructor to initialize the empty space at coordinate pair (sRow, sColumn).
   * Empty space must be on a valid space on the board.
   *
   * @param sRow    Representing the row number of the empty space.
   * @param sColumn Representing the column number of the empty space.
   */
  public EnglishSolitaireModel(int sRow, int sColumn) throws IllegalArgumentException {
    super(3, sRow, sColumn);
    if (!validPosn(sRow, sColumn)) {
      throw new IllegalArgumentException("Enter a valid coordinate on the board");
    }
  }

  /**
   * Constructor to initialize the arm thickness and set the empty space in the middle.
   *
   * @param armThickness Representing the thickness of each "arm" of the board.
   *                     Arm thickness must be an odd number.
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    super(armThickness, armThickness + ((armThickness - 3) / 2),
            armThickness + ((armThickness - 3) / 2));
    if (armThickness % 2 == 0 || armThickness < 1) {
      throw new IllegalArgumentException("Arm thickness must be an odd number!");
    }
  }

  /**
   * Constructor to initialize both the arm thickness and coordinate of empty space when given.
   *
   * @param armThickness Representing the thickness of each arm.
   *                     Must be an odd number.
   * @param sRow         Representing the row number of the empty space.
   *                     Must be a valid space on the board.
   * @param sColumn      Representing the column number of the empty space.
   *                     Must be a valid space on the board.
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sColumn) {
    super(armThickness, sRow, sColumn);
    if (armThickness % 2 == 0 || armThickness < 1) {
      throw new IllegalArgumentException("Arm thickness must be an odd number!");
    }
    if (!validPosn(sRow, sColumn) || outOfBounds(sRow, sColumn)) {
      throw new IllegalArgumentException("Enter a valid coordinate on the board");
    }
  }

  @Override
  protected boolean validPosn(int r, int c) {
    return !(r < armThickness - 1 && c < armThickness - 1) &&
            !(r < armThickness - 1 && c > armThickness * 2 - 2) &&
            !(r > armThickness * 2 - 2 && c < armThickness - 1) &&
            !(r > armThickness * 2 - 2 && c > armThickness * 2 - 2);
  }
}
