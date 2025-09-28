package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

  private static final By DASHBOARD_MENU_BUTTON_LOCATOR = By.cssSelector(
      "a[href='Default.cshtml'].ptip_s");
  private static final By CALENDAR_MENU_BUTTON_LOCATOR = By.cssSelector(
      "a[href='Calendar.cshtml'].ptip_s");
  private static final By LOGOUT_BUTTON_LOCATOR = By.cssSelector("a[href='logout.cshtml']");
  private static final By CALCULATOR_MENU_BUTTON_LOCATOR = By.cssSelector("a[href='#'].ptip_s");
  private static final By WORKOUT_REPORT_MENU_BUTTON_LOCATOR = By.cssSelector(
      "a[href='WorkoutReport.cshtml'].ptip_s");
  private static final String ADD_WORKOUT_BUTTON_SELECTOR = "#workout-add";
  private static final String UPCOMING_WORKOUTS_HEADER_SELECTOR = ".w-box-header";
  private static final String WORKOUT_DETAILS_TEXT_SELECTOR = ".dont-break-out";
  private static final String PAST_WORKOUTS_DETAILS_SELECTOR = ".minor";
  private static final By WORKOUT_DETAILS_LINK_LOCATOR = By.cssSelector(
      "a[href^='WorkoutDetails.cshtml?id='");
  private static final By PAST_WORKOUTS_SECTION_LOCATOR = By.cssSelector(
      "div[data-label='past-workouts']");
  private static final By UPCOMING_WORKOUTS_SECTION_LOCATOR = By.cssSelector(
      ".w-box.w-box-green.hideable");

  @Override
  public void isOpen() {
    $(ADD_WORKOUT_BUTTON_SELECTOR).shouldBe(clickable);
  }

  @Step("Открыть страницу 'Календарь'")
  public void clickCalendarMenu() {
    $(CALENDAR_MENU_BUTTON_LOCATOR).click();
  }

  @Step("Открыть страницу 'Калькулятор'")
  public void clickCalculatorMenu() {
    $(CALCULATOR_MENU_BUTTON_LOCATOR).click();
  }

  @Step("Открыть домашнюю страницу")
  public void clickDashboardMenu2() {
    $(DASHBOARD_MENU_BUTTON_LOCATOR).click();
  }

  @Step("Открыть страницу 'Отчёты'")
  public void clickWorkoutReportPage() {
    $(WORKOUT_REPORT_MENU_BUTTON_LOCATOR).click();
  }

  @Step("Открыть страницу 'Отчёты'")
  public void clickDashboardMenu() {
    $(UPCOMING_WORKOUTS_SECTION_LOCATOR).$(UPCOMING_WORKOUTS_HEADER_SELECTOR).click();
  }

  @Step("Открыть раздел 'Предстоящие тренировки'")
  public boolean isUpcomingWorkoutsDisplayed() {
    return $(UPCOMING_WORKOUTS_SECTION_LOCATOR).$(WORKOUT_DETAILS_TEXT_SELECTOR).exists();
  }

  @Step("Проверить наличие предстоящих тренировок")
  public void clickWorkoutDetailsLink() {
    $(WORKOUT_DETAILS_LINK_LOCATOR).click();
  }

  @Step("Открыть раздел 'Прошедшие тренировки'")
  public void clickPastWorkoutsSection() {
    $(PAST_WORKOUTS_SECTION_LOCATOR).click();
  }

  @Step("Проверить наличие прошедших тренировок")
  public boolean isPastWorkoutsDisplayed() {
    return $(PAST_WORKOUTS_SECTION_LOCATOR).$(WORKOUT_DETAILS_TEXT_SELECTOR).exists();
  }

  @Step("Получить текст деталей прошедшей тренировки")
  public String getPastWorkoutDetailsText() {
    return $(PAST_WORKOUTS_SECTION_LOCATOR).$(PAST_WORKOUTS_DETAILS_SELECTOR).getText();
  }

  @Step("Выйти из приложения")
  public void clickLogoutButton() {
    $(LOGOUT_BUTTON_LOCATOR).click();
  }
}