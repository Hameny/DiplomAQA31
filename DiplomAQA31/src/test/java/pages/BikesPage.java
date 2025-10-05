package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import dto.AddBikes;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class BikesPage{

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

  @Step("Открыть страницу")
  public BikesPage isOpen() {
    log.info("Page is open");
    $(ADD_BIKES_BUTTON).shouldBe(visible);
    return this;
  }

  @Step("Перейти на страницу с велосипедами")
  public BikesPage navigateToBikesPage() {
    log.info("Перейти на страницу с велосипедами");
    $(EQUIPMENT_PAGE_LINK).hover();
    $(BIKES_PAGE_LINK).click();
    return this;
  }

  @Step("Нажать кнопку добавления велосипеда")
  public BikesPage clickAddBikesButton() {
    log.info("Нажать кнопку добавления велосипеда");
    $(ADD_BIKES_BUTTON).click();
    return this;
  }

  @Step("Нажать кнопку редактирования велосипеда")
  public BikesPage clickEditShoesButton() {
    log.info("Нажать кнопку редактирования велосипеда");
    $(EDIT_BIKES_BUTTON).click();
    return this;
  }

  @Step("Дождаться загрузки страницы велосипеда")
  public BikesPage waitForBikesPageLoad() {
    log.info("Дождаться загрузки страницы велосипеда");
    $(EDIT_BIKES_BUTTON).shouldBe(visible);
    return this;
  }

  @Step("Нажать кнопку удаления велосипеда")
  public BikesPage clickDeleteBikesButton() {
    log.info("Нажать кнопку удаления велосипеда");
    $(DELETE_BIKES_BUTTON).click();
    return this;
  }

  @Step("Заполнить основную информацию об велосипеде")
  public BikesPage fillBasicBikesInfo(AddBikes quickAddBikes) {
    log.info("Заполнить основную информацию об велосипеде");
    $(ADD_BIKES_NAME).setValue(quickAddBikes.getBikeName());
    return this;
  }

  @Step("Получить название добавленного велосипеда")
  public String getActualName() {
    log.info("Получить название добавленного велосипеда");
    return $(By.id("ShoeName")).getAttribute("value");
  }

  @Step("Получить название велосипеда со страницы")
  public AddBikes getBikesNameFromPage() {
    log.info("Получить название велосипеда со страницы");
    String bikesNameFromPage = $(BIKES_INFO_TABLE_CELL).getText();
    return AddBikes.builder()
        .bikeName(bikesNameFromPage)
        .build();
  }

  @Step("Получить сообщение об ошибке валидации")
  public String getValidationError() {
    log.info("Получить сообщение об ошибке валидации");
    return $(ERROR_MESSAGE).getText();
  }

  @Step("Получить бренд добавленного велосипеда")
  public String getActualBrand() {
    log.info("Получить бренд добавленного велосипеда");
    return $(ACTUAL_BIKE_BRAND).getText();
  }

  @Step("Получить модель добавленного велосипеда")
  public String getActualModel() {
    log.info("Получить модель добавленного велосипеда");
    return $(ACTUAL_BIKE_MODEL).getAttribute("value");
  }

  @Step("Получить стоимость добавленного велосипеда")
  public String getActualCost() {
    log.info("Получить стоимость добавленного велосипеда");
    return $(ACTUAL_BIKE_COST).getAttribute("value");
  }

  @Step("Получить дату покупки")
  public String getActualDate() {
    log.info("Получить дату покупки");
    return $(ACTUAL_DATE).getAttribute("value");
  }

  @Step("Получить начальную дистанцию")
  public String getActualDistance() {
    log.info("Получить начальную дистанцию");
    return $(ACTUAL_STARTING_DISTANCE).getAttribute("value");
  }

  @Step("Получить заметки о велосипеде")
  public String getActualNotes() {
    log.info("Получить заметки о велосипеде");
    return $(ACTUAL_NOTES).getAttribute("value");
  }

  @Step("Нажать кнопку 'Редактировать'")
  public BikesPage clickEditButton() {
    log.info("Нажать кнопку 'Редактировать'");
    $(EDIT_BUTTON).click();
    return this;
  }

  @Step("Нажать кнопку 'Удалить'")
  public BikesPage clickDeleteButton() {
    log.info("Нажать кнопку 'Удалить'");
    $(DELETE_BUTTON).click();
    return this;
  }

  @Step("Нажать кнопку 'OK'")
  public BikesPage clickOKButton() {
    log.info("Нажать кнопку 'OK'");
    $(OK_BUTTON).click();
    return this;
  }

  @Step("Ожидание появления кнопки 'OK' в модальном окне")
  public BikesPage waitForOKButtonIsVisible() {
    log.info("Ожидание появления кнопки 'OK' в модальном окне");
    $(OK_BUTTON).shouldBe(visible);
    return this;
  }

  @Step("Получить текст о отсутствии текущих велосипедов")
  public String getNoBikesText() {
    log.info("Получить текст о отсутствии текущих велосипедов");
    return $(NO_BIKES_TEXT).getText();
  }
}
