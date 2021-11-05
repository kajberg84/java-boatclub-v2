package model;

import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.WinStrategy;

public interface RulesVisitor {
  public void visit(HitStrategy hitStrategy);
  public void visit(NewGameStrategy newGameStrategy);
  public void visit(WinStrategy winStrategy);
}
