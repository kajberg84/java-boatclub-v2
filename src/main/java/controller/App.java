package controller;

import model.Game;
import model.RulesVisitor;
import model.rules.AmericanSoft17PlayerAdvantageFactory;
import model.rules.RulesFactory;
import view.BaseView;
import view.EnglishRulesPrinterVisitor;
import view.EnglishView;
// import view.SwedishView;
// import view.SwedishRulesPrinterVisitor;

/**
 * Starts the application using the console.
 */
public class App {
  /**
   * Starts the game.

  * @param args Not used.
  */
  public static void main(String[] args) {
    RulesFactory r = new AmericanSoft17PlayerAdvantageFactory();
    Game g = new Game(r);
    BaseView v = new EnglishView(); // new SwedishView();
    // BaseView v = new SwedishView();
    RulesVisitor visitor = new EnglishRulesPrinterVisitor();
    // RulesVisitor visitor = new SwedishRulesPrinterVisitor();
    Player ctrl = new Player(v, g, visitor);

    v.displayWelcomeMessage();
    
    while (ctrl.play()) {

    }
  }
}