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
    AddWorkout quickWorkout = AddWorkout.builder()
        .activityType("Run")
        .build();
    dashboardPage.clickCalendarMenu();
    calendarPage.isOpen()
        .clickQuickAddToggle()
        .selectActivityType(quickWorkout)
        .clickSaveWorkoutButton();
    assertTrue(calendarPage.isWorkoutDisplayed(),"Тренировка не отображается в календаре");
  }

  @Test(groups = {"LoginWithSuccessLogin", "regression"})
  public void negativeAddQuickWorkout() {
    dashboardPage.clickCalendarMenu();
    calendarPage.isOpen()
        .clickQuickAddToggle()
        .clickSaveWorkoutButton();
    assertEquals(calendarPage.getActivityTypeErrorMessage(), ACTIVITY_TYPE_ERROR,"Сообщение об ошибке не совпадает с ожидаемым");
  }

  @Test(groups = {"LoginWithSuccessLogin", "regression", "smoke", "workoutDeleteToday"})
  public void addFullFromCalendar() {
    AddWorkout fullWorkout = AddWorkout.builder()
        .name("morning run")
        .build();
    dashboardPage.clickCalendarMenu();
    calendarPage.isOpen()
        .clickFullWorkoutFromCalendar();
    addWorkoutPage.selectActivityType("run", "Long Run")
        .addWorkoutName(fullWorkout)
        .clickSaveWorkoutButton();
    assertEquals(addWorkoutPage.getWorkoutNameText(), fullWorkout.getName(),"Наименование не совпадает с ожидаемым");
    dashboardPage.clickCalendarMenu();
  }

  @Test(groups = {"LoginWithSuccessLogin", "regression", "workoutDeleteToday"})
  public void editWorkout() {
    AddWorkout quickWorkout = AddWorkout.builder()
        .activityType("Swim")
        .name("Плавание")
        .build();
    dashboardPage.clickCalendarMenu();
    calendarPage.isOpen()
        .addQuickWorkoutFromCalendar()
        .selectActivityType(quickWorkout)
        .clickSaveWorkoutButton();
    assertTrue(calendarPage.isWorkoutDisplayed());
    calendarPage.editWorkout();
    workoutDetailsPage.isOpen()
        .clickWorkoutActionsDropdown();
    AddWorkout editWorkout = AddWorkout.builder()
        .timeOfDay("9:00 PM")
        .name("Плавание утром")
        .description("Плавание в бассейне")
        .showPlannedDistance(true)
        .distance("1")
        .plannedDistanceType("km")
        .duration("00:50:00")
        .distance("5.100")
        .distanceType("km")
        .duration("00:40:00")
        .paceType("min/km")
        .perceivedEffort("4 (Moderate)")
        .overallFeeling("Good")
        .caloriesBurned("500")
        .saveToLibrary(true)
        .build();
    workoutDetailsPage.fillWorkoutEditDetails(editWorkout);
    workoutDetailsPage.clickSaveUpdatedWorkout();
    workoutDetailsPage.isOpen();
    dashboardPage.clickCalendarMenu();
    assertTrue(calendarPage.isWorkoutDisplayed(), "Тренировка измененная не отображается");
  }

  @Test(groups = {"LoginWithSuccessLogin", "regression", "workoutDelete"})
  public void viewFutureTrainingFromDashboardPage() {
    AddWorkout quickWorkout = AddWorkout.builder()
        .activityType("Bike")
        .build();
    dashboardPage.clickCalendarMenu();
    calendarPage.isOpen()
        .clickQuickAddToggle()
        .setWorkoutDate(1)
        .selectActivityType(quickWorkout)
        .clickSaveWorkoutButton();
    dashboardPage.clickDashboardMenu2()
        .clickDashboardMenu();
    assertTrue(dashboardPage.isUpcomingWorkoutsDisplayed(), "Тренировка не отображается");
    dashboardPage.clickWorkoutDetailsLink();
    workoutDetailsPage.isOpen();
  }

  @Test(groups = {"LoginWithSuccessLogin", "regression"})
  public void viewPastTrainingFromDashboardPage() {
    AddWorkout quickWorkout = AddWorkout.builder()
        .activityType("Walk")
        .build();
    dashboardPage.clickCalendarMenu();
    calendarPage.isOpen()
        .clickQuickAddToggle()
        .setWorkoutDate(-1)
        .selectActivityType(quickWorkout)
        .clickSaveWorkoutButton();
    dashboardPage.clickDashboardMenu2()
        .clickPastWorkoutsSection();
    assertTrue(dashboardPage.isPastWorkoutsDisplayed());
    dashboardPage.clickWorkoutDetailsLink();
    workoutDetailsPage.isOpen()
        .clickWorkoutActionsDropdown();
    addWorkoutPage.deleteWorkout();
    calendarPage.isOpen();
    dashboardPage.clickDashboardMenu2();
    assertEquals(dashboardPage.getPastWorkoutDetailsText(), INFO_FROM_DASHBOARD,
        "Информация не совпадает");
  }

  @Test(groups = {"regression", "smoke", "LoginWithSuccessLogin", "workoutDelete"})
  public void fileUploadTest() {
    calendarPage.isOpen()
        .clickPlusIconInCalendar()
        .clickUploadWorkoutButton()
        .uploadWorkoutFile("src/test/resources/example.tcx", "Upload Workout");
    workoutDetailsPage.isOpen();
    calendarPage.verifyDownloadButtonClickable();
    assertEquals(workoutDetailsPage.getDisplayedWorkoutName(), "Upload Workout");
  }

  @Test(groups = {"regression", "smoke", "LoginWithSuccessLogin", "workoutDelete"})
  public void fileDownloadTest() {
    calendarPage.isOpen()
        .clickPlusIconInCalendar()
        .clickUploadWorkoutButton()
        .uploadWorkoutFile("src/test/resources/example.tcx", "Upload Workout");
    workoutDetailsPage.isOpen();
    String downloadedFileName = calendarPage.downloadWorkoutFile();
    assertTrue(downloadedFileName.endsWith(".tcx"),
        "Имя файла должно начинаться с '.tcx', но было: " + downloadedFileName);
  }
}