@Sanity @PokemonPage
Feature: Test on pokemon page

  Scenario: Populate and save pokemon generations
    Given Yunaz using chrome in desktop
    When he open "pokemon" page
    Then he is in "pokemon" page
    When he do "populate pokemon generations and store data to 'target/pokemon.json'"
    Then [file] file "target/pokemon.json" should exist
    And he assign response data pokemonGenerationList with value :
    """
      readfile(/target/,pokemon.json)
    """
    And he see that
      | actual                                         | validation | expectation |
      | response(pokemonGenerationList)                | NOT_EMPTY  | true        |
      | sizeof(response(pokemonGenerationList))        | EQUAL      | 9           |
      | response($.pokemonGenerationList.*.generation) | SORTED     | ascending   |
