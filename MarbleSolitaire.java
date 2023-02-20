package cs3500.marblesolitaire.model.hw04;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * Class to run the Marble Solitaire game.
 */
public final class MarbleSolitaire {

  /**
   * Main method to run the marble solitaire game.
   *
   * @param args command-line arguments input by user
   */
  public static void main(String[] args) {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model);
    Readable r = new InputStreamReader(System.in);
    int size = 0;
    int row = 0;
    int col = 0;
    switch (args[0]) {
      case "english":
        if (args.length >= 2) {
          if (args[1].equals("-size")) {
            size = Integer.parseInt(args[2]);
          } else if (args[1].equals("-hole")) {
            row = Integer.parseInt(args[2]);
            col = Integer.parseInt(args[3]);
          }

        } else {
          size = 3;
          row = 3;
          col = 3;
        }
        model = new EnglishSolitaireModel(size, row, col);
        view = new MarbleSolitaireTextView(model);

        break;
      case "european":
        if (args.length >= 2) {
          if (args[1].equals("-size")) {
            size = Integer.parseInt(args[2]);
          } else if (args[1].equals("-hole")) {
            row = Integer.parseInt(args[2]);
            col = Integer.parseInt(args[3]);
          }
        } else {
          size = 3;
          row = 3;
          col = 3;
        }
        model = new EuropeanSolitaireModel(size, row, col);
        view = new MarbleSolitaireTextView(model);
        break;
      case "triangular":
        if (args.length >= 2) {
          if (args[1].equals("-size")) {
            size = Integer.parseInt(args[2]);
          } else if (args[1].equals("-hole")) {
            row = Integer.parseInt(args[2]);
            col = Integer.parseInt(args[3]);
          }
        } else {
          size = 5;
          row = 0;
          col = 0;
        }
        model = new TriangleSolitaireModel(size, row, col);
        view = new TriangleSolitaireTextView(model);
        break;
      default:
        break;
    }
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, r);
    controller.playGame();
  }
}
