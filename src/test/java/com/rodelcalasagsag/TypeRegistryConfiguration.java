package com.rodelcalasagsag;

import com.rodelcalasagsag.custom_param_types.ElementState;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;

import java.util.Locale;

import static java.util.Locale.ENGLISH;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {
  @Override
  public Locale locale() {
    return ENGLISH;
  }

  @Override
  public void configureTypeRegistry(TypeRegistry typeRegistry) {
    typeRegistry.defineParameterType(
        new ParameterType<>(
            "state", "enabled|disabled|visible|hidden", ElementState.class, ElementState::new));
  }
}
