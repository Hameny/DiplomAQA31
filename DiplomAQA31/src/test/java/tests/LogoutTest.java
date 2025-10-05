package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

  private static final String LOGOUT_MESSAGE = "You have been successfully logged out of the system.";

  @Test(groups = {"smoke", "regression", "LoginWithSuccessLogin"})
  public void positiveLogoutTest() {
    logoutPage.logout();
    assertEquals(logoutPage.getSuccessMessage(), LOGOUT_MESSAGE,
        "Сообщение при logout не совпадает с ожидаемым");
  }
}