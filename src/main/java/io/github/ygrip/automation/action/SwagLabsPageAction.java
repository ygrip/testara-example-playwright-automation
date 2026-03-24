package io.github.ygrip.automation.action;

import io.github.ygrip.automation.page.SwagLabsPage;
import io.github.ygrip.testara.command.CommandExecutor;
import io.github.ygrip.testara.ui.executor.Actor;
import io.github.ygrip.testara.ui.executor.ActorManager;
import io.github.ygrip.testara.ui.executor.UserAction;
import io.github.ygrip.testara.ui.interaction.Click;
import io.github.ygrip.testara.ui.model.Action;
import io.github.ygrip.testara.ui.model.Locator;
import io.github.ygrip.testara.ui.model.OnPage;
import lombok.extern.log4j.Log4j2;

@Log4j2
@OnPage(value = {SwagLabsPage.class})
public class SwagLabsPageAction extends UserAction {

  @Action(value = "^add product '([^\"]*)' to cart$")
  public static void addProduct(String productName) throws Exception {
    //@formatter:off
    productName = CommandExecutor.executeCommand(productName);
    Actor actor = ActorManager.currentActor();
    Locator locator = SwagLabsPage.getButtonAddToCartProduct(productName);
    actor.attemptsTo(Click.on(locator));
    //@formatter:on
  }
}
