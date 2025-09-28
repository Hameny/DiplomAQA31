package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

import io.qameta.allure.Step;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import dto.AddWorkout;
import org.openqa.selenium.By;

public class CalendarPage extends BasePage {

  private static final String QUICK_ADD_TOGGLE_SELECTOR = "#QuickAddToggle";
  private static final By TODAY_DAY_LOCATOR = By.cssSelector("[class*='fc-today']");
  private static final String PLUS_ICON_SELECTOR = ".icon-plus";
  private static final String QUICK_ADD_LINK_SELECTOR = "a.quick-add";
  private static final String FULL_ADD_LINK_SELECTOR = ".full-add";
  private static final String WORKOUT_DATE_INPUT_SELECTOR = "#WorkoutDate";
  private static final String SAVE_WORKOUT_BUTTON_SELECTOR = "#saveButton";
  private static final String ACTIVITY_TYPE_DROPDOWN_SELECTOR = "#ActivityType";
  private static final String WORKOUT_NAME_INPUT_SELECTOR = "#Name";
  private static final By ERROR_ALERT_LOCATOR = By.cssSelector(".alert.alert-error");
  private static final By QUICK_UPLOAD_LINK_LOCATOR = By.cssSelector("a.quick-upload");
  private static final By QUICK_DELETE_LINK_LOCATOR = By.cssSelector("a.quick-delete");
  private static final By DAY_CONTENT_LOCATOR = By.cssSelector(".fc-day-content");
  private static final By EVENT_ACTIVITY_TITLE_LOCATOR = By.cssSelector(".fc-event-activity-title");
  private static final By FULL_VIEW_LINK_LOCATOR = By.cssSelector("a.full-view");
  private static final By DOWNLOAD_BUTTON_LOCATOR = By.cssSelector(
      "button[onclick*='Delivery/WorkoutSourceFile.cshtml']");
  private static final By MODAL_FOOTER_LOCATOR = By.cssSelector(".modal-footer");
  private static final By DELETE_CONFIRM_BUTTON_LOCATOR = By.cssSelector("a:nth-of-type(1)");
  private static final String WORKOUT_UPLOAD_IFRAME_SELECTOR = "#WorkoutUploadiFrame";
  private static final By FILE_INPUT_LOCATOR = By.cssSelector("input[type='file']");

  @Override
  public void isOpen() {
    $(QUICK_ADD_TOGGLE_SELECTOR).shouldBe(clickable);
  }

  @Step("Нажать на кнопку 'Быстрое добавление' тренировки")
  public void clickQuickAddToggle() {
    $(QUICK_ADD_TOGGLE_SELECTOR).click();
  }

  @Step("Добавить быструю тренировку на сегодня через календарь")
  public void addQuickWorkoutFromCalendar() {
    $(TODAY_DAY_LOCATOR).$(PLUS_ICON_SELECTOR).hover().click();
    $(TODAY_DAY_LOCATOR).$(QUICK_ADD_LINK_SELECTOR).shouldBe(visible).hover().click();
  }

  @Step("Нажать на плюс в календаре")
  public void clickPlusIconInCalendar() {
    $(TODAY_DAY_LOCATOR).$(PLUS_ICON_SELECTOR).hover().click();
  }

  @Step("Удалить сегодняшнюю тренировку")
  public void deleteTodayWorkout() {
    $(TODAY_DAY_LOCATOR).$(DAY_CONTENT_LOCATOR).$(EVENT_ACTIVITY_TITLE_LOCATOR).click();
    $(TODAY_DAY_LOCATOR).$(QUICK_DELETE_LINK_LOCATOR).click();
    $(MODAL_FOOTER_LOCATOR).$(DELETE_CONFIRM_BUTTON_LOCATOR).click();
    $(TODAY_DAY_LOCATOR).$(DAY_CONTENT_LOCATOR).$(EVENT_ACTIVITY_TITLE_LOCATOR).shouldBe(disappear);
  }

  @Step("Нажать кнопку 'Сохранить тренировку'")
  public void clickSaveWorkoutButton() {
    $(SAVE_WORKOUT_BUTTON_SELECTOR).click();
    isWorkoutDisplayed();
  }

  @Step("Добавить полную тренировку через календарь")
  public void clickFullWorkoutFromCalendar() {
    $(TODAY_DAY_LOCATOR).$(PLUS_ICON_SELECTOR).hover().click();
    $(TODAY_DAY_LOCATOR).$(FULL_ADD_LINK_SELECTOR).shouldBe(visible).hover().click();
  }

  @Step("Выбрать тип активности при быстром добавлении")
  public void selectActivityType(AddWorkout quickWorkout) {
    $(ACTIVITY_TYPE_DROPDOWN_SELECTOR).selectOption(quickWorkout.getActivityType());
  }

  @Step("Проверить отображение тренировки в календаре")
  public boolean isWorkoutDisplayed() {
    return $(TODAY_DAY_LOCATOR).$(DAY_CONTENT_LOCATOR).$(EVENT_ACTIVITY_TITLE_LOCATOR)
        .isDisplayed();
  }

  @Step("Получить текст ошибки типа активности")
  public String getActivityTypeErrorMessage() {
    return $(ERROR_ALERT_LOCATOR).getText();
  }

  @Step("Редактировать тренировку")
  public void editWorkout() {
    $(EVENT_ACTIVITY_TITLE_LOCATOR).click();
    $(FULL_VIEW_LINK_LOCATOR).click();
  }

  @Step("Установить дату тренировки")
  public void setWorkoutDate(int daysOffset) {
    LocalDate targetDate = LocalDate.now().plusDays(daysOffset);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
    String formattedDate = targetDate.format(formatter);
    $(WORKOUT_DATE_INPUT_SELECTOR).setValue(formattedDate);
  }

  @Step("Нажать кнопку 'Загрузить тренировку'")
  public void clickUploadWorkoutButton() {
    $(TODAY_DAY_LOCATOR).$(QUICK_UPLOAD_LINK_LOCATOR).click();
  }

  @Step("Загрузить файл тренировки")
  public void uploadWorkoutFile(String relativePathToFile, String Workout) {
    switchTo().frame($(WORKOUT_UPLOAD_IFRAME_SELECTOR));
    $(SAVE_WORKOUT_BUTTON_SELECTOR).shouldHave(clickable);
    $(WORKOUT_NAME_INPUT_SELECTOR).setValue(Workout);
    String pathToFile = System.getProperty("user.dir") + File.separator + relativePathToFile;
    File fileUpload = new File(pathToFile);
    $(FILE_INPUT_LOCATOR).uploadFile(fileUpload);
    $(SAVE_WORKOUT_BUTTON_SELECTOR).click();
    switchTo().defaultContent();
  }

  @Step("Проверить доступность кнопки скачивания")
  public void verifyDownloadButtonClickable() {
    $(DOWNLOAD_BUTTON_LOCATOR).shouldBe(clickable);
  }

  @Step("Скачать файл тренировки")
  public String downloadWorkoutFile() {
    File downloadedFile = $(DOWNLOAD_BUTTON_LOCATOR).download();
    return downloadedFile.getName();
  }
}


