package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_XpathTextContains {

    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with WebDriverManager
        WebDriverManager.chromedriver().setup();

        //define the webdriver
        WebDriver driver = new ChromeDriver();

        //navigate to yahoo
        driver.navigate().to("https://www.yahoo.com");

        //maximize driver
        driver.manage().window().fullscreen();

        //click on sign in button
        driver.findElement(By.xpath("//*[text() = 'Sign in']")).click();
        //wait 2 seconds
        Thread.sleep(2000);
        //go to yahoo home page
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(1000);
        //click on the bell icon
        //*[contains(@class,'rapid-nonanchor')]
        driver.findElement(By.xpath("//*[contains(@class,'rapid-nonanchor')]")).click();
        //*[contains(@class,'rapid-nonanchor')]
        //wait 2 seconds
        Thread.sleep(2000);

        //quit chrome
        driver.quit();


    }//end of main
}//end of class
