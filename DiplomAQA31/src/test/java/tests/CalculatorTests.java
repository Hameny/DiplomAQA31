package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import dto.Calculator;
import org.testng.annotations.Test;

public class CalculatorTests extends BaseTest {

  private static final String INTENSITY_CALC_ERROR_MESSAGE =
      "×\n" + "Please fix the following errors:\n" + "*Please enter an Integer value for Seconds.";

  @Test(groups = {"LoginWithSuccessLogin", "regression", "smoke"})
  public void positiveIntensityTest() {
    Calculator intensityCalc = Calculator.builder()
        .hours("00")
        .minutes("12")
        .seconds("5")
        .build();
    dashboardPage.clickCalculatorMenu();
    calculatorPage.isOpen()
        .selectEventType()
        .enterIntensityCalculationTime(intensityCalc)
        .clickCalculateButton();
    assertTrue(calculatorPage.isWorkoutSplitResultDisplayed(),"Результат не отображается");
  }

  @Test(groups = {"LoginWithSuccessLogin", "regression"})
  public void negativeIntensityTest() {
    Calculator intensityCalc = Calculator.builder()
        .minutes("18")
        .build();
    dashboardPage.clickCalculatorMenu();
    calculatorPage.isOpen()
        .selectEventType()
        .enterIntensityCalculationTime(intensityCalc)
        .clickCalculateButton();
    assertEquals(calculatorPage.getIntensityCalculationErrorMessage(),
        INTENSITY_CALC_ERROR_MESSAGE,"Сообщение не совпадает с ожидаемым");
  }

  @Test(groups = {"LoginWithSuccessLogin", "regression"})
  public void positiveTinmanTest() {
    Calculator intensityCalc = Calculator.builder()
        .hours("00")
        .minutes("16")
        .seconds("23")
        .build();
    dashboardPage.clickCalculatorMenu();
    calculatorPage.isOpen()
        .clickTinmanCalculator()
        .selectTinmanRaceDistance("5 km")
        .enterIntensityCalculationTime(intensityCalc)
        .selectGender()
        .clickCalculateButton();
    assertTrue(calculatorPage.isWorkoutSplitResultDisplayed(),"Результат калькулятора Tinman не отображается");
  }

  @Test(enabled = false, groups = {"LoginWithSuccessLogin"})
  public void defectTinmanTest() {
    Calculator intensityCalc = Calculator.builder()
        .hours("00")
        .minutes("20")
        .build();
    dashboardPage.clickCalculatorMenu();
    calculatorPage.isOpen()
        .clickTinmanCalculator()
        .selectTinmanRaceDistance("5 km")
        .enterIntensityCalculationTime(intensityCalc)
        .selectGender()
        .clickCalculateButton();
    assertEquals(calculatorPage.getIntensityCalculationErrorMessage(),
        INTENSITY_CALC_ERROR_MESSAGE,"Сообщение об ошибке не совпадает с ожидаемым");
  }
}