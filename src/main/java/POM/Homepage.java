package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
    private WebDriver driver;
    protected LoginPage loginPage;


    public Homepage(WebDriver driver){
        this.driver = driver;
    }

    //Click login/Signup Button then return to login Page
    public LoginPage clickLoginNdSignup() throws InterruptedException{
        driver.findElement(By.className("_12e27_1r3kc")).click();
        return new LoginPage(driver);
    }
}
