package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class AI_4 {

    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

//initialize chrome options
        ChromeOptions options = new ChromeOptions();

// add the options for maximizing the chrome meeting
// options.addArguments("start-fullscreen") for mac
        options.addArguments("start-fullscreen");

//define the chrome driver to use for your test
//creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);



        //create arraylist of
        ArrayList<String> locations = new ArrayList<>();
        locations.add("New York");
        locations.add("California");
        locations.add("Texas");

        for (int i=0; i < locations.size(); i++) {

            //navigate to hotels.com
            driver.navigate().to("https://www.hotels.com");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@aria-label= 'Going to']")).click();
            //clear and enter new home value
            try {
                WebElement cities = driver.findElement(By.xpath("//*[@id='destination_form_field']"));
                cities.click();
                cities.sendKeys("New York");
            } catch (Exception e) {
                System.out.println("Unable to enter new value on Home Value.. " + e);
            }//end of home val exception

            //sleep
            Thread.sleep(2000);

            //Arraylist webelement
            ArrayList<WebElement> subCities = new ArrayList<>(driver.findElements(By.xpath("//*[@class='is-subText truncate']")));

            //click on first location
            subCities.get(0).click();

            //sleep
            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@data-stid= 'open-room-picker']")).click();

            Thread.sleep(2000);

            ArrayList<Integer> adults = new ArrayList<>();
            adults.add(3);
            adults.add(4);
            adults.add(5);

            driver.findElement(By.xpath("//*[@class= 'uitk-layout-flex-item uitk-step-input-touch-target']")).click();

            try {
                WebElement children = driver.findElement(By.xpath("//*[@aria-label= 'Increase the number of children in room 1']"));
                children.click();

            } catch (Exception e) {
                System.out.println("Unable to submit children.. " + e);


                //use select command for each dropdown
////                WebElement child = driver.findElement(By.xpath("//*[@name= 'child-traveler_selector_children_age_selector-0-0']"));
//                WebElement child = driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']"));
////                Select childDropDown = new Select(child);
//                Select childDropDown = new Select(driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']")));

//                //select by visible text
//                childDropDown.selectByValue("8");
//                childDropDown.selectByIndex(7);
//                childDropDown.selectByVisibleText("7");

            }//end of child catch

            for(i=1; i < adults.get(0); i++) {
                try {
                    WebElement travelers = driver.findElement(By.xpath("//*[@aria-label= 'Increase the number of adults in room 1']"));
                    travelers.click();

                } catch (Exception e) {
                    System.out.println("Unable to submit Travelers.. " + e);

                }//end of adults catch

                try {
                    WebElement child = driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']"));
                    Select childDropDown = new Select(child);

                    childDropDown.selectByValue("8");

                } catch (Exception e) {
                    System.out.println("Unable to submit child age..." + e);

                }//end of child dop down

                //sleep
                Thread.sleep(1000);

                //select done
                driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();

                //sleep
                Thread.sleep(1000);

                //select search button
                driver.findElement(By.xpath("//*[@id='submit_button']")).click();

                //sleep
                Thread.sleep(2000);

                //click on hotels
                ArrayList<WebElement> hotels = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-spacing uitk-spacing-margin-blockstart-three']")));

                //use if condition
                if (i == 0) {
                    hotels.get(0).click();
                }
                else if (i == 1) {
                    hotels.get(2).click();
                }
                else if (i == 2) {
                    hotels.get(1).click();
                }//end of if statement

                //sleep
                Thread.sleep(2000);



            }//end of for loop travelers
        }//end of loop destination
    }//end of main
}//end of class
