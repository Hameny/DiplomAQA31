package pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;

import io.qameta.allure.Step;
import dto.AddShoes;
import org.openqa.selenium.By;

public class ShoesPage extends BasePage {

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

  @Override
  public void isOpen() {
    $(ADD_SHOES_BUTTON).shouldBe(clickable);
  }

  @Step("Перейти на страницу с обувью")
  public void navigateToShoesPage() {
    $(EQUIPMENT_PAGE).hover();
    $(SHOES_PAGE).click();
  }

  @Step("Нажать кнопку добавления обуви")
  public void clickAddShoesButton() {
    $(ADD_SHOES_BUTTON).click();
  }

  @Step("Получить сообщение об ошибке валидации")
  public String getValidationError() {
    return $(ERROR_MESSAGE).getText();
  }

  @Step("Нажать кнопку редактирования обуви")
  public void clickEditShoesButton() {
    $(EDIT_SHOES_BUTTON).click();
  }

  @Step("Дождаться загрузки страницы обуви")
  public void waitForShoesPageLoad() {
    $(EDIT_SHOES_BUTTON).shouldBe(clickable);
  }

  @Step("Нажать кнопку удаления обуви")
  public void clickDeleteShoesButton() {
    $(DELETE_SHOES_BUTTON).click();
  }

  @Step("Заполнить основную информацию об обуви")
  public void fillBasicShoesInfo(AddShoes quickAddshoes) {
    $(ADD_SHOES_NAME).setValue(quickAddshoes.getShoeName());
  }

  @Step("Получить название обуви со страницы")
  public AddShoes getShoesNameFromPage() {
    String shoesNameFromPage = $(SHOES_INFO_TABLE_CELL).getText();
    return  AddShoes.builder()
        .shoeName(shoesNameFromPage)
        .build();
  }

  @Step("Удалить обувь с подтверждением")
  public void deleteShoesWithConfirmation() {
    clickDeleteShoesButton();
    $(CONFIRMATION_MODAL).$(CONFIRM_DELETE_BUTTON).click();
    $(CALENDAR_DAY_CONTENT).$(ACTIVITY_TITLE).shouldBe(disappear);
  }

  @Step("Заполнить детальную информацию об обуви")
  public void fillDetailedShoesInfo(AddShoes editAddshoes) {
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
  }

  @Step("Получить полную информацию об обуви со страницы")
  public AddShoes getCompleteShoesInfoFromPage() {
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