package controller;

import model.Game;
import model.NewCardObserver;
import view.View;
import view.View.Action;


/**
 * Scenario controller for playing the game.
 */
public class Player implements NewCardObserver {
  View view;
  Game game;

  public Player(View ui, Game g) {
    view = ui;
    game = g;
    game.addSubscriber(this);
  }

  /**
   * Runs the play use case.

   * @param game The game state.
   * @param view The view to use.
   * @return True as long as the game should continue.
   */
  public boolean play() {
    view.displayWelcomeMessage();

    // view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    // view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    return userAction(game, view);
  }

  private boolean userAction(Game game, View view) {
    Action action = view.promptForAction();

    if (action == Action.PLAY) {
      game.newGame();
    } else if (action == Action.HIT) {
      game.hit();
    } else if (action == Action.STAND) {
      game.stand();
    }

    return action != Action.QUIT;
  }

  @Override
  public void newCard() {
    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore()); 
  }
}