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
    calculatorPage.isOpen();
    calculatorPage.selectEventType();
    calculatorPage.enterIntensityCalculationTime(intensityCalc);
    calculatorPage.clickCalculateButton();
    assertTrue(calculatorPage.isWorkoutSplitResultDisplayed());
  }

  @Test(groups = {"LoginWithSuccessLogin", "regression"})
  public void negativeIntensityTest() {
    Calculator intensityCalc =  Calculator.builder()
        .minutes("18")
        .build();
    dashboardPage.clickCalculatorMenu();
    calculatorPage.isOpen();
    calculatorPage.selectEventType();
    calculatorPage.enterIntensityCalculationTime(intensityCalc);
    calculatorPage.clickCalculateButton();
    assertEquals(calculatorPage.getIntensityCalculationErrorMessage(),
        INTENSITY_CALC_ERROR_MESSAGE);
  }

  @Test(groups = {"LoginWithSuccessLogin", "regression"})
  public void positiveTinmanTest() {
    Calculator intensityCalc = Calculator.builder()
        .hours("00")
        .minutes("16")
        .seconds("23")
        .build();
    dashboardPage.clickCalculatorMenu();
    calculatorPage.isOpen();
    calculatorPage.clickTinmanCalculator();
    calculatorPage.selectTinmanRaceDistance("5 km");
    calculatorPage.enterIntensityCalculationTime(intensityCalc);
    calculatorPage.selectGender();
    calculatorPage.clickCalculateButton();
    assertTrue(calculatorPage.isWorkoutSplitResultDisplayed());
  }

  @Test(enabled = false, groups = {"LoginWithSuccessLogin"})
  public void defectTinmanTest() {
    Calculator intensityCalc = Calculator.builder()
        .hours("00")
        .minutes("20")
        .build();
    dashboardPage.clickCalculatorMenu();
    calculatorPage.isOpen();
    calculatorPage.clickTinmanCalculator();
    calculatorPage.selectTinmanRaceDistance("5 km");
    calculatorPage.enterIntensityCalculationTime(intensityCalc);
    calculatorPage.selectGender();
    calculatorPage.clickCalculateButton();
    assertEquals(calculatorPage.getIntensityCalculationErrorMessage(),
        INTENSITY_CALC_ERROR_MESSAGE);
  }
}