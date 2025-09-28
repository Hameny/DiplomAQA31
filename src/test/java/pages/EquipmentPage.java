package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class EquipmentPage extends BasePage {

  private static final By SHOES_PAGE_LINK_LOCATOR = By.cssSelector("a[href='EquipmentShoes.cshtml']");

  @Override
  public void isOpen() {
    $(SHOES_PAGE_LINK_LOCATOR).shouldBe(clickable);
  }
}
