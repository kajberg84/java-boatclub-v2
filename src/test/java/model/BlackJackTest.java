package model;

import model.rules.HitStrategy;
import model.rules.RulesFactory;
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

  class DummyDealer extends Dealer {

    DummyDealer(RulesFactory rulesFactory) {
      super(rulesFactory);
    }
  }

  class DummyRulesFactory extends RulesFactory {

    @Override public HitStrategy getHitRule() {
      return new Soft17HitStrategy();
    }
  }

}
