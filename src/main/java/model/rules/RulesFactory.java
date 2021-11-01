package model.rules;

/**
 * Creates concrete rules.
 */
public interface RulesFactory {

  /**
   * Creates the rule to use for the dealer's hit behavior.

   * @return The rule to use
   */
  public HitStrategy getHitRule();
  /**
   * Creates the rule to use when starting a new game.

   * @return The rule to use.
   */
  public NewGameStrategy getNewGameRule();

  /**
   * Creates the rule to use for deciding the winner.

   * @return The rule to use.
   */
  public WinStrategy getWinRule();
}