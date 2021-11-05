package model.rules;

import model.Dealer;
import model.Player;

/**
 * Rule interface that encapsulates who should win.
 */
public interface WinStrategy extends RulesElement {
  final int maxScore = 21;

  /**
   * Checks if the dealer is the winner.

   * @param dealer the dealer to check.
   * @param player the player to check.
   * @return True if the rule decided the dealer is winner.
   */
  boolean isDealerWinner(Dealer dealer, Player player);

  String getRuleName();
}
