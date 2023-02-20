package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Implementation of the Controller interface. Built to take in user inputs and translate them
 * into functionality of the game.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Readable readable;

  /**
   * Default constructor for a controller.
   *
   * @param model    some MarbleSolitaire type
   * @param view     way to view game
   * @param readable inputs being read
   * @throws IllegalArgumentException if any parameters are null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable readable) throws IllegalArgumentException {
    if (model == null || view == null || readable == null) {
      throw new IllegalArgumentException("At least one parameter is null.");
    }
    this.model = model;
    this.view = view;
    this.readable = readable;
  }

  /**
   * Plays a new game of Marble Solitaire.
   *
   * @throws IllegalStateException if the controller is unable to read input or transmit output
   */
  @Override
  public void playGame() throws IllegalStateException {
    Scanner scanner = new Scanner(readable);
    try {
      view.renderBoard();
      view.renderMessage("Score: " + this.model.getScore() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Unable to read input or transmit output.");
    }
    ArrayList<Integer> inputList = new ArrayList<>();
    while (!model.isGameOver()) {
      String s = scanner.next();
      // if user quits
      if (s.equals("Q") || s.equals("q")) {
        try {
          view.renderMessage("Game quit!\nState of game when quit:\n");
          view.renderBoard();
          view.renderMessage("Score: " + model.getScore() + "\n");
          break;
        } catch (IOException e) {
          throw new IllegalStateException();
        }
        // handling valid input
      } else {
        try {
          if (Integer.parseInt(s) > 0) {
            int input = Integer.parseInt(s);
            inputList.add(input);
          }
          // Input is not positive
          else {
            try {
              view.renderMessage("Please re enter a valid input. Press Q to quit or enter a " +
                      "positive integer.\n");
            } catch (IOException e) {
              throw new IllegalStateException();
            }
          }
          // Input is not a number
        } catch (NumberFormatException e) {
          try {
            view.renderMessage("Please re enter a valid input. Press Q to quit or enter a " +
                    "positive integer.\n");
          } catch (IOException exception) {
            throw new IllegalStateException();
          }
        }
      }
      // 4 valid inputs, try move
      if (inputList.size() == 4) {
        try {
          model.move(inputList.get(0) - 1, inputList.get(1) - 1,
                  inputList.get(2) - 1, inputList.get(3) - 1);
          inputList.remove(0);
          inputList.remove(0);
          inputList.remove(0);
          inputList.remove(0);
          try {
            view.renderBoard();
            view.renderMessage("Score: " + model.getScore() + "\n");
          } catch (IOException e) {
            throw new IllegalStateException();
          }
        } catch (IllegalArgumentException e) {
          try {
            view.renderMessage("Invalid move. Play again.\n");
            inputList.remove(0);
            inputList.remove(0);
            inputList.remove(0);
            inputList.remove(0);
          } catch (IOException exception) {
            throw new IllegalStateException();
          }
        }
      }
    }
    if (model.isGameOver()) {
      try {
        view.renderMessage("Game over!\n");
        view.renderBoard();
        view.renderMessage("Score: " + model.getScore());
      } catch (IOException e) {
        throw new IllegalStateException();
      }
    }
  }
}
