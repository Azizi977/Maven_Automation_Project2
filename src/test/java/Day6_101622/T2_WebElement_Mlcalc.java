package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_WebElement_Mlcalc {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the chrome window
        //       options.addArguments("start-maximized","incognito");
        options.addArguments("start-fullscreen");
        //       options.addArguments("headless");
        //for windows use "start-maximized
        //       options.addArguments("start-maximized");
        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);
        //go to google page
        driver.navigate().to("https://www.mlcalc.com");
        //wait a few seconds
        Thread.sleep(3000);

        //clear and enter a new value on down payment
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
        //clear the purchase price
        pPrice.clear();
        //type new value in down payment
        pPrice.sendKeys("45000");

        //clear and enter new value for down payment
        WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
        //clear the down payment
        dPayment.clear();
        //type new value in down payment
        dPayment.sendKeys("25");

    }//end of main
}//end of class
