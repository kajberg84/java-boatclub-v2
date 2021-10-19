package model.rules;

import model.Dealer;
import model.Player;

/**
 * Player wins if equal score.
 */
public class PlayerAdvantageWinStrategy implements WinStrategy {

  @Override
  public boolean isDealerWinner(Dealer dealer, Player player) {
    if (player.calcScore() > maxScore) {
      return true;
    } else if (dealer.calcScore() > maxScore) {
      return false;
    }
    return dealer.calcScore() > player.calcScore();
  }
}
