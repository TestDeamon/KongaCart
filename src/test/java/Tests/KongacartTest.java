package Tests;

import POM.CartPage;
import POM.Homepage;
import POM.LoginPage;
import Setup.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class KongacartTest extends Base {
    private WebDriver driver;

    CartPage cartPage;
    LoginPage loginPage;
    @Test
    public void test() throws InterruptedException {
        loginPage = homepage.clickLoginNdSignup();
        loginPage.enterUsername("clairedavis@mailinator.com");
        loginPage.enterPassword("clairedavis@mailinator.com");
        cartPage = loginPage.sendDetailsToLogin();
        cartPage.clickCartMenu();
        cartPage.enterDeliveryAddress("Elizabeth", "Alola", "08100044638", "Agbowo", "Ibadan");
        Thread.sleep(3000);
        cartPage.cardPaymentMethod("5423456789902346", "11/20", "219");
        Thread.sleep(5000);
    }


}
