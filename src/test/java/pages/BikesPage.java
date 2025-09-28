package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import dto.AddBikes;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class BikesPage extends BasePage {
  private static final By ADD_BIKES_BUTTON = By.cssSelector("#saveButton");
  private static final By BIKES_PAGE_LINK = By.cssSelector("a[href='EquipmentBikes.cshtml']");
  private static final By EQUIPMENT_PAGE_LINK = By.cssSelector("a[href='Equipment.cshtml']");
  private static final By EDIT_BIKES_BUTTON = By.cssSelector(".btn.btn-mini");
  private static final By DELETE_BIKES_BUTTON = By.xpath("//a[@id='del-shoe2']");
  private static final By OK_BUTTON = By.xpath("//a[text()='OK']");
  private static final String ADD_BIKES_NAME = "#ShoeName";
  private static final String ERROR_MESSAGE = ".error";
  private static final By ACTUAL_BIKE_BRAND = By.xpath("//a[@class='select2-choice']/span");
  private static final By ACTUAL_BIKE_MODEL = By.id("ShoeModel");
  private static final By ACTUAL_BIKE_COST = By.id("ShoeCost");
  private static final By ACTUAL_DATE = By.id("ShoeDate");
  private static final By ACTUAL_STARTING_DISTANCE = By.id("StartDist");
  private static final By ACTUAL_NOTES = By.id("ShoeNotes");
  private static final By NO_BIKES_TEXT = By.xpath("//div[@class='hero-unit']/p[1]");
  private static final By EDIT_BUTTON = By.cssSelector(".edit-button"); // Предположим селектор для кнопки редактирования
  private static final By DELETE_BUTTON = By.cssSelector(".delete-button"); // Предположим селектор для кнопки удаления
  private static final By BIKES_INFO_TABLE_CELL = By.xpath("//table//tr//td[2]");


  @Override
  public void isOpen() {
    $(ADD_BIKES_BUTTON).shouldBe(visible);
  }

  @Step("Перейти на страницу с велосипедами")
  public void navigateToBikesPage() {
    $(EQUIPMENT_PAGE_LINK).hover();
    $(BIKES_PAGE_LINK).click();
  }

  @Step("Нажать кнопку добавления велосипеда")
  public void clickAddBikesButton() {
    $(ADD_BIKES_BUTTON).click();
  }

  @Step("Нажать кнопку редактирования велосипеда")
  public void clickEditShoesButton() {
    $(EDIT_BIKES_BUTTON).click();
  }

  @Step("Дождаться загрузки страницы велосипеда")
  public void waitForBikesPageLoad() {
    $(EDIT_BIKES_BUTTON).shouldBe(visible);
  }

  @Step("Нажать кнопку удаления велосипеда")
  public void clickDeleteBikesButton() {
    $(DELETE_BIKES_BUTTON).click();
  }

  @Step("Заполнить основную информацию об велосипеде")
  public void fillBasicBikesInfo(AddBikes quickAddBikes) {
    $(ADD_BIKES_NAME).setValue(quickAddBikes.getBikeName());
  }

  @Step("Получить название добавленного велосипеда")
  public String getActualName() {
    return $(By.id("ShoeName")).getAttribute("value");
  }

  @Step("Получить название обуви со страницы")
  public AddBikes getBikesNameFromPage() {
    String shoesNameFromPage = $(BIKES_INFO_TABLE_CELL).getText();
    return new AddBikes.AddBikeBuilder()
        .setBikeName(shoesNameFromPage)
        .build();
  }

  @Step("Получить сообщение об ошибке валидации")
  public String getValidationError() {
    return $(ERROR_MESSAGE).getText();
  }

  @Step("Получить бренд добавленного велосипеда")
  public String getActualBrand() {
    return $(ACTUAL_BIKE_BRAND).getText();
  }

  @Step("Получить модель добавленного велосипеда")
  public String getActualModel() {
    return $(ACTUAL_BIKE_MODEL).getAttribute("value");
  }

  @Step("Получить стоимость добавленного велосипеда")
  public String getActualCost() {
    return $(ACTUAL_BIKE_COST).getAttribute("value");
  }

  @Step("Получить дату покупки")
  public String getActualDate() {
    return $(ACTUAL_DATE).getAttribute("value");
  }

  @Step("Получить начальную дистанцию")
  public String getActualDistance() {
    return $(ACTUAL_STARTING_DISTANCE).getAttribute("value");
  }

  @Step("Получить заметки о велосипеде")
  public String getActualNotes() {
    return $(ACTUAL_NOTES).getAttribute("value");
  }

  @Step("Нажать кнопку 'Редактировать'")
  public void clickEditButton() {
    $(EDIT_BUTTON).click();
  }

  @Step("Нажать кнопку 'Удалить'")
  public void clickDeleteButton() {
    $(DELETE_BUTTON).click();
  }

  @Step("Нажать кнопку 'OK'")
  public void clickOKButton() {
    $(OK_BUTTON).click();
  }

  @Step("Ожидание появления кнопки 'OK' в модальном окне")
  public void waitForOKButtonIsVisible() {
    $(OK_BUTTON).shouldBe(visible);
  }

  @Step("Получить текст о отсутствии текущих велосипедов")
  public String getNoBikesText() {
    return $(NO_BIKES_TEXT).getText();
  }
}
