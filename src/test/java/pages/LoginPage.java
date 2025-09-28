package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

  private static final By EMAIL_INPUT_LOCATOR = By.cssSelector("#login_name");
  private static final By PASSWORD_INPUT_LOCATOR = By.cssSelector("#login_password");
  private static final By LOGIN_BUTTON_LOCATOR = By.cssSelector("button[type='submit']");
  private static final By EMAIL_ERROR_MESSAGE_LOCATOR = By.cssSelector(
      "label[class='error'][for='login_name']");

  @Override
  public void isOpen() {
    $(LOGIN_BUTTON_LOCATOR).shouldBe(clickable);
  }

  @Step("Ввести email: {email}")
  public void enterEmail(String email) {
    $(EMAIL_INPUT_LOCATOR).setValue(email);
  }

  @Step("Ввести пароль")
  public void enterPassword(String password) {
    $(PASSWORD_INPUT_LOCATOR).setValue(password);
  }

  @Step("Нажать кнопку входа")
  public void clickLoginButton() {
    $(LOGIN_BUTTON_LOCATOR).shouldBe(visible).click();
  }

  @Step("Авторизация с логином {email} и паролем {password}")
  public void login(String email, String password) {
    enterEmail(email);
    enterPassword(password);
    clickLoginButton();
  }

  @Step("Получить текст ошибки email")
  public String getEmailErrorMessageText() {
    return $(EMAIL_ERROR_MESSAGE_LOCATOR).text();
  }

  @Step("Проверить отображение сообщения об ошибке email")
  public void verifyEmailErrorMessageDisplayed() {
    $(EMAIL_ERROR_MESSAGE_LOCATOR).shouldBe(visible);
  }
}
