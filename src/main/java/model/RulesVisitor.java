package model;

import model.rules.AmericanNewGameStrategy;
import model.rules.BasicHitStrategy;
import model.rules.DealerAdvantageWinStrategy;
import model.rules.InternationalNewGameStrategy;
import model.rules.PlayerAdvantageWinStrategy;
import model.rules.Soft17HitStrategy;

/**
 * The interface of a rules visitor.
 */
public interface RulesVisitor {
  public void visit(BasicHitStrategy basicHitStrategy);

  public void visit(Soft17HitStrategy soft17HitStrategy);

  public void visit(InternationalNewGameStrategy internationalNewGameStrategy);

  public void visit(AmericanNewGameStrategy americanNewGameStrategy);

  public void visit(DealerAdvantageWinStrategy dealerAdvantageWinStrategy);

  public void visit(PlayerAdvantageWinStrategy playerAdvantageWinStrategy);
}
