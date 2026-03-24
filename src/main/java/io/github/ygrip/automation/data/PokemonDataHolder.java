package io.github.ygrip.automation.data;

import java.util.List;

import io.github.ygrip.automation.model.PokemonGeneration;
import io.github.ygrip.testara.core.model.DefaultData;
import io.github.ygrip.testara.core.model.ResponseData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ResponseData
public class PokemonDataHolder extends DefaultData {
  private List<PokemonGeneration> pokemonGenerationList;
}
