package view;

import model.RulesVisitor;
import model.rules.AmericanNewGameStrategy;
import model.rules.BasicHitStrategy;
import model.rules.DealerAdvantageWinStrategy;
import model.rules.InternationalNewGameStrategy;
import model.rules.PlayerAdvantageWinStrategy;
import model.rules.Soft17HitStrategy;

/**
 * A concrete rules visitor.
 */
public class RulesPrinterVisitor implements RulesVisitor {

  @Override
  public void visit(BasicHitStrategy basicHitStrategy) {
    System.out.println("Regular rules for dealer.");
  }

  @Override
  public void visit(Soft17HitStrategy soft17HitStrategy) {
    System.out.println("Dealer hits on soft 17.");
  }

  @Override
  public void visit(InternationalNewGameStrategy internationalNewGameStrategy) {
    System.out.println("Dealer gets one card and player gets two cards.");
    
  }

  @Override
  public void visit(AmericanNewGameStrategy americanNewGameStrategy) {
    System.out.println("Dealer gets two cards (one hidden and one visible) and player gets two cards.");
    
  }

  @Override
  public void visit(DealerAdvantageWinStrategy dealerAdvantageWinStrategy) {
    System.out.println("Dealer wins on equal score.");
    
  }

  @Override
  public void visit(PlayerAdvantageWinStrategy playerAdvantageWinStrategy) {
    System.out.println("Player wins on equal score.");
    
  }
}
