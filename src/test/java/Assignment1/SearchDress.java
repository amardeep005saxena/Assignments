/*
 *********************************************
 *     Step Definition Class                 *
 *********************************************
 */


package Assignment1;
import Assignment1.POM.shoppingJourney;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchDress extends browserConf  {

    private WebDriver driver;

    @Given("Website is accessible with {string}")
    public void websiteIsAccessibleWith(String URL) {
        setDriver(browser);
        driver=getDriver();
        driver.get(URL);

        String expectedText="T-SHIRTS";
        String actualText=driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).getText();
        Assert.assertTrue("Website not reachable",expectedText.equals(actualText));
    }


    @When("select and order the product")
    public void selectAndOrderTheProduct() throws InterruptedException {
        shoppingJourney shoppingJourney=new shoppingJourney(driver);
        AccountDetails PD =new AccountDetails(driver);
        shoppingJourney.checkDresses();
        shoppingJourney.selectDress();

        String expectedAmt= driver.findElement(By.xpath("//*[@id=\"our_price_display\"]")).getText();
        System.out.println("Expected Amount is :" + expectedAmt);

        shoppingJourney.setAddToCart();
        shoppingJourney.setProceedCheckout();

        System.out.println("CheckingOut...");

        String expectedText="SHOPPING-CART SUMMARY";
        String actualText=driver.findElement(By.xpath("//*[@id=\"cart_title\"]")).getText();
        System.out.println(actualText);
        Assert.assertTrue(actualText.contains(expectedText));


        System.out.println("Validate the amount in summary");

        String actualAmt=driver.findElement(By.xpath("//*[@id=\"product_price_4_16_0\"]/span")).getText();
        System.out.println(actualAmt);
        Assert.assertEquals(actualAmt,expectedAmt);

        System.out.println("Proceed with checkout in summary...");
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();

        System.out.println("SignIn");

        shoppingJourney.setAddEmail();
        PD.personalInfo();

        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();

        System.out.println("SignIn Completed!!!");

        driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();

        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
    }

    @Then("order completed successfully")
    public void orderCompletedSuccessfully() {
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
        String orderStatus=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText();
        System.out.println(orderStatus);
        Assert.assertEquals("Your order on My Store is complete.",orderStatus);
        System.out.println("Closing the Browser now");
        driver.quit();
    }


}

