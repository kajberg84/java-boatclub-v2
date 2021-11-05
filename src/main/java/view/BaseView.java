package view;

/**
 * Represents a view with common base methods.
 */
public abstract class BaseView implements View {

  /**
   * Represents an action.
   */
  private enum Action {
    PLAY,
    HIT,
    STAND,
    QUIT,
    None;
  }

  private Action action;
  
  /**
   * Returns pressed characters from the keyboard.

   * @return The pressed character.
   */
  private int getInput() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      return c;
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return 0;
    }
  }

  /**
   * Returns an action.
   */
  public void promptForAction() {
    int input = getInput();

    switch (input) {
      case('p'):
        action = Action.PLAY;
        return;
      case('h'):
        action = Action.HIT;
        return;
      case('s'):
        action = Action.STAND;
        return;
      case('q'):
        action = Action.QUIT;
        return;
      default:
        break;
    }
    action = Action.None;
  }

  public boolean isPlay() {
    return action == Action.PLAY;
  }

  public boolean isHit() {
    return action == Action.HIT;
  }

  public boolean isStand() {
    return action == Action.STAND;
  }

  public boolean isQuit() {
    return action == Action.QUIT;
  }
}
