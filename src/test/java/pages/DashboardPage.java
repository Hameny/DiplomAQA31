package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class DashboardPage{

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

  @Step("Page is open")
  public DashboardPage isOpen() {
    log.info("Page is open");
    $(ADD_WORKOUT_BUTTON_SELECTOR).shouldBe(clickable);
    return this;
  }

  @Step("Открыть страницу 'Календарь'")
  public DashboardPage clickCalendarMenu() {
    log.info("Открыть страницу 'Календарь'");
    $(CALENDAR_MENU_BUTTON_LOCATOR).click();
    return this;
  }

  @Step("Открыть страницу 'Калькулятор'")
  public DashboardPage clickCalculatorMenu() {
    log.info("Открыть страницу 'Калькулятор'");
    $(CALCULATOR_MENU_BUTTON_LOCATOR).click();
    return this;
  }

  @Step("Открыть домашнюю страницу")
  public DashboardPage clickDashboardMenu2() {
    log.info("Открыть домашнюю страницу");
    $(DASHBOARD_MENU_BUTTON_LOCATOR).click();
    return this;
  }

  @Step("Открыть страницу 'Отчёты'")
  public DashboardPage clickWorkoutReportPage() {
    log.info("Открыть страницу 'Отчёты'");
    $(WORKOUT_REPORT_MENU_BUTTON_LOCATOR).click();
    return this;
  }

  @Step("Открыть страницу 'Отчёты'")
  public DashboardPage clickDashboardMenu() {
    log.info("Открыть страницу 'Отчёты'");
    $(UPCOMING_WORKOUTS_SECTION_LOCATOR).$(UPCOMING_WORKOUTS_HEADER_SELECTOR).click();
    return this;
  }

  @Step("Открыть раздел 'Предстоящие тренировки'")
  public boolean isUpcomingWorkoutsDisplayed() {
    log.info("Открыть раздел 'Предстоящие тренировки'");
    return $(UPCOMING_WORKOUTS_SECTION_LOCATOR).$(WORKOUT_DETAILS_TEXT_SELECTOR).exists();
  }

  @Step("Проверить наличие предстоящих тренировок")
  public DashboardPage clickWorkoutDetailsLink() {
    log.info("Проверить наличие предстоящих тренировок");
    $(WORKOUT_DETAILS_LINK_LOCATOR).click();
    return this;
  }

  @Step("Открыть раздел 'Прошедшие тренировки'")
  public DashboardPage clickPastWorkoutsSection() {
    log.info("Открыть раздел 'Прошедшие тренировки'");
    $(PAST_WORKOUTS_SECTION_LOCATOR).click();
    return this;
  }

  @Step("Проверить наличие прошедших тренировок")
  public boolean isPastWorkoutsDisplayed() {
    log.info("Проверить наличие прошедших тренировок");
    return $(PAST_WORKOUTS_SECTION_LOCATOR).$(WORKOUT_DETAILS_TEXT_SELECTOR).exists();
  }

  @Step("Получить текст деталей прошедшей тренировки")
  public String getPastWorkoutDetailsText() {
    log.info("Получить текст деталей прошедшей тренировки");
    return $(PAST_WORKOUTS_SECTION_LOCATOR).$(PAST_WORKOUTS_DETAILS_SELECTOR).getText();
  }

  @Step("Выйти из приложения")
  public DashboardPage clickLogoutButton() {
    log.info("Выйти из приложения");
    $(LOGOUT_BUTTON_LOCATOR).click();
    return this;
  }
}