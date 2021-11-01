package model.rules;

/**
 * A rules factory creating the rules Soft17, American New Game and Player Advantage.
 */
public class AmericanSoft17PlayerAdvantageFactory implements RulesFactory {

  @Override
  public HitStrategy getHitRule() {
    return new Soft17HitStrategy();
  }

  @Override
  public NewGameStrategy getNewGameRule() {
    return new AmericanNewGameStrategy();
  }

  @Override
  public WinStrategy getWinRule() {
    return new PlayerAdvantageWinStrategy();
  }
}
