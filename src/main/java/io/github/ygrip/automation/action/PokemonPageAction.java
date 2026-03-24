package io.github.ygrip.automation.action;

import java.nio.file.Path;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import io.github.ygrip.automation.model.PokemonGeneration;
import io.github.ygrip.automation.page.PokemonPage;
import io.github.ygrip.testara.core.file.FileHelper;
import io.github.ygrip.testara.core.support.CommonHelper;
import io.github.ygrip.testara.ui.executor.UserAction;
import io.github.ygrip.testara.ui.interaction.Scroll;
import io.github.ygrip.testara.ui.model.Action;
import io.github.ygrip.testara.ui.model.OnPage;
import io.github.ygrip.testara.ui.observation.AllText;
import io.github.ygrip.testara.ui.observation.CountElements;
import io.github.ygrip.testara.ui.observation.ExecuteScript;
import io.github.ygrip.testara.ui.observation.TheAttribute;
import io.github.ygrip.testara.ui.observation.TheText;
import io.github.ygrip.testara.ui.page.Element;
import io.github.ygrip.testara.ui.populator.PopulateFor;
import io.github.ygrip.testara.ui.populator.Resolve;
import lombok.extern.log4j.Log4j2;

@Log4j2
@OnPage(value = {PokemonPage.class})
public class PokemonPageAction extends UserAction {

  @Action(value = "^populate pokemon generations and store data to '([^\"]*)'$")
  public static void populatePokemon(String path) throws Exception {
    //@formatter:off
    final var startNanos = System.nanoTime();
    String domain = "https://pokemondb.net";

    // Types: list of type strings per card (each "pokemon types" item is one type link;)
    final var getSiblingTextScript = "return arguments[0].previousElementSibling.innerText;";
    var typesPopulator = Resolve.from(AllText.of("pokemon types"));
    var pokemonNumberPopulator = Resolve.from(TheText.of("pokemon number")).asInteger();
    var linkPopulator = Resolve.from(TheAttribute.of("href").on("pokemon link"));
    var generationNumberPopulator = Resolve.from(ExecuteScript.of(getSiblingTextScript).withNoArguments())
      .asInteger();

    // One pokemon card: number, name, link, image, types (each .set().with() ends with .build() to chain)
    var pokemonCardPopulator = PopulateFor.all("info card")
      .set("number", pokemonNumberPopulator)
      .set("name", Resolve.from(TheText.of("pokemon name")))
      .set("image", Resolve.from(TheAttribute.of("src").on("image link")))
      .set("types", typesPopulator)
      .set("link").with(linkPopulator).into(link -> domain + link)
      .build();

    List<PokemonGeneration> result = PopulateFor.all("generations")
      .perform(Scroll.to(Element.of("generation number").precedingSibling()).andAlignToTop())
      .set("total", Resolve.from(CountElements.of("info card")).asInteger())
      .set("pokemons", pokemonCardPopulator)
      .set("generation", generationNumberPopulator)
      .andThen().resolveAs(new TypeReference<>() {});

    long elapsedMs = (System.nanoTime() - startNanos) / 1_000_000;
    log.info("#Done populating pokemon generations, process took: {} ms", elapsedMs);

    if (!CommonHelper.isBlank(result)) {
      String baseDir = System.getProperty("user.dir");
      Path resultPath = Path.of(baseDir, path);
      FileHelper.writeJson(result, resultPath.toString());
    }
    //@formatter:on
  }
}
