package view;

import model.RulesVisitor;
import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.WinStrategy;

public class RulesPrinterVisitor implements RulesVisitor {

  @Override
  public void visit(HitStrategy hitStrategy) {
    System.out.println("Applied hit rule: ");
  }

  @Override
  public void visit(NewGameStrategy newGameStrategy) {
    System.out.println("Applied new game rule: ");
  }

  @Override
  public void visit(WinStrategy winStrategy) {
    System.out.println("Applied win rule: ");
  }
}
