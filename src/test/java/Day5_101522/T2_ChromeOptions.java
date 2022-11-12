package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_ChromeOptions {
    public static void main(String[] args) {
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
        driver.navigate().to("https://www.google.com");
        //maximize the driver
        driver.manage().window().fullscreen();
        //locate element for search field and type cars
        //this is an example of a relative xpath
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Cars");
        //hit submit on the google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        //capture the search result and print it
        //capture the search result text
        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //extract out the number and print the search number only
        String[] arrayResult = result.split(" ");
        System.out.println("My search number is " + arrayResult[1]);
        //quit the driver to end the session
        driver.quit();
    }

}//end of class
