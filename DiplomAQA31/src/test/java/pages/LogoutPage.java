package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class LogoutPage {

  private static final By LOGIN_BUTTON_SELECTOR = By.cssSelector(".signup");
  private static final By SUCCESS_MESSAGE_SELECTOR = By.cssSelector(".alert.alert-success");

  @Step("Page is open")
  public LogoutPage isOpen() {
    log.info("Page is open");
    $(LOGIN_BUTTON_SELECTOR).shouldBe(clickable);
    return this;
  }

  @Step("Получить сообщение при выходе")
  public String getSuccessMessage() {
    log.info("Получить сообщение при выходе");
    return $(SUCCESS_MESSAGE_SELECTOR).getText();
  }
}
