package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;

import io.qameta.allure.Step;
import dto.AddShoes;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class ShoesPage{

  private static final By ADD_SHOES_BUTTON = By.cssSelector("#saveButton");
  private static final By SHOES_PAGE = By.cssSelector("a[href='EquipmentShoes.cshtml']");
  private static final By EQUIPMENT_PAGE = By.cssSelector("a[href='Equipment.cshtml']");
  private static final By EDIT_SHOES_BUTTON = By.cssSelector(".btn.btn-mini");
  private static final By DELETE_SHOES_BUTTON = By.id("del-shoe");
  private static final String ADD_SHOES_NAME = "#ShoeName";
  private static final By CONFIRMATION_MODAL = By.cssSelector(".modal-footer");
  private static final By CONFIRM_DELETE_BUTTON = By.cssSelector("a:nth-of-type(1)");
  private static final By CALENDAR_DAY_CONTENT = By.cssSelector(".fc-day-content");
  private static final By ACTIVITY_TITLE = By.cssSelector(".fc-event-activity-title");
  private static final By SHOES_INFO_TABLE_CELL = By.xpath("//table//tr//td[2]");
  private static final String ERROR_MESSAGE = ".error";
  private static final String BRAND_DROPDOWN_TOGGLE = "#s2id_ShoeBrand";
  private static final String SHOES_BRAND_SELECT = "#ShoeBrand";
  private static final String SHOES_MODEL_INPUT = "#ShoeModel";
  private static final String SHOES_COST_INPUT = "#ShoeCost";
  private static final String SHOES_PURCHASE_DATE_INPUT = "#ShoeDate";
  private static final String SHOES_SIZE_SELECT = "#ShoeSize";
  private static final String START_DISTANCE_INPUT = "#StartDist";
  private static final String DIST_TYPE_SELECT = "#DistType";
  private static final String DIST_ALERT_INPUT = "#DistAlert";
  private static final String DIST_DISTANCE_TYPE_SELECT = "#DistAlertType";

  @Step("Page is open")
  public ShoesPage isOpen() {
    log.info("Page is open");
    $(ADD_SHOES_BUTTON).shouldBe(clickable);
    return this;
  }

  @Step("Перейти на страницу с обувью")
  public ShoesPage navigateToShoesPage() {
    log.info("Перейти на страницу с обувью");
    $(EQUIPMENT_PAGE).hover();
    $(SHOES_PAGE).click();
    return this;
  }

  @Step("Нажать кнопку добавления обуви")
  public ShoesPage clickAddShoesButton() {
    log.info("Нажать кнопку добавления обуви");
    $(ADD_SHOES_BUTTON).click();
    return this;
  }

  @Step("Получить сообщение об ошибке валидации")
  public String getValidationError() {
    log.info("Получить сообщение об ошибке валидации");
    return $(ERROR_MESSAGE).getText();
  }

  @Step("Нажать кнопку редактирования обуви")
  public ShoesPage clickEditShoesButton() {
    log.info("Нажать кнопку редактирования обуви");
    $(EDIT_SHOES_BUTTON).click();
    return this;
  }

  @Step("Дождаться загрузки страницы обуви")
  public ShoesPage waitForShoesPageLoad() {
    log.info("Дождаться загрузки страницы обуви");
    $(EDIT_SHOES_BUTTON).shouldBe(clickable);
    return this;
  }

  @Step("Нажать кнопку удаления обуви")
  public ShoesPage clickDeleteShoesButton() {
    log.info("Нажать кнопку удаления обуви");
    $(DELETE_SHOES_BUTTON).click();
    return this;
  }

  @Step("Заполнить основную информацию об обуви")
  public ShoesPage fillBasicShoesInfo(AddShoes quickAddshoes) {
    log.info("Заполнить основную информацию об обуви");
    $(ADD_SHOES_NAME).setValue(quickAddshoes.getShoeName());
    return this;
  }

  @Step("Получить название обуви со страницы")
  public AddShoes getShoesNameFromPage() {
    log.info("Получить название обуви со страницы");
    String shoesNameFromPage = $(SHOES_INFO_TABLE_CELL).getText();
    return  AddShoes.builder()
        .shoeName(shoesNameFromPage)
        .build();
  }

  @Step("Удалить обувь с подтверждением")
  public ShoesPage deleteShoesWithConfirmation() {
    log.info("Удалить обувь с подтверждением");
    clickDeleteShoesButton();
    $(CONFIRMATION_MODAL).$(CONFIRM_DELETE_BUTTON).click();
    $(CALENDAR_DAY_CONTENT).$(ACTIVITY_TITLE).shouldBe(disappear);
    return this;
  }

  @Step("Заполнить детальную информацию об обуви")
  public ShoesPage fillDetailedShoesInfo(AddShoes editAddshoes) {
    log.info("Заполнить детальную информацию об обуви");
    $(BRAND_DROPDOWN_TOGGLE).click();
    $(SHOES_BRAND_SELECT).selectOption(editAddshoes.getBrand());
    $(SHOES_MODEL_INPUT).setValue(editAddshoes.getModel());
    $(SHOES_COST_INPUT).setValue(editAddshoes.getCost());
    $(SHOES_PURCHASE_DATE_INPUT).setValue(editAddshoes.getDatePurchased());
    $(SHOES_SIZE_SELECT).selectOption(editAddshoes.getSize());
    $(START_DISTANCE_INPUT).setValue(editAddshoes.getStartDistance());
    $(DIST_TYPE_SELECT).selectOption(editAddshoes.getStartDistanceType());
    $(DIST_ALERT_INPUT).setValue(editAddshoes.getAlertDistance());
    $(DIST_DISTANCE_TYPE_SELECT).selectOption(editAddshoes.getAlertDistanceType());
    return this;
  }

  @Step("Получить полную информацию об обуви со страницы")
  public AddShoes getCompleteShoesInfoFromPage() {
    log.info("Получить полную информацию об обуви со страницы");
    AddShoes resultAddShoes =  AddShoes.builder()
        .brand($(SHOES_BRAND_SELECT).getText())
        .model($(SHOES_MODEL_INPUT).getValue())
        .cost($(SHOES_COST_INPUT).getValue())
        .datePurchased($(SHOES_PURCHASE_DATE_INPUT).getValue())
        .size($(SHOES_SIZE_SELECT).getText())
        .startDistance($(START_DISTANCE_INPUT).getValue())
        .startDistanceType($(DIST_TYPE_SELECT).getText())
        .alertDistance($(DIST_ALERT_INPUT).getValue())
        .alertDistanceType($(DIST_DISTANCE_TYPE_SELECT).getText())
        .build();
    return resultAddShoes;
  }
}