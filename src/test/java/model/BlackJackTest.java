package model;

import model.rules.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BlackJackTest {

  @Test
  public void dealerTest_1() {
    DummyRulesFactory rulesFactory = new DummyRulesFactory();
    DummyDealer dealer = new DummyDealer(rulesFactory);

    Card.Mutable c1 = new Card.Mutable(Card.Color.Hearts, Card.Value.Ace);
    Card.Mutable c2 = new Card.Mutable(Card.Color.Hearts, Card.Value.Six);

    c1.show(true);
    dealer.dealCard(c1);
    c2.show(true);
    dealer.dealCard(c2);

    HitStrategy hitRule = rulesFactory.getHitRule();

    assertEquals(true, hitRule.doHit(dealer),"Dealer should take another card");
  }

  @Test
  public void dealerTest_2() {
    DummyRulesFactory rulesFactory = new DummyRulesFactory();
    DummyDealer dealer = new DummyDealer(rulesFactory);

    Card.Mutable c1 = new Card.Mutable(Card.Color.Spades, Card.Value.Ten);
    Card.Mutable c2 = new Card.Mutable(Card.Color.Clubs, Card.Value.Seven);

    c1.show(true);
    dealer.dealCard(c1);
    c2.show(true);
    dealer.dealCard(c2);

    HitStrategy hitRule = rulesFactory.getHitRule();
    assertEquals(false, hitRule.doHit(dealer), "Dealer should not take another card");
  }

  @Test
  public void dealerTest_3() {
    DummyRulesFactory rulesFactory = new DummyRulesFactory();
    DummyDealer dealer = new DummyDealer(rulesFactory);

    Card.Mutable c1 = new Card.Mutable(Card.Color.Hearts, Card.Value.Ace);
    Card.Mutable c2 = new Card.Mutable(Card.Color.Hearts, Card.Value.Six);
    Card.Mutable c3 = new Card.Mutable(Card.Color.Hearts, Card.Value.Ten);

    c1.show(true);
    dealer.dealCard(c1);
    c2.show(true);
    dealer.dealCard(c2);
    c3.show(true);
    dealer.dealCard(c3);

    assertEquals(17, dealer.calcScore(), "Dealer should have a score of 17");
  }

  @Test
  public void winnerTest_1() {
    DummyRulesFactory rulesFactory = new DummyRulesFactory();
    DummyDealer dealer = new DummyDealer(rulesFactory);
    DummyPlayer player = new DummyPlayer();

    Card.Mutable c1 = new Card.Mutable(Card.Color.Hearts, Card.Value.Ten);
    Card.Mutable c2 = new Card.Mutable(Card.Color.Hearts, Card.Value.Eight);
    Card.Mutable c3 = new Card.Mutable(Card.Color.Spades, Card.Value.Ten);
    Card.Mutable c4 = new Card.Mutable(Card.Color.Spades, Card.Value.Eight);

    c1.show(true);
    dealer.dealCard(c1);
    c2.show(true);
    dealer.dealCard(c2);
    c3.show(true);
    player.dealCard(c3);
    c4.show(true);
    player.dealCard(c4);

    WinStrategy winRule = rulesFactory.getWinRule();

    assertEquals(false, winRule.isDealerWinner(dealer, player), "Player should win when equal score.");
  }

  @Test
  public void winnerTest_2() {
    DummyRulesFactory_2 rulesFactory = new DummyRulesFactory_2();
    DummyDealer dealer = new DummyDealer(rulesFactory);
    DummyPlayer player = new DummyPlayer();

    Card.Mutable c1 = new Card.Mutable(Card.Color.Hearts, Card.Value.Ten);
    Card.Mutable c2 = new Card.Mutable(Card.Color.Hearts, Card.Value.Eight);
    Card.Mutable c3 = new Card.Mutable(Card.Color.Spades, Card.Value.Ten);
    Card.Mutable c4 = new Card.Mutable(Card.Color.Spades, Card.Value.Eight);

    c1.show(true);
    dealer.dealCard(c1);
    c2.show(true);
    dealer.dealCard(c2);
    c3.show(true);
    player.dealCard(c3);
    c4.show(true);
    player.dealCard(c4);

    WinStrategy winRule = rulesFactory.getWinRule();

    assertEquals(true, winRule.isDealerWinner(dealer, player), "Dealer should win when equal score.");
  }
  
  class DummyDealer extends Dealer {

    DummyDealer(RulesFactory rulesFactory) {
      super(rulesFactory);
    }
  }

  class DummyPlayer extends Player {

    DummyPlayer() {

    }
  }

  class DummyRulesFactory extends RulesFactory {

    @Override 
    public HitStrategy getHitRule() {
      return new Soft17HitStrategy();
    }

    @Override
    public WinStrategy getWinRule() {
      return new PlayerAdvantageWinStrategy();
    }
  }

  class DummyRulesFactory_2 extends RulesFactory {

    @Override
    public HitStrategy getHitRule() {
      return new Soft17HitStrategy();
    }

    @Override
    public WinStrategy getWinRule() {
      return new DealerAdvantageWinStrategy();
    }
  }

}
