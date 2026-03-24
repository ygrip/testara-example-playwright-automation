package io.github.ygrip.automation.page;

import io.github.ygrip.testara.ui.model.DeviceType;
import io.github.ygrip.testara.ui.model.Locator;
import io.github.ygrip.testara.ui.model.Page;
import io.github.ygrip.testara.ui.playwright.page.PlaywrightPage;

@Page(name = "swaglabs",
  url = "https://www.saucedemo.com/",
  platforms = {DeviceType.DEFAULT, DeviceType.DESKTOP, DeviceType.MOBILE}
)
public class SwagLabsPage extends PlaywrightPage {
  private static final Locator USERNAME_FIELD = Locator.id("user-name");
  private static final Locator PASSWORD_FIELD = Locator.id("password");
  private static final Locator BUTTON_LOGIN = Locator.id("login-button");
  private static final Locator LOGOUT_SIDEBAR = Locator.id("logout_sidebar_link");
  private static final Locator INVENTORY_CONTAINER = Locator.id("inventory_container");
  private static final Locator SHOPPING_CART = Locator.id("shopping_cart_container");
  private static final Locator CART_ITEMS = Locator.css(".cart_item");
  private static final Locator CART_ITEMS_NAME = Locator.css(".cart_item a");
  private static final Locator CART_ITEMS_QUANTITY = Locator.css(".cart_item .cart_quantity");
  private static final Locator BUTTON_BURGER = Locator.css(".bm-burger-button");
  private static final Locator BUTTON_CHECKOUT = Locator.css("button#checkout");
  private static final Locator INPUT_FIRST_NAME = Locator.id("first-name");
  private static final Locator INPUT_LAST_NAME = Locator.id("last-name");
  private static final Locator INPUT_POSTAL_CODE = Locator.id("postal-code");
  private static final Locator BUTTON_CONTINUE = Locator.id("continue");
  private static final Locator BUTTON_FINISH = Locator.css("button#finish");
  private static final Locator CHECKOUT_COMPLETE = Locator.id("checkout_complete_container");

  public static Locator getButtonAddToCartProduct(String productName) {
    return Locator.xpath(String.format("//*[@data-test='inventory-item'][contains(.,'%s')]//button", productName));
  }
}
