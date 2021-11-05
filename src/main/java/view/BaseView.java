package view;

public abstract class BaseView implements View {

  /**
   * Represents an action.
   */
  public enum Action {
    PLAY,
    HIT,
    STAND,
    QUIT,
    None;
  }
  
  /**
   * Returns pressed characters from the keyboard.

   * @return The pressed character.
   */
  public int getInput() {
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
  };

  /**
   * Returns an action.

   * @return The action represented by a pressed character.
   */
  public Action promptForAction() {
    int input = getInput();

    switch (input) {
      case('p'):
        return Action.PLAY;
      case('h'):
        return Action.HIT;
      case('s'):
        return Action.STAND;
      case('q'):
        return Action.QUIT;
      default:
        break;
    }
    return Action.None;
  }
}
