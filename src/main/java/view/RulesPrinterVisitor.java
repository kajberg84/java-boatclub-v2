package view;

import model.RulesVisitor;
import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.WinStrategy;

/**
 * A concrete rules visitor.
 */
public class RulesPrinterVisitor implements RulesVisitor {

  @Override
  public void visit(HitStrategy hitStrategy) {
    System.out.println("Applied hit rule: " + hitStrategy.getRuleName());
  }

  @Override
  public void visit(NewGameStrategy newGameStrategy) {
    System.out.println("Applied new game rule: " + newGameStrategy.getRuleName());
  }

  @Override
  public void visit(WinStrategy winStrategy) {
    System.out.println("Applied win rule: " + winStrategy.getRuleName());
  }
}
