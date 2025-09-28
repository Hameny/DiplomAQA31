package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import dto.AddWorkout;
import org.testng.annotations.Test;

public class CalendarTests extends BaseTest {

  private static final String ACTIVITY_TYPE_ERROR =
      "×\n" + "Please fix the following errors:\n" + "*Please select a valid Activity Type.";
  private static final String INFO_FROM_DASHBOARD = "You have no past workouts within the last 14 days.";

  @Test(groups = {"LoginWithSuccessLogin", "regression", "smoke", "workoutDeleteToday"})
  public void positiveAddQuickWorkOutTodayByButton() {
    AddWorkout quickWorkout = new AddWorkout.AddWorkoutBuilder()
        .setActivityType("Run")
        .build();
    dashboardPage.clickCalendarMenu();
    calendarPage.isOpen();
    calendarPage.clickQuickAddToggle();
    calendarPage.selectActivityType(quickWorkout);
    calendarPage.clickSaveWorkoutButton();
    assertTrue(calendarPage.isWorkoutDisplayed());
  }

  @Test(groups = {"LoginWithSuccessLogin", "regression"})
  public void negativeAddQuickWorkout() {
    dashboardPage.clickCalendarMenu();
    calendarPage.isOpen();
    calendarPage.clickQuickAddToggle();
    calendarPage.clickSaveWorkoutButton();
    assertEquals(calendarPage.getActivityTypeErrorMessage(), ACTIVITY_TYPE_ERROR);
  }

  @Test(groups = {"LoginWithSuccessLogin", "regression", "smoke", "workoutDeleteToday"})
  public void addFullFromCalendar() {
    AddWorkout fullWorkout = new AddWorkout.AddWorkoutBuilder()
        .setName("morning run")
        .build();
    dashboardPage.clickCalendarMenu();
    calendarPage.isOpen();
    calendarPage.clickFullWorkoutFromCalendar();
    addWorkoutPage.selectActivityType("run", "Long Run");
    addWorkoutPage.addWorkoutName(fullWorkout);
    addWorkoutPage.clickSaveWorkoutButton();
    assertEquals(addWorkoutPage.getWorkoutNameText(), fullWorkout.getName());
    dashboardPage.clickCalendarMenu();
  }

  @Test(groups = {"LoginWithSuccessLogin", "regression", "workoutDeleteToday"})
  public void editWorkout() {
    AddWorkout quickWorkout = new AddWorkout.AddWorkoutBuilder()
        .setActivityType("Swim")
        .setName("Плавание")
        .build();
    dashboardPage.clickCalendarMenu();
    calendarPage.isOpen();
    calendarPage.addQuickWorkoutFromCalendar();
    calendarPage.selectActivityType(quickWorkout);
    calendarPage.clickSaveWorkoutButton();
    assertTrue(calendarPage.isWorkoutDisplayed());
    calendarPage.editWorkout();
    workoutDetailsPage.isOpen();
    workoutDetailsPage.clickWorkoutActionsDropdown();
    AddWorkout editWorkout = new AddWorkout.AddWorkoutBuilder()
        .setTimeOfDay("9:00 PM")
        .setName("Плавание утром")
        .setDescription("Плавание в бассейне")
        .setShowPlannedDistance(true)
        .setpDistance("1")
        .setpDistanceType("km")
        .setpDuration("00:50:00")
        .setDistance("5.100")
        .setDistanceType("km")
        .setDuration("00:40:00")
        .setPaceType("min/km")
        .setPerEffort("4 (Moderate)")
        .setHowFeel("Good")
        .setkCal("500")
        .setSaveToLibrary(true)
        .build();
    workoutDetailsPage.fillWorkoutEditDetails(editWorkout);
    workoutDetailsPage.clickSaveUpdatedWorkout();
    workoutDetailsPage.isOpen();
    dashboardPage.clickCalendarMenu();
    assertTrue(calendarPage.isWorkoutDisplayed());
  }

  @Test(groups = {"LoginWithSuccessLogin", "regression", "workoutDelete"})
  public void viewFutureTrainingFromDashboardPage() {
    AddWorkout quickWorkout = new AddWorkout.AddWorkoutBuilder()
        .setActivityType("Bike")
        .build();
    dashboardPage.clickCalendarMenu();
    calendarPage.isOpen();
    calendarPage.clickQuickAddToggle();
    calendarPage.setWorkoutDate(1);
    calendarPage.selectActivityType(quickWorkout);
    calendarPage.clickSaveWorkoutButton();
    dashboardPage.clickDashboardMenu2();
    dashboardPage.clickDashboardMenu();
    assertTrue(dashboardPage.isUpcomingWorkoutsDisplayed());
    dashboardPage.clickWorkoutDetailsLink();
    workoutDetailsPage.isOpen();
  }

  @Test(groups = {"LoginWithSuccessLogin", "regression"})
  public void viewPastTrainingFromDashboardPage() {
    AddWorkout quickWorkout = new AddWorkout.AddWorkoutBuilder()
        .setActivityType("Walk")
        .build();
    dashboardPage.clickCalendarMenu();
    calendarPage.isOpen();
    calendarPage.clickQuickAddToggle();
    calendarPage.setWorkoutDate(-1);
    calendarPage.selectActivityType(quickWorkout);
    calendarPage.clickSaveWorkoutButton();
    dashboardPage.clickDashboardMenu2();
    dashboardPage.clickPastWorkoutsSection();
    assertTrue(dashboardPage.isPastWorkoutsDisplayed());
    dashboardPage.clickWorkoutDetailsLink();
    workoutDetailsPage.isOpen();
    workoutDetailsPage.clickWorkoutActionsDropdown();
    addWorkoutPage.deleteWorkout();
    calendarPage.isOpen();
    dashboardPage.clickDashboardMenu2();
    assertEquals(dashboardPage.getPastWorkoutDetailsText(), INFO_FROM_DASHBOARD);
  }

  @Test(groups = {"regression", "smoke", "LoginWithSuccessLogin", "workoutDelete"})
  public void fileUploadTest() {
    calendarPage.isOpen();
    calendarPage.clickPlusIconInCalendar();
    calendarPage.clickUploadWorkoutButton();
    calendarPage.uploadWorkoutFile("src/test/resources/example.tcx", "Upload Workout");
    workoutDetailsPage.isOpen();
    calendarPage.verifyDownloadButtonClickable();
    assertEquals(workoutDetailsPage.getDisplayedWorkoutName(), "Upload Workout");
  }

  @Test(groups = {"regression", "smoke", "LoginWithSuccessLogin", "workoutDelete"})
  public void fileDownloadTest() {
    calendarPage.isOpen();
    calendarPage.clickPlusIconInCalendar();
    calendarPage.clickUploadWorkoutButton();
    calendarPage.uploadWorkoutFile("src/test/resources/example.tcx", "Upload Workout");
    workoutDetailsPage.isOpen();
    String downloadedFileName = calendarPage.downloadWorkoutFile();
    assertTrue(downloadedFileName.endsWith(".tcx"),
        "Имя файла должно начинаться с '.tcx', но было: " + downloadedFileName);
  }
}