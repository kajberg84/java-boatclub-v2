package model.rules;

import model.RulesVisitor;

public interface RulesElement {
  void accept(RulesVisitor visitor);
}
