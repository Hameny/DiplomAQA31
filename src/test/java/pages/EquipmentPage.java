package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class EquipmentPage{

  private static final By SHOES_PAGE_LINK_LOCATOR = By.cssSelector("a[href='EquipmentShoes.cshtml']");

  @Step("Page is open")
  public EquipmentPage isOpen() {
    log.info("Page is open");
    $(SHOES_PAGE_LINK_LOCATOR).shouldBe(clickable);
    return this;
  }
}
