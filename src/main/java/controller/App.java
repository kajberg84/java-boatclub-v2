package controller;

import model.Dealer;
import model.Game;
import view.EnglishView;
// import view.SwedishView;
import view.View;

/**
 * Starts the application using the console.
 */
public class App {
  /**
   * Starts the game.

  * @param args Not used.
  */
  public static void main(String[] args) {
    Dealer d = new Dealer();
    Game g = new Game(d);
    View v = new EnglishView(); // new SwedishView();
    // View v = new SwedishView();
    Player ctrl = new Player(v, g);
    d.addSubscriber(ctrl);

    while (ctrl.play()) {

    }
  }
}