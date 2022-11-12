package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class AI_3 {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for incognito
        //       options.addArguments("start-maximized","incognito");
        options.addArguments("start-fullscreen","incognito");
        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);
        //create ArrayList for zipcodes
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11354");
        zipCode.add("11004");
        zipCode.add("10470");

        //for loop
        for(int i=0; i< zipCode.size();i++) {


            //go to google page
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            //wait a few seconds
            Thread.sleep(2000);

            //store locator
            WebElement searchBar = driver.findElement(By.xpath("//*[@id='location-search']"));
            //clear search
            searchBar.clear();
            //sleep statement
            Thread.sleep(2000);
            //search zipcode
            searchBar.sendKeys(zipCode.get(i));
            //click on search button
            driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();
            //sleep statement
            Thread.sleep(2000);
            //click on studio
            ArrayList<WebElement> locations = new ArrayList<>(driver.findElements(By.xpath("//*[@class='wrapperLink-2NobU']")));
            //use if condition
            if (i == 0) {
                locations.get(1).click();
            }
            else if (i == 1) {
                locations.get(2).click();
            }
            else if (i == 2) {
                locations.get(0).click();
            }//end of if  statement

            //sleep
            Thread.sleep(2000);

            //capture entire address
            String address = driver.findElement(By.xpath("//*[@class='infoContainer-12kv1']")).getText();
            //split the address lines by the "return"/next line to capture just the address lines
            String[] addressSplit = address.split("\\R");
            //print the appropriate statement
            System.out.println("For zip code " + zipCode.get(i) + " the address is " + addressSplit[0] + " " + addressSplit[1]);

            //define javascriptexecutor
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //scroll
            WebElement scrollView = driver.findElement(By.xpath("//*[contains(@class,'workshopSchedule')]"));
            //scroll
            jse.executeScript("arguments[0].scrollIntoView(true);", scrollView);
            //capture the entire table
            String entireTable = driver.findElement(By.xpath("//*[@class='workshopSchedule-2foP8']")).getText();
            //printing studio workshops
            System.out.println(entireTable);
            System.out.println();


        }//end of for loop
        //quit driver
        driver.quit();

    }//end of main

}//end of class
