/*
*********************************************
*     Browser configuration class           *
*********************************************
 */


package Assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class browserConf {
    public WebDriver driver;

    static String driverPath = "C:\\Users\\Lenovo\\Downloads\\";  // Change the location of driver for both IE and chrome.
    public String browser="chrome";  // Change the browser- chrome or IE

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(String browserType) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "IE":
                driver = initIEDriver();
                break;

        }
    }

    public static WebDriver initChromeDriver() {
        System.out.println("Launching google chrome...");
        System.setProperty("webdriver.chrome.driver", driverPath
                + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver initIEDriver() {
        System.out.println("Launching IE browser..");
        System.setProperty("webdriver.ie.driver", driverPath
                + "IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        return driver;
    }

}
