package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class LoginPage{

  private static final By EMAIL_INPUT_LOCATOR = By.cssSelector("#login_name");
  private static final By PASSWORD_INPUT_LOCATOR = By.cssSelector("#login_password");
  private static final By LOGIN_BUTTON_LOCATOR = By.cssSelector("button[type='submit']");
  private static final By EMAIL_ERROR_MESSAGE_LOCATOR = By.cssSelector(
      "label[class='error'][for='login_name']");

  @Step("Page is open")
  public LoginPage isOpen() {
    log.info("Page is open");
    $(LOGIN_BUTTON_LOCATOR).shouldBe(clickable);
    return this;
  }

  @Step("Ввести email: {email}")
  public LoginPage enterEmail(String email) {
    log.info("Ввести email");
    $(EMAIL_INPUT_LOCATOR).setValue(email);
    return this;
  }

  @Step("Ввести пароль")
  public LoginPage enterPassword(String password) {
    log.info("Ввести пароль");
    $(PASSWORD_INPUT_LOCATOR).setValue(password);
    return this;
  }

  @Step("Нажать кнопку входа")
  public LoginPage clickLoginButton() {
    log.info("Нажать кнопку входа");
    $(LOGIN_BUTTON_LOCATOR).shouldBe(visible).click();
    return this;
  }

  @Step("Авторизация с логином {email} и паролем {password}")
  public LoginPage login(String email, String password) {
    log.info("Авторизация с валидным логином и паролем");
    enterEmail(email);
    enterPassword(password);
    clickLoginButton();
    return this;
  }

  @Step("Получить текст ошибки email")
  public String getEmailErrorMessageText() {
    log.info("Получить текст ошибки email");
    return $(EMAIL_ERROR_MESSAGE_LOCATOR).text();
  }

  @Step("Проверить отображение сообщения об ошибке email")
  public LoginPage verifyEmailErrorMessageDisplayed() {
    log.info("Проверить отображение сообщения об ошибке email");
    $(EMAIL_ERROR_MESSAGE_LOCATOR).shouldBe(visible);
    return this;
  }
}
