package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

import io.qameta.allure.Step;
import dto.AddWorkout;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class AddWorkoutPage {

  private static final String SAVE_WORKOUT_BUTTON_SELECTOR = "#saveButton";
  private static final String DELETE_WORKOUT_BUTTON_SELECTOR = "#del-workout";
  private static final String WORKOUT_NAME_INPUT_SELECTOR = "#Name";
  private static final By CUSTOMIZE_SETTINGS_LINK_LOCATOR = By.cssSelector(
      "a[href='WorkoutCustomize.cshtml?id=']");
  private static final By MODAL_FOOTER_LOCATOR = By.cssSelector(".modal-footer");
  private static final By DELETE_CONFIRM_BUTTON_LOCATOR = By.cssSelector("a:nth-of-type(1)");
  private static final String WORKOUT_DETAILS_SECTION_SELECTOR = ".formSep";
  private static final By WORKOUT_NAME_DISPLAY_LOCATOR = By.cssSelector("div:nth-of-type(3)");
  private static final String ACTIVITY_TYPE_SELECTOR = "a[data-code='%s']";
  private static final String ACTIVITY_SUB_TYPE_XPATH = "//a[text()='%s']";

  @Step("Workout page is open")
  public AddWorkoutPage isOpen() {
    log.info("Workout page is open");
    $(CUSTOMIZE_SETTINGS_LINK_LOCATOR).shouldBe(clickable);
    return this;
  }

  @Step("Выбрать тип активности: {activityType}, подтип: {activitySubtype}")
  public AddWorkoutPage selectActivityType(String activityType, String activitySubtype) {
    log.info("Выбрать тип активности: {}, подтип: {}", activityType, activitySubtype);
    String activityTypeSelector = String.format(ACTIVITY_TYPE_SELECTOR, activityType);
    String activitySubtypeXpath = String.format(ACTIVITY_SUB_TYPE_XPATH, activitySubtype);
    $(activityTypeSelector).shouldBe(clickable).click();
    $(activitySubtypeXpath).shouldBe(clickable).click();
    return this;
  }

  @Step("Нажать кнопку 'Сохранить тренировку'")
  public AddWorkoutPage clickSaveWorkoutButton() {
    log.info("Нажать кнопку 'Сохранить тренировку'");
    $(SAVE_WORKOUT_BUTTON_SELECTOR).click();
    return this;
  }

  @Step("Ввести название тренировки")
  public AddWorkoutPage addWorkoutName(AddWorkout fullWorkout) {
    log.info("Ввести название тренировки");
    $(WORKOUT_NAME_INPUT_SELECTOR).setValue(fullWorkout.getName());
    return this;
  }

  @Step("Получить название тренировки со страницы")
  public String getWorkoutNameText() {
    log.info("Получить название тренировки со страницы");
    return $(WORKOUT_DETAILS_SECTION_SELECTOR).$(WORKOUT_NAME_DISPLAY_LOCATOR).text();
  }

  @Step("Удалить тренировку")
  public AddWorkoutPage deleteWorkout() {
    log.info("Удалить тренировку");
    $(DELETE_WORKOUT_BUTTON_SELECTOR).click();
    $(MODAL_FOOTER_LOCATOR).$(DELETE_CONFIRM_BUTTON_LOCATOR).click();
    return this;
  }
}