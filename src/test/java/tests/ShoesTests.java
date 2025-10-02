package tests;

import static org.testng.Assert.assertEquals;

import dto.AddShoes;
import org.testng.annotations.Test;

public class ShoesTests extends BaseTest {

  private static final String SHOES_ERROR = "This field is required.";

  @Test(groups = {"regression", "smoke", "LoginWithSuccessLogin", "shoesDelete"})
  public void positiveAddShoesTest() {
    AddShoes quickAddshoes = AddShoes.builder()
        .shoeName("New running Adidas shoes")
        .build();
    calendarPage.isOpen();
    shoesPage.navigateToShoesPage()
        .isOpen()
        .fillBasicShoesInfo(quickAddshoes)
        .clickAddShoesButton();
    AddShoes actualAddShoes = shoesPage.getShoesNameFromPage();
    shoesPage.waitForShoesPageLoad();
    assertEquals(actualAddShoes.getShoeName(), quickAddshoes.getShoeName(),
        "Полученное имя обуви не совпадает с ожидаемым");
    shoesPage.clickEditShoesButton();
  }

  @Test(groups = {"regression", "LoginWithSuccessLogin", "shoesDelete"})
  public void positiveEditShoesTest() {
    AddShoes quickAddshoes = AddShoes.builder()
        .shoeName("NEW ADIDAS")
        .build();
    calendarPage.isOpen();
    shoesPage.navigateToShoesPage()
        .isOpen()
        .fillBasicShoesInfo(quickAddshoes)
        .clickAddShoesButton()
        .clickEditShoesButton()
        .isOpen();
    AddShoes editAddshoes = AddShoes.builder()
        .brand("adidas")
        .model("GAZELLE")
        .cost("550.00")
        .datePurchased("9/10/2025")
        .size("13")
        .startDistance("0")
        .startDistanceType("km")
        .alertDistance("500")
        .alertDistanceType("km")
        .build();
    shoesPage.fillDetailedShoesInfo(editAddshoes)
        .clickAddShoesButton()
        .clickEditShoesButton();
    AddShoes actualAddShoes = shoesPage.getCompleteShoesInfoFromPage();
    shoesPage.waitForShoesPageLoad();
    assertEquals(actualAddShoes, editAddshoes,
        "Полученное значение обуви не совпадает с ожидаемым");
  }

  @Test(groups = {"regression", "smoke", "LoginWithSuccessLogin"})
  public void negativeAddShoesTest() {
    calendarPage.isOpen();
    shoesPage.navigateToShoesPage()
        .isOpen()
        .clickAddShoesButton();
    assertEquals(shoesPage.getValidationError(), SHOES_ERROR,
        "Сообщение об ошибке не совпадает с ожидаемым");
  }
}