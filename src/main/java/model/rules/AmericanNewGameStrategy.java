package model.rules;

import model.Dealer;
import model.Player;

public class AmericanNewGameStrategy implements NewGameStrategy {

  public boolean newGame(Dealer dealer, Player player) {
    dealer.dealNewCard(player, true);
    dealer.dealNewCard(dealer, true);
    dealer.dealNewCard(player, true);
    dealer.dealNewCard(dealer, false);

    return true;
  }
}