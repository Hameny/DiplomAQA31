package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

import io.qameta.allure.Step;
import dto.Calculator;
import org.openqa.selenium.By;

public class CalculatorPage extends BasePage {

  private static final String SAVE_BUTTON = "#saveButtonSettings";
  private static final By TINMAN_CALCULATOR_LINK_LOCATOR = By.cssSelector(
      "a[href^='https://log.finalsurge.com/TinmanCalc.cshtml']");
  private static final By RACE_DISTANCE_DROPDOWN_LOCATOR = By.cssSelector("[name='distance']");
  private static final String GENDER_RADIO_BUTTON_SELECTOR = "#Male";
  private static final By ERROR_ALERT_LOCATOR = By.cssSelector(".alert.alert-error");
  private static final By RACE_SPLIT_RESULT_LOCATOR = By.cssSelector(".w-box");
  private static final String EVENT_TYPE_RADIO_BUTTON_SELECTOR = "#FIVEK";
  private static final String HOURS_INPUT_SELECTOR = "#TimeHH";
  private static final String MINUTES_INPUT_SELECTOR = "#TimeMM";
  private static final String SECONDS_INPUT_SELECTOR = "#TimeSS";

  @Override
  public void isOpen() {
    switchTo().frame(0);
    {
      $(SAVE_BUTTON).shouldBe(clickable);
    }
  }

  @Step("Ввести время для расчета интенсивности")
  public void enterIntensityCalculationTime(Calculator intensityCalc) {
    $(HOURS_INPUT_SELECTOR).setValue(intensityCalc.getHours());
    $(MINUTES_INPUT_SELECTOR).setValue(intensityCalc.getMinutes());
    $(SECONDS_INPUT_SELECTOR).setValue(intensityCalc.getSeconds());
  }

  @Step("Выбрать калькулятор Tinman")
  public void clickTinmanCalculator() {
    $(TINMAN_CALCULATOR_LINK_LOCATOR).click();
  }

  @Step("Выбрать тип события")
  public void selectEventType() {
    $(EVENT_TYPE_RADIO_BUTTON_SELECTOR).click();
  }

  @Step("Выбрать дистанцию для расчета Tinman")
  public void selectTinmanRaceDistance(String distance) {
    $(RACE_DISTANCE_DROPDOWN_LOCATOR).selectOption(distance);
  }

  @Step("Нажать кнопку 'Рассчитать'")
  public void clickCalculateButton() {
    $(SAVE_BUTTON).click();
  }

  @Step("Заполнить гендер")
  public void selectGender() {
    $(GENDER_RADIO_BUTTON_SELECTOR).click();
  }

  @Step("Проверить отображение результатов расчета")
  public boolean isWorkoutSplitResultDisplayed() {
    return $(RACE_SPLIT_RESULT_LOCATOR).should(exist).isDisplayed();
  }

  @Step("Получить текст ошибки расчета интенсивности")
  public String getIntensityCalculationErrorMessage() {
    return $(ERROR_ALERT_LOCATOR).text();
  }
}
