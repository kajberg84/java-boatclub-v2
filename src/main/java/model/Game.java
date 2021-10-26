package model;

// import java.util.ArrayList;

/**
 * Represents the entirety of the game. Acts as a Facade to the model.
 */
public class Game {

  private Dealer dealer;
  private Player player;
  // private ArrayList<NewCardObserver> subscribers;

  /**
   * Constructor that creates a new game instance with a dealer and player.
   */
  public Game(Dealer d) {
    dealer = d;
    // dealer = new Dealer(new model.rules.RulesFactory());
    player = new Player();
    // subscribers = new ArrayList<>();
  }

  // public void addSubscriber(NewCardObserver subscriber) {
  //   subscribers.add(subscriber);
  // }

  // public void removeSubscriber(NewCardObserver subscriber) {
  //   subscribers.remove(subscriber);
  // }

  // private void notifySubscribersOnNewCard() {
  //   for (NewCardObserver s : subscribers) {
  //     s.newCard();
  //   }
  // }

  /**
   * Checks if the game has ended.

   * @return true if the game has ended.
   */
  public boolean isGameOver() {
    return dealer.isGameOver();
  }

  /**
   * Checks if the dealer is the winner.

   * @return True if the dealer has won over the player.
   */
  public boolean isDealerWinner() {
    return dealer.isDealerWinner(player);
  }

  /**
   * Stars a new game.

   * @return True if a new game could be started.
   */
  public boolean newGame() {
    return dealer.newGame(player);
  }

  /**
   * Call to let the player get a new card.

   * @return True if the player got a new card.
   */
  public boolean hit() {
    // if (dealer.hit(player)) {
    //   notifySubscribersOnNewCard();
    //   return true;
    // }
    // return false;
    return dealer.hit(player);
  }

  /**
   * Call to let the dealer take cards.

   * @return True if the dealer has the initiaive.
   */
  public boolean stand() {
    // if (dealer.stand()) {
    //   notifySubscribersOnNewCard();
    //   return true;
    // }
    // return false;
    return dealer.stand();
  }

  /**
   * Gets the cards currently in the dealer's hand.

   * @return The dealer's cards.
   */
  public Iterable<Card> getDealerHand() {
    return dealer.getHand();
  }

  /**
   * Gets the cards currently in the player's hand.

   * @return The palyer's cards.
   */
  public Iterable<Card> getPlayerHand() {
    return player.getHand();
  }

  /**
   * Returns the score of the dealer's hand.

   * @return the score.
   */
  public int getDealerScore() {
    return dealer.calcScore();
  }

  /**
   * Returns the score of the player's hand.

   * @return the score.
   */
  public int getPlayerScore() {
    return player.calcScore();
  }
}