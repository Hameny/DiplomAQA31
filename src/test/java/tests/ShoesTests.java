package tests;

import static org.testng.Assert.assertEquals;

import dto.AddShoes;
import org.testng.annotations.Test;

public class ShoesTests extends BaseTest {

  private static final String SHOES_ERROR = "This field is required.";

  @Test(groups = {"regression", "smoke", "LoginWithSuccessLogin", "shoesDelete"})
  public void positiveAddShoesTest() {
    AddShoes quickAddshoes = new AddShoes.AddShoesBuilder()
        .setShoeName("New running Adidas shoes")
        .build();
    calendarPage.isOpen();
    shoesPage.navigateToShoesPage();
    shoesPage.isOpen();
    shoesPage.fillBasicShoesInfo(quickAddshoes);
    shoesPage.clickAddShoesButton();
    AddShoes actualAddShoes = shoesPage.getShoesNameFromPage();
    shoesPage.waitForShoesPageLoad();
    assertEquals(actualAddShoes.getShoesName(), quickAddshoes.getShoesName(),
        "Имя обуви не совпадает с ожидаемым");
    shoesPage.clickEditShoesButton();
  }

  @Test(groups = {"regression", "LoginWithSuccessLogin", "shoesDelete"})
  public void positiveEditShoesTest() {
    AddShoes quickAddshoes = new AddShoes.AddShoesBuilder()
        .setShoeName("NEW ADIDAS")
        .build();
    calendarPage.isOpen();
    shoesPage.navigateToShoesPage();
    shoesPage.isOpen();
    shoesPage.fillBasicShoesInfo(quickAddshoes);
    shoesPage.clickAddShoesButton();
    shoesPage.clickEditShoesButton();
    shoesPage.isOpen();
    AddShoes editAddshoes = new AddShoes.AddShoesBuilder()
        .setBrand("adidas")
        .setModel("GAZELLE")
        .setCost("550.00")
        .setDatePurchased("9/10/2025")
        .setSize("13")
        .setStartDistance("0")
        .setStartDistancetype("km")
        .setAlertDistance("500")
        .setAlertDistancetype("km")
        .build();
    shoesPage.fillDetailedShoesInfo(editAddshoes);
    shoesPage.clickAddShoesButton();
    shoesPage.clickEditShoesButton();
    AddShoes actualAddShoes = shoesPage.getCompleteShoesInfoFromPage();
    shoesPage.waitForShoesPageLoad();
    assertEquals(actualAddShoes, editAddshoes, "значения не совпадают с ожидаемым");
  }

  @Test(groups = {"regression", "smoke", "LoginWithSuccessLogin"})
  public void negativeAddShoesTest() {
    calendarPage.isOpen();
    shoesPage.navigateToShoesPage();
    shoesPage.isOpen();
    shoesPage.clickAddShoesButton();
    assertEquals(shoesPage.getValidationError(), SHOES_ERROR);
  }
}