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
    dealer.dealCard(c1);
    dealer.dealCard(c2);
    
    HitStrategy hitRule = rulesFactory.getHitRule();

    assertEquals(true, hitRule.doHit(dealer),"Dealer should take another card");
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
