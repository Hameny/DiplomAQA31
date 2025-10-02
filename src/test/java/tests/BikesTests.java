package tests;

import static org.testng.Assert.assertEquals;

import dto.AddBikes;
import org.testng.annotations.Test;

public class BikesTests extends BaseTest {

  private static final String ERROR = "This field is required.";

  @Test(description = "Проверка добавления велосипеда",
      groups = {"regression", "smoke", "LoginWithSuccessLogin"})
  public void positiveAddBikeTest() {
    AddBikes quickAddBike = AddBikes.builder()
        .bikeName("Bike for ride")
        .build();
    calendarPage.isOpen();
    bikesPage.navigateToBikesPage()
        .isOpen()
        .fillBasicBikesInfo(quickAddBike)
        .clickAddBikesButton();
    AddBikes actualAddBikes = bikesPage.getBikesNameFromPage();
    bikesPage.waitForBikesPageLoad();
    assertEquals(actualAddBikes.getBikeName(), quickAddBike.getBikeName(),
        "Название велосипеда не совпадает с ожидаемым");
    shoesPage.clickEditShoesButton();
  }

  @Test(groups = {"regression", "smoke", "LoginWithSuccessLogin"})
  public void negativeAddBikesTest() {
    calendarPage.isOpen();
    bikesPage.navigateToBikesPage()
        .isOpen()
        .clickAddBikesButton();
    assertEquals(bikesPage.getValidationError(), ERROR, "Ошибка не совпадает");
  }
}