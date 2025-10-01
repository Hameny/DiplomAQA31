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
    AddWorkout quickWorkout =  AddWorkout.builder()
        .activityType("Walk")
        .build();
    dashboardPage.clickCalendarMenu();
    calendarPage.isOpen();
    calendarPage.clickQuickAddToggle();
    calendarPage.selectActivityType(quickWorkout);
    calendarPage.clickSaveWorkoutButton();
    dashboardPage.clickWorkoutReportPage();
    reportPage.isOpen();
    reportPage.setWorkoutStartDate(-1);
    reportPage.setWorkoutEndDate(1);
    reportPage.clickViewReportButton();
    assertTrue(reportPage.isReportDisplayed());
    dashboardPage.clickWorkoutDetailsLink();
    switchTo().window(1);
    workoutDetailsPage.isOpen();
  }

  @Test(groups = {"LoginWithSuccessLogin", "regression"})
  public void negativeViewZoneReport() {
    dashboardPage.clickWorkoutReportPage();
    reportPage.isOpen();
    reportPage.clickZoneReportLink();
    reportPage.setWorkoutStartDate(-1);
    reportPage.setWorkoutEndDate(1);
    reportPage.clickViewReportButton();
    Assert.assertEquals(reportPage.getErrorMessage(), ERROR_MESSAGE);
  }
}
