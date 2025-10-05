package tests;

import static com.codeborne.selenide.Selenide.switchTo;
import static org.testng.Assert.assertTrue;

import dto.AddWorkout;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReportTests extends BaseTest {

  private static final String ERROR_MESSAGE =
      "×\n" + "Please fix the following errors:\n" + "*Please select a valid Activity Zone Type.";

  @Test(groups = {"LoginWithSuccessLogin", "regression", "smoke", "workoutDelete"})
  public void positiveViewWorkoutReport() {
    AddWorkout quickWorkout = AddWorkout.builder()
        .activityType("Walk")
        .build();
    dashboardPage.clickCalendarMenu();
    calendarPage.isOpen()
        .clickQuickAddToggle()
        .selectActivityType(quickWorkout)
        .clickSaveWorkoutButton();
    dashboardPage.clickWorkoutReportPage();
    reportPage.isOpen()
        .setWorkoutStartDate(-1)
        .setWorkoutEndDate(1)
        .clickViewReportButton();
    assertTrue(reportPage.isReportDisplayed());
    dashboardPage.clickWorkoutDetailsLink();
    switchTo().window(1);
    workoutDetailsPage.isOpen();
  }

  @Test(groups = {"LoginWithSuccessLogin", "regression"})
  public void negativeViewZoneReport() {
    dashboardPage.clickWorkoutReportPage();
    reportPage.isOpen()
        .clickZoneReportLink()
        .setWorkoutStartDate(-1)
        .setWorkoutEndDate(1)
        .clickViewReportButton();
    Assert.assertEquals(reportPage.getErrorMessage(), ERROR_MESSAGE,
        "Сообщение об ошибке не совпадает с ожидаемым");
  }
}
