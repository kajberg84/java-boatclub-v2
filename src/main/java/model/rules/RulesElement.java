package model.rules;

import model.RulesVisitor;

/**
 * The interface of a rules element.
 */
public interface RulesElement {
  void accept(RulesVisitor visitor);
}
