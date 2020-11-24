/*
 *********************************************
 *     Step Definition Class                 *
 *********************************************
 */


package Assignment1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchDress extends browserConf  {

    private String browser="chrome";  // Change the browser- chrome or IE

    private String email="amar"+Math.random()+"@gmail.com";

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

        Actions actions = new Actions(driver);
        WebElement Dresses= driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
        actions.doubleClick(Dresses).build().perform();
        Thread.sleep(9000);
        WebElement secondDress=driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img"));

        actions.moveToElement(secondDress).build().perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[2]")).click();


        String expectedAmt= driver.findElement(By.xpath("//*[@id=\"our_price_display\"]")).getText();
        System.out.println(expectedAmt);

        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
        Thread.sleep(8000);

        System.out.println("ADD TO CART");

        String expectedText="SHOPPING-CART SUMMARY";
        String actualText=driver.findElement(By.xpath("//*[@id=\"cart_title\"]")).getText();
        System.out.println(actualText);
        Assert.assertTrue(actualText.contains(expectedText));


        System.out.println("Validate the amount in summary");

        String actualAmt=driver.findElement(By.xpath("//*[@id=\"product_price_4_16_0\"]/span")).getText();
        System.out.println(actualAmt);
        Assert.assertEquals(actualAmt,expectedAmt);

        System.out.println("Proceed to checkout");
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();

        System.out.println("SignIn");

        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
        AccountDetails PD =new AccountDetails(driver);
        PD.personalInfo();

        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();

        System.out.println("SignIn Completed!");

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

