package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

import dto.AddWorkout;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class WorkoutDetailsPage{

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

  @Step("Page is open")
  public WorkoutDetailsPage isOpen() {
    log.info("Page is open");
    $(UPDATE_WORKOUT_DROPDOWN).shouldBe(clickable);
    return this;
  }

  @Step("Нажать кнопку выбора действия для тренировки")
  public WorkoutDetailsPage clickWorkoutActionsDropdown() {
    log.info("Нажать кнопку выбора действия для тренировки");
    $(UPDATE_WORKOUT_DROPDOWN).click();
    return this;
  }

  @Step("Сохранить обновленную тренировку")
  public WorkoutDetailsPage clickSaveUpdatedWorkout() {
    log.info("Сохранить обновленную тренировку");
    $(SAVE_UPDATED_WORKOUT_BUTTON).click();
    return this;
  }

  @Step("Заполнить детали редактирования тренировки")
  public WorkoutDetailsPage fillWorkoutEditDetails(AddWorkout editWorkout) {
    log.info("Заполнить детали редактирования тренировки");
    $(WORKOUT_TIME_INPUT).setValue(editWorkout.getTimeOfDay());
    $(WORKOUT_NAME_INPUT).setValue(editWorkout.getName());
    $(DESCRIPTION_INPUT).setValue(editWorkout.getDescription());
    $(PLANNED_WORKOUT_CHECKBOX).click();
    $(PLANNED_DISTANCE_INPUT).setValue(editWorkout.getPlannedDistance());
    $(PLANNED_DISTANCE_TYPE_SELECT).selectOption(editWorkout.getPlannedDistanceType());
    $(PLANNED_DURATION_INPUT).setValue(editWorkout.getPlannedDuration());
    $(ACTUAL_DISTANCE_INPUT).setValue(editWorkout.getDistance());
    $(ACTUAL_DISTANCE_TYPE_SELECT).selectOption(editWorkout.getDistanceType());
    $(ACTUAL_DURATION_INPUT).setValue(editWorkout.getDuration());
    $(PACE_TYPE_SELECT).selectOption(editWorkout.getPaceType());
    $(PERCEIVED_EFFORT_SELECT).selectOption(editWorkout.getPerceivedEffort());
    $(FEELING_GOOD_RADIO).click();
    $(CALORIES_BURNED_INPUT).setValue(editWorkout.getCaloriesBurned());
    $(SAVE_TO_LIBRARY_CHECKBOX).click();
    return this;
  }

  @Step("Получить название тренировки со страницы")
  public String getDisplayedWorkoutName() {
    log.info("Получить название тренировки со страницы");
    return $(WORKOUT_NAME_DISPLAY).getText();
  }
}
