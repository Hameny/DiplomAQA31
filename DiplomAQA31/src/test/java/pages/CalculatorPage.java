package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

import io.qameta.allure.Step;
import dto.Calculator;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class CalculatorPage {

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

  @Step("Page is open")
  public CalculatorPage isOpen() {
    switchTo().frame(0);
    {
      log.info("Page is open");
      $(SAVE_BUTTON).shouldBe(clickable);
      return this;
    }
  }

  @Step("Ввести время для расчета интенсивности")
  public CalculatorPage enterIntensityCalculationTime(Calculator intensityCalc) {
    log.info("Ввести время для расчета интенсивности");
    $(HOURS_INPUT_SELECTOR).setValue(intensityCalc.getHours());
    $(MINUTES_INPUT_SELECTOR).setValue(intensityCalc.getMinutes());
    $(SECONDS_INPUT_SELECTOR).setValue(intensityCalc.getSeconds());
    return this;
  }

  @Step("Выбрать калькулятор Tinman")
  public CalculatorPage clickTinmanCalculator() {
    log.info("Выбрать калькулятор Tinman");
    $(TINMAN_CALCULATOR_LINK_LOCATOR).click();
    return this;
  }

  @Step("Выбрать тип события")
  public CalculatorPage selectEventType() {
    log.info("Выбрать тип события");
    $(EVENT_TYPE_RADIO_BUTTON_SELECTOR).click();
    return this;
  }

  @Step("Выбрать дистанцию для расчета Tinman")
  public CalculatorPage selectTinmanRaceDistance(String distance) {
    log.info("Выбрать дистанцию для расчета Tinman");
    $(RACE_DISTANCE_DROPDOWN_LOCATOR).selectOption(distance);
    return this;
  }

  @Step("Нажать кнопку 'Рассчитать'")
  public CalculatorPage clickCalculateButton() {
    log.info("Нажать кнопку 'Рассчитать'");
    $(SAVE_BUTTON).click();
    return this;
  }

  @Step("Заполнить гендер")
  public CalculatorPage selectGender() {
    log.info("Заполнить гендер");
    $(GENDER_RADIO_BUTTON_SELECTOR).click();
    return this;
  }

  @Step("Проверить отображение результатов расчета")
  public boolean isWorkoutSplitResultDisplayed() {
    log.info("Проверить отображение результатов расчета");
    return $(RACE_SPLIT_RESULT_LOCATOR).should(exist).isDisplayed();
  }

  @Step("Получить текст ошибки расчета интенсивности")
  public String getIntensityCalculationErrorMessage() {
    log.info("Получить текст ошибки расчета интенсивности");
    return $(ERROR_ALERT_LOCATOR).text();
  }
}
