package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T4_mlcalc_Scroll {
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

        //define javascript executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        /*
        //scroll down to 800 pixels
        jse.executeScript("scroll(0,800)");
        //wait few seconds
        Thread.sleep(2000);
        //scroll up to 400 pixels
        jse.executeScript("scroll(0,-400)");
        //wait few seconds
        Thread.sleep(2000);

         */

        //declare calculate button into WebElement variable
        WebElement calculateButton = driver.findElement(By.xpath("//*[@value='Calculate']"));
        //scroll into view of calculate button
        jse.executeScript("arguments[0].scrollIntoView(true);", calculateButton);
        //wait 2 seconds
        Thread.sleep(3000);

        //quit chrome
        driver.quit();

    }//end of main
}//end of class
