package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class AI_4p2 {
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


        //create arraylist of locations
        ArrayList<String> locations = new ArrayList<>();
        locations.add("Utah");
        locations.add("Nashville");
        locations.add("Texas");

        //create arraylist for adults
        ArrayList<Integer> adults = new ArrayList<>();
        adults.add(3);
        adults.add(4);
        adults.add(5);

        //create arraylist for child age
        ArrayList<String> cAge = new ArrayList<>();
        cAge.add("1");
        cAge.add("2");
        cAge.add("3");


        for (int i = 0; i < locations.size(); i++) {

            //navigate to hotels.com
            driver.navigate().to("https://www.hotels.com");
            Thread.sleep(4000);

            try {
                //click on search bar
                driver.findElement(By.xpath("//*[@class= 'uitk-fake-input uitk-form-field-trigger']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on going to.. " + e);
            }

            //sleep
            Thread.sleep(4000);


            try {
                //tyoe in location
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(locations.get(i));
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(Keys.ENTER);
                //driver.findElements(By.xpath("//*[@id='destination_form_field']")).get.click(0)
            } catch (Exception e) {
                System.out.println("Unable to click on location.. " + e);
            }

            //sleep
            Thread.sleep(10000);

            //click on travelers
            try {
                driver.findElement(By.xpath("//*[@class='uitk-menu-trigger uitk-fake-input uitk-form-field-trigger']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on travelers.. " + e);
            }

            //sleep
            Thread.sleep(2000);

            //create and arraylist
            ArrayList<WebElement> plusMinus = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-step-input-button']")));

            //click to add one child
            try {
                plusMinus.get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to click on + to add a child.. " + e);
            }


            //create for loop
            for (int j = 1; j < adults.get(i); j++) {
                //add adults age
                try {
                    plusMinus.get(1).click();
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("Unable to add adults age.. " + e);
                }

            }//end of adults loop

            Thread.sleep(1000);

            //click to add one child
            try {
                plusMinus.get(3).click();
            } catch (Exception e) {
                System.out.println("Unable to add one child.. " + e);
            }


            //use select command for children
            WebElement child = driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']"));
            Select childDropDown = new Select(child);

            //select by value
            try {
                childDropDown.selectByValue(cAge.get(i));
            } catch (Exception e) {
                System.out.println("Unable to select value.. " + e);
            }

            //click done
            try {
                driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click done.. " + e);
            }

            //click on search button
            try {
                driver.findElement(By.xpath("//*[@id='submit_button']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click search.. " + e);
            }

            //sleep
            Thread.sleep(2000);

            //create arraylist of hotels
            ArrayList<WebElement> hotels = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-spacing uitk-spacing-margin-blockstart-three']")));
            //click on hotels
            if (i == 0) {
                try {
                    hotels.get(0).click();
                } catch (Exception e) {
                    System.out.println("Unable to click on first link.." + e);
                }
            }//end of if statement
            else if (i == 1) {
                try {
                    hotels.get(2).click();
                } catch (Exception e) {
                    System.out.println("Unable to click on first link.." + e);
                }
            }//end of if statement 2
            else if (i == 2) {
                try {
                    hotels.get(1).click();
                } catch (Exception e) {
                    System.out.println("Unable to click on second link.." + e);
                }
            }//end of if statement 3

            //capture all tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to new tabs
            driver.switchTo().window(tabs.get(1));

            //sleep
            Thread.sleep(6000);

            //capture name of the hotel
            try {
                String hotelName = driver.findElements(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).get(0).getText();
                //print hotel name
                System.out.println(hotelName);
            } catch (Exception e) {
                System.out.println("Unable to print out hotel name" + e);
            }

            //click on reserve now
            try {
                driver.findElement(By.xpath("//*[@class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-primary']")).click();
            } catch (Exception e) {
                System.out.println("Unable to reserve.. " + e);
            }

            //sleep
            Thread.sleep(2000);

            //capture price of hotel
            try {
                String price = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();

                //print out price of hotel
                System.out.println(price);
            } catch (Exception e) {
                System.out.println("Unable to capture the price of the hotel.." + e);
            }

            //click on reserve now
            try {
                driver.findElements(By.xpath("//*[@data-stid= 'submit-hotel-reserve']")).get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to click reserve now.." + e);
            }

            //sleep
            Thread.sleep(4000);

            WebElement reserveNowPopUp = driver.findElement(By.xpath("//*[@class='uitk-toolbar-title-content']"));
            if (reserveNowPopUp.isDisplayed()) {
                //if the popup os dispalayed then click on pay now
                driver.findElement(By.xpath("//span[text() = 'Pay now']")).click();
            }

            //capture dates
            try {
                String dates = driver.findElement(By.xpath("//*[@class='booking-details-travel-details-wrapper fs-base clear bg-white mb-none--xs bd-all bdra-big mt-mouse']")).getText();
                //print out dates
                System.out.println(dates);
            } catch (Exception e) {
                System.out.println("Unable to capture and print out dates.." + e);
            }

            //close tab
            driver.close();

            //switch back to home page
            driver.switchTo().window(tabs.get(0));

        }//end of hotels loop

        driver.quit();





        }//end of main
    }//end of class
