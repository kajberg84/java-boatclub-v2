package model.rules;

import model.Dealer;
import model.Player;
import model.RulesVisitor;

public class InternationalNewGameStrategy implements NewGameStrategy {

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