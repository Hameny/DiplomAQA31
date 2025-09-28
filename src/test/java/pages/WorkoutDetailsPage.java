package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

import dto.AddWorkout;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class WorkoutDetailsPage extends BasePage {

  private static final String UPDATE_WORKOUT_DROPDOWN = ".dropdown-toggle";
  private static final String SAVE_UPDATED_WORKOUT_BUTTON = "#saveButton";
  private static final By WORKOUT_NAME_DISPLAY = By.xpath(".//div[@class='formSep']//div[3]");
  private static final String WORKOUT_TIME_INPUT = "#WorkoutTime";
  private static final String WORKOUT_NAME_INPUT = "#Name";
  private static final String DESCRIPTION_INPUT = "#Desc";
  private static final String PLANNED_WORKOUT_CHECKBOX = "#PlannedWorkout";
  private static final String PLANNED_DISTANCE_INPUT = "#PDistance";
  private static final String PLANNED_DISTANCE_TYPE_SELECT = "#PDistType";
  private static final String PLANNED_DURATION_INPUT = "#PDuration";
  private static final String ACTUAL_DISTANCE_INPUT = "#Distance";
  private static final String ACTUAL_DISTANCE_TYPE_SELECT = "#DistType";
  private static final String ACTUAL_DURATION_INPUT = "#Duration";
  private static final String PACE_TYPE_SELECT = "#PaceType";
  private static final String PERCEIVED_EFFORT_SELECT = "#PerEffort";
  private static final String FEELING_GOOD_RADIO = "#hf_good";
  private static final String CALORIES_BURNED_INPUT = "#kCal";
  private static final String SAVE_TO_LIBRARY_CHECKBOX = "#SaveLibrary";

  @Override
  public void isOpen() {
    $(UPDATE_WORKOUT_DROPDOWN).shouldBe(clickable);
  }

  @Step("Нажать кнопку выбора действия для тренировки")
  public void clickWorkoutActionsDropdown() {
    $(UPDATE_WORKOUT_DROPDOWN).click();
  }

  @Step("Сохранить обновленную тренировку")
  public void clickSaveUpdatedWorkout() {
    $(SAVE_UPDATED_WORKOUT_BUTTON).click();
  }

  @Step("Заполнить детали редактирования тренировки")
  public void fillWorkoutEditDetails(AddWorkout editWorkout) {
    $(WORKOUT_TIME_INPUT).setValue(editWorkout.getTimeOfDay());
    $(WORKOUT_NAME_INPUT).setValue(editWorkout.getName());
    $(DESCRIPTION_INPUT).setValue(editWorkout.getDescription());
    $(PLANNED_WORKOUT_CHECKBOX).click();
    $(PLANNED_DISTANCE_INPUT).setValue(editWorkout.getpDistance());
    $(PLANNED_DISTANCE_TYPE_SELECT).selectOption(editWorkout.getpDistanceType());
    $(PLANNED_DURATION_INPUT).setValue(editWorkout.getpDuration());
    $(ACTUAL_DISTANCE_INPUT).setValue(editWorkout.getDistance());
    $(ACTUAL_DISTANCE_TYPE_SELECT).selectOption(editWorkout.getDistanceType());
    $(ACTUAL_DURATION_INPUT).setValue(editWorkout.getDuration());
    $(PACE_TYPE_SELECT).selectOption(editWorkout.getPaceType());
    $(PERCEIVED_EFFORT_SELECT).selectOption(editWorkout.getPerEffort());
    $(FEELING_GOOD_RADIO).click();
    $(CALORIES_BURNED_INPUT).setValue(editWorkout.getkCal());
    $(SAVE_TO_LIBRARY_CHECKBOX).click();
  }

  @Step("Получить название тренировки со страницы")
  public String getDisplayedWorkoutName() {
    return $(WORKOUT_NAME_DISPLAY).getText();
  }
}
