package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class AI_2 {
    public static void main(String[] args) throws InterruptedException {
        //create ArrayList of sports
        ArrayList<String> sports = new ArrayList<>();
        sports.add("Soccer");
        sports.add("Basketball");
        sports.add("Football");
        sports.add("Hockey");
        //define webdriver manager setup
        WebDriverManager.chromedriver().setup();
        //define chrome driver to use for test
        //create instance for browser to use for automation
        WebDriver driver = new ChromeDriver();

        for(int i=0; i< sports.size();i++) {
            //navigate to bing
            driver.navigate().to("https://www.bing.com");
            //maximize window
            driver.manage().window().fullscreen();
            //sleep statement
            Thread.sleep(3000);
            //search keyword on search field
            //xpath to locate element
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sports.get(i));
            //hit submit on bing search button
            driver.findElement(By.xpath("//*[@name='search']")).submit();
            //sleep statement
            Thread.sleep(3000);
            //capture search result text
            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //split message to extract out search result
            String[] splitResult = result.split(" ");
            System.out.println("the search for " + sports.get(i) + " is " + splitResult[0]);
        }//end of for loop

        //quit driver to end session
        driver.quit();

    }//end of main



}//end of java class
