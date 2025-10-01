package tests;

import static org.testng.Assert.assertEquals;

import dto.AddBikes;
import org.testng.annotations.Test;

public class BikesTests extends BaseTest {

  private static final String ERROR = "This field is required.";

  @Test(groups = {"regression", "smoke", "LoginWithSuccessLogin"})
  public void positiveAddBikeTest() {
    AddBikes quickAddBike = AddBikes.builder()
        .bikeName("New bike")
        .build();
    calendarPage.isOpen();
    bikesPage.navigateToBikesPage();
    bikesPage.isOpen();
    bikesPage.fillBasicBikesInfo(quickAddBike);
    bikesPage.clickAddBikesButton();
    AddBikes actualAddBikes = bikesPage.getBikesNameFromPage();
    bikesPage.waitForBikesPageLoad();
    assertEquals(actualAddBikes.getBikeName(), quickAddBike.getBikeName(),
        "Имя обуви не совпадает с ожидаемым");
    shoesPage.clickEditShoesButton();
  }

  @Test(groups = {"regression", "smoke", "LoginWithSuccessLogin"})
  public void negativeAddBikesTest() {
    calendarPage.isOpen();
    bikesPage.navigateToBikesPage();
    bikesPage.isOpen();
    bikesPage.clickAddBikesButton();
    assertEquals(bikesPage.getValidationError(), ERROR,"Ошибка не совпадает");
  }
}