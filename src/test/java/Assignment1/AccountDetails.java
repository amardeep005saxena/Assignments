/*
 *********************************************
 *     Account Details Configuration         *
 *********************************************
 */


package Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.concurrent.TimeUnit;

public class AccountDetails  {
    WebDriver driver;

    public AccountDetails (WebDriver driver){
        this.driver=driver;
    }

    public void personalInfo() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement title=driver.findElement(By.xpath("//*[@id=\"id_gender1\"]"));
        WebElement firstName=driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
        WebElement lastName=driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        WebElement password=driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        WebElement address= driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        WebElement city=driver.findElement(By.xpath("//*[@id=\"city\"]"));
        Select state= new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
        WebElement pinCode=driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
        Select country=new Select (driver.findElement(By.xpath("//*[@id=\"id_country\"]")));
        WebElement phone=driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]"));
        WebElement addressAlias=driver.findElement(By.xpath("//*[@id=\"alias\"]"));

        title.click();
        firstName.sendKeys("Amar");
        lastName.sendKeys("Amar");
        password.sendKeys("test123*");
        address.sendKeys("street1");
        city.sendKeys("NY");
        state.selectByVisibleText("Iowa");
        country.selectByVisibleText("United States");
        pinCode.sendKeys("22222");
        phone.sendKeys("98898999988");
        addressAlias.sendKeys("Address1");
    }
}
