package model.rules;

import model.Player;
import model.RulesVisitor;

/**
 * Represents the basic hit strategy.
 */
public class BasicHitStrategy implements HitStrategy {
  private static final int hitLimit = 17;

  public boolean doHit(Player dealer) {
    return dealer.calcScore() < hitLimit;
  }

  @Override
  public void accept(RulesVisitor visitor) {
    visitor.visit(this);
  }
}