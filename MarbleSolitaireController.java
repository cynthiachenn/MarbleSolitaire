package cs3500.marblesolitaire.controller;

/**
 * Interface for the controller of marble solitaire containing one method to play the game.
 */
public interface MarbleSolitaireController {
  /**
   * Plays a new game of Marble Solitaire.
   *
   * @throws IllegalStateException if the controller is unable to read input or transmit output
   */
  void playGame() throws IllegalStateException;
}
