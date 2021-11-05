package model;

import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.WinStrategy;

/**
 * The interface of a rules visitor.
 */
public interface RulesVisitor {
  public void visit(HitStrategy hitStrategy);

  public void visit(NewGameStrategy newGameStrategy);

  public void visit(WinStrategy winStrategy);
}
