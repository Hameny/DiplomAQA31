package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

import io.qameta.allure.Step;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;

public class ReportPage extends BasePage {

  private static final String VIEW_REPORT_BUTTON_SELECTOR = "#saveButton";
  private static final String ZONE_REPORT_LINK_SELECTOR = ("a[href='WorkoutZoneReport']");
  private static final String WORKOUT_START_DATE_INPUT_SELECTOR = "#WorkoutDate";
  private static final String WORKOUT_END_DATE_INPUT_SELECTOR = "#WorkoutDateEnd";
  private static final String ERROR_ALERT_SELECTOR = ".alert.alert-error";
  private static final By ACTIVITY_TYPE_CELL_LOCATOR = By.xpath("//table//tr[1]//td[2]");
  private static final String DATE_PATTERN = "M/dd/yyyy";

  @Override
  public void isOpen() {
    $(VIEW_REPORT_BUTTON_SELECTOR).shouldBe(clickable);
  }

  @Step("Установить дату в поле")
  private void setDateField(int daysOffset, String selector) {
    LocalDate targetDate = LocalDate.now().plusDays(daysOffset);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
    String formattedDate = targetDate.format(formatter);
    $(selector).setValue(formattedDate);
  }

  @Step("Установить начальную дату тренировки")
  public void setWorkoutStartDate(int daysOffsetFromToday) {
    setDateField(daysOffsetFromToday, WORKOUT_START_DATE_INPUT_SELECTOR);
  }

  @Step("Установить конечную дату тренировки")
  public void setWorkoutEndDate(int daysOffsetFromToday) {
    setDateField(daysOffsetFromToday, WORKOUT_END_DATE_INPUT_SELECTOR);
  }

  @Step("Нажать кнопку 'Просмотреть отчет'")
  public void clickViewReportButton() {
    $(VIEW_REPORT_BUTTON_SELECTOR).click();
  }

  @Step("Нажать ссылку 'Отчет по зонам'")
  public void clickZoneReportLink() {
    $(ZONE_REPORT_LINK_SELECTOR).click();
  }

  @Step("Проверить отображение отчета")
  public boolean isReportDisplayed() {
    return $(ACTIVITY_TYPE_CELL_LOCATOR).$(By.partialLinkText("Walk")).isDisplayed();
  }

  @Step("Получить текст ошибки")
  public String getErrorMessage() {
    return $(ERROR_ALERT_SELECTOR).getText();
  }
}