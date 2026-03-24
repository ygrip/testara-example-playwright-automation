package io.github.ygrip.automation.page;

import io.github.ygrip.testara.ui.model.DeviceType;
import io.github.ygrip.testara.ui.model.Locator;
import io.github.ygrip.testara.ui.model.Page;
import io.github.ygrip.testara.ui.playwright.page.PlaywrightPage;

@Page(name = "pokemon",
  url = "https://pokemondb.net/pokedex/national",
  platforms = {DeviceType.DEFAULT, DeviceType.DESKTOP, DeviceType.MOBILE}
)
public class PokemonPage extends PlaywrightPage {
  private final static Locator generations = Locator.css("div.infocard-list-pkmn-lg");
  private final static Locator generationNumber = Locator.xpath("preceding-sibling::h2");
  private final static Locator infoCard = Locator.css("div.infocard");
  private final static Locator pokemonNumber = Locator.css("* > span.infocard-lg-data");
  private final static Locator pokemonName = Locator.css("a.ent-name");
  private final static Locator pokemonLink = Locator.css("* > span.infocard-lg-img > a");
  private final static Locator imageLink = Locator.css("* > span.infocard-lg-img > a > *  > *.img-fixed");
  private final static Locator pokemonTypes = Locator.css("* > span > small > a.itype");
}
