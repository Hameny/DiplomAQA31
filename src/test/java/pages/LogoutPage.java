package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class LogoutPage extends BasePage {

  private static final By LOGIN_BUTTON_SELECTOR = By.cssSelector(".signup");
  private static final By SUCCESS_MESSAGE_SELECTOR = By.cssSelector(".alert.alert-success");

  @Override
  public void isOpen() {
    $(LOGIN_BUTTON_SELECTOR).shouldBe(clickable);
  }

  public String getSuccessMessage() {
    return $(SUCCESS_MESSAGE_SELECTOR).getText();
  }
}
