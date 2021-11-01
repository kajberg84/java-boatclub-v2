package model.rules;

public class InternationalBasicDealerAdvantageFactory implements RulesFactory {

  @Override
  public HitStrategy getHitRule() {
    return new BasicHitStrategy();
  }

  @Override
  public NewGameStrategy getNewGameRule() {
    return new InternationalNewGameStrategy();
  }

  @Override
  public WinStrategy getWinRule() {
    return new DealerAdvantageWinStrategy();
  }
  
}
