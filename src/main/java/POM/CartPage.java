package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }


    public void clickCartMenu() throws InterruptedException {
        Thread.sleep(10000);
        //Click My cart menu
        driver.findElement(By.cssSelector("._79484_1sLEt")).click();
        Thread.sleep(10000);


        //Click Continue to Checkout Button at the button of the page
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/div/div[2]/div[3]/div/div[6]/div")).click();

        Thread.sleep(10000);
        //Close Phone number modal
        //Isolate
//        driver.findElement(By.xpath("/html/body/div[2]/div/section/div[2]/section/section/aside/div[1]/div/a")).click();

        Thread.sleep(3000);
        //Select Delivery Address
        driver.findElements(By.cssSelector("._549f7_zvZ8u ._0a08a_3czMG")).get(0).click();
//        driver.findElement(By.xpath("/html/body/div[2]/div/section/div[2]/section/main/form/div/div/section[1]/div[2]/div/div[1]/div/div[1]/form/div/div/a")).click();
    }
    public void enterDeliveryAddress(String fName, String lName, String no, String street, String city) throws InterruptedException {
        Thread.sleep(1000);
        //Enter first name
        driver.findElement(By.id("firstname")).sendKeys(fName);
        Thread.sleep(1000);

        //Enter last name
        driver.findElement(By.id("lastname")).sendKeys(lName);
        Thread.sleep(1000);

        //Enter Mobile No
        driver.findElement(By.id("telephone")).sendKeys(no);
        Thread.sleep(1000);

        //Enter Street Address
        driver.findElement(By.id("street")).sendKeys(street);
        Thread.sleep(1000);

        //Enter city
        driver.findElement(By.id("city")).sendKeys(city);
        Thread.sleep(1000);

        //Scroll down to Find Other elements on the Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.name("saveDeliveryAddress"));
        js.executeScript("arguments[0].scrollIntoView();", Element);

        //Select State
        Select state = new Select(driver.findElement(By.name("regionId")));
        state.selectByValue("1061493616");
        Thread.sleep(1000);

        //Select Local Government Area
        Select lga = new Select(driver.findElement(By.name("areaId")));
        lga.selectByValue("22");
        Thread.sleep(1000);

        //Click Next Button
        driver.findElement(By.name("saveDeliveryAddress")).click();
    }

    //Select address on Address book page
    public void selectAddress() throws InterruptedException {
        driver.findElement(By.name("selectDeliveryAddress")).click();

        //Use this address button
        driver.findElement(By.cssSelector("._2aac2_3bwnD ._841f1_1RZK9")).click();

        //Select Pay Now
        driver.findElement(By.name("selectPaymentMethod")).click();


        //Continue to Payment button
        driver.findElement(By.name("placeOrder")).click();
    }

    public void cardPaymentMethod(String cardNo, String expiryDate, String cvv) throws InterruptedException {
        //Select Payment Method
        System.out.println("Select payment method");

        //Second select address
        driver.findElement(By.name("selectDeliveryAddress")).click();

        System.out.println("Select payment method");
//        driver.findElement(By.cssSelector("._0a08a_3czMG ._7e22a_3zNWE")).click();

        System.out.println("About to Click Use this address");
        driver.findElement(By.tagName("button")).click();

        driver.findElement(By.cssSelector(".dashboard-card .payment-option-content")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("card-number")).sendKeys(cardNo);
        driver.findElement(By.id("expiry")).sendKeys(expiryDate);
        driver.findElement(By.id("cvv")).sendKeys(cvv);
        Thread.sleep(2000);
        pin();
        driver.findElement(By.id("validateCardForm")).click();

        //Close Error Message
        driver.findElement(By.cssSelector(".data-card__close")).click();
        Thread.sleep(3000);
    }

    private void pin() throws InterruptedException{
        List<WebElement> el = driver.findElements(By.cssSelector(".pin-keypad__button"));
        el.get(3).click();
        el.get(1).click();
        el.get(9).click();
        el.get(0).click();
    }
}
