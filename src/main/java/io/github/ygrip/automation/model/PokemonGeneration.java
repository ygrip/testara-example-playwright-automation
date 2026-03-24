package io.github.ygrip.automation.model;

import java.util.List;

import lombok.Data;

@Data
public class PokemonGeneration {
  private Integer generation;
  private Integer total;
  private List<Pokemon> pokemons;
}
