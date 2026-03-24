package io.github.ygrip.automation.page;

import com.microsoft.playwright.ElementHandle;

import io.github.ygrip.testara.ui.model.DeviceType;
import io.github.ygrip.testara.ui.model.Locator;
import io.github.ygrip.testara.ui.model.Page;
import io.github.ygrip.testara.ui.playwright.page.PlaywrightPage;

@Page(name = "github",
  url = "https://github.com",
  platforms = {DeviceType.DEFAULT, DeviceType.DESKTOP, DeviceType.MOBILE}
)
public class GithubPage extends PlaywrightPage {
  private static final Locator SEARCH_BAR = Locator.className("search-input");
  private static final Locator INPUT_SEARCH_FIELD = Locator.id("query-builder-test");
  private static final Locator githubIcon = Locator.css("header svg.octicon-mark-github");
  private static final Locator PROFILE_CARD = Locator.className("vcard-names-container");
  private final com.microsoft.playwright.Locator githubLogo = findOne("header svg.octicon-mark-github");
}
