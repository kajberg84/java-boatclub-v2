package model.rules;

import model.Dealer;
import model.Player;

/**
 * Represents American new game strategy.
 */
public class AmericanNewGameStrategy implements NewGameStrategy {

  /**
   * Encapsulates the start of a new game. I.e. should deal cards to dealer and player according to some rule.

   * @param dealer The dealer to deal cards to.
   * @param player The player to deal cards to.
   * @return True if the game could be started.
   */
  public boolean newGame(Dealer dealer, Player player) {
    dealer.dealNewCard(player, true);
    dealer.dealNewCard(dealer, true);
    dealer.dealNewCard(player, true);
    dealer.dealNewCard(dealer, false);

    return true;
  }
}