package view;

import model.RulesVisitor;
import model.rules.AmericanNewGameStrategy;
import model.rules.BasicHitStrategy;
import model.rules.DealerAdvantageWinStrategy;
import model.rules.InternationalNewGameStrategy;
import model.rules.PlayerAdvantageWinStrategy;
import model.rules.Soft17HitStrategy;

public class SwedishRulesPrinterVisitor implements RulesVisitor {

  @Override
  public void visit(BasicHitStrategy basicHitStrategy) {
    System.out.println("Vanliga regler gäller för croupiern.");
  }

  @Override
  public void visit(Soft17HitStrategy soft17HitStrategy) {
    System.out.println("Soft 17 gäller för croupiern.");
  }

  @Override
  public void visit(InternationalNewGameStrategy internationalNewGameStrategy) {
    System.out.println("Croupiern drar ett kort och spelaren två.");
    
  }

  @Override
  public void visit(AmericanNewGameStrategy americanNewGameStrategy) {
    System.out.println("Croupiern drar två kort (ett dolt och ett synligt) och spelaren två.");
  }

  @Override
  public void visit(DealerAdvantageWinStrategy dealerAdvantageWinStrategy) {
    System.out.println("Vid lika vinner croupiern.");
  }

  @Override
  public void visit(PlayerAdvantageWinStrategy playerAdvantageWinStrategy) {
    System.out.println("Vid lika vinner spelaren.");
  }
  
}
