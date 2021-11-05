package model.rules;

import model.Dealer;
import model.Player;
import model.RulesVisitor;

/**
 * Represents international rule for dealing cards in a new game.
 */
public class InternationalNewGameStrategy implements NewGameStrategy {

  /**
   * Deal cards when a new game is initiated.
   */
  public boolean newGame(Dealer dealer, Player player) {
    dealer.dealNewCard(player, true);
    dealer.dealNewCard(dealer, true);
    dealer.dealNewCard(player, true);

    return true;
  }

  @Override
  public void accept(RulesVisitor visitor) {
    visitor.visit(this);
  }
}