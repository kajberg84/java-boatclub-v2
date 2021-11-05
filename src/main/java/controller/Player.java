package controller;

import model.Game;
import model.NewCardObserver;
import model.RulesVisitor;
import view.RulesPrinterVisitor;
import view.View;
import view.View.Action;


/**
 * Scenario controller for playing the game.
 */
public class Player implements NewCardObserver {
  View view;
  Game game;
  RulesVisitor visitor = new RulesPrinterVisitor();

  /**
   * Constructor that creates a player controller instance with a view and game facade.

   * @param ui The view.
   * @param g The game facade.
   */
  public Player(View ui, Game g) {
    view = ui;
    game = g;
    game.addSubscriber(this);
  }

  /**
   * Runs the play use case.

   * @return True as long as the game should continue.
   */
  public boolean play() {
    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    return userAction(game, view);
  }

  private boolean userAction(Game game, View view) {
    Action action = view.promptForAction();

    if (action == Action.PLAY) {
      game.newGame(visitor);
    } else if (action == Action.HIT) {
      game.hit();
    } else if (action == Action.STAND) {
      game.stand();
    }

    return action != Action.QUIT;
  }

  @Override
  public void newCard() {
    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    view.displayWelcomeMessage();
    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore()); 
  }
}