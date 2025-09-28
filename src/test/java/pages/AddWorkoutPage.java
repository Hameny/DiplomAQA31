package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

import io.qameta.allure.Step;
import dto.AddWorkout;
import org.openqa.selenium.By;

public class AddWorkoutPage extends BasePage {

  private static final String SAVE_WORKOUT_BUTTON_SELECTOR = "#saveButton";
  private static final String DELETE_WORKOUT_BUTTON_SELECTOR = "#del-workout";
  private static final String WORKOUT_NAME_INPUT_SELECTOR = "#Name";
  private static final By CUSTOMIZE_SETTINGS_LINK_LOCATOR = By.cssSelector(
      "a[href='WorkoutCustomize.cshtml?id=']");
  private static final By MODAL_FOOTER_LOCATOR = By.cssSelector(".modal-footer");
  private static final By DELETE_CONFIRM_BUTTON_LOCATOR = By.cssSelector("a:nth-of-type(1)");
  private static final String WORKOUT_DETAILS_SECTION_SELECTOR = ".formSep";
  private static final By WORKOUT_NAME_DISPLAY_LOCATOR = By.cssSelector("div:nth-of-type(3)");

  @Override
  public void isOpen() {
    $(CUSTOMIZE_SETTINGS_LINK_LOCATOR).shouldBe(clickable);
  }

  @Step("Выбрать тип активности: {activityType}, подтип: {activitySubtype}")
  public void selectActivityType(String activityType, String activitySubtype) {
    $(By.cssSelector("a[data-code='" + activityType + "']")).shouldBe(clickable).click();
    $(By.xpath("//a[text()='" + activitySubtype + "']")).shouldBe(clickable).click();
  }

  @Step("Нажать кнопку 'Сохранить тренировку'")
  public void clickSaveWorkoutButton() {
    $(SAVE_WORKOUT_BUTTON_SELECTOR).click();
  }

  @Step("Ввести название тренировки")
  public void addWorkoutName(AddWorkout fullWorkout) {
    $(WORKOUT_NAME_INPUT_SELECTOR).setValue(fullWorkout.getName());
  }

  @Step("Получить название тренировки со страницы")
  public String getWorkoutNameText() {
    return $(WORKOUT_DETAILS_SECTION_SELECTOR).$(WORKOUT_NAME_DISPLAY_LOCATOR).text();
  }

  @Step("Удалить тренировку")
  public void deleteWorkout() {
    $(DELETE_WORKOUT_BUTTON_SELECTOR).click();
    $(MODAL_FOOTER_LOCATOR).$(DELETE_CONFIRM_BUTTON_LOCATOR).click();
  }
}