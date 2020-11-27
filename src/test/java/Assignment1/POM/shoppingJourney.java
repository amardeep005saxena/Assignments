package Assignment1.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class shoppingJourney<wait> {
    private WebDriver driver;


    public  shoppingJourney(WebDriver driver){
        this.driver=driver;


    }

    private By DressesOption=By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
    private By selectEveningDress=By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img");
    private By clickViewDress=By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[2]");
    private By addToCart=By.xpath("//*[@id=\"add_to_cart\"]/button/span");
    private By proceedCheckout= By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
    private By addEmail=By.xpath("//*[@id=\"email_create\"]");
    private By submitCreate=By.xpath("//*[@id=\"SubmitCreate\"]");
    private String email="amar"+Math.random()+"@gmail.com";

    public void waitToLoad(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void checkDresses()  {
        waitToLoad();
        System.out.println("Check the Dresses from website");
        WebElement dresses=driver.findElement(DressesOption);
        Actions actions=new Actions(driver);
        actions.doubleClick(dresses).build().perform();
    }

    public void selectDress()  {

        waitToLoad();
        System.out.println("Selecting the Dresses from website");
        WebElement dresses=driver.findElement(selectEveningDress);
        Actions actions=new Actions(driver);
        actions.moveToElement(dresses).build().perform();
        WebElement view=driver.findElement(clickViewDress);
        view.click();

    }

   public void setAddToCart()  {
        waitToLoad();
       System.out.println("Add to Cart");
       WebElement addCart = driver.findElement(addToCart);
       addCart.click();

   }

   public void setProceedCheckout()  {
        waitToLoad();
       System.out.println("Proceed to Checkout..");
       driver.findElement(proceedCheckout).click();


   }

   public void setAddEmail(){
       System.out.println("Add Email and submit create button");
       driver.findElement(addEmail).sendKeys(email);
       driver.findElement(submitCreate).click();
   }


}
