package controller;

import model.Game;
import model.NewCardObserver;
import model.RulesVisitor;
import view.BaseView;
import view.EnglishRulesPrinterVisitor;


/**
 * Scenario controller for playing the game.
 */
public class Player implements NewCardObserver {
  BaseView view;
  Game game;
  RulesVisitor visitor;

  /**
   * Constructor that creates a player controller instance with a view and game facade.

   * @param ui The view.
   * @param g The game facade.
   */
  public Player(BaseView view, Game game, RulesVisitor visitor) {
    this.view = view;
    this.game = game;
    this.visitor = visitor;
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

  private boolean userAction(Game game, BaseView view) {
    view.promptForAction();

    if (view.isPlay()) {
      game.newGame(visitor);
    } else if (view.isHit()) {
      game.hit();
    } else if (view.isStand()) {
      game.stand();
    }

    return !view.isQuit();
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