package com.rodelcalasagsag.custom_param_types;

public class ElementState {

  private final String state;

  public ElementState(String state) {
    this.state = state.toLowerCase();
  }

  public boolean isEnabled() {
    switch (state) {
      case "enabled":
        return true;
      case "disabled":
        return false;
      default:
        throw new Error(invalidStateMsg());
    }
  }

  public boolean isVisible() {
    switch (state) {
      case "visible":
        return true;
      case "hidden":
        return false;
      default:
        throw new Error(invalidStateMsg());
    }
  }

  private String invalidStateMsg() {
    return "Invalid State: " + state;
  }
}
