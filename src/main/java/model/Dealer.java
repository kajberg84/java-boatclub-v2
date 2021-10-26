package model;

import java.util.ArrayList;
import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.RulesFactory;
import model.rules.WinStrategy;

/**
 * Represents a dealer player that handles the deck of cards and runs the game using rules.
 */
public class Dealer extends Player {

  private Deck deck;
  private NewGameStrategy newGameRule;
  private HitStrategy hitRule;
  private WinStrategy winRule;
  private ArrayList<NewCardObserver> subscribers;

  /**
   * Initializing constructor.

   * @param rulesFactory A factory that creates the rules to use.
   */
  public Dealer(RulesFactory rulesFactory) {
    newGameRule = rulesFactory.getNewGameRule();
    hitRule = rulesFactory.getHitRule();
    winRule = rulesFactory.getWinRule();
    subscribers = new ArrayList<>();
  }

  public void addSubscriber(NewCardObserver subscriber) {
    subscribers.add(subscriber);
  }

  public void removeSubscriber(NewCardObserver subscriber) {
    subscribers.remove(subscriber);
  }

  private void notifySubscribersOnNewCard() {
    for (NewCardObserver s : subscribers) {
      s.newCard();
    }
  }

  /**
   * Starts a new game if the game is not currently under way.

   * @param player The player to play agains.
   * @return True if the game could be started.
   */
  public boolean newGame(Player player) {
    if (deck == null || isGameOver()) {
      deck = new Deck();
      clearHand();
      player.clearHand();
      return newGameRule.newGame(this, player);
    }
    return false;
  }

  /**
   * Gives the player one more card if possible. I.e. the player hits.

   * @param player The player to give a card to.
   * @return true if the player could get a new card, false otherwise.
   */
  public boolean hit(Player player) {
    if (deck != null && player.calcScore() < maxScore && !isGameOver()) {
      dealNewCard(player, true);
      return true;
    }
    return false;
  }

  /**
   * The player has chosen to take no more cards, it is the dealer's turn.

   * @return true if the dealer could get a new card, false otherwise.
   */
  public boolean stand() {
    if (deck != null) {
      showHand();
      while (hitRule.doHit(this)) {
        dealNewCard(this, true);
        return true;
      }
    }
    return false;
  }

  /**
   * Deals a new card to a player or dealer. Card can be visible or hidden.

   * @param player The player (player or dealer) that should be dealt a new card.
   * @param isVisible The visibility status of the card.
   */
  public void dealNewCard(Player player, Boolean isVisible) {
    Card.Mutable c = deck.getCard();
    c.show(isVisible);
    player.dealCard(c);
    notifySubscribersOnNewCard();
  }

  /**
   * Checks if the dealer is the winner compared to a player.

   * @param player The player to check agains.
   * @return True if the dealer is the winner, false if the player is the winner.
   */
  public boolean isDealerWinner(Player player) {
    return winRule.isDealerWinner(this, player);
  }

  /**
   * Checks if the game is over, i.e. the dealer can take no more cards.

   * @return True if the game is over.
   */
  public boolean isGameOver() {
    if (deck != null && hitRule.doHit(this) != true) {
      return true;
    }
    return false;
  }
}